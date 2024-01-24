package com.artframework.servicemesh.domains.datasource.repository;

import com.artframework.servicemesh.domains.datasource.domain.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface DatasourceRepository extends BaseRepository<DatasourceDomain, SvcMeshDatasourceDO> {

    /**
    * 分页查询
    * @param request 请求�?
    * @return 返回数据
    */
    IPage<DatasourceDomain> page(DatasourcePageDomain request);
}
