package com.artframework.servicemesh.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* svc_mesh_flow_config
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@TableName("svc_mesh_flow_config")
public class SvcMeshFlowConfigDO  {


    /**
    * 主鍵
    */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
    * 流程ID
    */
    @TableField("flow_id")
    private Long flowId;
    /**
    * 流程配置
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
