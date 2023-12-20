package com.artframework.servicemesh.domains.service.repository;

import com.artframework.servicemesh.domains.service.dto.request.*;
import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface ServiceRepository extends BaseRepository<ServiceDTO, SvcMeshServiceDO> {

    /**
    * 分页查询
    * @param request 请求体
    * @return 返回数据
    */
    IPage<ServiceDTO> page(ServicePageRequest request);

    public interface SvcMeshDatasourceRepository extends BaseRepository<ServiceDTO.SvcMeshDatasourceDTO, SvcMeshDatasourceDO> {
    }

}
