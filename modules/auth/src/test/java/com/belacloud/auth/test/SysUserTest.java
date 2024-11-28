package com.belacloud.auth.test;

import com.belacloud.auth.entity.SysUser;
import com.belacloud.auth.mapper.SysUserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SysUserTest {

    @Resource
    private SysUserMapper sysUserMapper;

    @Test
    public void testQuery(){
        List<SysUser> sysUsers = sysUserMapper.selectList(null);
        System.out.println(sysUsers);
    }
}
