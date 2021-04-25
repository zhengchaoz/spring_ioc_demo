package factory;

import cn.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @user 郑超
 * @date 2021/4/22
 */
public class AppConfigTest {
    
    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    }
    
}
