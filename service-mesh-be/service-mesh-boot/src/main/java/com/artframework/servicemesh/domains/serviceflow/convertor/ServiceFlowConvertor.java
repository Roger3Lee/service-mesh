
package com.artframework.servicemesh.domains.serviceflow.convertor;

import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ServiceFlowConvertorDecorator.class)
public interface  ServiceFlowConvertor{
    ServiceFlowConvertor INSTANCE= Mappers.getMapper(ServiceFlowConvertor.class);

    ServiceFlowDTO convert2DTO(SvcMeshFlowDO request);
    List<ServiceFlowDTO> convert2DTO(List<SvcMeshFlowDO> request);

    @BeanMapping(qualifiedByName = { "ServiceFlowConvertorDecorator"})
    SvcMeshFlowDO convert2DO(ServiceFlowDTO request);
    List<SvcMeshFlowDO> convert2DO(List<ServiceFlowDTO> request);

    ServiceFlowDTO.SvcMeshFlowConfigDTO convert2SvcMeshFlowConfigDTO(SvcMeshFlowConfigDO request);
    List<ServiceFlowDTO.SvcMeshFlowConfigDTO> convert2SvcMeshFlowConfigDTO(List<SvcMeshFlowConfigDO>  request);
    SvcMeshFlowConfigDO convert2SvcMeshFlowConfigDO(ServiceFlowDTO.SvcMeshFlowConfigDTO request);
    List<SvcMeshFlowConfigDO> convert2SvcMeshFlowConfigDO(List<ServiceFlowDTO.SvcMeshFlowConfigDTO>  request);
    ServiceFlowDTO.SvcMeshFlowNodeDTO convert2SvcMeshFlowNodeDTO(SvcMeshFlowNodeDO request);
    List<ServiceFlowDTO.SvcMeshFlowNodeDTO> convert2SvcMeshFlowNodeDTO(List<SvcMeshFlowNodeDO>  request);
    SvcMeshFlowNodeDO convert2SvcMeshFlowNodeDO(ServiceFlowDTO.SvcMeshFlowNodeDTO request);
    List<SvcMeshFlowNodeDO> convert2SvcMeshFlowNodeDO(List<ServiceFlowDTO.SvcMeshFlowNodeDTO>  request);
    ServiceFlowDTO.SvcMeshFlowInvokeLogDTO convert2SvcMeshFlowInvokeLogDTO(SvcMeshFlowInvokeLogDO request);
    List<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO> convert2SvcMeshFlowInvokeLogDTO(List<SvcMeshFlowInvokeLogDO>  request);
    SvcMeshFlowInvokeLogDO convert2SvcMeshFlowInvokeLogDO(ServiceFlowDTO.SvcMeshFlowInvokeLogDTO request);
    List<SvcMeshFlowInvokeLogDO> convert2SvcMeshFlowInvokeLogDO(List<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO>  request);

}
