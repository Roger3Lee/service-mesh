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
@ApiModel(value = "服務編排流程")
public class ServiceFlowDomain extends BaseDomain {
    /**
    * ���IID
    */
    @ApiModelProperty(value =  "���IID")
    private Long id;
    /**
    * Ψһ���R
    */
    @ApiModelProperty(value =  "Ψһ���R")
    private String uuid;
    /**
    * ���a
    */
    @ApiModelProperty(value =  "���a")
    private String code;
    /**
    * ���Q
    */
    @ApiModelProperty(value =  "���Q")
    private String name;
    /**
    * ����
    */
    @ApiModelProperty(value =  "����")
    private String description;
    /**
    * �⻧��
    */
    @ApiModelProperty(value =  "�⻧��")
    private String tenantId;
    /**
    * �ֹ���
    */
    @ApiModelProperty(value =  "�ֹ���")
    private String version;
    /**
    * ������
    */
    @ApiModelProperty(value =  "������")
    private String createBy;
    /**
    * ����������
    */
    @ApiModelProperty(value =  "����������")
    private String createByName;
    /**
    * ����ʱ��
    */
    @ApiModelProperty(value =  "����ʱ��")
    private java.util.Date createTime;
    /**
    * ������
    */
    @ApiModelProperty(value =  "������")
    private String updateBy;
    /**
    * ����������
    */
    @ApiModelProperty(value =  "����������")
    private String updateByName;
    /**
    * ����ʱ��
    */
    @ApiModelProperty(value =  "����ʱ��")
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
    * 加载数据標識�?
    */
    @ApiModelProperty(value =  "加载数据標識�?")
    private LoadFlag loadFlag;

    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SvcMeshFlowConfigDomain extends BaseDomain{
        /**
        * ���I
        */
        @ApiModelProperty(value =  "���I")
        private Long id;
        /**
        * ����ID
        */
        @ApiModelProperty(value =  "����ID")
        private Long flowId;
        /**
        * ��������
        */
        @ApiModelProperty(value =  "��������")
        private String config;
        /**
        * �⻧��
        */
        @ApiModelProperty(value =  "�⻧��")
        private String tenantId;
        /**
        * �ֹ���
        */
        @ApiModelProperty(value =  "�ֹ���")
        private String version;
        /**
        * ������
        */
        @ApiModelProperty(value =  "������")
        private String createBy;
        /**
        * ����������
        */
        @ApiModelProperty(value =  "����������")
        private String createByName;
        /**
        * ����ʱ��
        */
        @ApiModelProperty(value =  "����ʱ��")
        private java.util.Date createTime;
        /**
        * ������
        */
        @ApiModelProperty(value =  "������")
        private String updateBy;
        /**
        * ����������
        */
        @ApiModelProperty(value =  "����������")
        private String updateByName;
        /**
        * ����ʱ��
        */
        @ApiModelProperty(value =  "����ʱ��")
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
        * ���I
        */
        @ApiModelProperty(value =  "���I")
        private Long id;
        /**
        * ����ID
        */
        @ApiModelProperty(value =  "����ID")
        private Long flowId;
        /**
        * ���cID
        */
        @ApiModelProperty(value =  "���cID")
        private String nodeId;
        /**
        * ���c���a
        */
        @ApiModelProperty(value =  "���c���a")
        private String code;
        /**
        * ���c��ͣ������������c���D�Q���c���Д๝�c��
        */
        @ApiModelProperty(value =  "���c��ͣ������������c���D�Q���c���Д๝�c��")
        private String nodeType;
        /**
        * ���c����json
        */
        @ApiModelProperty(value =  "���c����json")
        private String config;
        /**
        * �⻧��
        */
        @ApiModelProperty(value =  "�⻧��")
        private String tenantId;
        /**
        * �ֹ���
        */
        @ApiModelProperty(value =  "�ֹ���")
        private String version;
        /**
        * ������
        */
        @ApiModelProperty(value =  "������")
        private String createBy;
        /**
        * ����������
        */
        @ApiModelProperty(value =  "����������")
        private String createByName;
        /**
        * ����ʱ��
        */
        @ApiModelProperty(value =  "����ʱ��")
        private java.util.Date createTime;
        /**
        * ������
        */
        @ApiModelProperty(value =  "������")
        private String updateBy;
        /**
        * ����������
        */
        @ApiModelProperty(value =  "����������")
        private String updateByName;
        /**
        * ����ʱ��
        */
        @ApiModelProperty(value =  "����ʱ��")
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
        * ���IID
        */
        @ApiModelProperty(value =  "���IID")
        private Long id;
        /**
        * ��������ID
        */
        @ApiModelProperty(value =  "��������ID")
        private Long flowId;
        /**
        * �{�÷�IP
        */
        @ApiModelProperty(value =  "�{�÷�IP")
        private String sourceIp;
        /**
        * ���շ�IP
        */
        @ApiModelProperty(value =  "���շ�IP")
        private String targetIp;
        /**
        * Ո�󅢔�
        */
        @ApiModelProperty(value =  "Ո�󅢔�")
        private String request;
        /**
        * 푑�
        */
        @ApiModelProperty(value =  "푑�")
        private String response;
        /**
        * �{�����I
        */
        @ApiModelProperty(value =  "�{�����I")
        private String log;
        /**
        * ��B Y��ɹ��� N��ʧ��
        */
        @ApiModelProperty(value =  "��B Y��ɹ��� N��ʧ��")
        private String status;
        /**
        * �⻧��
        */
        @ApiModelProperty(value =  "�⻧��")
        private String tenantId;
        /**
        * �ֹ���
        */
        @ApiModelProperty(value =  "�ֹ���")
        private String version;
        /**
        * ������
        */
        @ApiModelProperty(value =  "������")
        private String createBy;
        /**
        * ����������
        */
        @ApiModelProperty(value =  "����������")
        private String createByName;
        /**
        * ����ʱ��
        */
        @ApiModelProperty(value =  "����ʱ��")
        private java.util.Date createTime;
        /**
        * ������
        */
        @ApiModelProperty(value =  "������")
        private String updateBy;
        /**
        * ����������
        */
        @ApiModelProperty(value =  "����������")
        private String updateByName;
        /**
        * ����ʱ��
        */
        @ApiModelProperty(value =  "����ʱ��")
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
        * 加載�?有數據， 謹慎使用
        */
        @ApiModelProperty(value =  "加載�?有數據， 謹慎使用")
        private Boolean loadAll;

        /**
        * 加載SvcMeshFlowConfigDomain
        */
        @ApiModelProperty(value =  "加載SvcMeshFlowConfigDomain")
        private Boolean loadSvcMeshFlowConfig;

        /**
        * 加載SvcMeshFlowNodeDomain
        */
        @ApiModelProperty(value =  "加載SvcMeshFlowNodeDomain")
        private Boolean loadSvcMeshFlowNode;

        /**
        * 加載SvcMeshFlowInvokeLogDomain
        */
        @ApiModelProperty(value =  "加載SvcMeshFlowInvokeLogDomain")
        private Boolean loadSvcMeshFlowInvokeLog;
    }
}
