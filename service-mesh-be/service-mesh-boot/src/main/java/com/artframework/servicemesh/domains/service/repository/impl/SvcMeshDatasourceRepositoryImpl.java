package com.artframework.servicemesh.domains.service.repository.impl;

import com.artframework.servicemesh.domains.service.convertor.*;
import com.artframework.servicemesh.domains.service.lambdaexp.*;
import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.domains.service.repository.*;
import com.artframework.servicemesh.entities.*;
import com.artframework.domain.core.repository.impl.*;

import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.io.Serializable;
import java.util.List;

@Repository(value="service-SvcMeshDatasourceRepositoryImpl")
public class SvcMeshDatasourceRepositoryImpl extends BaseRepositoryImpl<ServiceDomain.SvcMeshDatasourceDomain,SvcMeshDatasourceDO>  implements SvcMeshDatasourceRepository {

    @Override
    public List<SvcMeshDatasourceDO> convert2DO(List<ServiceDomain.SvcMeshDatasourceDomain> list) {
        return ServiceConvertor.INSTANCE.convert2SvcMeshDatasourceDO(list);
    }

    @Override
    public List<ServiceDomain.SvcMeshDatasourceDomain> convert2DTO(List<SvcMeshDatasourceDO> list) {
        return ServiceConvertor.INSTANCE.convert2SvcMeshDatasourceDTO(list);
    }

    @Override
    public void convert2DTO(SvcMeshDatasourceDO item ,ServiceDomain.SvcMeshDatasourceDomain targetItem){
        ServiceConvertor.INSTANCE.convert2SvcMeshDatasourceDTO(item,targetItem);
    }

    @Override
    public SFunction<ServiceDomain.SvcMeshDatasourceDomain, Serializable> keyLambda() {
        return ServiceLambdaExp.svcMeshDatasourceDomainKeyLambda;
    }

    @Override
    public Class<SvcMeshDatasourceDO> getDOClass() {
        return SvcMeshDatasourceDO.class;
    }
}
