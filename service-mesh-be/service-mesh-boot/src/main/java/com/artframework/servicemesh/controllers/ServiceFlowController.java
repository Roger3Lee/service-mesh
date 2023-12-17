package com.artframework.servicemesh.controllers;

import com.artframework.servicemesh.domains.serviceflow.dto.*;
import com.artframework.servicemesh.domains.serviceflow.dto.request.*;
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
    * @param request 请求体
    * @return IPage<ServiceFlowDTO>
    */
    @PostMapping("page")
    public IPage<ServiceFlowDTO> page(@RequestBody ServiceFlowPageRequest request){
        return serviceFlowService.page(request);
    }

    /**
    * 查找
    * @param request 请求体
    * @return ServiceFlowDTO
    */
    @PostMapping("/query")
    public ServiceFlowDTO find(@RequestBody ServiceFlowFindRequest request){
        return serviceFlowService.find(request);
    }

    /**
    * 新增
    * @param request 请求体
    * @return Long
    */
    @PutMapping()
    public Long insert(@RequestBody ServiceFlowCreateRequest request){
        return serviceFlowService.insert(request);
    }

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    @PostMapping()
    public Boolean update(@RequestBody ServiceFlowUpdateRequest request){
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
