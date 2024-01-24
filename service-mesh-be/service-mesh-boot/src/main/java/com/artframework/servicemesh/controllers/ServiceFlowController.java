package com.artframework.servicemesh.controllers;

import com.artframework.servicemesh.domains.serviceflow.domain.*;
import com.artframework.servicemesh.domains.serviceflow.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/serviceFlow/v1")
public class ServiceFlowController {
    @Autowired
    private ServiceFlowService serviceFlowService;

    /**
    * 分页查询
    * @param request 请求�?
    * @return IPage<ServiceFlowDomain>
    */
    @PostMapping("page")
    public IPage<ServiceFlowDomain> page(@RequestBody ServiceFlowPageDomain request){
        return serviceFlowService.page(request);
    }

    /**
    * 查找
    * @param request 请求�?
    * @return ServiceFlowDomain
    */
    @PostMapping("/query")
    public ServiceFlowDomain find(@RequestBody ServiceFlowFindDomain request){
        return serviceFlowService.find(request);
    }

    /**
    * 新增
    * @param request 请求�?
    * @return Long
    */
    @PutMapping()
    public Long insert(@RequestBody ServiceFlowDomain request){
        return serviceFlowService.insert(request);
    }

    /**
    * 修改
    * @param request 请求�?
    * @return 成功OR失败
    */
    @PostMapping()
    public Boolean update(@RequestBody ServiceFlowDomain request){
        return serviceFlowService.update(request);
    }

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    @DeleteMapping
    public Boolean delete(@RequestParam("key") Long key){
        return serviceFlowService.delete(key);
    }
}
