package com.artframework.servicemesh.domains.datasource.repository.impl;

import com.artframework.servicemesh.domains.datasource.convertor.*;
import com.artframework.servicemesh.domains.datasource.lambdaexp.*;
import com.artframework.servicemesh.domains.datasource.domain.*;
import com.artframework.servicemesh.domains.datasource.repository.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.impl.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.io.Serializable;
import java.util.List;

@Repository(value="datasource-DatasourceRepositoryImpl")
public class DatasourceRepositoryImpl extends BaseRepositoryImpl<DatasourceDomain,SvcMeshDatasourceDO>  implements DatasourceRepository {

    @Override
    public List<SvcMeshDatasourceDO> convert2DO(List<DatasourceDomain> list) {
        return DatasourceConvertor.INSTANCE.convert2DO(list);
    }

    @Override
    public List<DatasourceDomain> convert2DTO(List<SvcMeshDatasourceDO> list) {
        return DatasourceConvertor.INSTANCE.convert2DTO(list);
    }

    @Override
    public void convert2DTO(SvcMeshDatasourceDO item ,DatasourceDomain targetItem){
        DatasourceConvertor.INSTANCE.convert2DTO(item,targetItem);
    }

    @Override
    public SFunction<DatasourceDomain, Serializable> keyLambda() {
        return DatasourceLambdaExp.dtoKeyLambda;
    }

    @Override
    public Class<SvcMeshDatasourceDO> getDOClass() {
        return SvcMeshDatasourceDO.class;
    }

    @Override
    public IPage<DatasourceDomain> page(DatasourcePageDomain request){
        IPage<SvcMeshDatasourceDO> page=new Page<>(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<SvcMeshDatasourceDO> wrapper =new LambdaQueryWrapper<SvcMeshDatasourceDO>();
        wrapper.like(StrUtil.isNotBlank(request.getCode()), SvcMeshDatasourceDO::getCode, request.getCode());
        wrapper.like(StrUtil.isNotBlank(request.getName()), SvcMeshDatasourceDO::getName, request.getName());
        wrapper.in(CollectionUtil.isNotEmpty(request.getType()), SvcMeshDatasourceDO::getType, request.getType());
        return this.baseMapper.selectPage(page,wrapper).convert(DatasourceConvertor.INSTANCE::convert2DTO);
    }
}
