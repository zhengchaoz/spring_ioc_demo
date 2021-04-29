package cn.jt.mapper;

import cn.jt.pojo.DemoUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @user 郑超
 * @date 2021/4/28
 */
public interface DemoUserMapper extends BaseMapper<DemoUser> {

    List<DemoUser> findAll();

}
