package cn.brainysoon.superhouse.web;

import cn.brainysoon.superhouse.bean.Staff;
import cn.brainysoon.superhouse.service.LogService;
import cn.brainysoon.superhouse.service.ScrapService;
import cn.brainysoon.superhouse.utils.CodePaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by brainy on 17-2-18.
 */
@Controller
@RequestMapping("/scrap")
public class ScrapController {

    private ScrapService scrapService;
    private LogService logService;

    @Autowired
    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    @Autowired
    public void setScrapService(ScrapService scrapService) {
        this.scrapService = scrapService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String scrap(Model model) {

        model.addAttribute("goodses", scrapService.findGoodsScraped());

        return "discard";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doScrap(Model model,
                          HttpSession httpSession,
                          @RequestParam(value = "_id") String[] _id) {


        int code = scrapService.scrapGoods(_id);

        //插入日志
        if (code > 0) {
            Staff staff = (Staff) httpSession.getAttribute("staff");
            for (String id : _id) {
                logService.addLogByClass(staff.get_id(), id, LogService.SCRAP_GOODS_LOG);
            }
        }

        model.addAttribute("code", code);
        model.addAttribute("codestring", CodePaser.getCodePaser().paserScrapGoodsCodeToString(code));

        return "redirect:/scrap";
    }
}
