package com.artframework.servicemesh.domains.serviceflow.dto;

import com.artframework.domain.core.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


/**
* serviceFlow
*
* @author auto
* @version v1.0
* @date 2023-12-17 12:20:56
*/
@Getter
@Setter
@ToString
public class ServiceFlowDTO extends BaseDTO {
    /**
    * 主鍵ID
    */
    private Long id;
    /**
    * 唯一標識
    */
    private String uuid;
    /**
    * 編碼
    */
    private String code;
    /**
    * 名稱
    */
    private String name;
    /**
    * 描述
    */
    private String description;
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
    * RELATE svc_mesh_flow_config
    */
    private SvcMeshFlowConfigDTO svcMeshFlowConfig;
    /**
    * RELATE svc_mesh_flow_node
    */
    private java.util.List<SvcMeshFlowNodeDTO> svcMeshFlowNodeList;
    /**
    * RELATE svc_mesh_flow_invoke_log
    */
    private java.util.List<SvcMeshFlowInvokeLogDTO> svcMeshFlowInvokeLogList;

    /**
    * 加载数据对象
    */
    private LoadFlag loadFlag;

    @Getter
    @Setter
    @ToString
    public static class SvcMeshFlowConfigDTO extends BaseDTO{
        /**
        * 是否有变化
        */
        private Boolean changed = false;

        /**
        * 主鍵
        */
        private Long id;
        /**
        * 流程ID
        */
        private Long flowId;
        /**
        * 流程配置
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
    public static class SvcMeshFlowNodeDTO extends BaseDTO{
        /**
        * 是否有变化
        */
        private Boolean changed = false;

        /**
        * 主鍵
        */
        private Long id;
        /**
        * 流程ID
        */
        private Long flowId;
        /**
        * 節點ID
        */
        private String nodeId;
        /**
        * 節點編碼
        */
        private String code;
        /**
        * 節點類型，包括數據節點，轉換節點，判斷節點等
        */
        private String nodeType;
        /**
        * 節點配置json
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
    public static class SvcMeshFlowInvokeLogDTO extends BaseDTO{
        /**
        * 是否有变化
        */
        private Boolean changed = false;

        /**
        * 主鍵ID
        */
        private Long id;
        /**
        * 服務流程ID
        */
        private Long flowId;
        /**
        * 調用方IP
        */
        private String sourceIp;
        /**
        * 服務方IP
        */
        private String targetIp;
        /**
        * 請求參數
        */
        private String request;
        /**
        * 響應
        */
        private String response;
        /**
        * 調用日誌
        */
        private String log;
        /**
        * 狀態 Y為成功， N為失敗
        */
        private String status;
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
        private Boolean loadSvcMeshFlowConfig = false;

        /**
        *
        */
        private Boolean loadSvcMeshFlowNode = false;

        /**
        *
        */
        private Boolean loadSvcMeshFlowInvokeLog = false;

        /**
         * 過濾條件
         */
        private Map<String, Object> filters = new HashMap<>();
    }
}
