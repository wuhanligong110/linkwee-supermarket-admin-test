package com.linkwee.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linkwee.web.dao.PermissionMapper;
import com.linkwee.web.generic.GenericDao;
import com.linkwee.web.generic.GenericServiceImpl;
import com.linkwee.web.model.Permission;
import com.linkwee.web.request.PageRequest;
import com.linkwee.web.service.PermissionService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限Service实现类
 *
 * @author Mignet
 * @since 2014年6月10日 下午12:05:03
 */
@Service
public class PermissionServiceImpl extends GenericServiceImpl<Permission, Integer> implements PermissionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PermissionServiceImpl.class);
	
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public GenericDao<Permission, Integer> getDao() {
        return permissionMapper;
    }

    @Override
    public List<Permission> selectPermissionsByRoleId(Integer roleId) {
        return permissionMapper.selectPermissionsByRoleId(roleId);
    }

	@Override
	public List<Permission> selectList(PageRequest pageRequest) {
		LOGGER.debug(" 测试自动分页:%d,%d",pageRequest.getPageNo(),pageRequest.getPageSize());
		PageHelper.startPage(pageRequest.getPageNo(),pageRequest.getPageSize());
		Page<Permission> permissionPage = permissionMapper.selectList();
		return permissionPage.getResult();
	}

	@Override
	public List<Permission> selectByName(String permissionName) {
		return permissionMapper.selectByName(permissionName);
	}
	
    @Override
	public List<Permission> selectListAll() {
		return permissionMapper.selectListAll();
	}

	@Override
	public boolean updateRolePermissions(String roleId,String[] permissions) {
		permissionMapper.deleteRolePermissionsByRoleid(Integer.parseInt(roleId));
		for(String permissionId:permissions){
			if(!StringUtils.isBlank(permissionId)){
				permissionMapper.insertRolePermission(Integer.parseInt(roleId),Integer.parseInt(permissionId));
			}
		}
		return true;
	}
	
	@Override
	public int delete(Integer id) {
		//删除角色与权限表中该权限
		permissionMapper.deleteRolePermissionsByPermissionId(id);
		return permissionMapper.deleteByPrimaryKey(id);
	}
}
