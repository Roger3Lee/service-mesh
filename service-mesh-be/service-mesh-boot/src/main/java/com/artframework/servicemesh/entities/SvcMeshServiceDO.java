package com.artframework.servicemesh.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
* svc_mesh_service
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@TableName(value="svc_mesh_service", autoResultMap = true)
@KeySequence("seq_svc_mesh_service_id")
public class SvcMeshServiceDO  {


    /**
    * ���IID
    */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    /**
    * ����Դ����
    */
    @TableField("datasource_id")
    private Long datasourceId;
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
    * Ո��ģ��
    */
    @TableField("input_template")
    private String inputTemplate;
    /**
    * ����
    */
    @TableField("config")
    private String config;
    /**
    * ݔ��ģ��
    */
    @TableField("output_template")
    private String outputTemplate;
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
