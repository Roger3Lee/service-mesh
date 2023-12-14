package com.artframework.servicemesh.domains.serviceflow.dto.request;

import lombok.*;

import java.io.Serializable;

import com.artframework.servicemesh.domains.serviceflow.dto.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFlowFindRequest {
    private Serializable key;

    /**
    * 默认加载所有
    */
    private ServiceFlowDTO.LoadFlag loadFlag = new ServiceFlowDTO.LoadFlag();
}
