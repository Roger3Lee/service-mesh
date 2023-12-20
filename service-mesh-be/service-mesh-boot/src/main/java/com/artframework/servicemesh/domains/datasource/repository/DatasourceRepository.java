package com.artframework.servicemesh.domains.datasource.repository;

import com.artframework.servicemesh.domains.datasource.dto.request.*;
import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface DatasourceRepository extends BaseRepository<DatasourceDTO, SvcMeshDatasourceDO> {

    /**
    * 分页查询
    * @param request 请求体
    * @return 返回数据
    */
    IPage<DatasourceDTO> page(DatasourcePageRequest request);


}
