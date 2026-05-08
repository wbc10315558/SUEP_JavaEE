package com.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SysUserQueryDto {
    @Size(max = 20, message = "用户名长度必须在 1-20 之间")
    private String username;
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度必须在 1-50 之间")
    private String email;
    private Integer age;
    private String phone;
    private Integer status;
    public LocalDateTime startTime;
    public LocalDateTime endTime;
}