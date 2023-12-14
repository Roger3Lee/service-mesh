package com.artframework.servicemesh.domains.datasource.convertor;

import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Named("DatasourceConvertorDecorator")
public class DatasourceConvertorDecorator {

    @BeforeMapping
    public void before(DatasourceDTO dtoRequest) {
    }

    @AfterMapping
    public void after(DatasourceDTO dtoRequest, @MappingTarget SvcMeshDatasourceDO doRequest) {
    }
}
