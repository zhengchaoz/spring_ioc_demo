package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author 郑超
 * @create 2021/5/11
 */
@Data
@Accessors(chain = true)
public class AxiosPojo {

    private Integer id;
    private String name;

}
