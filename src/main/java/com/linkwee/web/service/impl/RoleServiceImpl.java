package com.linkwee.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.linkwee.web.dao.PermissionMapper;
import com.linkwee.web.dao.RoleMapper;
import com.linkwee.web.generic.GenericDao;
import com.linkwee.web.generic.GenericServiceImpl;
import com.linkwee.web.model.Role;
import com.linkwee.web.model.datatable.DataTable;
import com.linkwee.web.model.datatable.DataTableReturn;
import com.linkwee.web.service.RoleService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色Service实现类
 *
 * @author Mignet
 * @since 2014年6月10日 下午4:16:33
 */
@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, Integer> implements RoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
	
    @Resource
    private RoleMapper roleMapper;
    
    @Resource
    private PermissionMapper permissionMapper;

    @Override
    public GenericDao<Role, Integer> getDao() {
        return roleMapper;
    }

    @Override
    public List<Role> selectRolesByUserId(Integer userId) {
        return roleMapper.selectRolesByUserId(userId);
    }

    @Override
	public List<Role> selectListAll() {
		return roleMapper.selectListAll();
	}

	@Override
	public boolean updateUserRoles(String id,String[] roles) {
		roleMapper.deleteUserRolesByUserid(Integer.parseInt(id));
		for(String roleid:roles){
			if(!StringUtils.isBlank(roleid)){
				roleMapper.insertUserRole(Integer.parseInt(id),Integer.parseInt(roleid));
			}
		}
		return true;
	}

	@Override
	public DataTableReturn selectByDatatables(DataTable dt) {
		DataTableReturn tableReturn = new DataTableReturn();
		tableReturn.setDraw(dt.getDraw()+1);
		LOGGER.debug(" 排序和模糊查询 ");
		PageHelper.startPage(dt.getStart()/dt.getLength()+1,dt.getLength());
		Page<Role> page = this.roleMapper.selectBySearchInfo(dt);
		List<Role> list = page.getResult();
		tableReturn.setData(list);
		tableReturn.setRecordsFiltered((int) page.getTotal());
		tableReturn.setRecordsTotal((int) page.getTotal());
		return tableReturn;
	}

	@Override
	public int delete(Integer id) {
		permissionMapper.deleteRolePermissionsByRoleid(id);
		return roleMapper.deleteByPrimaryKey(id);
	}

}
