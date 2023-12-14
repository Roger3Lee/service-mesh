package com.artframework.servicemesh.domains.service.dto.request;

import lombok.*;

import java.io.Serializable;

import com.artframework.servicemesh.domains.service.dto.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFindRequest {
    private Serializable key;

    /**
    * 默认加载所有
    */
    private ServiceDTO.LoadFlag loadFlag = new ServiceDTO.LoadFlag();
}
