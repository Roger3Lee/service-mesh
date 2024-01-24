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

@Repository(value="serviceFlow-SvcMeshFlowInvokeLogRepositoryImpl")
public class SvcMeshFlowInvokeLogRepositoryImpl extends BaseRepositoryImpl<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain,SvcMeshFlowInvokeLogDO>  implements SvcMeshFlowInvokeLogRepository {

    @Override
    public List<SvcMeshFlowInvokeLogDO> convert2DO(List<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain> list) {
        return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowInvokeLogDO(list);
    }

    @Override
    public List<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain> convert2DTO(List<SvcMeshFlowInvokeLogDO> list) {
        return ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowInvokeLogDTO(list);
    }

    @Override
    public void convert2DTO(SvcMeshFlowInvokeLogDO item ,ServiceFlowDomain.SvcMeshFlowInvokeLogDomain targetItem){
        ServiceFlowConvertor.INSTANCE.convert2SvcMeshFlowInvokeLogDTO(item,targetItem);
    }

    @Override
    public SFunction<ServiceFlowDomain.SvcMeshFlowInvokeLogDomain, Serializable> keyLambda() {
        return ServiceFlowLambdaExp.svcMeshFlowInvokeLogDomainKeyLambda;
    }

    @Override
    public Class<SvcMeshFlowInvokeLogDO> getDOClass() {
        return SvcMeshFlowInvokeLogDO.class;
    }
}
