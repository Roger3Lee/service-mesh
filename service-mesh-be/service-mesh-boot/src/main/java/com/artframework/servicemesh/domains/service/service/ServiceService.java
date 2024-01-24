package com.artframework.servicemesh.domains.service.service;

import com.artframework.servicemesh.domains.service.domain.*;

import com.artframework.domain.core.domain.*;
import com.artframework.domain.core.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.List;
import java.io.Serializable;

public interface ServiceService extends BaseDomainService {

    /**
    * 分页查询
    * @param request 请求�?
    * @return
    */
    IPage<ServiceDomain> page(ServicePageDomain request);

    /**
    * 查找
    * @param request 请求�?
    * @return
    */
    ServiceDomain find(ServiceFindDomain request);

    /**
    * 查找
    * @param request 请求�?
    * @param domain 源domain,如果此參數不為空則直接使用此參數作為主實�?
    * @return
    */
    ServiceDomain find(ServiceFindDomain request, ServiceDomain domain);


    /**
     * 查找
     * @param request 请求�?
     * @return
     */
    ServiceDomain findByKey(ServiceFindDomain request, SFunction<ServiceDomain, Serializable> keyLambda);

    /**
    * 新增
    * @param request 请求�?
    * @return
    */
    Long insert(ServiceDomain request);

    /**
    * 修改
    * @param request 请求�?
    * @return 成功OR失败
    */
    Boolean update(ServiceDomain request);
    /**
    * 修改,此方法不用再加載domain主entity數據
    * @param request 请求�?
    * @param domain 原始domain
    * @return 成功OR失败
    */
    Boolean update(ServiceDomain request, ServiceDomain domain);
    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    Boolean delete(Long key);
    /**
     *
     * @param filters
     * @return
     */
    Boolean deleteRelated(List<BaseLoadFlag.Filter> filters);
}
