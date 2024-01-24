package com.artframework.servicemesh.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* svc_mesh_flow_node
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@TableName(value="svc_mesh_flow_node", autoResultMap = true)
@KeySequence("seq_svc_mesh_flow_node_id")
public class SvcMeshFlowNodeDO  {


    /**
    * 主鍵
    */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    /**
    * 流程ID
    */
    @TableField("flow_id")
    private Long flowId;
    /**
    * 節點ID
    */
    @TableField("node_id")
    private String nodeId;
    /**
    * 節點編碼
    */
    @TableField("code")
    private String code;
    /**
    * 節點類型，包括數據節點，轉換節點，判斷節點等
    */
    @TableField("node_type")
    private String nodeType;
    /**
    * 節點配置json
    */
    @TableField("config")
    private String config;
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
