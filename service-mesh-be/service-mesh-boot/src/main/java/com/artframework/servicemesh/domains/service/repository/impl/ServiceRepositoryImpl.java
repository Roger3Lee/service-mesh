package com.artframework.servicemesh.domains.service.repository.impl;

import com.artframework.servicemesh.domains.service.convertor.*;
import com.artframework.servicemesh.domains.service.lambdaexp.*;
import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.domains.service.repository.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.impl.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.io.Serializable;
import java.util.List;

@Repository(value="service-ServiceRepositoryImpl")
public class ServiceRepositoryImpl extends BaseRepositoryImpl<ServiceDomain,SvcMeshServiceDO>  implements ServiceRepository {

    @Override
    public List<SvcMeshServiceDO> convert2DO(List<ServiceDomain> list) {
        return ServiceConvertor.INSTANCE.convert2DO(list);
    }

    @Override
    public List<ServiceDomain> convert2DTO(List<SvcMeshServiceDO> list) {
        return ServiceConvertor.INSTANCE.convert2DTO(list);
    }

    @Override
    public void convert2DTO(SvcMeshServiceDO item ,ServiceDomain targetItem){
        ServiceConvertor.INSTANCE.convert2DTO(item,targetItem);
    }

    @Override
    public SFunction<ServiceDomain, Serializable> keyLambda() {
        return ServiceLambdaExp.dtoKeyLambda;
    }

    @Override
    public Class<SvcMeshServiceDO> getDOClass() {
        return SvcMeshServiceDO.class;
    }

    @Override
    public IPage<ServiceDomain> page(ServicePageDomain request){
        IPage<SvcMeshServiceDO> page=new Page<>(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<SvcMeshServiceDO> wrapper =new LambdaQueryWrapper<>();
        return this.baseMapper.selectPage(page,wrapper).convert(ServiceConvertor.INSTANCE::convert2DTO);
    }
}
