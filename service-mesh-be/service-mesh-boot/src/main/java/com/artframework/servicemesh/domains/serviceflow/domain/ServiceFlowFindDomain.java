package com.artframework.servicemesh.domains.serviceflow.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceFlowFindDomain {
    private Serializable key;

    /**
    * 默认加载�?�?
    */
    @Builder.Default
    private ServiceFlowDomain.LoadFlag loadFlag = new ServiceFlowDomain.LoadFlag();
}
