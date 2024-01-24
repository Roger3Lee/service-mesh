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

@Repository(value="serviceFlow-SvcMeshFlowNodeRepositoryImpl")
public class SvcMeshFlowNodeRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDomain.SvcMeshFlowNodeDomain,SvcMeshFlowNodeDO>  implements SvcMeshFlowNodeRepository {

    @Override
    public List<SvcMeshFlowNodeDO> convert2DO(List<ServiceFlowDomain.SvcMeshFlowNodeDomain> list) {
        return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowNodeDO(list);
    }

    @Override
    public List<ServiceFlowDomain.SvcMeshFlowNodeDomain> convert2DTO(List<SvcMeshFlowNodeDO> list) {
        return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowNodeDTO(list);
    }

    @Override
    public void convert2DTO(SvcMeshFlowNodeDO item ,ServiceFlowDomain.SvcMeshFlowNodeDomain targetItem){
        ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowNodeDTO(item,targetItem);
    }

    @Override
    public SFunction<ServiceFlowDomain.SvcMeshFlowNodeDomain, Serializable> keyLambda() {
        return ServiceFlowLambdaExp.svcMeshFlowNodeDomainKeyLambda;
    }

    @Override
    public Class<SvcMeshFlowNodeDO> getDOClass() {
        return SvcMeshFlowNodeDO.class;
    }
}
