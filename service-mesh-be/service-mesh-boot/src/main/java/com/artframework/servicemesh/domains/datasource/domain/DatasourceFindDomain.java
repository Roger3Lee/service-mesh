package com.artframework.servicemesh.domains.datasource.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DatasourceFindDomain {
    private Serializable key;

    /**
    * 默认加载�?�?
    */
    @Builder.Default
    private DatasourceDomain.LoadFlag loadFlag = new DatasourceDomain.LoadFlag();
}
