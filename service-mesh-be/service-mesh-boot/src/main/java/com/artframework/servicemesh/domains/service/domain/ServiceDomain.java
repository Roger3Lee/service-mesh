package com.artframework.servicemesh.domains.service.domain;

import com.artframework.domain.core.domain.*;
import lombok.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* service
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@ApiModel(value = "鏈嶅嫏")
public class ServiceDomain extends BaseDomain {
    /**
    * 主鍵ID
    */
    @ApiModelProperty(value =  "主鍵ID")
    private Long id;
    /**
    * 數據源配置
    */
    @ApiModelProperty(value =  "數據源配置")
    private Long datasourceId;
    /**
    * 編碼
    */
    @ApiModelProperty(value =  "編碼")
    private String code;
    /**
    * 名稱
    */
    @ApiModelProperty(value =  "名稱")
    private String name;
    /**
    * 請求模板
    */
    @ApiModelProperty(value =  "請求模板")
    private String inputTemplate;
    /**
    * 配置
    */
    @ApiModelProperty(value =  "配置")
    private String config;
    /**
    * 輸出模板
    */
    @ApiModelProperty(value =  "輸出模板")
    private String outputTemplate;
    /**
    * 租户号
    */
    @ApiModelProperty(value =  "租户号")
    private String tenantId;
    /**
    * 乐观锁
    */
    @ApiModelProperty(value =  "乐观锁")
    private String version;
    /**
    * 創建人
    */
    @ApiModelProperty(value =  "創建人")
    private String createBy;
    /**
    * 創建人姓名
    */
    @ApiModelProperty(value =  "創建人姓名")
    private String createByName;
    /**
    * 创建时间
    */
    @ApiModelProperty(value =  "创建时间")
    private java.util.Date createTime;
    /**
    * 更新人
    */
    @ApiModelProperty(value =  "更新人")
    private String updateBy;
    /**
    * 更新人姓名
    */
    @ApiModelProperty(value =  "更新人姓名")
    private String updateByName;
    /**
    * 更新时间
    */
    @ApiModelProperty(value =  "更新时间")
    private java.util.Date updateTime;

    /**
    * RELATE svc_mesh_datasource
    */
    @ApiModelProperty(value =  "RELATE svc_mesh_datasource")
    private SvcMeshDatasourceDomain svcMeshDatasource;


    /**
    * 鍔犺浇鏁版嵁妯欒瓨椤?
    */
    @ApiModelProperty(value =  "鍔犺浇鏁版嵁妯欒瓨椤?")
    private LoadFlag loadFlag;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SvcMeshDatasourceDomain extends BaseDomain{
        /**
        * 主鍵ID
        */
        @ApiModelProperty(value =  "主鍵ID")
        private Long id;
        /**
        * 編碼
        */
        @ApiModelProperty(value =  "編碼")
        private String code;
        /**
        * 名稱
        */
        @ApiModelProperty(value =  "名稱")
        private String name;
        /**
        * 數據源類型
        */
        @ApiModelProperty(value =  "數據源類型")
        private String type;
        /**
        * 配置
        */
        @ApiModelProperty(value =  "配置")
        private String config;
        /**
        * 租户号
        */
        @ApiModelProperty(value =  "租户号")
        private String tenantId;
        /**
        * 乐观锁
        */
        @ApiModelProperty(value =  "乐观锁")
        private String version;
        /**
        * 創建人
        */
        @ApiModelProperty(value =  "創建人")
        private String createBy;
        /**
        * 創建人姓名
        */
        @ApiModelProperty(value =  "創建人姓名")
        private String createByName;
        /**
        * 创建时间
        */
        @ApiModelProperty(value =  "创建时间")
        private java.util.Date createTime;
        /**
        * 更新人
        */
        @ApiModelProperty(value =  "更新人")
        private String updateBy;
        /**
        * 更新人姓名
        */
        @ApiModelProperty(value =  "更新人姓名")
        private String updateByName;
        /**
        * 更新时间
        */
        @ApiModelProperty(value =  "更新时间")
        private java.util.Date updateTime;
    }


    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LoadFlag extends BaseLoadFlag{
        /**
        * 鍔犺級鎵?鏈夋暩鎿氾紝 璎规厧浣跨敤
        */
        @ApiModelProperty(value =  "鍔犺級鎵?鏈夋暩鎿氾紝 璎规厧浣跨敤")
        private Boolean loadAll;

        /**
        * 鍔犺級SvcMeshDatasourceDomain
        */
        @ApiModelProperty(value =  "鍔犺級SvcMeshDatasourceDomain")
        private Boolean loadSvcMeshDatasource;
    }
}
