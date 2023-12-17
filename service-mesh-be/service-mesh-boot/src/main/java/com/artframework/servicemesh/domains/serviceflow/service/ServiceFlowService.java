package com.artframework.servicemesh.domains.serviceflow.service;

import com.artframework.servicemesh.domains.serviceflow.dto.request.*;
import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.domain.core.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface ServiceFlowService extends BaseDomainService {

    /**
    * 分页查询
    * @param request 请求体
    * @return
    */
    IPage<ServiceFlowDTO> page(ServiceFlowPageRequest request);

    /**
    * 查找
    * @param request 请求体
    * @return
    */
    ServiceFlowDTO find(ServiceFlowFindRequest request);

    /**
    * 新增
    * @param request 请求体
    * @return
    */
    Long insert(ServiceFlowCreateRequest request);

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    Boolean update(ServiceFlowUpdateRequest request);

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    Boolean delete(Long key);
}
