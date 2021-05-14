package com.jt;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@SpringBootTest
class SpringBootRunTests {

    @Test
    void contextLoads() {
        System.out.println(DigestUtils.md5DigestAsHex("root".getBytes()));
    }

}
