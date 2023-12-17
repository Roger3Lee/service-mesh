package com.artframework.servicemesh.domains.service.service;

import com.artframework.servicemesh.domains.service.dto.request.*;
import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.domain.core.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface ServiceService extends BaseDomainService {

    /**
    * 分页查询
    * @param request 请求体
    * @return
    */
    IPage<ServiceDTO> page(ServicePageRequest request);

    /**
    * 查找
    * @param request 请求体
    * @return
    */
    ServiceDTO find(ServiceFindRequest request);

    /**
    * 新增
    * @param request 请求体
    * @return
    */
    Long insert(ServiceCreateRequest request);

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    Boolean update(ServiceUpdateRequest request);

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    Boolean delete(Long key);
}
