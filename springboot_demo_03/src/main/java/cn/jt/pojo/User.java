package cn.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 郑超
 * @create 2021/4/30
 */
@Data
@Accessors(chain = true)
public class User {

    private Integer id;
    private String name;
    private Long[] hobby;// JavaBean中必须使用包装类型，默认值为null，并且有更多的方法

    private Dog dog;

}
