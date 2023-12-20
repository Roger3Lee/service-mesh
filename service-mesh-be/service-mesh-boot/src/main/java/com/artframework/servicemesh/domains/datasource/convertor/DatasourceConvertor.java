
package com.artframework.servicemesh.domains.datasource.convertor;

import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = DatasourceConvertorDecorator.class)
public interface  DatasourceConvertor{
    DatasourceConvertor INSTANCE= Mappers.getMapper(DatasourceConvertor.class);

    DatasourceDTO convert2DTO(SvcMeshDatasourceDO request);
    List<DatasourceDTO> convert2DTO(List<SvcMeshDatasourceDO> request);

    @BeanMapping(qualifiedByName = { "DatasourceConvertorDecorator"})
    SvcMeshDatasourceDO convert2DO(DatasourceDTO request);
    List<SvcMeshDatasourceDO> convert2DO(List<DatasourceDTO> request);


}
