package com.linkwee.web.service;

import com.linkwee.web.generic.GenericService;
import com.linkwee.web.model.Permission;
import com.linkwee.web.request.PageRequest;

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
	List<Permission> selectList(PageRequest pageRequest);

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
