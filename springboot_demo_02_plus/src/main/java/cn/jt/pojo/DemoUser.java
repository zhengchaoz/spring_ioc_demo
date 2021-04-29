package cn.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @user 郑超
 * @date 2021/4/28
 */
@Data
@Accessors(chain = true)
@TableName("demo_user")// 实体类和表绑定
public class DemoUser extends Model<DemoUser> {

    @TableId(value = "id", type = IdType.AUTO)
//    @TableId(value = "id", type = IdType.ASSIGN_UUID) UUID使用随机hash算法，几乎保证不重复
    private Integer id;
//    @TableField(value = "name", exist = false) value：字段别名 exist：实体类属性名和表中字段不绑定
    private String name;
    private Integer age;
    private String sex;

}
