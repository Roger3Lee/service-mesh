
package com.artframework.servicemesh.domains.service.convertor;

import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ServiceConvertorDecorator.class)
public interface  ServiceConvertor{
    ServiceConvertor INSTANCE= Mappers.getMapper(ServiceConvertor.class);

    ServiceDTO convert2DTO(SvcMeshServiceDO request);
    List<ServiceDTO> convert2DTO(List<SvcMeshServiceDO> request);

    @BeanMapping(qualifiedByName = { "ServiceConvertorDecorator"})
    SvcMeshServiceDO convert2DO(ServiceDTO request);
    List<SvcMeshServiceDO> convert2DO(List<ServiceDTO> request);

    ServiceDTO.SvcMeshDatasourceDTO convert2SvcMeshDatasourceDTO(SvcMeshDatasourceDO request);
    List<ServiceDTO.SvcMeshDatasourceDTO> convert2SvcMeshDatasourceDTO(List<SvcMeshDatasourceDO>  request);
    SvcMeshDatasourceDO convert2SvcMeshDatasourceDO(ServiceDTO.SvcMeshDatasourceDTO request);
    List<SvcMeshDatasourceDO> convert2SvcMeshDatasourceDO(List<ServiceDTO.SvcMeshDatasourceDTO>  request);
}
