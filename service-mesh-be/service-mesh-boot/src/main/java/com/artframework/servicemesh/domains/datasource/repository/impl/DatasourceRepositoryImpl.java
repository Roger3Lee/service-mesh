package com.artframework.servicemesh.domains.datasource.repository.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.StrUtil;
import com.artframework.servicemesh.domains.datasource.convertor.*;
import com.artframework.servicemesh.domains.datasource.lambdaexp.*;
import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.servicemesh.domains.datasource.dto.request.*;
import com.artframework.servicemesh.domains.datasource.repository.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.impl.*;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.List;

@Repository
public class DatasourceRepositoryImpl extends BaseRepositoryImpl<DatasourceDTO,SvcMeshDatasourceDO>  implements DatasourceRepository {

    @Override
    public List<SvcMeshDatasourceDO> convert2DO(List<DatasourceDTO> list) {
        return DatasourceConvertor.INSTANCE.convert2DO(list);
    }

    @Override
    public List<DatasourceDTO> convert2DTO(List<SvcMeshDatasourceDO> list) {
        return DatasourceConvertor.INSTANCE.convert2DTO(list);
    }

    @Override
    public SFunction<DatasourceDTO, Serializable> keyLambda() {
        return DatasourceLambdaExp.dtoKeyLambda;
    }

    @Override
    public Class<SvcMeshDatasourceDO> getDOClass() {
        return SvcMeshDatasourceDO.class;
    }

    @Override
    public IPage<DatasourceDTO> page(DatasourcePageRequest request){
        IPage<SvcMeshDatasourceDO> page=new Page<>(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<SvcMeshDatasourceDO> wrapper =new LambdaQueryWrapper<SvcMeshDatasourceDO>();
        wrapper.like(StrUtil.isNotBlank(request.getCode()), SvcMeshDatasourceDO::getCode, request.getCode());
        wrapper.like(StrUtil.isNotBlank(request.getName()), SvcMeshDatasourceDO::getName, request.getName());
        wrapper.in(CollectionUtil.isNotEmpty(request.getType()), SvcMeshDatasourceDO::getType, request.getType());
        return this.baseMapper.selectPage(page,wrapper).convert(DatasourceConvertor.INSTANCE::convert2DTO);
    }


}
