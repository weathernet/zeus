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

    //所有的问题
    table.render({
        elem: '#LAY-push-push'
        , url: '/queryAllWkPush'
        , cols: [[
            {field: 'pushTitle',title: '标题'}
            , {field: 'pushUrl',title: '推送地址'}
            , {field: 'pushContext',title: '推送内容'}
            , {title: '操作', width: 240, align: 'center', fixed: 'right', toolbar: '#table-push-push'}
        ]]
        , page: true
        , limit: 20
        , limits: [20, 25, 30, 35, 40]
        , text: '对不起，加载出现异常！'
    });
    //监听工具条
    table.on('tool(LAY-push-push)', function (obj) {//表格的名称
        var data = obj.data;
        if (obj.event === 'edit') {//form表单上的图标
            admin.popup({
                title: '修改用户信息'
                , area: ['550px', '550px']
                , id: 'LAY-popup-push-edit'
                , success: function (layero, index) {
                    view(this.id).render('push/push-form', data).done(function () {//跳转的路径
                        form.render(null, 'LAY-push-push');//读取表格的信息
                        //监听提交
                        form.on('submit(push-form-submit)', function (data) {//form 表单提交的按钮
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/updateWkPush", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function () {
                                    layui.table.reload('LAY-push-push'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        } else if (obj.event === 'del') {
            layer.confirm('确定删除此技能？', function (index) {
                var pushId = data.pushId;
                $.post("/deleteWkpush", {pushId: pushId}, function () {
                    obj.del();
                    layer.close(index);
                })
            });
        }else if (obj.event === 'push') {
            layer.confirm('确定推送此信息？', function (index) {
                var pushId = data.pushId;
                $.post("/deleteWkpush", {pushId: pushId}, function () {
                    obj.del();
                    layer.close(index);
                })
            });
        }
    });
    //对外暴露的接口
    exports('push', {});
});