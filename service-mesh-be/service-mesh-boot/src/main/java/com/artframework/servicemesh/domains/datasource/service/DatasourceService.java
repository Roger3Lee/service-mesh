package com.artframework.servicemesh.domains.datasource.service;

import com.artframework.servicemesh.domains.datasource.dto.request.*;
import com.artframework.servicemesh.domains.datasource.dto.*;
import com.artframework.domain.core.service.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface DatasourceService extends BaseDomainService {

    /**
    * 分页查询
    * @param request 请求体
    * @return
    */
    IPage<DatasourceDTO> page(DatasourcePageRequest request);

    /**
    * 查找
    * @param request 请求体
    * @return
    */
    DatasourceDTO find(DatasourceFindRequest request);

    /**
    * 新增
    * @param request 请求体
    * @return
    */
    Long insert(DatasourceCreateRequest request);

    /**
    * 修改
    * @param request 请求体
    * @return 成功OR失败
    */
    Boolean update(DatasourceUpdateRequest request);

    /**
    * 删除
    * @param key 数据ID
    * @return 成功OR失败
    */
    Boolean delete(Long key);
}
