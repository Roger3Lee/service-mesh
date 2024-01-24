package com.artframework.servicemesh.domains.serviceflow.repository.impl;

import com.artframework.servicemesh.domains.serviceflow.convertor.*;
import com.artframework.servicemesh.domains.serviceflow.lambdaexp.*;
import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.domains.serviceflow.repository.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.impl.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.io.Serializable;
import java.util.List;

@Repository(value="serviceFlow-ServiceFlowRepositoryImpl")
public class ServiceFlowRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDomain,SvcMeshFlowDO>  implements ServiceFlowRepository {

    @Override
    public List<SvcMeshFlowDO> convert2DO(List<ServiceFlowDomain> list) {
        return ServiceFlowConvertor.INSTANCE.convert2DO(list);
    }

    @Override
    public List<ServiceFlowDomain> convert2DTO(List<SvcMeshFlowDO> list) {
        return ServiceFlowConvertor.INSTANCE.convert2DTO(list);
    }

    @Override
    public void convert2DTO(SvcMeshFlowDO item ,ServiceFlowDomain targetItem){
        ServiceFlowConvertor.INSTANCE.convert2DTO(item,targetItem);
    }

    @Override
    public SFunction<ServiceFlowDomain, Serializable> keyLambda() {
        return ServiceFlowLambdaExp.dtoKeyLambda;
    }

    @Override
    public Class<SvcMeshFlowDO> getDOClass() {
        return SvcMeshFlowDO.class;
    }

    @Override
    public IPage<ServiceFlowDomain> page(ServiceFlowPageDomain request){
        IPage<SvcMeshFlowDO> page=new Page<>(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<SvcMeshFlowDO> wrapper =new LambdaQueryWrapper<>();
        return this.baseMapper.selectPage(page,wrapper).convert(ServiceFlowConvertor.INSTANCE::convert2DTO);
    }
}
