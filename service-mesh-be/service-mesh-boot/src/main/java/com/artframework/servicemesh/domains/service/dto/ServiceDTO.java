package com.artframework.servicemesh.domains.service.dto;

import com.artframework.domain.core.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


/**
* service
*
* @author auto
* @version v1.0
* @date 2023-12-17 12:20:56
*/
@Getter
@Setter
@ToString
public class ServiceDTO extends BaseDTO {
    /**
    * 主鍵ID
    */
    private Long id;
    /**
    * 數據源配置
    */
    private Long datasourceId;
    /**
    * 編碼
    */
    private String code;
    /**
    * 名稱
    */
    private String name;
    /**
    * 請求模板
    */
    private String inputTemplate;
    /**
    * 配置
    */
    private String config;
    /**
    * 輸出模板
    */
    private String outputTemplate;
    /**
    * 租户号
    */
    private String tenantId;
    /**
    * 乐观锁
    */
    private String version;
    /**
    * 創建人
    */
    private String createBy;
    /**
    * 創建人姓名
    */
    private String createByName;
    /**
    * 创建时间
    */
    private java.util.Date createTime;
    /**
    * 更新人
    */
    private String updateBy;
    /**
    * 更新人姓名
    */
    private String updateByName;
    /**
    * 更新时间
    */
    private java.util.Date updateTime;

    /**
    * RELATE svc_mesh_datasource
    */
    private SvcMeshDatasourceDTO svcMeshDatasource;

    /**
    * 加载数据对象
    */
    private LoadFlag loadFlag;

    @Getter
    @Setter
    @ToString
    public static class SvcMeshDatasourceDTO extends BaseDTO{
        /**
        * 是否有变化
        */
        private Boolean changed = false;

        /**
        * 主鍵ID
        */
        private Long id;
        /**
        * 編碼
        */
        private String code;
        /**
        * 名稱
        */
        private String name;
        /**
        * 數據源類型
        */
        private String type;
        /**
        * 配置
        */
        private String config;
        /**
        * 租户号
        */
        private String tenantId;
        /**
        * 乐观锁
        */
        private String version;
        /**
        * 創建人
        */
        private String createBy;
        /**
        * 創建人姓名
        */
        private String createByName;
        /**
        * 创建时间
        */
        private java.util.Date createTime;
        /**
        * 更新人
        */
        private String updateBy;
        /**
        * 更新人姓名
        */
        private String updateByName;
        /**
        * 更新时间
        */
        private java.util.Date updateTime;
    }

    @Getter
    @Setter
    @ToString
    public static class LoadFlag{

        /**
        *
        */
        private Boolean loadSvcMeshDatasource = false;

        /**
         * 過濾條件
         */
        private Map<String, Object> filters = new HashMap<>();
    }
}
