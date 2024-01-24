package com.artframework.servicemesh.domains.service.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceFindDomain {
    private Serializable key;

    /**
    * 默认加载�?�?
    */
    @Builder.Default
    private ServiceDomain.LoadFlag loadFlag = new ServiceDomain.LoadFlag();
}
