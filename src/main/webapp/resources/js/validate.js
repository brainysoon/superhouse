/**
 * Created by coolfy on 2017/2/20.
 */



/*校验存货信息*/

$().ready(function () {

    $.validator.addMethod("isDigits", function(value, element) {                                         /*校验货物编号*/
        return this.optional(element) || /^\d+$/.test(value);
    }, "只能输入0-9数字");

    $.validator.addMethod("isChineseChar", function(value, element) {
        return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);
    }, "匹配中文(包括汉字和字符) ");

    jQuery.validator.addMethod("isNumber", function(value, element) {
        return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);
    }, "匹配数值类型，包括整数和浮点数");

    $.validator.addMethod("isDate", function(value, element) {
        return this.optional(element) || /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/.test(value);
    }, "只能输入XXXX-XX-XX或XXXX/XX/XX格式日期");


    $("#saveForm").validate({
        rules:{
            _id:{
                required:true,
                minlength:6,
                maxlength:20,
                isDigits:true
            },
            position:{
                required:true,
                minlength:1,
                maxlength:4,
                isDigits:true
            },
            goodsname:{
                required:true,
                isChineseChar:true
            },
            usefullife:{
                required:true,
                minlength:1,
                maxlength:4,
                isDigits:true
            },
            price:{
                required:true,
                minlength:1,
                maxlength:7,
                isNumber:true
            },
            count:{
                required:true,
                minlength:1,
                maxlength:5,
                isDigits:true
            },
            goodsclass:{
                required:true,
                isChineseChar:true
            },
            dateproduced:{
                required:true,
                isDate:true
            }
        },
        messages:{
            _id:{
                required:"请输入货物编号",
                minlength:"至少由6位数字组成",
                maxlength:"最多由20位数字组成",
                isDigits:"只能输入0-9数字"
            },
            position:{
                required:"请输入货物位置",
                minlength:"至少由1位数字组成",
                maxlength:"最多由4位数字组成",
                isDigits:"只能输入0-9数字"
            },
            goodsname:{
                required:"请输入货物名称",
                isChineseChar:"只能输入汉字或字符"
            },
            usefullife:{
                required:"请输入有效日期",
                minlength:"至少由1位数字组成",
                maxlength:"最多由4位数字组成",
                isDigits:"只能输入0-9数字"
            },
            price:{
                required:"请输入合法价格",
                minlength:"至少由1位数字组成",
                maxlength:"最多由7位数字组成",
                isNumber:"只能输入整数或浮点数"
            },
            count:{
                required:"请输入有效数量",
                minlength:"至少由1位数字组成",
                maxlength:"最多由5位数字组成",
                isDigits:"只能输入0-9数字"
            },
            goodsclass:{
                required:"请输入货物类别名称",
                isChineseChar:"只能输入汉字或字符"
            },
            dateproduced:{
                required:"请输入合法日期",
                isDate:"日期格式XXXX-XX-XX"
            }
        }
    });
});






/*校验取货信息*/

$().ready(function () {

    $.validator.addMethod("isDigits", function(value, element) {                                         /*校验货物编号*/
        return this.optional(element) || /^\d+$/.test(value);
    }, "只能输入0-9数字");

    $("#takeForm").validate({
        rules:{
            _id:{
                required:true,
                minlength:6,
                maxlength:20,
                isDigits:true
            },
            position:{
                required:true,
                minlength:1,
                maxlength:4,
                isDigits:true
            },
            count:{
                required:true,
                minlength:1,
                maxlength:5,
                isDigits:true
            },
        },
        messages:{
            _id:{
                required:"请输入货物编号",
                minlength:"至少由6位数字组成",
                maxlength:"最多由20位数字组成",
                isDigits:"只能输入0-9数字"
            },
            position:{
                required:"请输入货物位置",
                minlength:"至少由1位数字组成",
                maxlength:"最多由4位数字组成",
                isDigits:"只能输入0-9数字"
            },
            count:{
                required:"请输入有效数量",
                minlength:"至少由1位数字组成",
                maxlength:"最多由5位数字组成",
                isDigits:"只能输入0-9数字"
            },
        }
    });
});




/*校验员工信息*/

$().ready(function () {

    $.validator.addMethod("isDigits", function(value, element) {                                         /*校验员工编号*/
        return this.optional(element) || /^\d+$/.test(value);
    }, "只能输入0-9数字");

    $.validator.addMethod("isChineseChar", function(value, element) {
        return this.optional(element) || /^[\u0391-\uFFE5]+$/.test(value);
    }, "匹配中文(包括汉字和字符) ");

    $.validator.addMethod("stringCheck", function(value, element) {                                         /*校验密码*/
        return this.optional(element) || /^.*[A-Za-z0-9\\w_-]+.*$/.test(value);
    }, "只能包含英文、数字、下划线等字符");

    $.validator.addMethod("isDate", function(value, element) {
        return this.optional(element) || /^(\d{1,4})(-|\/)(\d{1,2})(-|\/)(\d{1,2})$/.test(value);
    }, "只能输入XXXX-XX-XX格式日期");


    $("#manageForm").validate({
        rules:{
            _id:{
                required:true,
                minlength:6,
                maxlength:8,
                isDigits:true
            },
            staffname:{
                required:true,
                isChineseChar:true
            },
            password:{
                required:true,
                minlength:6,
                maxlength:8,
                stringCheck:true
            },
            birthday:{
                required:true,
                isDate:true
            }
        },
        messages:{
            _id:{
                required:"请输入员工编号",
                minlength:"至少由6位数字组成",
                maxlength:"最多由8位数字组成",
                isDigits:"只能输入0-9数字"
            },
            staffname:{
                required:"请输入员工姓名",
                isChineseChar:"只能输入汉字或字符"
            },
            workCompany:{
                required:"请输入您的密码",
                minlength:"至少由6位组成",
                maxlength:"最多由8位组成",
                stringCheck:"只能包含字符,数字,下划线"
            },
            birthday:{
                required:"请输入合法日期",
                isDate:"正确日期格式 XXXX-XX-XX"
            }
        }
    });
});

