package com.artframework.servicemesh.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* svc_mesh_flow_invoke_log
*
* @author auto
* @version v1.0
* @date 2023-12-14 21:13:24
*/
@Getter
@Setter
@ToString
@TableName("svc_mesh_flow_invoke_log")
public class SvcMeshFlowInvokeLogDO  {


    /**
    * 主鍵ID
    */
    @TableId(value = "id", type = IdType.AUTO)
    private java.math.BigDecimal id;
    /**
    * 服務流程ID
    */
    @TableField("flow_id")
    private java.math.BigDecimal flowId;
    /**
    * 調用方IP
    */
    @TableField("source_ip")
    private String sourceIp;
    /**
    * 服務方IP
    */
    @TableField("target_ip")
    private String targetIp;
    /**
    * 請求參數
    */
    @TableField("request")
    private String request;
    /**
    * 響應
    */
    @TableField("response")
    private String response;
    /**
    * 調用日誌
    */
    @TableField("log")
    private String log;
    /**
    * 狀態 Y為成功， N為失敗
    */
    @TableField("status")
    private String status;
    /**
    * 租户号
    */
    @TableField("tenant_id")
    private String tenantId;
    /**
    * 乐观锁
    */
    @TableField("version")
    private String version;
    /**
    * 創建人
    */
    @TableField("create_by")
    private String createBy;
    /**
    * 創建人姓名
    */
    @TableField("create_by_name")
    private String createByName;
    /**
    * 创建时间
    */
    @TableField("create_time")
    private java.util.Date createTime;
    /**
    * 更新人
    */
    @TableField("update_by")
    private String updateBy;
    /**
    * 更新人姓名
    */
    @TableField("update_by_name")
    private String updateByName;
    /**
    * 更新时间
    */
    @TableField("update_time")
    private java.util.Date updateTime;
}
