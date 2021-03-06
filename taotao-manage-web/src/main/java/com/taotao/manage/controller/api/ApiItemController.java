package com.taotao.manage.controller.api;

import com.taotao.manage.pojo.Item;
import com.taotao.manage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by dd876799869 on 2017/6/24.
 */
@Controller
@RequestMapping("api/item")
public class ApiItemController {

    @Autowired
    private ItemService itemService;

    /**
     * 对外提供查询商品基本信息接口
     * @return
     */
    @RequestMapping(value = "{itemId}",method = RequestMethod.GET)
    public ResponseEntity<Item> queryItemByItemId(@PathVariable Long itemId){
        try {
            Item json = itemService.queryById(itemId);
            return  ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
