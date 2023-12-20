package com.artframework.servicemesh.domains.serviceflow.service.impl;

import com.artframework.servicemesh.domains.serviceflow.service.*;
import com.artframework.servicemesh.domains.serviceflow.dto.request.*;
import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.servicemesh.domains.serviceflow.repository.*;
import com.artframework.domain.core.service.impl.*;
import com.artframework.domain.core.uitls.*;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import com.artframework.servicemesh.domains.serviceflow.lambdaexp.*;

@Service
public class ServiceFlowServiceImpl extends BaseDomainServiceImpl implements ServiceFlowService {
    @Autowired
    private ServiceFlowRepository serviceFlowRepository;

    @Autowired
    private ServiceFlowRepository.SvcMeshFlowConfigRepository svcMeshFlowConfigRepository;

    @Autowired
    private ServiceFlowRepository.SvcMeshFlowNodeRepository svcMeshFlowNodeRepository;

    @Autowired
    private ServiceFlowRepository.SvcMeshFlowInvokeLogRepository svcMeshFlowInvokeLogRepository;

    /**
    * 分页查询
    * @param request 请求体
    * @return
    */
    @Override
    public IPage<ServiceFlowDTO> page(ServiceFlowPageRequest request){
        return serviceFlowRepository.page(request);
    }

    /**
    * 查找
    * @param request 请求体
    * @return
    */
    @Override
    public ServiceFlowDTO find(ServiceFlowFindRequest request){
        ServiceFlowDTO response = serviceFlowRepository.query(request.getKey(), ServiceFlowLambdaExp.doKeyLambda);
        if(ObjectUtil.isNull(response)){
            return response;
        }

        if (ObjectUtil.isNotNull(request.getLoadFlag())) {
            if(request.getLoadFlag().getLoadSvcMeshFlowConfig()){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowConfigSourceLambda.apply(response);
                response.setSvcMeshFlowConfig(svcMeshFlowConfigRepository.query(key, ServiceFlowLambdaExp.svcMeshFlowConfigTargetLambda));
            }
            if(request.getLoadFlag().getLoadSvcMeshFlowNode()){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowNodeSourceLambda.apply(response);
                response.setSvcMeshFlowNodeList(svcMeshFlowNodeRepository.queryList(key, ServiceFlowLambdaExp.svcMeshFlowNodeTargetLambda,
                                FiltersUtils.getEntityFilters(request.getLoadFlag().getFilters(), this.getEntityName(ServiceFlowDTO.SvcMeshFlowNodeDTO.class))));
            }
            if(request.getLoadFlag().getLoadSvcMeshFlowInvokeLog()){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowInvokeLogSourceLambda.apply(response);
                response.setSvcMeshFlowInvokeLogList(svcMeshFlowInvokeLogRepository.queryList(key, ServiceFlowLambdaExp.svcMeshFlowInvokeLogTargetLambda,
                                FiltersUtils.getEntityFilters(request.getLoadFlag().getFilters(), this.getEntityName(ServiceFlowDTO.SvcMeshFlowInvokeLogDTO.class))));
            }
        }
        response.setLoadFlag(request.getLoadFlag());
        return response;
    }


    /**
    * 新增
    * @param request 请求体
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insert(ServiceFlowCreateRequest request){
        //插入关联数据svc_mesh_flow_config
        if(ObjectUtil.isNotNull(request.getSvcMeshFlowConfig())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowConfigSourceLambda.apply(request);
            ServiceFlowLambdaExp.svcMeshFlowConfigTargetSetLambda.accept(request.getSvcMeshFlowConfig(),(Long)key);
            svcMeshFlowConfigRepository.insert(request.getSvcMeshFlowConfig());
        }
        //插入关联数据svc_mesh_flow_node
        if(CollUtil.isNotEmpty(request.getSvcMeshFlowNodeList())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowNodeSourceLambda.apply(request);
            request.getSvcMeshFlowNodeList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowNodeTargetSetLambda.accept(x,(Long)key));
            svcMeshFlowNodeRepository.insert(request.getSvcMeshFlowNodeList());
        }
        //插入关联数据svc_mesh_flow_invoke_log
        if(CollUtil.isNotEmpty(request.getSvcMeshFlowInvokeLogList())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowInvokeLogSourceLambda.apply(request);
            request.getSvcMeshFlowInvokeLogList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowInvokeLogTargetSetLambda.accept(x,(Long)key));
            svcMeshFlowInvokeLogRepository.insert(request.getSvcMeshFlowInvokeLogList());
        }
        //插入数据
        ServiceFlowDTO dto = serviceFlowRepository.insert(request);
        return (Long) ServiceFlowLambdaExp.dtoKeyLambda.apply(dto);
    }

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(ServiceFlowUpdateRequest request){
        Serializable keyId = ServiceFlowLambdaExp.dtoKeyLambda.apply(request);
        ServiceFlowDTO old = find(new ServiceFlowFindRequest(keyId, request.getLoadFlag()));
        if(ObjectUtil.isNotNull(request.getLoadFlag()) && request.getLoadFlag().getLoadSvcMeshFlowConfig()
            && ObjectUtil.isNotNull(request.getSvcMeshFlowConfig())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowConfigSourceLambda.apply(request);
            ServiceFlowLambdaExp.svcMeshFlowConfigTargetSetLambda.accept(request.getSvcMeshFlowConfig(),(Long)key);
            if(BooleanUtil.isTrue(request.getSvcMeshFlowConfig().getChanged())){
                svcMeshFlowConfigRepository.update(request.getSvcMeshFlowConfig());
            }
        }
        //更新关联数据svc_mesh_flow_node
        if(CollUtil.isNotEmpty(request.getSvcMeshFlowNodeList())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowNodeSourceLambda.apply(request);
            request.getSvcMeshFlowNodeList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowNodeTargetSetLambda.accept(x,(Long)key));
            this.merge(old.getSvcMeshFlowNodeList(), request.getSvcMeshFlowNodeList(), ServiceFlowLambdaExp.svcMeshFlowNodeKeyLambda, svcMeshFlowNodeRepository);
        }
        //更新关联数据svc_mesh_flow_invoke_log
        if(CollUtil.isNotEmpty(request.getSvcMeshFlowInvokeLogList())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowInvokeLogSourceLambda.apply(request);
            request.getSvcMeshFlowInvokeLogList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowInvokeLogTargetSetLambda.accept(x,(Long)key));
            this.merge(old.getSvcMeshFlowInvokeLogList(), request.getSvcMeshFlowInvokeLogList(), ServiceFlowLambdaExp.svcMeshFlowInvokeLogKeyLambda, svcMeshFlowInvokeLogRepository);
        }


        //更新数据
        serviceFlowRepository.update(request);
        return true;
    }

    /**
    * 删除
    * @param id 数据ID
    * @return 成功OR失败
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Long id){
        ServiceFlowDTO old = find(new ServiceFlowFindRequest(id ,new ServiceFlowDTO.LoadFlag()));

        //删除关联数据svc_mesh_flow_config
        if(ObjectUtil.isNotNull(old.getSvcMeshFlowConfig())){
            svcMeshFlowConfigRepository.delete(CollUtil.newArrayList(old.getSvcMeshFlowConfig()));
        }
        //删除关联数据svc_mesh_flow_node
        if(CollUtil.isNotEmpty(old.getSvcMeshFlowNodeList())){
            svcMeshFlowNodeRepository.delete(old.getSvcMeshFlowNodeList());
        }
        //删除关联数据svc_mesh_flow_invoke_log
        if(CollUtil.isNotEmpty(old.getSvcMeshFlowInvokeLogList())){
            svcMeshFlowInvokeLogRepository.delete(old.getSvcMeshFlowInvokeLogList());
        }
        return serviceFlowRepository.delete(CollUtil.newArrayList(old)) > 0;
    }
}
