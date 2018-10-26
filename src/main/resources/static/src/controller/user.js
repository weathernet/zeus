/**

 @Name：layuiAdmin 用户登入和注册等
 @Author：贤心
 @Site：http://www.layui.com/admin/
 @License: LPPL

 */

layui.define(['table', 'form'], function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin
        , table = layui.table			//表格
        , form = layui.form;

    //时间戳的处理
    layui.laytpl.toDateString = function (d, format) {
        var date = new Date(d || new Date())
            , ymd = [
            this.digit(date.getFullYear(), 4)
            , this.digit(date.getMonth() + 1)
            , this.digit(date.getDate())
        ]
            , hms = [
            this.digit(date.getHours())
            , this.digit(date.getMinutes())
            , this.digit(date.getSeconds())
        ];
        format = format || 'yyyy-MM-dd ';
        return format.replace(/yyyy/g, ymd[0])
            .replace(/MM/g, ymd[1])
            .replace(/dd/g, ymd[2])
            .replace(/HH/g, hms[0])
            .replace(/mm/g, hms[1])
            .replace(/ss/g, hms[2]);
    };
//数字前置补零
    layui.laytpl.digit = function (num, length, end) {
        var str = '';
        num = String(num);
        length = length || 2;
        for (var i = num.length; i < length; i++) {
            str += '0';
        }
        return num < Math.pow(10, length) ? str + (num | 0) : num;
    };
    var $body = $('body');
    //自定义验证
    form.verify({
        nickname: function (value, item) { //value：表单的值、item：表单的DOM对象
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '用户名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '用户名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '用户名不能全为数字';
            }
        }
        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        , pass: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]
    });
    //更换图形验证码
    $body.on('click', '#LAY-user-get-vercode', function () {
        var othis = $(this);
        this.src = 'https://www.oschina.net/action/user/captcha?t=' + new Date().getTime()
    });


    //所有的问题
    table.render({
        elem: '#LAY-user-user'
        , url: '/queryAllWkUser'
        , cols: [[
            {field: 'userId', width: 100, title: '用户编号'}
            , {field: 'userPhone', width: 100, title: '手机号'}
            , {field: 'userNickname', title: '用户昵称'}
            , {field: 'userRealname', title: '真实姓名'}
            , {field: 'userBalance', title: '余额'}
            , {field: 'userHeadpic', title: '头像', templet: '#userHeadpic'}
            , {field: 'userSex', title: '性别', templet: '#userSex'}
            , {field: 'userType', title: '类型', templet: '#userType'}
            , {field: 'userState', title: '状态', templet: '#userState'}
            , {field: 'userAuditState', title: '实名认证', templet: '#UserAuditState'}
            , {field: 'createTime', title: '注册日期', templet: '<div>{{ layui.laytpl.toDateString(d.createTime) }}</div>'}
            , {title: '操作', width: 240, align: 'center', fixed: 'right', toolbar: '#table-user-user'}
        ]]
        , page: true
        , limit: 20
        , limits: [20, 25, 30, 35, 40]
        , text: '对不起，加载出现异常！'
    });
    //监听工具条
    table.on('tool(LAY-user-user)', function (obj) {//表格的名称
        var data = obj.data;
        if (obj.event === 'edit') {//form表单上的图标
            admin.popup({
                title: '修改用户信息'
                , area: ['550px', '550px']
                , id: 'LAY-popup-user-edit'
                , success: function (layero, index) {
                    view(this.id).render('user/user-form', data).done(function () {//跳转的路径
                        form.render(null, 'LAY-user-user');//读取表格的信息
                        //监听提交
                        form.on('submit(user-form-submit)', function (data) {//form 表单提交的按钮
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/updateWkUser", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function () {
                                    layui.table.reload('LAY-user-user'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        } else if (obj.event === 'unit') {
            admin.popup({
                title: '查看单位信息'
                , area: ['1600px', '600px']
                , resize: false
                , success: function (layero, index) {
                    var userId = obj.data.userId
                    console.log(userId)
                    var html = "";
                    html += '<div class="layui-fluid">'
                    html += '<div class="layui-card">'
                    html += '<div class="layui-card-body">	'
                    html += '<table id="LAY-unit-unit" lay-filter="LAY-unit-unit"></table>'
                    html += '<script type="text/html" id="Image">'
                    html += '<img style="display: inline-block; width: 50%; height: 100%;" src=/mall/{{ d.image }} onclick="previewImg(this)">'
                    html += '</script>'
                    html += '</div>'
                    html += '</div>'
                    html += '</div>'
                    $("#LAY-system-view-popup").html(html);
                    table.render({
                        elem: '#LAY-unit-unit'
                        , url: '/queryWkUser?userId=' + userId
                        , cols: [[
                            {field: 'userUnitName', title: '单位名称'}
                            , {field: 'userUnitHeadpic', title: '单位头像', templet: '#Details1'}
                            , {field: 'userUnitType', title: '用户单位类型'}
                            , {field: 'userUnitPic', title: '单位照片', templet: '#Details2'}
                            , {field: 'userUnitAddress', title: '单位地址'}
                            , {field: 'userBusinessLicense', title: '单位营业执照', templet: '#Details3'}
                            , {field: 'userJob', title: '职位'}
                            , {field: 'userWorkYear', title: '工作年限'}
                            , {field: 'userWorkExp', title: '工作经历'}
                            , {field: 'userWorkPic', title: '用户工作照片', templet: '#Details4'}
                            , {field: 'userPayAccount', title: '支付宝账号'}
                            , {field: 'userWeixinAccount', title: '微信支付账号'}
                        ]]
                        , page: true
                        , limit: 20
                        , limits: [20, 25, 30, 35, 40]
                        , text: '对不起，加载出现异常！'
                    });
                }

            });
        } else if (obj.event === 'real') {
            admin.popup({
                title: '查看单位信息'
                , area: ['1200px', '600px']
                , resize: false
                , success: function (layero, index) {
                    var userId = obj.data.userId
                    console.log(userId)
                    var html = "";
                    html += '<div class="layui-fluid">'
                    html += '<div class="layui-card">'
                    html += '<div class="layui-card-body">	'
                    html += '<table id="LAY-unit-unit" lay-filter="LAY-unit-unit"></table>'
                    html += '<script type="text/html" id="Image">'
                    html += '<img style="display: inline-block; width: 50%; height: 100%;" src=/mall/{{ d.image }} onclick="previewImg(this)">'
                    html += '</script>'
                    html += '</div>'
                    html += '</div>'
                    html += '</div>'
                    $("#LAY-system-view-popup").html(html);
                    table.render({
                        elem: '#LAY-unit-unit'
                        , url: '/queryWkUser?userId=' + userId
                        , cols: [[
                            {field: 'userCardid', title: '身份证正面照', templet: '#Identity1'}
                            , {field: 'userCardidback', title: '身份证背面照片', templet: '#Identity2'}
                            , {field: 'userCardidinfo', title: '本人手持身份证照片', templet: '#Identity3'}
                            , {field: 'userReferrerPhone', title: '推荐人手机号'}
                            , {field: 'userEgName', title: '紧急联系人姓名'}
                            , {field: 'userEgPhone', title: '紧急联系人手机号'}
                        ]]
                        , page: true
                        , limit: 20
                        , limits: [20, 25, 30, 35, 40]
                        , text: '对不起，加载出现异常！'
                    });
                }

            });
        }
    });
    //对外暴露的接口
    exports('user', {});
});