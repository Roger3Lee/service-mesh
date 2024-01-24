package com.artframework.servicemesh.domains.serviceflow.service;

import com.artframework.servicemesh.domains.serviceflow.domain.*;

import com.artframework.domain.core.domain.*;
import com.artframework.domain.core.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;

import java.util.List;
import java.io.Serializable;

public interface ServiceFlowService extends BaseDomainService {

    /**
    * 分页查询
    * @param request 请求�?
    * @return
    */
    IPage<ServiceFlowDomain> page(ServiceFlowPageDomain request);

    /**
    * 查找
    * @param request 请求�?
    * @return
    */
    ServiceFlowDomain find(ServiceFlowFindDomain request);

    /**
    * 查找
    * @param request 请求�?
    * @param domain 源domain,如果此參數不為空則直接使用此參數作為主實�?
    * @return
    */
    ServiceFlowDomain find(ServiceFlowFindDomain request, ServiceFlowDomain domain);


    /**
     * 查找
     * @param request 请求�?
     * @return
     */
    ServiceFlowDomain findByKey(ServiceFlowFindDomain request, SFunction<ServiceFlowDomain, Serializable> keyLambda);

    /**
    * 新增
    * @param request 请求�?
    * @return
    */
    Long insert(ServiceFlowDomain request);

    /**
    * 修改
    * @param request 请求�?
    * @return 成功OR失败
    */
    Boolean update(ServiceFlowDomain request);
    /**
    * 修改,此方法不用再加載domain主entity數據
    * @param request 请求�?
    * @param domain 原始domain
    * @return 成功OR失败
    */
    Boolean update(ServiceFlowDomain request, ServiceFlowDomain domain);
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
