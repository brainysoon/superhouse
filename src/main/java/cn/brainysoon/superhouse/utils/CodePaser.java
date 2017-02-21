package cn.brainysoon.superhouse.utils;

/**
 * Created by brainy on 17-2-18.
 */
public class CodePaser {

    private static CodePaser codePaser = new CodePaser();

    private CodePaser() {

    }

    public static CodePaser getCodePaser() {

        return codePaser;
    }

    /**
     * @param loginCode 登录后的状态吗
     * @return 返回是否登录成功
     */
    public boolean paserLoginCode(int loginCode) {

        //如果大于零则表示登录成功
        return loginCode > 0;
    }

    /**
     * @param loginCode
     * @return //将状态吗转换成我们能够看懂的
     */
    public String paserLoginCodeToString(int loginCode) {

        if (loginCode < -1) {

            return "格式不对";
        } else if (loginCode < 0) {
            return "不存在该员工";
        } else if (loginCode == 0) {

            return "密码或者员工号错误";
        } else {

            return "登录成功";
        }
    }

    /**
     * @param saveCode 存货物的状态码
     * @return 是否存货物成功
     */
    public boolean paserSaveGoodsCode(int saveCode) {

        return saveCode > 0;
    }

    public String paserSaveGoodsCodeToString(int saveCode) {

        if (saveCode == -3) {

            return "货物数据格式有误";
        } else if (saveCode == -2) {

            return "服务器内部错误,存货物失败";
        } else if (saveCode == -1) {

            return "存货物失败";
        } else if (saveCode > 0) {

            return "货物存成功";
        } else {
            return "存货物失败";
        }
    }

    /**
     * @param pickCode
     * @return
     */
    public String paserPickGoodsCodeToString(int pickCode) {

        if (pickCode == -4) {

            return "货物已经提取完";
        } else if (pickCode == -3) {

            return "货物数量不够";
        } else if (pickCode == -2) {

            return "不存在该货物";
        } else if (pickCode == -1) {

            return "服务器错误";
        } else if (pickCode == 0) {

            return "提取失败";
        } else if (pickCode > 0) {

            return "提出成功";
        } else {
            return "位置代码";
        }
    }

    /**
     * @param scrapCode
     * @return
     */
    public String paserScrapGoodsCodeToString(int scrapCode) {

        if (scrapCode > 0) {

            return " 成功报废" + scrapCode + "个货物";
        } else if (scrapCode == -1) {

            return "服务器错误";
        } else {

            return "报废失败";
        }
    }

    /**
     * @param staffCode
     * @return
     */
    public String paserAddStaffCodeToString(int staffCode) {

        if (staffCode > 0) {

            return "添加成功";
        } else if (staffCode == -1) {

            return "服务器出错";
        } else if (staffCode == -2) {

            return "格式错误";
        } else {
            return "添加未成功";
        }
    }

    /**
     * @param staffCode
     * @return
     */
    public String paserStopStaffCodeToString(int staffCode) {

        if (staffCode > 0) {

            return "停止成功" + staffCode + "个员工";
        } else if (staffCode == -1) {

            return "服务器错误";
        } else if (staffCode == -3) {

            return "格式错误";
        } else {

            return "停止失败";
        }
    }
}
