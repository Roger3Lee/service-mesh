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
@TableName(value="svc_mesh_flow_config", autoResultMap = true)
@KeySequence("seq_svc_mesh_flow_config_id")
public class SvcMeshFlowConfigDO  {


    /**
    * ���I
    */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    /**
    * ����ID
    */
    @TableField("flow_id")
    private Long flowId;
    /**
    * ��������
    */
    @TableField("config")
    private String config;
    /**
    * �⻧��
    */
    @TableField("tenant_id")
    private String tenantId;
    /**
    * �ֹ���
    */
    @TableField("version")
    private String version;
    /**
    * ������
    */
    @TableField("create_by")
    private String createBy;
    /**
    * ����������
    */
    @TableField("create_by_name")
    private String createByName;
    /**
    * ����ʱ��
    */
    @TableField("create_time")
    private java.util.Date createTime;
    /**
    * ������
    */
    @TableField("update_by")
    private String updateBy;
    /**
    * ����������
    */
    @TableField("update_by_name")
    private String updateByName;
    /**
    * ����ʱ��
    */
    @TableField("update_time")
    private java.util.Date updateTime;
}
