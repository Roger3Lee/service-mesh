package com.artframework.servicemesh.domains.datasource.service.impl;

import com.artframework.servicemesh.domains.datasource.service.*;
import com.artframework.servicemesh.domains.datasource.domain.*;
import com.artframework.servicemesh.domains.datasource.repository.*;
import com.artframework.domain.core.service.impl.*;
import com.artframework.domain.core.uitls.*;

import com.artframework.domain.core.domain.*;
import com.artframework.domain.core.repository.BaseRepository;
import cn.hutool.core.collection.*;
import cn.hutool.core.util.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.artframework.servicemesh.domains.datasource.lambdaexp.*;

import javax.annotation.PostConstruct;


@Service
public class DatasourceServiceImpl extends BaseDomainServiceImpl implements DatasourceService {
    @Autowired
    private DatasourceRepository datasourceRepository;

    /**
    * 分页查询
    * @param request 请求�?
    * @return
    */
    @Override
    public IPage<DatasourceDomain> page(DatasourcePageDomain request){
        return datasourceRepository.page(request);
    }

   /**
    * 查找
    * @param request 请求�?
    * @return
    */
    @Override
    public DatasourceDomain find(DatasourceFindDomain request){
        return find(request, null);
    }

    /**
    * 查找
    * @param request 请求�?
    * @param response 原始數據，避免重新查詢主�?
    * @return
    */
    @Override
    public DatasourceDomain find(DatasourceFindDomain request, DatasourceDomain response){
        return datasourceRepository.query(request.getKey(), DatasourceLambdaExp.doKeyLambda);
    }


    /**
     * 查找
     * @param request 请求�?
     * @param keyLambda 請求key參數對應的字段的lambda表達�?
     * @return
     */
    @Override
    public DatasourceDomain findByKey(DatasourceFindDomain request, SFunction<DatasourceDomain, Serializable> keyLambda){
        return find(request, datasourceRepository.queryByKey(request.getKey(), keyLambda));
    }

    /**
    * 新增
    * @param request 请求�?
    * @return
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long insert(DatasourceDomain request){
        //插入数据
        DatasourceDomain domain = datasourceRepository.insert(request);
        return (Long) DatasourceLambdaExp.dtoKeyLambda.apply(domain);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(DatasourceDomain request){
        if(request.getChanged()){
            datasourceRepository.update(request);
        }
        return true;
    }

    /**
    * 删除
    * @param id 数据ID
    * @return 成功OR失败
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean delete(Long id){
        return datasourceRepository.deleteById(id) > 0;
    }
}
