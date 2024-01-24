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
@ApiModel(value = "鏁告摎婧?")
public class DatasourceDomain extends BaseDomain {
    /**
    * 主鍵ID
    */
    @ApiModelProperty(value =  "主鍵ID")
    private Long id;
    /**
    * 編碼
    */
    @ApiModelProperty(value =  "編碼")
    private String code;
    /**
    * 名稱
    */
    @ApiModelProperty(value =  "名稱")
    private String name;
    /**
    * 數據源類型
    */
    @ApiModelProperty(value =  "數據源類型")
    private String type;
    /**
    * 配置
    */
    @ApiModelProperty(value =  "配置")
    private String config;
    /**
    * 租户号
    */
    @ApiModelProperty(value =  "租户号")
    private String tenantId;
    /**
    * 乐观锁
    */
    @ApiModelProperty(value =  "乐观锁")
    private String version;
    /**
    * 創建人
    */
    @ApiModelProperty(value =  "創建人")
    private String createBy;
    /**
    * 創建人姓名
    */
    @ApiModelProperty(value =  "創建人姓名")
    private String createByName;
    /**
    * 创建时间
    */
    @ApiModelProperty(value =  "创建时间")
    private java.util.Date createTime;
    /**
    * 更新人
    */
    @ApiModelProperty(value =  "更新人")
    private String updateBy;
    /**
    * 更新人姓名
    */
    @ApiModelProperty(value =  "更新人姓名")
    private String updateByName;
    /**
    * 更新时间
    */
    @ApiModelProperty(value =  "更新时间")
    private java.util.Date updateTime;



    /**
    * 鍔犺浇鏁版嵁妯欒瓨椤?
    */
    @ApiModelProperty(value =  "鍔犺浇鏁版嵁妯欒瓨椤?")
    private LoadFlag loadFlag;



    @Getter
    @Setter
    @ToString
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LoadFlag extends BaseLoadFlag{
        /**
        * 鍔犺級鎵?鏈夋暩鎿氾紝 璎规厧浣跨敤
        */
        @ApiModelProperty(value =  "鍔犺級鎵?鏈夋暩鎿氾紝 璎规厧浣跨敤")
        private Boolean loadAll;
    }
}
