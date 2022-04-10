package com.ballcat.blog.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author pengshun
 * @date 2022-04-10 22:28
 * @description
 */
@Data
@ApiModel(description = "用户登陆入参")
public class UserDTO {

    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty(message = "密码不能为空")
    private String password;

//    @ApiModelProperty(value = "验证码", required = true)
//    @NotEmpty(message = "验证码不能为空")
    private String verifyCode;
}
