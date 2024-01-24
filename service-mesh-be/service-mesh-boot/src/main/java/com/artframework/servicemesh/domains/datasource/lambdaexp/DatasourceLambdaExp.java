package com.artframework.servicemesh.domains.datasource.lambdaexp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.artframework.servicemesh.domains.datasource.domain.*;
import com.artframework.servicemesh.entities.*;

import java.util.function.*;
import java.io.Serializable;

/**
* datasource
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
public class DatasourceLambdaExp{
    /**
    * KEY  lambda
    */
    public static SFunction<DatasourceDomain, Serializable> dtoKeyLambda= DatasourceDomain::getId;

    /**
    * KEY  lambda
    */
    public static SFunction<SvcMeshDatasourceDO, Serializable> doKeyLambda= SvcMeshDatasourceDO::getId;


}
