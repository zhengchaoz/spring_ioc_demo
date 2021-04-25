package cn.jt.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @user 郑超
 * @date 2021/4/22
 */
@Component
public class User implements Serializable {

    private static final long serialVersionUID = -1530273050904654036L;

    private int id;
    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Value("0001")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Value("胡雪飞")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
