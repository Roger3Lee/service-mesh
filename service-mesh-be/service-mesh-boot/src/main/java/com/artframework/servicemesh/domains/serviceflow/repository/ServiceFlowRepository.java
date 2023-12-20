package com.artframework.servicemesh.domains.serviceflow.repository;

import com.artframework.servicemesh.domains.serviceflow.dto.request.*;
import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

public interface ServiceFlowRepository extends BaseRepository<ServiceFlowDTO, SvcMeshFlowDO> {

    /**
    * 分页查询
    * @param request 请求体
    * @return 返回数据
    */
    IPage<ServiceFlowDTO> page(ServiceFlowPageRequest request);

    public interface SvcMeshFlowConfigRepository extends BaseRepository<ServiceFlowDTO.SvcMeshFlowConfigDTO, SvcMeshFlowConfigDO> {
    }
    public interface SvcMeshFlowNodeRepository extends BaseRepository<ServiceFlowDTO.SvcMeshFlowNodeDTO, SvcMeshFlowNodeDO> {
    }
    public interface SvcMeshFlowInvokeLogRepository extends BaseRepository<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO, SvcMeshFlowInvokeLogDO> {
    }

}
