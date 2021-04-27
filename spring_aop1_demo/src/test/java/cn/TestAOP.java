package cn;

import cn.service.DeptService;
import cn.config.SpringConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/26
 */
public class TestAOP {

    @Test
    public void test(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        // 配置类中开启@EnableAspectJAutoProxy后，getBean获取的是动态生成的代理类
        DeptService deptService = context.getBean(DeptService.class);
        System.out.println(deptService.getClass());

        deptService.addDept();
        deptService.updateDept();

        System.out.println("===");
        deptService.deleteDept(9528);
        System.out.println("===");
    }

}
