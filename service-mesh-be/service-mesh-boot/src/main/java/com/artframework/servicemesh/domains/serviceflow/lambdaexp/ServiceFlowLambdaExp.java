package com.artframework.servicemesh.domains.serviceflow.lambdaexp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.entities.*;

import java.util.function.*;
import java.io.Serializable;

/**
* serviceFlow
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
public class ServiceFlowLambdaExp{
    /**
    * KEY  lambda
    */
    public static SFunction<ServiceFlowDomain, Serializable> dtoKeyLambda= ServiceFlowDomain::getId;

    /**
    * KEY  lambda
    */
    public static SFunction<SvcMeshFlowDO, Serializable> doKeyLambda= SvcMeshFlowDO::getId;


    /**
    *  svc_mesh_flow_config lambda
    */
    public static SFunction<ServiceFlowDomain.SvcMeshFlowConfigDomain, Serializable> svcMeshFlowConfigDomainKeyLambda = ServiceFlowDomain.SvcMeshFlowConfigDomain::getId;


    /**
    * RELATE svc_mesh_flow_config lambda
    */
    public static SFunction<ServiceFlowDomain, Serializable> svcMeshFlowConfigDomainEntitySourceLambda = ServiceFlowDomain::getId;


    /**
    * RELATE svc_mesh_flow_config lambda
    */
    public static BiConsumer<ServiceFlowDomain.SvcMeshFlowConfigDomain,Long> svcMeshFlowConfigDomainTargetSetLambda =ServiceFlowDomain.SvcMeshFlowConfigDomain::setFlowId;

  /**
    * RELATE svc_mesh_flow_config lambda
    */
    public static SFunction<ServiceFlowDomain.SvcMeshFlowConfigDomain,Serializable> svcMeshFlowConfigDomainTargetLambda =ServiceFlowDomain.SvcMeshFlowConfigDomain::getFlowId;


    /**
    * RELATE svc_mesh_flow_config lambda
    */
    public static SFunction<SvcMeshFlowConfigDO,Serializable> svcMeshFlowConfigDOTargetLambda =SvcMeshFlowConfigDO::getFlowId;

    /**
    *  svc_mesh_flow_node lambda
    */
    public static SFunction<ServiceFlowDomain.SvcMeshFlowNodeDomain, Serializable> svcMeshFlowNodeDomainKeyLambda = ServiceFlowDomain.SvcMeshFlowNodeDomain::getId;


    /**
    * RELATE svc_mesh_flow_node lambda
    */
    public static SFunction<ServiceFlowDomain, Serializable> svcMeshFlowNodeDomainEntitySourceLambda = ServiceFlowDomain::getId;


    /**
    * RELATE svc_mesh_flow_node lambda
    */
    public static BiConsumer<ServiceFlowDomain.SvcMeshFlowNodeDomain,Long> svcMeshFlowNodeDomainTargetSetLambda =ServiceFlowDomain.SvcMeshFlowNodeDomain::setFlowId;

  /**
    * RELATE svc_mesh_flow_node lambda
    */
    public static SFunction<ServiceFlowDomain.SvcMeshFlowNodeDomain,Serializable> svcMeshFlowNodeDomainTargetLambda =ServiceFlowDomain.SvcMeshFlowNodeDomain::getFlowId;


    /**
    * RELATE svc_mesh_flow_node lambda
    */
    public static SFunction<SvcMeshFlowNodeDO,Serializable> svcMeshFlowNodeDOTargetLambda =SvcMeshFlowNodeDO::getFlowId;

    /**
    *  svc_mesh_flow_invoke_log lambda
    */
    public static SFunction<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain, Serializable> svcMeshFlowInvokeLogDomainKeyLambda = ServiceFlowDomain.SvcMeshFlowInvokeLogDomain::getId;


    /**
    * RELATE svc_mesh_flow_invoke_log lambda
    */
    public static SFunction<ServiceFlowDomain, Serializable> svcMeshFlowInvokeLogDomainEntitySourceLambda = ServiceFlowDomain::getId;


    /**
    * RELATE svc_mesh_flow_invoke_log lambda
    */
    public static BiConsumer<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain,Long> svcMeshFlowInvokeLogDomainTargetSetLambda =ServiceFlowDomain.SvcMeshFlowInvokeLogDomain::setFlowId;

  /**
    * RELATE svc_mesh_flow_invoke_log lambda
    */
    public static SFunction<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain,Serializable> svcMeshFlowInvokeLogDomainTargetLambda =ServiceFlowDomain.SvcMeshFlowInvokeLogDomain::getFlowId;


    /**
    * RELATE svc_mesh_flow_invoke_log lambda
    */
    public static SFunction<SvcMeshFlowInvokeLogDO,Serializable> svcMeshFlowInvokeLogDOTargetLambda =SvcMeshFlowInvokeLogDO::getFlowId;

}
