package com.artframework.servicemesh.domains.datasource.lambdaexp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.servicemesh.entities.*;

import java.util.function.*;
import java.io.Serializable;

/**
* datasource
*
* @author auto
* @version v1.0
* @date 2023-12-17 12:20:56
*/
@Getter
@Setter
@ToString
public class DatasourceLambdaExp{
        /**
        * KEY  lambda
        */
        public static SFunction<DatasourceDTO, Serializable> dtoKeyLambda= DatasourceDTO::getId;

        /**
        * KEY  lambda
        */
        public static SFunction<SvcMeshDatasourceDO, Serializable> doKeyLambda= SvcMeshDatasourceDO::getId;

}
