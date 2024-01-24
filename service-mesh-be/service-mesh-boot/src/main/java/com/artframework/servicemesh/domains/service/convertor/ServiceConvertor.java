
package com.artframework.servicemesh.domains.service.convertor;

import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ServiceConvertorDecorator.class)
public interface  ServiceConvertor{
    ServiceConvertor INSTANCE= Mappers.getMapper(ServiceConvertor.class);

    ServiceDomain convert2DTO(SvcMeshServiceDO request);
    void convert2DTO(SvcMeshServiceDO request, @MappingTarget ServiceDomain target);
    List<ServiceDomain> convert2DTO(List<SvcMeshServiceDO> request);


    @BeanMapping(qualifiedByName = { "ServiceConvertorDecorator"})
    SvcMeshServiceDO convert2DO(ServiceDomain request);
    List<SvcMeshServiceDO> convert2DO(List<ServiceDomain> request);

    ServiceDomain.SvcMeshDatasourceDomain convert2SvcMeshDatasourceDTO(SvcMeshDatasourceDO request);
    void convert2SvcMeshDatasourceDTO(SvcMeshDatasourceDO request, @MappingTarget ServiceDomain.SvcMeshDatasourceDomain target);
    List<ServiceDomain.SvcMeshDatasourceDomain> convert2SvcMeshDatasourceDTO(List<SvcMeshDatasourceDO>  request);
    SvcMeshDatasourceDO convert2SvcMeshDatasourceDO(ServiceDomain.SvcMeshDatasourceDomain request);
    List<SvcMeshDatasourceDO> convert2SvcMeshDatasourceDO(List<ServiceDomain.SvcMeshDatasourceDomain>  request);

}
