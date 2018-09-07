package com.linkwee.web.dao;

import com.github.pagehelper.Page;
import com.linkwee.annotaions.MyBatisRepository;
import com.linkwee.web.generic.GenericDao;
import com.linkwee.web.model.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface PermissionMapper extends GenericDao<Permission, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);

    /**
     * 通过角色id 查询角色 拥有的权限
     * 
     * @param roleId
     * @return
     */
	List<Permission> selectPermissionsByRoleId(Integer roleId);

	Page<Permission> selectList();

	List<Permission> selectByName(String permissionName);

	/**
	 * 可分配权限列表
	 * @return
	 */
	List<Permission> selectListAll();

	/**
	 * 删除某角色关联的权限
	 * @param roleId
	 */
	void deleteRolePermissionsByRoleid(@Param("roleId") int roleId);

	/**
	 * 插入角色权限关联
	 * @param roleId
	 * @param permissionId
	 */
	void insertRolePermission(@Param("roleId") int roleId, @Param("permissionId") int permissionId);

	void deleteRolePermissionsByPermissionId(@Param("permissionId") Integer permissionId);
}