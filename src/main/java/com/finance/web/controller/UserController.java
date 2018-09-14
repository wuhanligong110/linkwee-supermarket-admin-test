package com.finance.web.controller;

import com.github.pagehelper.Page;
import com.google.common.collect.ImmutableMap;
import com.finance.annotaions.RequestLogging;
import com.finance.page.PageInfo;
import com.finance.rbac.PermissionSign;
import com.finance.rbac.Result;
import com.finance.utils.security.SHA256;
import com.finance.web.model.Role;
import com.finance.web.model.User;
import com.finance.web.service.RoleService;
import com.finance.web.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户控制器
 * 
 * @author Mignet
 * @since 2014年5月28日 下午3:54:00
 **/
@Controller
@RequestMapping(value = "/user")
@RequestLogging("用户控制器")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
    @Resource
    private UserService userService;
    @Resource
    private RoleService roleService;


    /**
     * 查看用户列表
     */
    @RequestMapping(value="",   method=RequestMethod.GET)  
    @RequiresPermissions(value = PermissionSign.SYS_USER_CREATE)
    public String users(Model model) {
    	return "sys/user-list";
    }
    
    //test
    @RequestMapping(value="/test/page",   method=RequestMethod.GET)  
    public String test() {
    	return "sys/test";
    }
    
    /**
     * 用户密码
     */
    @RequestMapping(value="/toresetpwd",   method=RequestMethod.GET)  
    public String toresetPwd(Model model) {
    	return "sys/reset-pwd";
    }
    
    /**
     * 用户密码重置
     */
    @RequestMapping(value="/{id}/resetpwd",   method=RequestMethod.POST)  
    @ResponseBody
    @RequestLogging("用户密码重置")
    public Result resetDefaultPwd(@PathVariable("id")String id) {
    	User u = userService.selectById(Integer.valueOf(id));
    	u.setPassword(SHA256.crypt(u.getUsername()+"@123456"));
    	int i = userService.update(u);
    	if(i==1){
    		return new Result(true,"密码重置成功!");
    	}else{
    		return new Result(false,500,"密码重置失败");
    	}
    }
    
    /**
     * 用户修改密码
     */
    @RequestMapping(value="/resetpwd",   method=RequestMethod.POST)  
    @ResponseBody
    @RequestLogging("用户修改密码")
    public Result resetPwd(@RequestParam("new_password")String new_password) {
    	Subject currentUser = SecurityUtils.getSubject();
    	User u = userService.selectByUsername(currentUser.getPrincipal().toString());
    	u.setPassword(new_password);
    	int i = userService.update(u);
    	if(i==1){
    		return new Result(true,"密码修改成功!");
    	}else{
    		return new Result(false,500,"密码修改失败");
    	}
    }
    
    @RequestMapping(value="/list", method=RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseBody
    public PageInfo<User> userLists(@RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize,
									@RequestParam("username") String username) {
    	Page<User> users = userService.selectListByName(username,pageNo,pageSize);
		PageInfo<User> pageInfo = new PageInfo<>(users);
    	return pageInfo;
    }

    /**
     * 基于权限标识的权限控制案例<br>
     * 如果这里使用PUT请求并且路径是/{id}，才是Restful的
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.SYS_USER_CREATE)
    @RequestLogging("用户新增更新")
    public Result create(User item) {
    	if(item.getId()==0){
    		item.setId(null);
	    	item.setCreateTime(new Date());
	    	item.setPassword(SHA256.crypt(item.getUsername()+"@123456"));
	    	int i = userService.insert(item);
	    	if(i==1){
	    		return new Result(true,"新增用户成功!");
	    	}else{
	    		return new Result(false,500,"新增失败");
	    	}
    	}else{
    		int i = userService.update(item);
	    	if(i==1){
	    		return new Result(true,"更新用户成功!");
	    	}else{
	    		return new Result(false,500,"更新失败");
	    	}
    	}
    }
    
    /**
     * 这里使用POST或者PATCH请求并且路径是/{id}才是Restful的
     * @param item
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.SYS_USER_CREATE)
    public Result update(User item) {
    	int i = userService.update(item);
    	if(i==1){
    		return new Result(true,"更新用户成功!");
    	}else{
    		return new Result(false,500,"更新失败");
    	}
    }
    
    /**
     *  这里使用DELETE请求并且路径是/{id}才是Restful的
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.SYS_USER_CREATE)
    public Result delete(@PathVariable("id") String id) {
    	User u  =userService.selectById(Integer.valueOf(id));
    	Subject currentUser = SecurityUtils.getSubject();
    	if(currentUser.getPrincipal().equals(u.getUsername())){
    		return new Result(false,401,"不允许删除自己的用户!");
    	}
    	int i = userService.delete(Integer.valueOf(id));
    	if(i==1){
    		return new Result(true,"删除用户成功!");
    	}else{
    		return new Result(false,500,"删除失败");
    	}
    }
    
    /**
     *  获取用户角色
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}/role", method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.SYS_USER_CREATE)
    public ImmutableMap<String, List<Role>> getRoles(@PathVariable("id") String id) {
    	List<Role> roles = roleService.selectListAll();
    	List<Role> roleList = roleService.selectRolesByUserId(Integer.parseInt(id));
    	return ImmutableMap.of("roles",roles,"roleList",roleList);
    }
    
    @RequestMapping(value = "/{id}/role", method = RequestMethod.POST)
    @ResponseBody
    @RequiresPermissions(value = PermissionSign.SYS_USER_CREATE)
    public Result updateRoles(@PathVariable("id") String id, String roles) {
    	if(roles==null)return new Result(false,404,"当前不允许去掉所有角色!");
    	boolean flag = roleService.updateUserRoles(id,roles.split(","));
    	if(flag){
    		return new Result(true,"更新成功!");
    	}else{
    		return new Result(false,500,"更新失败");
    	}
    }
    /**
     *  这里使用GET请求并且路径是/{id}才是Restful的
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@PathVariable("id") String id) {
    	return userService.selectById(Integer.valueOf(id));
    }
    
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public boolean canUsed(@RequestParam("username") String username) {
    	User u =  userService.selectByUsername(username);
    	if(u!=null){
    		return false;
    	}else{
    		return true;
    	}
    }
    
}