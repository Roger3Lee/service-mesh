package com.artframework.servicemesh.domains.service.convertor;

import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Named("ServiceConvertorDecorator")
public class ServiceConvertorDecorator {

    @BeforeMapping
    public void before(ServiceDTO dtoRequest) {
    }

    @AfterMapping
    public void after(ServiceDTO dtoRequest, @MappingTarget SvcMeshServiceDO doRequest) {
    }
}
