/**
 * model 层：
 * 数据库实体层，也被称为 entity 层、pojo 层
 * 用于存储数据库中的数据，类属性与数据库表字段对应
 * 通常情况下，Model 层使用 ORM（对象关系映射）技术，如 JPA，MyBatis等与数据库进行交互
 */
package com.example.dream_spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("数据库字段")
public class Data {

    @ApiModelProperty(value = "信息所属ID", required = true, example = "1")
    private int id;

    @ApiModelProperty(value = "信息来源IP地址", required = true, example = "127.0.0.1")
    private String ip;

    @ApiModelProperty(value = "信息来源所属省份", required = true, example = "湖北")
    private String province;

    @ApiModelProperty(value = "内容发布时间", required = true, example = "2023-2-6 16:58:00")
    private String time;

    @ApiModelProperty(value = "梦想内容", required = true, example = "环游世界！")
    private String str;

    @ApiModelProperty(value = "点赞数", required = true, example = "52")
    private int likes;

}