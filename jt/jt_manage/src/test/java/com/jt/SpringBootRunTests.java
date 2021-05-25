package com.jt;

import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.jt.pojo.ItemCat;
import com.jt.service.ItemCatService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author 刘昱江
 * 时间 2021/5/11
 */
@SpringBootTest
class SpringBootRunTests {

    @Autowired
    private ItemCatService itemCatService;

    @Test
    void contextLoads() {
        List<ItemCat> itemCats = itemCatService.findItemCatList(0);
//        List<ItemCat> list = itemCats.stream().filter(itemCat -> itemCat.getParentId() == 0)
//                .collect(Collectors.toList());
//        list.forEach(itemCat1 -> itemCat1.setChildren(
//                getMapStream(itemCats, itemCat1.getParentId())
//        ));
//        list.forEach(itemCat1 -> {
//            itemCat1.getChildren().forEach(itemCat2 -> itemCat2.setChildren(
//                    getMapStream(itemCats, itemCat2.getParentId())
//            ));
//        });
        List<ItemCat> collect = itemCats.stream().filter(itemCat -> itemCat.getParentId() == 0)
                .peek(itemCat -> itemCat.setChildren(getChildren(itemCat, itemCats)))
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private List<ItemCat> getChildren(ItemCat itemCat, List<ItemCat> itemCats) {
        return itemCats.stream().filter(e -> Objects.equals(e.getParentId(), itemCat.getId()))
                .peek(e -> e.setChildren(getChildren(e, itemCats))
        ).collect(Collectors.toList());
    }

}
