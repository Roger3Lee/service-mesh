package com.artframework.servicemesh.domains.serviceflow.repository.impl;

import com.artframework.servicemesh.domains.serviceflow.convertor.*;
import com.artframework.servicemesh.domains.serviceflow.lambdaexp.*;
import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.servicemesh.domains.serviceflow.dto.request.*;
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

@Repository
public class ServiceFlowRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDTO,SvcMeshFlowDO>  implements ServiceFlowRepository {

    @Override
    public List<SvcMeshFlowDO> convert2DO(List<ServiceFlowDTO> list) {
        return ServiceFlowConvertor.INSTANCE.convert2DO(list);
    }

    @Override
    public List<ServiceFlowDTO> convert2DTO(List<SvcMeshFlowDO> list) {
        return ServiceFlowConvertor.INSTANCE.convert2DTO(list);
    }

    @Override
    public SFunction<ServiceFlowDTO, Serializable> keyLambda() {
        return ServiceFlowLambdaExp.dtoKeyLambda;
    }

    @Override
    public Class<SvcMeshFlowDO> getDOClass() {
        return SvcMeshFlowDO.class;
    }

    @Override
    public IPage<ServiceFlowDTO> page(ServiceFlowPageRequest request){
        IPage<SvcMeshFlowDO> page=new Page<>(request.getPageNum(), request.getPageSize());
        LambdaQueryWrapper<SvcMeshFlowDO> wrapper =new LambdaQueryWrapper<SvcMeshFlowDO>();
        return this.baseMapper.selectPage(page,wrapper).convert(ServiceFlowConvertor.INSTANCE::convert2DTO);
    }

    @Repository
    public static class SvcMeshFlowConfigRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDTO.SvcMeshFlowConfigDTO,SvcMeshFlowConfigDO>  implements SvcMeshFlowConfigRepository {

        @Override
        public List<SvcMeshFlowConfigDO> convert2DO(List<ServiceFlowDTO.SvcMeshFlowConfigDTO> list) {
            return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowConfigDO(list);
        }

        @Override
        public List<ServiceFlowDTO.SvcMeshFlowConfigDTO> convert2DTO(List<SvcMeshFlowConfigDO> list) {
            return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowConfigDTO(list);
        }

        @Override
        public SFunction<ServiceFlowDTO.SvcMeshFlowConfigDTO, Serializable> keyLambda() {
            return ServiceFlowLambdaExp.svcMeshFlowConfigKeyLambda;
        }

        @Override
        public Class<SvcMeshFlowConfigDO> getDOClass() {
            return SvcMeshFlowConfigDO.class;
        }
    }
    @Repository
    public static class SvcMeshFlowNodeRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDTO.SvcMeshFlowNodeDTO,SvcMeshFlowNodeDO>  implements SvcMeshFlowNodeRepository {

        @Override
        public List<SvcMeshFlowNodeDO> convert2DO(List<ServiceFlowDTO.SvcMeshFlowNodeDTO> list) {
            return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowNodeDO(list);
        }

        @Override
        public List<ServiceFlowDTO.SvcMeshFlowNodeDTO> convert2DTO(List<SvcMeshFlowNodeDO> list) {
            return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowNodeDTO(list);
        }

        @Override
        public SFunction<ServiceFlowDTO.SvcMeshFlowNodeDTO, Serializable> keyLambda() {
            return ServiceFlowLambdaExp.svcMeshFlowNodeKeyLambda;
        }

        @Override
        public Class<SvcMeshFlowNodeDO> getDOClass() {
            return SvcMeshFlowNodeDO.class;
        }
    }
    @Repository
    public static class SvcMeshFlowInvokeLogRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO,SvcMeshFlowInvokeLogDO>  implements SvcMeshFlowInvokeLogRepository {

        @Override
        public List<SvcMeshFlowInvokeLogDO> convert2DO(List<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO> list) {
            return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowInvokeLogDO(list);
        }

        @Override
        public List<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO> convert2DTO(List<SvcMeshFlowInvokeLogDO> list) {
            return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowInvokeLogDTO(list);
        }

        @Override
        public SFunction<ServiceFlowDTO.SvcMeshFlowInvokeLogDTO, Serializable> keyLambda() {
            return ServiceFlowLambdaExp.svcMeshFlowInvokeLogKeyLambda;
        }

        @Override
        public Class<SvcMeshFlowInvokeLogDO> getDOClass() {
            return SvcMeshFlowInvokeLogDO.class;
        }
    }
}
