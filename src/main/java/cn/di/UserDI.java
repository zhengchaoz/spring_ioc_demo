package cn.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * @user 郑超
 * @date 2021/4/22
 */
//等价于<bean id="userDI" class="cn.di.UserDI"/>
//@Component
public class UserDI {

//    @Value("自动注入属性值")
    private Integer id;
    private String name;

//    @Autowired 先byType 可以省略set方法；属性required=false时该属性可以为空 类似@Nullable
//    @Qualifier(value = "显示指定xml中的bean的id值") 和 @Autowired一起用
//    @Resource 同样是自动装配，先是byName。然后byType，也可以指定name = "显示指定xml中的bean的id值"
    private Person person;

    private List list;
    private Set set;
    private Map map;
    private Properties properties;

    public UserDI() {
    }

    public UserDI(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDI.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("person=" + person)
                .add("list=" + list)
                .add("set=" + set)
                .add("map=" + map)
                .add("properties=" + properties)
                .toString();
    }
}
