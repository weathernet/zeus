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
        elem: '#LAY-line-line'
        , url: '/queryAllSysCreditLine'
        , cols: [[
            {field: 'creditLineUserId', width: 180, title: '用户ID'}
            , {field: 'creditLineMoney', width: 180, sort: true, title: '授信金额'}
            , {field: 'creditLineRemoney', width: 180, sort: true, title: '已使用金额'}
            , {field: 'creditLineState', width: 180, title: '授信状态', templet: '#Status', sort: true}
            , {
                field: 'createTime',
                title: '创建日期',
                sort: true,
                templet: '<div>{{ layui.laytpl.toDateString(d.createTime) }}</div>'
            }
            , {
                field: 'updateTime',
                title: '修改日期',
                sort: true,
                templet: '<div>{{ layui.laytpl.toDateString(d.updateTime) }}</div>'
            }
            , {title: '操作', width: 160, align: 'center', fixed: 'right', toolbar: '#table-line-line'}
        ]]
        , page: true
        , limit: 20
        , limits: [20, 25, 30, 35, 40]
        , text: '对不起，加载出现异常！'
    });
    //监听工具条
    table.on('tool(LAY-line-line)', function (obj) {//表格的名称
        var data = obj.data;
        if (obj.event === 'edit') {//form表单上的图标
            admin.popup({
                title: '修改用户信息'
                , area: ['550px', '550px']
                , id: 'LAY-popup-line-edit'
                , success: function (layero, index) {
                    view(this.id).render('line/line-form', data).done(function () {//跳转的路径
                        form.render(null, 'LAY-line-line');//读取表格的信息
                        //监听提交
                        form.on('submit(line-form-submit)', function (data) {//form 表单提交的按钮
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/updateSysCreditLine", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function () {
                                    layui.table.reload('LAY-line-line'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        } else if (obj.event === 'del') {
            layer.confirm('确定删除此技能？', function (index) {
                var lineId = data.lineId;
                $.post("/deleteWkline", {lineId: lineId}, function (data) {
                    obj.del();
                    layer.close(index);
                })
            });
        }
    });
    //对外暴露的接口
    exports('line', {});
});