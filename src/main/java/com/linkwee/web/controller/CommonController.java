package com.linkwee.web.controller;

import com.linkwee.web.response.MenuTreeResp;
import com.linkwee.web.service.MenuSerivce;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共视图控制器
 * 
 * @author Mignet
 * @since 2014年4月15日 下午4:16:34
 **/
@Controller
public class CommonController {


    @Resource
    private MenuSerivce menuSerivce;
    /*@Resource
    private SysConfigService sysConfigService;*/

    /**
     * 首页
     * 
     * @param request
     * @return
     */
    @RequestMapping("index")
    public String index(HttpServletRequest request, Model model) throws Exception{
        List<MenuTreeResp> menuTreeRespList = menuSerivce.findMenuTree();
        model.addAttribute("menus",menuTreeRespList);
        return "index";
    }
    
    @RequestMapping(value = "common/datatablesEditor/fileUpload", method = RequestMethod.POST)
	@ResponseBody
    public Map<String, Object> fileUpload(String action,String uploadField,MultipartFile upload) {
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	
    	//图片服务器
//    	String imgServer = sysConfigService.getValuesByKey("img_server_url");
//    	String returnFileId = CommonUtils.uploadFiles(imgServer, upload);

		String imgServer = "";
		String returnFileId = "";
    	
    	//基本参数
    	Map<String, Object> baseParameterMap = new HashMap<String, Object>();
    	baseParameterMap.put("id", returnFileId);
    	returnMap.put("upload",baseParameterMap);
    	
    	//其他参数
    	Map<String, Object> otherParameterMap = new HashMap<String, Object>();
    	otherParameterMap.put("web_path",imgServer );
    	
    	Map<String, Object> otherParameterMapOutOne = new HashMap<String, Object>();
    	otherParameterMapOutOne.put(returnFileId, otherParameterMap);
    	Map<String, Object> otherParameterMapOut = new HashMap<String, Object>();
    	otherParameterMapOut.put("files", otherParameterMapOutOne);//虚拟表名  便于datatables 获取参数  与前端js对应
    	returnMap.put("files", otherParameterMapOut);
    	return returnMap;
    }
}