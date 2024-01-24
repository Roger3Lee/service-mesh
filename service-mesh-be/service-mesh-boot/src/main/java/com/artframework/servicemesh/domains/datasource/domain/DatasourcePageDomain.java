package com.artframework.servicemesh.domains.datasource.domain;

import com.artframework.domain.core.domain.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DatasourcePageDomain extends PageDomain {
    private String code;
    private String name;
    private List<String> type;
}
