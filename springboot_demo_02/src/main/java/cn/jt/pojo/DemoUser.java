package cn.jt.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @user 郑超
 * @date 2021/4/28
 */
@Data
@Accessors(chain = true)
public class DemoUser {

    private Integer id;
    private String name;
    private Integer age;
    private String sex;

}
