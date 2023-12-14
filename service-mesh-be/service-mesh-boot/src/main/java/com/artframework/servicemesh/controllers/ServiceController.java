package com.artframework.servicemesh.controllers;

import com.artframework.servicemesh.domains.service.dto.*;
import com.artframework.servicemesh.domains.service.dto.request.*;
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
    * @param request 请求体
    * @return IPage<ServiceDTO>
    */
    @PostMapping("page")
    public IPage<ServiceDTO> page(@RequestBody ServicePageRequest request){
        return serviceService.page(request);
    }

    /**
    * 查找
    * @param request 请求体
    * @return ServiceDTO
    */
    @PostMapping("/query")
    public ServiceDTO find(@RequestBody ServiceFindRequest request){
        return serviceService.find(request);
    }

    /**
    * 新增
    * @param request 请求体
    * @return java.math.BigDecimal
    */
    @PutMapping()
    public java.math.BigDecimal insert(@RequestBody ServiceCreateRequest request){
        return serviceService.insert(request);
    }

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    @PostMapping()
    public Boolean update(@RequestBody ServiceUpdateRequest request){
        return serviceService.update(request);
    }

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    @DeleteMapping
    public Boolean delete(@RequestParam("key") java.math.BigDecimal key){
        return serviceService.delete(key);
    }
}
