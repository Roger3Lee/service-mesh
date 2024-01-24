package com.artframework.servicemesh.domains.datasource.service;

import com.artframework.servicemesh.domains.datasource.domain.*;

import com.artframework.domain.core.domain.*;
import com.artframework.domain.core.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.List;
import java.io.Serializable;

public interface DatasourceService extends BaseDomainService {

    /**
    * 分页查询
    * @param request 请求�?
    * @return
    */
    IPage<DatasourceDomain> page(DatasourcePageDomain request);

    /**
    * 查找
    * @param request 请求�?
    * @return
    */
    DatasourceDomain find(DatasourceFindDomain request);

    /**
    * 查找
    * @param request 请求�?
    * @param domain 源domain,如果此參數不為空則直接使用此參數作為主實�?
    * @return
    */
    DatasourceDomain find(DatasourceFindDomain request, DatasourceDomain domain);


    /**
     * 查找
     * @param request 请求�?
     * @return
     */
    DatasourceDomain findByKey(DatasourceFindDomain request, SFunction<DatasourceDomain, Serializable> keyLambda);

    /**
    * 新增
    * @param request 请求�?
    * @return
    */
    Long insert(DatasourceDomain request);

    /**
    * 修改
    * @param request 请求�?
    * @return 成功OR失败
    */
    Boolean update(DatasourceDomain request);
    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    Boolean delete(Long key);
}
