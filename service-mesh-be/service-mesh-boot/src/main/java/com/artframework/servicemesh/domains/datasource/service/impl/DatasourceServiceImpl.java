package com.artframework.servicemesh.domains.datasource.service.impl;

import com.artframework.servicemesh.domains.datasource.service.*;
import com.artframework.servicemesh.domains.datasource.dto.request.*;
import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.servicemesh.domains.datasource.repository.*;
import com.artframework.domain.core.service.impl.*;
import com.artframework.domain.core.uitls.*;

import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.io.Serializable;
import com.artframework.servicemesh.domains.datasource.lambdaexp.*;

@Service
public class DatasourceServiceImpl extends BaseDomainServiceImpl implements DatasourceService {
    @Autowired
    private DatasourceRepository datasourceRepository;

    /**
    * 分页查询
    * @param request 请求体
    * @return
    */
    @Override
    public IPage<DatasourceDTO> page(DatasourcePageRequest request){
        return datasourceRepository.page(request);
    }

    /**
    * 查找
    * @param request 请求体
    * @return
    */
    @Override
    public DatasourceDTO find(DatasourceFindRequest request){
        return datasourceRepository.query(request.getKey(), DatasourceLambdaExp.doKeyLambda);
    }

    /**
    * 新增
    * @param request 请求体
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public java.math.BigDecimal insert(DatasourceCreateRequest request){
        //插入数据
        DatasourceDTO dto = datasourceRepository.insert(request);
        return (java.math.BigDecimal) DatasourceLambdaExp.dtoKeyLambda.apply(dto);
    }

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(DatasourceUpdateRequest request){
        //更新数据
        datasourceRepository.update(request);
        return true;
    }

    /**
    * 删除
    * @param id 数据ID
    * @return 成功OR失败
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(java.math.BigDecimal id){
        return datasourceRepository.deleteById(id) > 0;
    }
}
