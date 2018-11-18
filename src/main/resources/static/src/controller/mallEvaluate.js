layui.define(['table', 'form'], function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin
        , table = layui.table
        , form = layui.form;
    //----------时间戳的处理开始----------
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
    //----------时间戳的处理结束----------

    //**********表格显示开始**********
    table.render({
        elem: '#LAY-mallEvaluate-list'
        , url: '/mall/evaluate/query'
        ,toolbar: true
        , cols: [[
             {field: 'evaluateId',  title: '编号'}
            , {field: 'evaluateTraderId', title: ' 商户主键',edit: 'text', sort: true}
            , {field: 'evaluateGoodsId', title: ' 商品的主键',edit: 'text', sort: true}
            , {field: 'evaluateUserId', title: ' 用户ID',edit: 'text', sort: true}
            , {field: 'evaluateUserNickName', title: ' 用户昵称',edit: 'text', sort: true}
            , {field: 'evaluateImage', title: ' 照片',edit: 'text', sort: true}
            , {field: 'evaluateContent', title: ' ',edit: 'text', sort: true}
            , {field: 'createTime', title: '创建日期',templet: '<div>{{ layui.laytpl.toDateString(d.createTime) }}</div>'}
            , {field: 'updateTime', title: '修改日期',templet: '<div>{{ layui.laytpl.toDateString(d.updateTime) }}</div>'}
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#table-mallEvaluate-toolbar'}//设置表格工具条的名称
        ]]
        , page: true//开启分页
        , limit: 20
        , limits: [20, 25, 30, 35, 40]
        , text: '对不起，加载出现异常！'
    });
    //**********表格显示开始***********

     //<<<<<<<<<<<<<<<监听单元格编辑开始<<<<<<<<<<<<<<<
    table.on('edit(LAY-mallEvaluate-list)', function(obj){
        var data = obj.value //得到所在行所有键值
            $.ajax({
                type: "POST", //请求方式 post
                dataType: 'json', //数据类型 json
                contentType: "application/json; charset=utf-8",
                url: "/mall/evaluate/update", // 请求地址
                data: JSON.stringify(data), //请求附带参数
                success: function () {
                    layui.table.reload('LAY-userInfo-list'); //重载表格
                }
            });
    });
    //<<<<<<<<<<<<<<<监听单元格编辑结束<<<<<<<<<<<<<<<

    //++++++++++监听工具条操作开始++++++++++
    table.on('tool(LAY-mallEvaluate-list)', function (obj) {//表格的名称
        var data = obj.data;
        if (obj.event === 'edit') {//匹配工具栏的edit字段
            admin.popup({
                title: '修改词条信息'
                , area: ['550px', '550px']
                , success: function (layero, index) {
                    view(this.id).render('mallEvaluate/form', data).done(function () {//跳转的路径
                        form.render(null, 'mallEvaluate-form');//读取表单的信息
                        //监听提交
                        form.on('submit(mallEvaluate-form-submit)', function (data) {//form 表单提交的按钮
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/mall/evaluate/update", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function () {
                                    layui.table.reload('LAY-mallEvaluate-list'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        } else if (obj.event === 'del') {//匹配工具栏的del字段
            layer.confirm('确定删除词条信息？', function (index) {
                var id = data.evaluateId;//根据数据库的字段更改data.id中id的命名
                $.post("/mall/evaluate/delete", {id: id}, function (data) {
                    obj.del();
                    layer.close(index);
                })
            });
        }
    });
    //++++++++++监听工具条操作开始++++++++++

    //**********新增开始**********
    var active = {
        add: function () {
            admin.popup({
                title: '添加词条'
                , area: ['550px', '550px']//设置弹出框大小
                , success: function (layero, index) {
                    view(this.id).render('mallEvaluate/form').done(function () {
                        //监听提交
                        form.on('submit(mallEvaluate-form-submit)', function (data) {
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/mall/evaluate/add", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function (data) {
                                    layui.table.reload('LAY-mallEvaluate-list'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        }
    }
    $('.layui-btn.mallEvaluate-form').on('click', function() {var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    //**********新增结束**********

    //==========搜索开始==========
    form.render(null, 'lay-admin-mallEvaluate-form');
    form.on('submit(LAY-mallEvaluate-back-search)',
        function(data) {
            var field = data.field;
            console.log(field)
            //执行重载
            table.reload('LAY-mallEvaluate-list', {
                method: "post",
                url: "/mall/evaluate/search",
                where: field
            });
        });
    //==========搜索结束==========

    //对外暴露的接口
    exports('mallEvaluate', {});
});