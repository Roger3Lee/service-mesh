package com.artframework.servicemesh.domains.service.convertor;

import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Named("ServiceConvertorDecorator")
public class ServiceConvertorDecorator {

    @BeforeMapping
    public void before(ServiceDomain dtoRequest) {
    }

    @AfterMapping
    public void after(ServiceDomain dtoRequest, @MappingTarget SvcMeshServiceDO doRequest) {
    }
}
