package com.finance.web.service;

import com.finance.page.PageInfo;
import com.finance.web.generic.GenericClient;
import com.finance.web.generic.GenericClientService;
import com.finance.web.generic.GenericServiceImpl;
import com.finance.web.model.SmAdvertisement;
import com.finance.web.model.datatable.DataTable;
import com.finance.web.model.datatable.DataTableReturn;
import com.finance.web.service.client.SmAdvertisementClient;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;


/**
*
* @描述：SmAdvertisementService 服务实现类
*
* @创建人： Hxb
*
* @创建时间：2018年09月26日 16:58:21
*
* Copyright (c) 深圳领会科技有限公司-版权所有
*/
@Service("smAdvertisementService")
public class SmAdvertisementService extends GenericClientService<SmAdvertisement, Long>{

   private static final Logger LOGGER = LoggerFactory.getLogger(SmAdvertisementService.class);

   @Resource
   private SmAdvertisementClient smAdvertisementClient;

    @Override
    public GenericClient<SmAdvertisement, Long> getClient() {
        return smAdvertisementClient;
    }

   public DataTableReturn selectByDatatables(DataTable dt) {
       DataTableReturn tableReturn = new DataTableReturn();
       tableReturn.setDraw(dt.getDraw()+1);
       LOGGER.debug(" -- SmAdvertisement -- 排序和模糊查询 ");
       PageInfo<SmAdvertisement> pageInfo = smAdvertisementClient.selectBySearchInfo(dt);
       tableReturn.setData(pageInfo.getDatas());
       tableReturn.setRecordsFiltered((int) pageInfo.getTotalCount());
       tableReturn.setRecordsTotal((int) pageInfo.getTotalCount());
       return tableReturn;
   }


}
