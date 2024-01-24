
package com.artframework.servicemesh.domains.serviceflow.convertor;

import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ServiceFlowConvertorDecorator.class)
public interface  ServiceFlowConvertor{
    ServiceFlowConvertor INSTANCE= Mappers.getMapper(ServiceFlowConvertor.class);

    ServiceFlowDomain convert2DTO(SvcMeshFlowDO request);
    void convert2DTO(SvcMeshFlowDO request, @MappingTarget ServiceFlowDomain target);
    List<ServiceFlowDomain> convert2DTO(List<SvcMeshFlowDO> request);


    @BeanMapping(qualifiedByName = { "ServiceFlowConvertorDecorator"})
    SvcMeshFlowDO convert2DO(ServiceFlowDomain request);
    List<SvcMeshFlowDO> convert2DO(List<ServiceFlowDomain> request);

    ServiceFlowDomain.SvcMeshFlowConfigDomain convert2SvcMeshFlowConfigDTO(SvcMeshFlowConfigDO request);
    void convert2SvcMeshFlowConfigDTO(SvcMeshFlowConfigDO request, @MappingTarget ServiceFlowDomain.SvcMeshFlowConfigDomain target);
    List<ServiceFlowDomain.SvcMeshFlowConfigDomain> convert2SvcMeshFlowConfigDTO(List<SvcMeshFlowConfigDO>  request);
    SvcMeshFlowConfigDO convert2SvcMeshFlowConfigDO(ServiceFlowDomain.SvcMeshFlowConfigDomain request);
    List<SvcMeshFlowConfigDO> convert2SvcMeshFlowConfigDO(List<ServiceFlowDomain.SvcMeshFlowConfigDomain>  request);
    ServiceFlowDomain.SvcMeshFlowNodeDomain convert2SvcMeshFlowNodeDTO(SvcMeshFlowNodeDO request);
    void convert2SvcMeshFlowNodeDTO(SvcMeshFlowNodeDO request, @MappingTarget ServiceFlowDomain.SvcMeshFlowNodeDomain target);
    List<ServiceFlowDomain.SvcMeshFlowNodeDomain> convert2SvcMeshFlowNodeDTO(List<SvcMeshFlowNodeDO>  request);
    SvcMeshFlowNodeDO convert2SvcMeshFlowNodeDO(ServiceFlowDomain.SvcMeshFlowNodeDomain request);
    List<SvcMeshFlowNodeDO> convert2SvcMeshFlowNodeDO(List<ServiceFlowDomain.SvcMeshFlowNodeDomain>  request);
    ServiceFlowDomain.SvcMeshFlowInvokeLogDomain convert2SvcMeshFlowInvokeLogDTO(SvcMeshFlowInvokeLogDO request);
    void convert2SvcMeshFlowInvokeLogDTO(SvcMeshFlowInvokeLogDO request, @MappingTarget ServiceFlowDomain.SvcMeshFlowInvokeLogDomain target);
    List<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain> convert2SvcMeshFlowInvokeLogDTO(List<SvcMeshFlowInvokeLogDO>  request);
    SvcMeshFlowInvokeLogDO convert2SvcMeshFlowInvokeLogDO(ServiceFlowDomain.SvcMeshFlowInvokeLogDomain request);
    List<SvcMeshFlowInvokeLogDO> convert2SvcMeshFlowInvokeLogDO(List<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain>  request);

}
