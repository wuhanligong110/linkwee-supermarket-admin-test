package com.linkwee.web.dao;

import com.github.pagehelper.Page;
import com.linkwee.annotaions.MyBatisRepository;
import com.linkwee.web.generic.GenericDao;
import com.linkwee.web.model.Role;
import com.linkwee.web.model.datatable.DataTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface RoleMapper extends GenericDao<Role, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    /**
     * 通过用户id 查询用户 拥有的角色
     * 
     * @param userId
     * @return
     */
    List<Role> selectRolesByUserId(Integer userId);

    /**
     * 封装DataTable对象查询
     * @param dt
     * @return
     */
	Page<Role> selectBySearchInfo(@Param("dt") DataTable dt);

	/**
	 * 获取所有角色
	 * @return
	 */
	List<Role> selectListAll();

	void deleteUserRolesByUserid(@Param("userId") Integer userId);

	void insertUserRole(@Param("userId") int userId, @Param("roleId") int roleId);

}