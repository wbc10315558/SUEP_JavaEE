package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.entity.SysUser;
import com.demo.mapper.SysUserMapper;
import com.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServicelmpl extends ServiceImpl<SysUserMapper, SysUser> implements UserService {
}
