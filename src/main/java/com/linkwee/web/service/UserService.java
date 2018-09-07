package com.linkwee.web.service;

import com.github.pagehelper.Page;
import com.linkwee.web.generic.GenericService;
import com.linkwee.web.model.User;

/**
 * 用户 业务 接口
 * 
 * @author Mignet
 * @since 2014年7月5日 上午11:53:33
 **/
public interface UserService extends GenericService<User, Integer> {

    /**
     * 用户验证
     * 
     * @param user
     * @return
     */
    User authentication(User user);


    /**
     * 根据用户名查询用户列表
     * @param username
     * @param page
     * @return
     */
	Page<User> selectListByName(String username, int pageNo, int pageSize);

	/**
     * 根据用户名查询用户
     * @param username
     * @param page
     * @return
     */
	User selectByUsername(String username);
}
