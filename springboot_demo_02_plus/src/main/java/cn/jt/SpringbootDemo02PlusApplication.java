package cn.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"cn.jt.mapper"})
public class SpringbootDemo02PlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo02PlusApplication.class, args);
    }

}
