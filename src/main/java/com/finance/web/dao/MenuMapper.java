package com.finance.web.dao;

import com.github.pagehelper.Page;
import com.finance.annotaions.MyBatisRepository;
import com.finance.web.model.MenusModel;
import com.finance.web.request.CfpCommonRequest;
import com.finance.web.response.MenusResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Mignet on 2016/6/22.
 *
 * @Author Libin
 * @Date 2016/6/22
 */
@MyBatisRepository
public interface MenuMapper {

    public Page<MenusResp> findMenuList(@Param("query") CfpCommonRequest<MenusModel> cfpCommonRequest) throws Exception;

    public MenusModel findMenuOne(@Param("query") MenusModel menusModel) throws Exception;

    public int deleteMenus(@Param("iids") List<Integer> iids) throws Exception;

    public int updateMenus(@Param("query") MenusModel menusModel) throws Exception;

    public int insertMenu(MenusModel menusModel) throws Exception;
}
