package cn.jt.pojo;

/**
 * @user 郑超
 * @date 2021/4/21
 */
public class User {

    private String conn;

    public User() {
        System.out.println("创建对象User。。。");
    }

    public void init() {
        this.conn = "初始化资源User。。。";
        System.out.println(conn);
    }

    public void say() {
        System.out.println("你好Spring!");
    }

    public void destroy() {
        this.conn = null;
        System.out.println("释放资源User。。。");
    }
}
