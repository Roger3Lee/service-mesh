package com.artframework.servicemesh.domains.service.repository;

import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface ServiceRepository extends BaseRepository<ServiceDomain, SvcMeshServiceDO> {

    /**
    * 分页查询
    * @param request 请求�?
    * @return 返回数据
    */
    IPage<ServiceDomain> page(ServicePageDomain request);
}
