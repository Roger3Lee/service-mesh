package com.artframework.servicemesh.domains.serviceflow.repository.impl;

import com.artframework.servicemesh.domains.serviceflow.convertor.*;
import com.artframework.servicemesh.domains.serviceflow.lambdaexp.*;
import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.domains.serviceflow.repository.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.impl.*;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.io.Serializable;
import java.util.List;

@Repository(value="serviceFlow-SvcMeshFlowConfigRepositoryImpl")
public class SvcMeshFlowConfigRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDomain.SvcMeshFlowConfigDomain,SvcMeshFlowConfigDO>  implements SvcMeshFlowConfigRepository {

    @Override
    public List<SvcMeshFlowConfigDO> convert2DO(List<ServiceFlowDomain.SvcMeshFlowConfigDomain> list) {
        return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowConfigDO(list);
    }

    @Override
    public List<ServiceFlowDomain.SvcMeshFlowConfigDomain> convert2DTO(List<SvcMeshFlowConfigDO> list) {
        return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowConfigDTO(list);
    }

    @Override
    public void convert2DTO(SvcMeshFlowConfigDO item ,ServiceFlowDomain.SvcMeshFlowConfigDomain targetItem){
        ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowConfigDTO(item,targetItem);
    }

    @Override
    public SFunction<ServiceFlowDomain.SvcMeshFlowConfigDomain, Serializable> keyLambda() {
        return ServiceFlowLambdaExp.svcMeshFlowConfigDomainKeyLambda;
    }

    @Override
    public Class<SvcMeshFlowConfigDO> getDOClass() {
        return SvcMeshFlowConfigDO.class;
    }
}
