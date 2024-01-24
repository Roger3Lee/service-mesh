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
*/
@Getter
@Setter
@ToString
@TableName(value="svc_mesh_flow_invoke_log", autoResultMap = true)
@KeySequence("seq_svc_mesh_flow_invoke_log_id")
public class SvcMeshFlowInvokeLogDO  {


    /**
    * ���IID
    */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;
    /**
    * ��������ID
    */
    @TableField("flow_id")
    private Long flowId;
    /**
    * �{�÷�IP
    */
    @TableField("source_ip")
    private String sourceIp;
    /**
    * ���շ�IP
    */
    @TableField("target_ip")
    private String targetIp;
    /**
    * Ո�󅢔�
    */
    @TableField("request")
    private String request;
    /**
    * 푑�
    */
    @TableField("response")
    private String response;
    /**
    * �{�����I
    */
    @TableField("log")
    private String log;
    /**
    * ��B Y��ɹ��� N��ʧ��
    */
    @TableField("status")
    private String status;
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
