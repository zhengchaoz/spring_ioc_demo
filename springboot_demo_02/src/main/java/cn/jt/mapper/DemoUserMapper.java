package cn.jt.mapper;

import cn.jt.pojo.DemoUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @user 郑超
 * @date 2021/4/28
 */
public interface DemoUserMapper {

    List<DemoUser> findAll();

    @Select("select * from demo_user where id = #{id};")
    DemoUser findById(@Param("id") Integer id);

    @Insert("insert into demo_user (name, age, sex) value (#{name}, #{age}, #{sex});")
    int insert(DemoUser demoUser);

//    @Update("update demo_user set name = #{name}, age = #{age}, sex = #{sex} where id = #{id};")
    int update(DemoUser demoUser);

    @Delete("delete from demo_user where id = #{id};")
    int deleteById(@Param("id") Integer id);

}
