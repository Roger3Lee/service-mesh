package com.artframework.servicemesh.domains.service.lambdaexp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.servicemesh.entities.*;

import java.util.function.*;
import java.io.Serializable;

/**
* service
*
* @author auto
* @version v1.0
* @date 2023-12-14 21:13:24
*/
@Getter
@Setter
@ToString
public class ServiceLambdaExp{
        /**
        * KEY  lambda
        */
        public static SFunction<ServiceDTO, Serializable> dtoKeyLambda= ServiceDTO::getId;

        /**
        * KEY  lambda
        */
        public static SFunction<SvcMeshServiceDO, Serializable> doKeyLambda= SvcMeshServiceDO::getId;


        /**
        *  svc_mesh_datasource lambda
        */
        public static SFunction<ServiceDTO.SvcMeshDatasourceDTO, Serializable> svcMeshDatasourceKeyLambda = ServiceDTO.SvcMeshDatasourceDTO::getId;


        /**
        * RELATE svc_mesh_datasource lambda
        */
        public static SFunction<ServiceDTO, Serializable> svcMeshDatasourceSourceLambda = ServiceDTO::getDatasourceId;


        /**
        * RELATE user_address lambda
        */
        public static BiConsumer<ServiceDTO.SvcMeshDatasourceDTO,java.math.BigDecimal> svcMeshDatasourceTargetSetLambda =ServiceDTO.SvcMeshDatasourceDTO::setId;

        /**
        * RELATE svc_mesh_datasource lambda
        */
        public static SFunction<SvcMeshDatasourceDO,Serializable> svcMeshDatasourceTargetLambda =SvcMeshDatasourceDO::getId;
}
