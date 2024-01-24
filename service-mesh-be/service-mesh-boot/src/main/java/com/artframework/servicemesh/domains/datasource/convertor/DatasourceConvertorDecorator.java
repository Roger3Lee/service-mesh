package com.artframework.servicemesh.domains.datasource.convertor;

import com.artframework.servicemesh.domains.datasource.domain.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Named("DatasourceConvertorDecorator")
public class DatasourceConvertorDecorator {

    @BeforeMapping
    public void before(DatasourceDomain dtoRequest) {
    }

    @AfterMapping
    public void after(DatasourceDomain dtoRequest, @MappingTarget SvcMeshDatasourceDO doRequest) {
    }
}
