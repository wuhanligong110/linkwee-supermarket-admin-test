package com.linkwee.web.dao;

import com.github.pagehelper.Page;
import com.linkwee.annotaions.MyBatisRepository;
import com.linkwee.web.generic.GenericDao;
import com.linkwee.web.model.User;
import org.apache.ibatis.annotations.Param;

@MyBatisRepository
public interface UserMapper extends GenericDao<User, Integer> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Page<User> selectListByUsername(@Param("username") String username);

	User selectByUsername(String username);

	User authentication(@Param("record") User user);


}