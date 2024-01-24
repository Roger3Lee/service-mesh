package com.artframework.servicemesh.domains.datasource.domain;

import com.artframework.domain.core.domain.*;
import lombok.*;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
* datasource
*
* @author auto
* @version v1.0
*/
@Getter
@Setter
@ToString
@ApiModel(value = "數據�?")
public class DatasourceDomain extends BaseDomain {
    /**
    * ���IID
    */
    @ApiModelProperty(value =  "���IID")
    private Long id;
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
    * ����Դ���
    */
    @ApiModelProperty(value =  "����Դ���")
    private String type;
    /**
    * ����
    */
    @ApiModelProperty(value =  "����")
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
    public static class LoadFlag extends BaseLoadFlag{
        /**
        * 加載�?有數據， 謹慎使用
        */
        @ApiModelProperty(value =  "加載�?有數據， 謹慎使用")
        private Boolean loadAll;
    }
}
