package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author 刘昱江
 * 时间 2021/4/7
 */
@EqualsAndHashCode(callSuper = true)
@TableName("item_desc")
@Data
@Accessors(chain = true)
public class ItemDesc extends BasePojo {

    private Integer id;
    private String itemDesc;

}
