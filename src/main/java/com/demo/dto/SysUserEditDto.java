package com.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SysUserEditDto {
    @NotNull(message = "用户ID不能为空")
    private Long id;

    @NotEmpty(message = "用户名不能为空")
    @Size(min = 1, max = 20, message = "用户名长度必须在 1-20 之间")
    private String username;

    private String password;

    @Email(message = "邮箱格式不正确")
    @NotEmpty(message = "邮箱不能为空")
    @Size(min = 1, max = 50, message = "邮箱长度必须在 1-50 之间")
    private String email;

    @NotNull(message = "年龄不能为空")
    private Integer age;

    private String phone;

    private Integer status;
}