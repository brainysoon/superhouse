package cn.brainysoon.superhouse.web;

import cn.brainysoon.superhouse.service.SaveService;
import cn.brainysoon.superhouse.utils.CodePaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

/**
 * Created by brainy on 17-2-18.
 */
@Controller
@RequestMapping("/save")
public class SaveController {

    SaveService saveService;

    public void setSaveService(SaveService saveService) {
        this.saveService = saveService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String save() {
        return "save";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doSave(Model model,
                         @RequestParam(value = "_id") String _id,
                         @RequestParam(value = "goodsname") String goodsname,
                         @RequestParam(value = "count") Integer count,
                         @RequestParam(value = "goodsclass") String goodsclass,
                         @RequestParam(value = "price") Double price,
                         @RequestParam(value = "usefullife") Integer usefullife,
                         @RequestParam(value = "dateproduced") Date dateproduced,
                         @RequestParam(value = "position") Integer position) {

        int saveCode = saveService.saveGoods(_id, goodsname, count, goodsclass,
                price, usefullife, dateproduced, position);

        if (CodePaser.getCodePaser().paserSaveGoodsCode(saveCode)) {

          
        } else {

        }

        return null;
    }
}