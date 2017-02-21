package cn.brainysoon.superhouse.web;

import cn.brainysoon.superhouse.bean.Goods;
import cn.brainysoon.superhouse.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brainy on 17-2-18.
 */
@Controller
@RequestMapping("/query")
public class QueryController {

    private QueryService queryService;

    @Autowired
    public void setQueryService(QueryService queryService) {
        this.queryService = queryService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String query(Model model) {

        model.addAttribute("goodses", queryService.queryGoodsByKey(""));

        return "search";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doQuery(Model model,
                          @RequestParam(value = "key") String key) {

        //key 关键字包括 _id 商品号 ,goodsname 商品名称,goodclass 商品类别

        List<Goods> goodses = new ArrayList<>();

        goodses = queryService.queryGoodsByKey(key);

        model.addAttribute("goodses", goodses);

        return "search";
    }
}
