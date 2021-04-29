package cn.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.jt.mapper")// 扫描指定包下的mapper接口文件
public class SpringbootDemo02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo02Application.class, args);
    }

}
