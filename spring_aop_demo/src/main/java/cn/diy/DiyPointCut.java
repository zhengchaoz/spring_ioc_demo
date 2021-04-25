package cn.diy;

/**
 * 非侵入式AOP
 *
 * @user 郑超
 * @date 2021/4/25
 */
public class DiyPointCut {

    public void before() {
        System.out.println("===方法执行前===");
    }

    public void after() {
        System.out.println("===方法执行后===");
    }

}
