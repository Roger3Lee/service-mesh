package com.artframework.servicemesh.domains.datasource.dto.request;

import com.artframework.domain.core.dto.request.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DatasourcePageRequest extends PageRequest {
    private String code;
    private String name;
    private List<String> type;
}
