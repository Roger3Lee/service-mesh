package com.artframework.servicemesh.domains.service.service.impl;

import com.artframework.servicemesh.domains.service.service.*;
import com.artframework.servicemesh.domains.service.dto.request.*;
import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.servicemesh.domains.service.repository.*;
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
import com.artframework.servicemesh.domains.service.lambdaexp.*;

@Service
public class ServiceServiceImpl extends BaseDomainServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private ServiceRepository.SvcMeshDatasourceRepository svcMeshDatasourceRepository;

    /**
    * 分页查询
    * @param request 请求体
    * @return
    */
    @Override
    public IPage<ServiceDTO> page(ServicePageRequest request){
        return serviceRepository.page(request);
    }

    /**
    * 查找
    * @param request 请求体
    * @return
    */
    @Override
    public ServiceDTO find(ServiceFindRequest request){
        ServiceDTO response = serviceRepository.query(request.getKey(), ServiceLambdaExp.doKeyLambda);
        if(ObjectUtil.isNull(response)){
            return response;
        }

        if (ObjectUtil.isNotNull(request.getLoadFlag())) {
            if(request.getLoadFlag().getLoadSvcMeshDatasource()){
                Serializable key = ServiceLambdaExp.svcMeshDatasourceSourceLambda.apply(response);
                response.setSvcMeshDatasource(svcMeshDatasourceRepository.query(key, ServiceLambdaExp.svcMeshDatasourceTargetLambda));
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
    public Long insert(ServiceCreateRequest request){
        //插入关联数据svc_mesh_datasource
        if(ObjectUtil.isNotNull(request.getSvcMeshDatasource())){
            Serializable key = ServiceLambdaExp.svcMeshDatasourceSourceLambda.apply(request);
            ServiceLambdaExp.svcMeshDatasourceTargetSetLambda.accept(request.getSvcMeshDatasource(),(Long)key);
            svcMeshDatasourceRepository.insert(request.getSvcMeshDatasource());
        }
        //插入数据
        ServiceDTO dto = serviceRepository.insert(request);
        return (Long) ServiceLambdaExp.dtoKeyLambda.apply(dto);
    }

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(ServiceUpdateRequest request){
        Serializable keyId = ServiceLambdaExp.dtoKeyLambda.apply(request);
        ServiceDTO old = find(new ServiceFindRequest(keyId, request.getLoadFlag()));
        if(ObjectUtil.isNotNull(request.getLoadFlag()) && request.getLoadFlag().getLoadSvcMeshDatasource()
            && ObjectUtil.isNotNull(request.getSvcMeshDatasource())){
            Serializable key = ServiceLambdaExp.svcMeshDatasourceSourceLambda.apply(request);
            ServiceLambdaExp.svcMeshDatasourceTargetSetLambda.accept(request.getSvcMeshDatasource(),(Long)key);
            if(BooleanUtil.isTrue(request.getSvcMeshDatasource().getChanged())){
                svcMeshDatasourceRepository.update(request.getSvcMeshDatasource());
            }
        }


        //更新数据
        serviceRepository.update(request);
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
        ServiceDTO old = find(new ServiceFindRequest(id ,new ServiceDTO.LoadFlag()));

        //删除关联数据svc_mesh_datasource
        if(ObjectUtil.isNotNull(old.getSvcMeshDatasource())){
            svcMeshDatasourceRepository.delete(CollUtil.newArrayList(old.getSvcMeshDatasource()));
        }
        return serviceRepository.delete(CollUtil.newArrayList(old)) > 0;
    }
}
