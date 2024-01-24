package com.artframework.servicemesh.controllers;

import com.artframework.servicemesh.domains.datasource.domain.DatasourceDomain;
import com.artframework.servicemesh.domains.service.domain.*;
import com.artframework.servicemesh.domains.service.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/service/v1")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    /**
    * 分页查询
    * @param request 请求�?
    * @return IPage<ServiceDomain>
    */
    @PostMapping("page")
    public IPage<ServiceDomain> page(@RequestBody ServicePageDomain request){
        return serviceService.page(request);
    }

    /**
    * 查找
    * @param request 请求�?
    * @return ServiceDomain
    */
    @PostMapping("/query")
    public ServiceDomain find(@RequestBody ServiceFindDomain request){
        return serviceService.find(request);
    }

    /**
    * 新增
    * @param request 请求�?
    * @return Long
    */
    @PutMapping()
    public Long insert(@RequestBody ServiceDomain request){
        return serviceService.insert(request);
    }

    /**
    * 修改
    * @param request 请求�?
    * @return 成功OR失败
    */
    @PostMapping()
    public Boolean update(@RequestBody ServiceDomain request){
        return serviceService.update(request);
    }

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    @DeleteMapping
    public Boolean delete(@RequestParam("key") Long key){
        return serviceService.delete(key);
    }
}
