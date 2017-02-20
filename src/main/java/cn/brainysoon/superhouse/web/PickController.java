package cn.brainysoon.superhouse.web;

import cn.brainysoon.superhouse.bean.Staff;
import cn.brainysoon.superhouse.service.LogService;
import cn.brainysoon.superhouse.service.PickService;
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
@RequestMapping("pick")
public class PickController {

    private PickService pickService;
    private LogService logService;

    @Autowired
    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    @Autowired
    public void setPickService(PickService pickService) {
        this.pickService = pickService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String pick() {

        return "take";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doPick(Model model,
                         HttpSession httpSession,
                         @RequestParam(value = "_id") String _id,
                         @RequestParam(value = "position") Integer position,
                         @RequestParam(value = "count") Integer count) {

        int pickCode = pickService.pickGoods(_id, position, count);

        //插入日志
        if (pickCode > 0) {

            Staff staff = (Staff) httpSession.getAttribute("staff");
            logService.addLogByClass(staff.get_id(), _id, LogService.PICK_GOODS_LOG);
        }

        model.addAttribute("code", pickCode);
        model.addAttribute("codestring", CodePaser.getCodePaser().paserPickGoodsCodeToString(pickCode));

        return "take";
    }
}
