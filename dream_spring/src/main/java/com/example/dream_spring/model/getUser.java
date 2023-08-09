package com.example.dream_spring.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("获取信息内容")
public class getUser {

    @ApiModelProperty(value = "信息所属ID", required = true, example = "1")
    private int id;

    @ApiModelProperty(value = "信息来源所属省份", required = true, example = "湖北")
    private String province;

    @ApiModelProperty(value = "梦想内容", required = true, example = "环游世界！")
    private String str;

    @ApiModelProperty(value = "点赞数", required = true, example = "52")
    private int likes;
}
