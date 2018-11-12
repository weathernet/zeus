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
        elem: '#LAY-userOrder-list'
        , url: '/user/order/query'
        , cols: [[
            {field: 'orderId', title: '订单号'}
            , {field: 'orderUserId', title: '用户Id'}
            , {field: 'orderType', title: '类型'}
            , {field: 'orderGoodsId', title: '商品编号'}
            , {field: 'orderGoodsTitle', title: '商品标题'}
            , {field: 'orderGoodsImage', title: '商品照片'}
            , {field: 'orderGoodsPrice', title: '商品价格'}
            , {field: 'orderGoodsStatus', title: '订单状态'}
            , {field: 'orderUserPhone', title: '收货人手机号'}
            , {field: 'orderUserAddress', title: '收货人地址'}
            , {field: 'orderCourierCompany', title: '快递公司'}
            , {field: 'orderCourierNumber', title: '快递单号'}
            , {field: 'orderHousingId', title: '房源Id'}
            , {field: 'orderHousingTitle', title: '房源标题'}
            , {field: 'orderHousingImage', title: '房源图片'}
            , {field: 'orderHousingStartTime', title: '房屋合约开始时间'}
            , {field: 'orderHousingEndTime', title: '租房合约的结束时间'}
            , {field: 'orderHousingPrice', title: '租金'}
            , {
                field: 'createTime',
                title: '订单生成时间',
                templet: '<div>{{ layui.laytpl.toDateString(d.createTime) }}</div>'
            }
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#table-userOrder-toolbar'}//设置表格工具条的名称
        ]]
        , page: true//开启分页
        , limit: 20
        , limits: [20, 25, 30, 35, 40]
        , text: '对不起，加载出现异常！'
    });
    //**********表格显示开始***********

    //++++++++++监听工具条操作开始++++++++++
    table.on('tool(LAY-userOrder-list)', function (obj) {//表格的名称
        var data = obj.data;
        if (obj.event === 'edit') {//匹配工具栏的edit字段
            admin.popup({
                title: '修改词条信息'
                , area: ['550px', '550px']
                , success: function (layero, index) {
                    view(this.id).render('userOrder/form', data).done(function () {//跳转的路径
                        form.render(null, 'LAY-userOrder-list');//读取表格的信息
                        //监听提交
                        form.on('submit(userOrder-form-submit)', function (data) {//form 表单提交的按钮
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/user/order/update", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function () {
                                    layui.table.reload('LAY-userOrder-list'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        } else if (obj.event === 'del') {//匹配工具栏的del字段
            layer.confirm('确定删除词条信息？', function (index) {
                var id = data.id;//根据数据库的字段更改data.id中id的命名
                $.post("/user/order/delete", {id: id}, function (data) {
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
                    view(this.id).render('userOrder/form').done(function () {
                        //监听提交
                        form.on('submit(userOrder-form-submit)', function (data) {
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/user/order/add", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function (data) {
                                    layui.table.reload('LAY-userOrder-list'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        }
    }
    $('.layui-btn.userOrder-form').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    //**********新增结束**********

    //==========搜索开始==========
    form.render(null, 'lay-admin-userOrder-form');
    form.on('submit(LAY-userOrder-back-search)',
        function (data) {
            var field = data.field;
            console.log(field)
            //执行重载
            table.reload('LAY-userOrder-list', {
                method: "post",
                url: "/user/order/search",
                where: field
            });
        });
    //==========搜索结束==========

    //对外暴露的接口
    exports('userOrder', {});
});