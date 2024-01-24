package com.artframework.servicemesh.domains.serviceflow.domain;

import com.artframework.domain.core.domain.*;
import lombok.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* serviceFlow
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@ApiModel(value = "鏈嶅嫏绶ㄦ帓娴佺▼")
public class ServiceFlowDomain extends BaseDomain {
    /**
    * 主鍵ID
    */
    @ApiModelProperty(value =  "主鍵ID")
    private Long id;
    /**
    * 唯一標識
    */
    @ApiModelProperty(value =  "唯一標識")
    private String uuid;
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
    * 描述
    */
    @ApiModelProperty(value =  "描述")
    private String description;
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
    * RELATE svc_mesh_flow_config
    */
    @ApiModelProperty(value =  "RELATE svc_mesh_flow_config")
    private SvcMeshFlowConfigDomain svcMeshFlowConfig;
    /**
    * RELATE svc_mesh_flow_node
    */
    @ApiModelProperty(value =  "RELATE svc_mesh_flow_node")
    private java.util.List<SvcMeshFlowNodeDomain> svcMeshFlowNodeList;
    /**
    * RELATE svc_mesh_flow_invoke_log
    */
    @ApiModelProperty(value =  "RELATE svc_mesh_flow_invoke_log")
    private java.util.List<SvcMeshFlowInvokeLogDomain> svcMeshFlowInvokeLogList;


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
    public static class SvcMeshFlowConfigDomain extends BaseDomain{
        /**
        * 主鍵
        */
        @ApiModelProperty(value =  "主鍵")
        private Long id;
        /**
        * 流程ID
        */
        @ApiModelProperty(value =  "流程ID")
        private Long flowId;
        /**
        * 流程配置
        */
        @ApiModelProperty(value =  "流程配置")
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
    public static class SvcMeshFlowNodeDomain extends BaseDomain{
        /**
        * 主鍵
        */
        @ApiModelProperty(value =  "主鍵")
        private Long id;
        /**
        * 流程ID
        */
        @ApiModelProperty(value =  "流程ID")
        private Long flowId;
        /**
        * 節點ID
        */
        @ApiModelProperty(value =  "節點ID")
        private String nodeId;
        /**
        * 節點編碼
        */
        @ApiModelProperty(value =  "節點編碼")
        private String code;
        /**
        * 節點類型，包括數據節點，轉換節點，判斷節點等
        */
        @ApiModelProperty(value =  "節點類型，包括數據節點，轉換節點，判斷節點等")
        private String nodeType;
        /**
        * 節點配置json
        */
        @ApiModelProperty(value =  "節點配置json")
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
    public static class SvcMeshFlowInvokeLogDomain extends BaseDomain{
        /**
        * 主鍵ID
        */
        @ApiModelProperty(value =  "主鍵ID")
        private Long id;
        /**
        * 服務流程ID
        */
        @ApiModelProperty(value =  "服務流程ID")
        private Long flowId;
        /**
        * 調用方IP
        */
        @ApiModelProperty(value =  "調用方IP")
        private String sourceIp;
        /**
        * 服務方IP
        */
        @ApiModelProperty(value =  "服務方IP")
        private String targetIp;
        /**
        * 請求參數
        */
        @ApiModelProperty(value =  "請求參數")
        private String request;
        /**
        * 響應
        */
        @ApiModelProperty(value =  "響應")
        private String response;
        /**
        * 調用日誌
        */
        @ApiModelProperty(value =  "調用日誌")
        private String log;
        /**
        * 狀態 Y為成功， N為失敗
        */
        @ApiModelProperty(value =  "狀態 Y為成功， N為失敗")
        private String status;
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
        * 鍔犺級SvcMeshFlowConfigDomain
        */
        @ApiModelProperty(value =  "鍔犺級SvcMeshFlowConfigDomain")
        private Boolean loadSvcMeshFlowConfig;

        /**
        * 鍔犺級SvcMeshFlowNodeDomain
        */
        @ApiModelProperty(value =  "鍔犺級SvcMeshFlowNodeDomain")
        private Boolean loadSvcMeshFlowNode;

        /**
        * 鍔犺級SvcMeshFlowInvokeLogDomain
        */
        @ApiModelProperty(value =  "鍔犺級SvcMeshFlowInvokeLogDomain")
        private Boolean loadSvcMeshFlowInvokeLog;
    }
}
