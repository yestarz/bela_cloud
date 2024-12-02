package com.belacloud.auth.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.belacloud.auth.beans.LoginRequest;
import com.belacloud.auth.entity.SysUser;
import com.belacloud.auth.service.SysUserService;
import com.belacloud.common.beans.R;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/system/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/list")
    public List<SysUser> list() {
        return sysUserService.list();
    }

    @GetMapping("/{id}")
    public SysUser getUserById(@PathVariable Long id) {
        return sysUserService.getById(id);
    }

    @PostMapping("/login")
    public R<String> login(@RequestBody LoginRequest request) {
        if (StrUtil.equals(request.getUsername(), "admin") && StrUtil.equals(request.getPassword(), "123456")) {
            StpUtil.login(1L); // 登录账号id
            SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
            return R.ok(tokenInfo.getTokenValue());
        }
        return R.error("用户名或密码错误");
    }

    @GetMapping("/checkLogin")
    public R<Long> checkLogin(){
        return R.ok(StpUtil.getLoginIdAsLong());
    }
}
