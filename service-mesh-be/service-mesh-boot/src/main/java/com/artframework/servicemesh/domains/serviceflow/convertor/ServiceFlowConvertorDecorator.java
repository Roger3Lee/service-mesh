package com.artframework.servicemesh.domains.serviceflow.convertor;

import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Named("ServiceFlowConvertorDecorator")
public class ServiceFlowConvertorDecorator {

    @BeforeMapping
    public void before(ServiceFlowDTO dtoRequest) {
    }

    @AfterMapping
    public void after(ServiceFlowDTO dtoRequest, @MappingTarget SvcMeshFlowDO doRequest) {
    }
}
