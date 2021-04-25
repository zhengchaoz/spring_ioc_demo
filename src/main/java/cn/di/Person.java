package cn.di;

import java.util.StringJoiner;

/**
 * @user 郑超
 * @date 2021/4/22
 */
public class Person {

    private int id;

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .toString();
    }
}
