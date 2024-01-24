package com.artframework.servicemesh.domains.serviceflow.service.impl;

import com.artframework.servicemesh.domains.serviceflow.service.*;
import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.domains.serviceflow.repository.*;
import com.artframework.domain.core.service.impl.*;
import com.artframework.domain.core.uitls.*;

import com.artframework.domain.core.domain.*;
import com.artframework.domain.core.repository.BaseRepository;
import cn.hutool.core.collection.*;
import cn.hutool.core.util.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.artframework.servicemesh.domains.serviceflow.lambdaexp.*;

import javax.annotation.PostConstruct;


@Service
public class ServiceFlowServiceImpl extends BaseDomainServiceImpl implements ServiceFlowService {
    //用於保存實體和repository之間的關�?
    private final Map<String, BaseRepository> _DomainRepositoryMap = new HashMap<>();
    @Autowired
    private ServiceFlowRepository serviceFlowRepository;

    @Autowired
    private SvcMeshFlowConfigRepository svcMeshFlowConfigRepository;

    @Autowired
    private SvcMeshFlowNodeRepository svcMeshFlowNodeRepository;

    @Autowired
    private SvcMeshFlowInvokeLogRepository svcMeshFlowInvokeLogRepository;

    @PostConstruct
    public void init(){
        _DomainRepositoryMap.put(FiltersUtils.getEntityName(ServiceFlowDomain.SvcMeshFlowConfigDomain.class), this.svcMeshFlowConfigRepository);
        _DomainRepositoryMap.put(FiltersUtils.getEntityName(ServiceFlowDomain.SvcMeshFlowNodeDomain.class), this.svcMeshFlowNodeRepository);
        _DomainRepositoryMap.put(FiltersUtils.getEntityName(ServiceFlowDomain.SvcMeshFlowInvokeLogDomain.class), this.svcMeshFlowInvokeLogRepository);
    }
    /**
    * 分页查询
    * @param request 请求�?
    * @return
    */
    @Override
    public IPage<ServiceFlowDomain> page(ServiceFlowPageDomain request){
        return serviceFlowRepository.page(request);
    }

   /**
    * 查找
    * @param request 请求�?
    * @return
    */
    @Override
    public ServiceFlowDomain find(ServiceFlowFindDomain request){
        return find(request, null);
    }

    /**
    * 查找
    * @param request 请求�?
    * @param response 原始數據，避免重新查詢主�?
    * @return
    */
    @Override
    public ServiceFlowDomain find(ServiceFlowFindDomain request, ServiceFlowDomain response){
        if(ObjectUtil.isNull(response)){
            response = serviceFlowRepository.query(request.getKey(), ServiceFlowLambdaExp.doKeyLambda);
            if(ObjectUtil.isNull(response)){
                return response;
            }
        }

        if (ObjectUtil.isNotNull(request.getLoadFlag())) {
            if(BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshFlowConfig())){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowConfigDomainEntitySourceLambda.apply(response);
                if(ObjectUtil.isNotNull(key)){
                    response.setSvcMeshFlowConfig(svcMeshFlowConfigRepository.query(key, ServiceFlowLambdaExp.svcMeshFlowConfigDOTargetLambda));
                }
            }
            if(BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshFlowNode())){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowNodeDomainEntitySourceLambda.apply(response);
                if(ObjectUtil.isNotNull(key)){
                    response.setSvcMeshFlowNodeList(svcMeshFlowNodeRepository.queryList(key, ServiceFlowLambdaExp.svcMeshFlowNodeDOTargetLambda,
                                    FiltersUtils.getEntityFilters(request.getLoadFlag().getFilters(), ServiceFlowDomain.SvcMeshFlowNodeDomain.class)));
                }
            }
            if(BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshFlowInvokeLog())){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainEntitySourceLambda.apply(response);
                if(ObjectUtil.isNotNull(key)){
                    response.setSvcMeshFlowInvokeLogList(svcMeshFlowInvokeLogRepository.queryList(key, ServiceFlowLambdaExp.svcMeshFlowInvokeLogDOTargetLambda,
                                    FiltersUtils.getEntityFilters(request.getLoadFlag().getFilters(), ServiceFlowDomain.SvcMeshFlowInvokeLogDomain.class)));
                }
            }
        }
        response.setLoadFlag(request.getLoadFlag());
        return response;
    }


    /**
     * 查找
     * @param request 请求�?
     * @param keyLambda 請求key參數對應的字段的lambda表達�?
     * @return
     */
    @Override
    public ServiceFlowDomain findByKey(ServiceFlowFindDomain request, SFunction<ServiceFlowDomain, Serializable> keyLambda){
        return find(request, serviceFlowRepository.queryByKey(request.getKey(), keyLambda));
    }

    /**
    * 新增
    * @param request 请求�?
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insert(ServiceFlowDomain request){
        //插入数据
        ServiceFlowDomain domain = serviceFlowRepository.insert(request);

        //插入关联数据svc_mesh_flow_config
        if(ObjectUtil.isNotNull(request.getSvcMeshFlowConfig())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowConfigDomainEntitySourceLambda.apply(domain);
            ServiceFlowLambdaExp.svcMeshFlowConfigDomainTargetSetLambda.accept(request.getSvcMeshFlowConfig(),(Long)key);
            svcMeshFlowConfigRepository.insert(request.getSvcMeshFlowConfig());
        }

        //插入关联数据svc_mesh_flow_node
        if(CollUtil.isNotEmpty(request.getSvcMeshFlowNodeList())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowNodeDomainEntitySourceLambda.apply(domain);
            request.getSvcMeshFlowNodeList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowNodeDomainTargetSetLambda.accept(x,(Long)key));
            svcMeshFlowNodeRepository.insert(request.getSvcMeshFlowNodeList());
        }

        //插入关联数据svc_mesh_flow_invoke_log
        if(CollUtil.isNotEmpty(request.getSvcMeshFlowInvokeLogList())){
            Serializable key = ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainEntitySourceLambda.apply(domain);
            request.getSvcMeshFlowInvokeLogList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainTargetSetLambda.accept(x,(Long)key));
            svcMeshFlowInvokeLogRepository.insert(request.getSvcMeshFlowInvokeLogList());
        }
        return (Long) ServiceFlowLambdaExp.dtoKeyLambda.apply(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(ServiceFlowDomain request){
        Serializable keyId = ServiceFlowLambdaExp.dtoKeyLambda.apply(request);
        ServiceFlowDomain old = find(new ServiceFlowFindDomain(keyId, null));
        return update(request,old);
    }
    /**
    * 修改
    * @param request 请求�?
    * @param domain 原始數據，避免重新查詢主�?
    * @return 成功OR失败
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(ServiceFlowDomain request, ServiceFlowDomain domain){
        Serializable keyId = ServiceFlowLambdaExp.dtoKeyLambda.apply(request);
        ServiceFlowDomain old = find(new ServiceFlowFindDomain(keyId, request.getLoadFlag()), domain);
        //更新关联数据svc_mesh_flow_config
        if(ObjectUtil.isNotNull(request.getLoadFlag())
            && (BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshFlowConfig()))){
            if(ObjectUtil.isNotNull(request.getSvcMeshFlowConfig())){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowConfigDomainEntitySourceLambda.apply(request);
                ServiceFlowLambdaExp.svcMeshFlowConfigDomainTargetSetLambda.accept(request.getSvcMeshFlowConfig(),(Long)key);
            }
            this.merge(ObjectUtil.isNotNull(old.getSvcMeshFlowConfig())? CollUtil.toList(old.getSvcMeshFlowConfig()):ListUtil.empty(),
                    ObjectUtil.isNotNull(request.getSvcMeshFlowConfig())? CollUtil.toList(request.getSvcMeshFlowConfig()):ListUtil.empty(),
                    ServiceFlowLambdaExp.svcMeshFlowConfigDomainKeyLambda, svcMeshFlowConfigRepository);
        }
        //更新关联数据svc_mesh_flow_node
        if(ObjectUtil.isNotNull(request.getLoadFlag())
            && (BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshFlowNode()))){
            if(CollUtil.isNotEmpty(request.getSvcMeshFlowNodeList())){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowNodeDomainEntitySourceLambda.apply(request);
                request.getSvcMeshFlowNodeList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowNodeDomainTargetSetLambda.accept(x,(Long)key));
            }
            this.merge(old.getSvcMeshFlowNodeList(), request.getSvcMeshFlowNodeList(), ServiceFlowLambdaExp.svcMeshFlowNodeDomainKeyLambda, svcMeshFlowNodeRepository);
        }
        //更新关联数据svc_mesh_flow_invoke_log
        if(ObjectUtil.isNotNull(request.getLoadFlag())
            && (BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshFlowInvokeLog()))){
            if(CollUtil.isNotEmpty(request.getSvcMeshFlowInvokeLogList())){
                Serializable key = ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainEntitySourceLambda.apply(request);
                request.getSvcMeshFlowInvokeLogList().forEach(x->ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainTargetSetLambda.accept(x,(Long)key));
            }
            this.merge(old.getSvcMeshFlowInvokeLogList(), request.getSvcMeshFlowInvokeLogList(), ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainKeyLambda, svcMeshFlowInvokeLogRepository);
        }


        //更新数据
        if(request.getChanged()){
            serviceFlowRepository.update(request);
        }
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
        ServiceFlowDomain old = find(new ServiceFlowFindDomain(id ,ServiceFlowDomain.LoadFlag.builder().build()));
        if (ObjectUtil.isNull(old)) {
            return false;
        }

        //删除关联数据svc_mesh_flow_config
        svcMeshFlowConfigRepository.deleteByFilter(ListUtil.toList(FiltersUtils.build(ServiceFlowLambdaExp.svcMeshFlowConfigDomainTargetLambda,
               ServiceFlowLambdaExp.svcMeshFlowConfigDomainEntitySourceLambda.apply(old))));
        //删除关联数据svc_mesh_flow_node
        svcMeshFlowNodeRepository.deleteByFilter(ListUtil.toList(FiltersUtils.build(ServiceFlowLambdaExp.svcMeshFlowNodeDomainTargetLambda,
               ServiceFlowLambdaExp.svcMeshFlowNodeDomainEntitySourceLambda.apply(old))));
        //删除关联数据svc_mesh_flow_invoke_log
        svcMeshFlowInvokeLogRepository.deleteByFilter(ListUtil.toList(FiltersUtils.build(ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainTargetLambda,
               ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainEntitySourceLambda.apply(old))));
        return serviceFlowRepository.delete(CollUtil.newArrayList(old)) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteRelated(List<BaseLoadFlag.Filter> filters) {
        if (CollUtil.isEmpty(filters)) {
            return false;
        }

        int totalEffect = 0;
        Map<String, List<BaseLoadFlag.Filter>> filterMap = filters.stream().collect(Collectors.groupingBy(BaseLoadFlag.Filter::getEntity));
        for (Map.Entry<String, List<BaseLoadFlag.Filter>> item : filterMap.entrySet()) {
            BaseRepository repository = _DomainRepositoryMap.get(item.getKey());
            if (null == repository) {
                throw new UnsupportedOperationException("刪除不支持的實體:" + item.getKey());
            }

            totalEffect += repository.deleteByFilter(item.getValue());
        }

        return totalEffect > 0;
    }
}
