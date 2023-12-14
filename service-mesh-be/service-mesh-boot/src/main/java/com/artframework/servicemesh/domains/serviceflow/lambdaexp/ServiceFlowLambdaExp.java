package com.artframework.servicemesh.domains.serviceflow.lambdaexp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.servicemesh.entities.*;

import java.util.function.*;
import java.io.Serializable;

/**
* serviceFlow
*
* @author auto
* @version v1.0
* @date 2023-12-14 21:13:24
*/
@Getter
@Setter
@ToString
public class ServiceFlowLambdaExp{
        /**
        * KEY  lambda
        */
        public static SFunction<ServiceFlowDTO, Serializable> dtoKeyLambda= ServiceFlowDTO::getId;

        /**
        * KEY  lambda
        */
        public static SFunction<SvcMeshFlowDO, Serializable> doKeyLambda= SvcMeshFlowDO::getId;


        /**
        *  svc_mesh_flow_config lambda
        */
        public static SFunction<ServiceFlowDTO.SvcMeshFlowConfigDTO, Serializable> svcMeshFlowConfigKeyLambda = ServiceFlowDTO.SvcMeshFlowConfigDTO::getId;


        /**
        * RELATE svc_mesh_flow_config lambda
        */
        public static SFunction<ServiceFlowDTO, Serializable> svcMeshFlowConfigSourceLambda = ServiceFlowDTO::getId;


        /**
        * RELATE user_address lambda
        */
        public static BiConsumer<ServiceFlowDTO.SvcMeshFlowConfigDTO,java.math.BigDecimal> svcMeshFlowConfigTargetSetLambda =ServiceFlowDTO.SvcMeshFlowConfigDTO::setFlowId;

        /**
        * RELATE svc_mesh_flow_config lambda
        */
        public static SFunction<SvcMeshFlowConfigDO,Serializable> svcMeshFlowConfigTargetLambda =SvcMeshFlowConfigDO::getFlowId;

        /**
        *  svc_mesh_flow_node lambda
        */
        public static SFunction<ServiceFlowDTO.SvcMeshFlowNodeDTO, Serializable> svcMeshFlowNodeKeyLambda = ServiceFlowDTO.SvcMeshFlowNodeDTO::getId;


        /**
        * RELATE svc_mesh_flow_node lambda
        */
        public static SFunction<ServiceFlowDTO, Serializable> svcMeshFlowNodeSourceLambda = ServiceFlowDTO::getId;


        /**
        * RELATE user_address lambda
        */
        public static BiConsumer<ServiceFlowDTO.SvcMeshFlowNodeDTO,java.math.BigDecimal> svcMeshFlowNodeTargetSetLambda =ServiceFlowDTO.SvcMeshFlowNodeDTO::setFlowId;

        /**
        * RELATE svc_mesh_flow_node lambda
        */
        public static SFunction<SvcMeshFlowNodeDO,Serializable> svcMeshFlowNodeTargetLambda =SvcMeshFlowNodeDO::getFlowId;

        /**
        *  svc_mesh_flow_invoke_log lambda
        */
        public static SFunction<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO, Serializable> svcMeshFlowInvokeLogKeyLambda = ServiceFlowDTO.SvcMeshFlowInvokeLogDTO::getId;


        /**
        * RELATE svc_mesh_flow_invoke_log lambda
        */
        public static SFunction<ServiceFlowDTO, Serializable> svcMeshFlowInvokeLogSourceLambda = ServiceFlowDTO::getId;


        /**
        * RELATE user_address lambda
        */
        public static BiConsumer<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO,java.math.BigDecimal> svcMeshFlowInvokeLogTargetSetLambda =ServiceFlowDTO.SvcMeshFlowInvokeLogDTO::setFlowId;

        /**
        * RELATE svc_mesh_flow_invoke_log lambda
        */
        public static SFunction<SvcMeshFlowInvokeLogDO,Serializable> svcMeshFlowInvokeLogTargetLambda =SvcMeshFlowInvokeLogDO::getFlowId;
}
