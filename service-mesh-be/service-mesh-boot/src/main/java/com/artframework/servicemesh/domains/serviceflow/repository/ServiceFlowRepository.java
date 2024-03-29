package com.artframework.servicemesh.domains.serviceflow.repository;

import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface ServiceFlowRepository extends BaseRepository<ServiceFlowDomain, SvcMeshFlowDO> {

    /**
    * 分页查询
    * @param request 请求�?
    * @return 返回数据
    */
    IPage<ServiceFlowDomain> page(ServiceFlowPageDomain request);
}
