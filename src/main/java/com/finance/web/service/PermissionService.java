package com.finance.web.service;

import com.github.pagehelper.Page;
import com.finance.web.generic.GenericService;
import com.finance.web.model.Permission;
import com.finance.web.request.PageRequest;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 权限 业务接口
 * 
 * @author Mignet
 * @since 2014年6月10日 下午12:02:39
 **/
public interface PermissionService extends GenericService<Permission, Integer> {

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
    List<Permission> selectPermissionsByRoleId(Integer roleId);

    /**
     * 查询所有数据<翻页>
     * @param pageRequest
     * @return
     */
	Page<Permission> selectList(int pageNo,int pageSize);

	List<Permission> selectByName(String permissionName);

	/**
	 * 更新角色权限
	 * @param roleid
	 * @param permissions
	 * @return
	 */
	boolean updateRolePermissions(String roleid, String[] permissions);

	List<Permission> selectListAll();

}
