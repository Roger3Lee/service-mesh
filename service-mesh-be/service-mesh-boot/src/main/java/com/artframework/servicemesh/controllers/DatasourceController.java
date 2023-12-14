package com.artframework.servicemesh.controllers;

import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.servicemesh.domains.datasource.dto.request.*;
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
    * @param request 请求体
    * @return IPage<DatasourceDTO>
    */
    @PostMapping("page")
    public IPage<DatasourceDTO> page(@RequestBody DatasourcePageRequest request){
        return datasourceService.page(request);
    }

    /**
    * 查找
    * @param request 请求体
    * @return DatasourceDTO
    */
    @PostMapping("/query")
    public DatasourceDTO find(@RequestBody DatasourceFindRequest request){
        return datasourceService.find(request);
    }

    /**
    * 新增
    * @param request 请求体
    * @return java.math.BigDecimal
    */
    @PutMapping()
    public java.math.BigDecimal insert(@RequestBody DatasourceCreateRequest request){
        return datasourceService.insert(request);
    }

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    @PostMapping()
    public Boolean update(@RequestBody DatasourceUpdateRequest request){
        return datasourceService.update(request);
    }

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    @DeleteMapping
    public Boolean delete(@RequestParam("key") java.math.BigDecimal key){
        return datasourceService.delete(key);
    }
}
