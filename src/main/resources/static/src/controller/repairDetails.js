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
        elem: '#LAY-repairDetails-list'
        , url: '/repair/details/query'
        ,toolbar: true
        , cols: [[
            {field: 'detailsTitle', title: '详情标题'}
            , {field: 'detailsImage', title: '详情图片', templet: "#Img"}
            , {field: 'detailsService', title: '服务详情'}
            , {field: 'detailsPrice', title: '服务价格'}
            , {field: 'createTime', title: '创建日期', templet: '<div>{{ layui.laytpl.toDateString(d.createTime) }}</div>'}
            , {field: 'updateTime', title: '修改日期', templet: '<div>{{ layui.laytpl.toDateString(d.updateTime) }}</div>'}
            , {title: '操作', width: 240, align: 'center', fixed: 'right', toolbar: '#table-repairDetails-toolbar'}//设置表格工具条的名称
        ]]
        , page: true//开启分页
        , limit: 20
        , limits: [20, 25, 30, 35, 40]
        , text: '对不起，加载出现异常！'
    });
    //**********表格显示开始***********

    //++++++++++监听工具条操作开始++++++++++
    table.on('tool(LAY-repairDetails-list)', function (obj) {//表格的名称
        var data = obj.data;
        if (obj.event === 'edit') {//匹配工具栏的edit字段
            admin.popup({
                title: '修改词条信息'
                , area: ['550px', '550px']
                , success: function (layero, index) {
                    view(this.id).render('repairDetails/form', data).done(function () {//跳转的路径
                        detailsRepairMenuId = data.repairMenuId;
                        form.render(null, 'repairDetails-form');//读取表单的信息
                        //+++++++++++++二级下拉框初始化开始++++++++++
                        $('#repairSubmenuId').html('')//清空下拉框防止option标签重叠
                        $.get("/repairParentMenu/" + detailsRepairMenuId, {},
                            function (data) {
                                var $html = "";
                                if (data != null) {
                                    $.each(data,
                                        function (index, item) {
                                            $html += "<option value='" + item.repairSubId + "'>" + item.repairSubName + "</option>";
                                        });
                                    $("select[name='repairSubmenuId']").append($html);
                                    form.render('select');
                                }
                            });
                        //+++++++++++++二级下拉框初始化结束++++++++++
                        //监听提交
                        form.on('submit(repairDetails-form-submit)', function (data) {//form 表单提交的按钮
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/repair/details/update", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function () {
                                    layui.table.reload('LAY-repairDetails-list'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        } else if (obj.event === 'del') {//匹配工具栏的del字段
            layer.confirm('确定删除词条信息？', function (index) {
                var id = data.detailsId;//根据数据库的字段更改data.id中id的命名
                $.post("/repair/details/delete", {id: id}, function (data) {
                    obj.del();
                    layer.close(index);
                })
            });
        } else if (obj.event === 'more') {
            var id = data.repairSubmenuId;
            admin.popup({
                title: '查看图片'
                , area: ['1200px', '600px']
                , resize: false
                , success: function (layero, index) {
                    var html = "";
                    html += '<div class="layui-fluid">'
                    html += '<div class="layui-card">'
                    html += '<div class="layui-card-body">	'
                    html += '<table id="LAY-repairCostById-list" lay-filter="LAY-repairCostById-list"></table>'
                    html += '</div>'
                    html += '</div>'
                    html += '</div>'
                    $("#LAY-system-view-popup").html(html);
                    table.render({
                        elem: '#LAY-repairCostById-list'
                        , url: '/repair/cost/queryById/' + id
                        , cols: [[
                            {field: 'costTitle', title: '标题'}
                            , {field: 'costSubTitle', title: '副标题'}
                            , {field: 'costPrice', title: '价格'}
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
    //++++++++++监听工具条操作开始++++++++++

    //**********新增开始**********
    var active = {
        add: function () {
            admin.popup({
                title: '添加词条'
                , area: ['550px', '550px']//设置弹出框大小
                , success: function (layero, index) {
                    view(this.id).render('repairDetails/form').done(function () {
                        //监听提交
                        form.on('submit(repairDetails-form-submit)', function (data) {
                            var field = data.field; //获取提交的字段
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/repair/details/add", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function (data) {
                                    layui.table.reload('LAY-repairDetails-list'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        }
    }
    $('.layui-btn.repairDetails-form').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    //**********新增结束**********

    //==========搜索开始==========
    form.render(null, 'lay-admin-repairDetails-form');
    form.on('submit(LAY-repairDetails-back-search)',
        function (data) {
            var field = data.field;
            console.log(field)
            //执行重载
            table.reload('LAY-repairDetails-list', {
                method: "post",
                url: "/repair/details/search",
                where: field
            });
        });
    //==========搜索结束==========

    //对外暴露的接口
    exports('repairDetails', {});
});