package cn.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 郑超
 * @create 2021/4/30
 */
@Data
@Accessors(chain = true)
public class Dog {

    private String dogName;
    private Integer dogAge;

}
