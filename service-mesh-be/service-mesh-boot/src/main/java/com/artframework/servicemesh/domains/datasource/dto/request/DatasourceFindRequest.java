package com.artframework.servicemesh.domains.datasource.dto.request;

import lombok.*;

import java.io.Serializable;

import com.artframework.servicemesh.domains.datasource.dto.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DatasourceFindRequest {
    private Serializable key;

    /**
    * 默认加载所有
    */
    private DatasourceDTO.LoadFlag loadFlag = new DatasourceDTO.LoadFlag();
}
