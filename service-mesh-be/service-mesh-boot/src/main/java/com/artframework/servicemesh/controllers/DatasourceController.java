package com.artframework.servicemesh.controllers;

import com.artframework.servicemesh.domains.datasource.domain.*;
import com.artframework.servicemesh.domains.datasource.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping("/datasource/v1")
public class DatasourceController {
    @Autowired
    private DatasourceService datasourceService;

    /**
    * 分页查询
    * @param request 请求�?
    * @return IPage<DatasourceDomain>
    */
    @PostMapping("page")
    public IPage<DatasourceDomain> page(@RequestBody DatasourcePageDomain request){
        return datasourceService.page(request);
    }

    /**
    * 查找
    * @param request 请求�?
    * @return DatasourceDomain
    */
    @PostMapping("/query")
    public DatasourceDomain find(@RequestBody DatasourceFindDomain request){
        return datasourceService.find(request);
    }

    /**
    * 新增
    * @param request 请求�?
    * @return Long
    */
    @PutMapping()
    public Long insert(@RequestBody DatasourceDomain request){
        return datasourceService.insert(request);
    }

    /**
    * 修改
    * @param request 请求�?
    * @return 成功OR失败
    */
    @PostMapping()
    public Boolean update(@RequestBody DatasourceDomain request){
        return datasourceService.update(request);
    }

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    @DeleteMapping
    public Boolean delete(@RequestParam("key") Long key){
        return datasourceService.delete(key);
    }
}
