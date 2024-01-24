package com.artframework.servicemesh.domains.serviceflow.convertor;

import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.entities.*;
import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Named("ServiceFlowConvertorDecorator")
public class ServiceFlowConvertorDecorator {

    @BeforeMapping
    public void before(ServiceFlowDomain dtoRequest) {
    }

    @AfterMapping
    public void after(ServiceFlowDomain dtoRequest, @MappingTarget SvcMeshFlowDO doRequest) {
    }
}
