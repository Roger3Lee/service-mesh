package com.artframework.servicemesh.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* svc_mesh_flow
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@TableName(value="svc_mesh_flow", autoResultMap = true)
@KeySequence("seq_svc_mesh_flow_id")
public class SvcMeshFlowDO  {


    /**
    * ���IID
    */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    /**
    * Ψһ���R
    */
    @TableField("uuid")
    private String uuid;
    /**
    * ���a
    */
    @TableField("code")
    private String code;
    /**
    * ���Q
    */
    @TableField("name")
    private String name;
    /**
    * ����
    */
    @TableField("description")
    private String description;
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
