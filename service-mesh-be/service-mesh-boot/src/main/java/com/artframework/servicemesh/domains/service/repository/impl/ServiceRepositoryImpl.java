package com.artframework.servicemesh.domains.service.repository.impl;

import com.artframework.servicemesh.domains.service.convertor.*;
import com.artframework.servicemesh.domains.service.lambdaexp.*;
import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.servicemesh.domains.service.dto.request.*;
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

@Repository
public class ServiceRepositoryImpl extends BaseRepositoryImpl<ServiceDTO,SvcMeshServiceDO>  implements ServiceRepository {

    @Override
    public List<SvcMeshServiceDO> convert2DO(List<ServiceDTO> list) {
        return ServiceConvertor.INSTANCE.convert2DO(list);
    }

    @Override
    public List<ServiceDTO> convert2DTO(List<SvcMeshServiceDO> list) {
        return ServiceConvertor.INSTANCE.convert2DTO(list);
    }

    @Override
    public SFunction<ServiceDTO, Serializable> keyLambda() {
        return ServiceLambdaExp.dtoKeyLambda;
    }

    @Override
    public Class<SvcMeshServiceDO> getDOClass() {
        return SvcMeshServiceDO.class;
    }

    @Override
    public IPage<ServiceDTO> page(ServicePageRequest request){
        IPage<SvcMeshServiceDO> page=new Page<>(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<SvcMeshServiceDO> wrapper =new LambdaQueryWrapper<SvcMeshServiceDO>();
        return this.baseMapper.selectPage(page,wrapper).convert(ServiceConvertor.INSTANCE::convert2DTO);
    }

    @Repository
    public static class SvcMeshDatasourceRepositoryImpl extends BaseRepositoryImpl<ServiceDTO.SvcMeshDatasourceDTO,SvcMeshDatasourceDO>  implements SvcMeshDatasourceRepository {

        @Override
        public List<SvcMeshDatasourceDO> convert2DO(List<ServiceDTO.SvcMeshDatasourceDTO> list) {
            return ServiceConvertor.INSTANCE.convert2SvcMeshDatasourceDO(list);
        }

        @Override
        public List<ServiceDTO.SvcMeshDatasourceDTO> convert2DTO(List<SvcMeshDatasourceDO> list) {
            return ServiceConvertor.INSTANCE.convert2SvcMeshDatasourceDTO(list);
        }

        @Override
        public SFunction<ServiceDTO.SvcMeshDatasourceDTO, Serializable> keyLambda() {
            return ServiceLambdaExp.svcMeshDatasourceKeyLambda;
        }

        @Override
        public Class<SvcMeshDatasourceDO> getDOClass() {
            return SvcMeshDatasourceDO.class;
        }
    }

}
