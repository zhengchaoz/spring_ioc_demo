package cn.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.StringJoiner;

/**
 * @user 郑超
 * @date 2021/4/27
 */
@Component// 将对象交给Spring容器管理
@PropertySource(value = "classpath:/dept.properties", encoding = "UTF-8")
@Data// Get() Set() 可选参数构造函数 toString() equals() hashCode()
@Accessors(chain = true)// 链式Set()
//@NoArgsConstructor无参构造方法
//@AllArgsConstructor全参构造方法
public class Dept {

    @Value("${dept.id}")
    private Integer id;
    @Value("${dept.name}")
    private String name;

    @Value("${dept.id2}")
    private Integer id2;
    @Value("${dept.name2}")
    private String name2;

}
