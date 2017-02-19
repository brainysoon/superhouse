package cn.brainysoon.superhouse.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by brainy on 17-2-18.
 */
@Controller
@RequestMapping("/query")
public class QueryController {

    @RequestMapping(method = RequestMethod.GET)
    public String query() {

        return "query";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doQuery(Model model,
                          @RequestParam(value = "key") String key,
                          @RequestParam(value = "keyclass") String keyclass) {

        //key 关键字包括 _id 商品号 ,goodsname 商品名称,goodclass 商品类别

        return null;
    }
}
