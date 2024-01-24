package com.artframework.servicemesh.domains.service.lambdaexp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.entities.*;

import java.util.function.*;
import java.io.Serializable;

/**
* service
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
public class ServiceLambdaExp{
    /**
    * KEY  lambda
    */
    public static SFunction<ServiceDomain, Serializable> dtoKeyLambda= ServiceDomain::getId;

    /**
    * KEY  lambda
    */
    public static SFunction<SvcMeshServiceDO, Serializable> doKeyLambda= SvcMeshServiceDO::getId;


    /**
    *  svc_mesh_datasource lambda
    */
    public static SFunction<ServiceDomain.SvcMeshDatasourceDomain, Serializable> svcMeshDatasourceDomainKeyLambda = ServiceDomain.SvcMeshDatasourceDomain::getId;


    /**
    * RELATE svc_mesh_datasource lambda
    */
    public static SFunction<ServiceDomain, Serializable> svcMeshDatasourceDomainEntitySourceLambda = ServiceDomain::getDatasourceId;


    /**
    * RELATE svc_mesh_datasource lambda
    */
    public static BiConsumer<ServiceDomain.SvcMeshDatasourceDomain,Long> svcMeshDatasourceDomainTargetSetLambda =ServiceDomain.SvcMeshDatasourceDomain::setId;

  /**
    * RELATE svc_mesh_datasource lambda
    */
    public static SFunction<ServiceDomain.SvcMeshDatasourceDomain,Serializable> svcMeshDatasourceDomainTargetLambda =ServiceDomain.SvcMeshDatasourceDomain::getId;


    /**
    * RELATE svc_mesh_datasource lambda
    */
    public static SFunction<SvcMeshDatasourceDO,Serializable> svcMeshDatasourceDOTargetLambda =SvcMeshDatasourceDO::getId;

}
