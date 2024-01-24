
package com.artframework.servicemesh.domains.datasource.convertor;

import com.artframework.servicemesh.domains.datasource.domain.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = DatasourceConvertorDecorator.class)
public interface  DatasourceConvertor{
    DatasourceConvertor INSTANCE= Mappers.getMapper(DatasourceConvertor.class);

    DatasourceDomain convert2DTO(SvcMeshDatasourceDO request);
    void convert2DTO(SvcMeshDatasourceDO request, @MappingTarget DatasourceDomain target);
    List<DatasourceDomain> convert2DTO(List<SvcMeshDatasourceDO> request);


    @BeanMapping(qualifiedByName = { "DatasourceConvertorDecorator"})
    SvcMeshDatasourceDO convert2DO(DatasourceDomain request);
    List<SvcMeshDatasourceDO> convert2DO(List<DatasourceDomain> request);


}
