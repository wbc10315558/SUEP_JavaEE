package com.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.demo.common.Result;
import com.demo.dto.SysUserDto;
import com.demo.dto.SysUserEditDto;
import com.demo.entity.SysUser;
import com.demo.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class SysUserController {
    private final UserService userService;

    public SysUserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public Result<SysUser> save(@RequestBody @Valid SysUserDto user) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user, sysUser);
        boolean success = userService.save(sysUser);
        return Result.success(success ? "添加成功" : "添加失败", null);
    }
    @PutMapping("/edit")
    public Result<Void> update(@RequestBody @Valid @NotNull SysUserEditDto user){
        //判定用户名不能重复，记录不能是自己
        if (userService.exists(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername,user.getUsername())
                .ne(SysUser::getId,user.getId()))){
            return Result.error("用户名已存在");
        }
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(user,sysUser);
        boolean success = userService.updateById(sysUser);
        return success?Result.success():Result.error("修改失败");
    }

    @DeleteMapping("/{id}")
    public Result<SysUser> getByID(@PathVariable long id){
        SysUser user = userService.getById(id);
        return user == null ? Result.error("用户不存在"):Result.success(user);
    }

    @GetMapping("/{id}")
    public Result<SysUser> getById(@PathVariable Long id) {
        SysUser user = userService.getById(id);
        return user == null ? Result.error("用户不存在") : Result.success(user);
    }
}