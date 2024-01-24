package com.artframework.servicemesh.domains.service.service.impl;

import com.artframework.servicemesh.domains.service.service.*;
import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.domains.service.repository.*;
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

import com.artframework.servicemesh.domains.service.lambdaexp.*;

import javax.annotation.PostConstruct;


@Service
public class ServiceServiceImpl extends BaseDomainServiceImpl implements ServiceService {
    //用於保存實體和repository之間的關�?
    private final Map<String, BaseRepository> _DomainRepositoryMap = new HashMap<>();
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private SvcMeshDatasourceRepository svcMeshDatasourceRepository;

    @PostConstruct
    public void init(){
        _DomainRepositoryMap.put(FiltersUtils.getEntityName(ServiceDomain.SvcMeshDatasourceDomain.class), this.svcMeshDatasourceRepository);
    }
    /**
    * 分页查询
    * @param request 请求�?
    * @return
    */
    @Override
    public IPage<ServiceDomain> page(ServicePageDomain request){
        return serviceRepository.page(request);
    }

   /**
    * 查找
    * @param request 请求�?
    * @return
    */
    @Override
    public ServiceDomain find(ServiceFindDomain request){
        return find(request, null);
    }

    /**
    * 查找
    * @param request 请求�?
    * @param response 原始數據，避免重新查詢主�?
    * @return
    */
    @Override
    public ServiceDomain find(ServiceFindDomain request, ServiceDomain response){
        if(ObjectUtil.isNull(response)){
            response = serviceRepository.query(request.getKey(), ServiceLambdaExp.doKeyLambda);
            if(ObjectUtil.isNull(response)){
                return response;
            }
        }

        if (ObjectUtil.isNotNull(request.getLoadFlag())) {
            if(BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshDatasource())){
                Serializable key = ServiceLambdaExp.svcMeshDatasourceDomainEntitySourceLambda.apply(response);
                if(ObjectUtil.isNotNull(key)){
                    response.setSvcMeshDatasource(svcMeshDatasourceRepository.query(key, ServiceLambdaExp.svcMeshDatasourceDOTargetLambda));
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
    public ServiceDomain findByKey(ServiceFindDomain request, SFunction<ServiceDomain, Serializable> keyLambda){
        return find(request, serviceRepository.queryByKey(request.getKey(), keyLambda));
    }

    /**
    * 新增
    * @param request 请求�?
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insert(ServiceDomain request){
        //插入数据
        ServiceDomain domain = serviceRepository.insert(request);

        //插入关联数据svc_mesh_datasource
        if(ObjectUtil.isNotNull(request.getSvcMeshDatasource())){
            Serializable key = ServiceLambdaExp.svcMeshDatasourceDomainEntitySourceLambda.apply(domain);
            ServiceLambdaExp.svcMeshDatasourceDomainTargetSetLambda.accept(request.getSvcMeshDatasource(),(Long)key);
            svcMeshDatasourceRepository.insert(request.getSvcMeshDatasource());
        }
        return (Long) ServiceLambdaExp.dtoKeyLambda.apply(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(ServiceDomain request){
        Serializable keyId = ServiceLambdaExp.dtoKeyLambda.apply(request);
        ServiceDomain old = find(new ServiceFindDomain(keyId, null));
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
    public Boolean update(ServiceDomain request, ServiceDomain domain){
        Serializable keyId = ServiceLambdaExp.dtoKeyLambda.apply(request);
        ServiceDomain old = find(new ServiceFindDomain(keyId, request.getLoadFlag()), domain);
        //更新关联数据svc_mesh_datasource
        if(ObjectUtil.isNotNull(request.getLoadFlag())
            && (BooleanUtil.isTrue(request.getLoadFlag().getLoadAll()) || BooleanUtil.isTrue(request.getLoadFlag().getLoadSvcMeshDatasource()))){
            if(ObjectUtil.isNotNull(request.getSvcMeshDatasource())){
                Serializable key = ServiceLambdaExp.svcMeshDatasourceDomainEntitySourceLambda.apply(request);
                ServiceLambdaExp.svcMeshDatasourceDomainTargetSetLambda.accept(request.getSvcMeshDatasource(),(Long)key);
            }
            this.merge(ObjectUtil.isNotNull(old.getSvcMeshDatasource())? CollUtil.toList(old.getSvcMeshDatasource()):ListUtil.empty(),
                    ObjectUtil.isNotNull(request.getSvcMeshDatasource())? CollUtil.toList(request.getSvcMeshDatasource()):ListUtil.empty(),
                    ServiceLambdaExp.svcMeshDatasourceDomainKeyLambda, svcMeshDatasourceRepository);
        }


        //更新数据
        if(request.getChanged()){
            serviceRepository.update(request);
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
        ServiceDomain old = find(new ServiceFindDomain(id ,ServiceDomain.LoadFlag.builder().build()));
        if (ObjectUtil.isNull(old)) {
            return false;
        }

        //删除关联数据svc_mesh_datasource
        svcMeshDatasourceRepository.deleteByFilter(ListUtil.toList(FiltersUtils.build(ServiceLambdaExp.svcMeshDatasourceDomainTargetLambda,
               ServiceLambdaExp.svcMeshDatasourceDomainEntitySourceLambda.apply(old))));
        return serviceRepository.delete(CollUtil.newArrayList(old)) > 0;
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
