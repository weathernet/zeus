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
        elem: '#LAY-remark-remark'
        , url: '/queryAllWkRemark'
        , cols: [[
            {field: 'remarkHotelId', width: 100, title: '酒店的ID'}
            , {field: 'wkUser', width: 100, title: '真实姓名', templet: '<div>{{d.wkUser.userRealname}}</div>'}
            , {field: 'remarkHotelId', width: 100, title: '酒店的ID'}
            , {field: 'remarkMarkuserId', width: 100, title: '评论的用户'}
            , {field: 'remarkSatisfy', width: 100, title: '满意评论'}
            , {field: 'remarkNotSatisfy', width: 100, title: '不满意评论'}
            , {field: 'remarkPoint', width: 100, title: '评论分数'}
            , {field: 'remarkImgPic0', width: 100, title: '评价图片1',templet:'#Img0'}
            , {field: 'remarkImgPic1', width: 100, title: '评价图片2',templet:'#Img1'}
            , {field: 'remarkImgPic2', width: 100, title: '评价图片3',templet:'#Img2'}
            , {field: 'remarkImgPic3', width: 100, title: '评价图片4',templet:'#Img3'}
            , {field: 'remarkImgPic4', width: 100, title: '评价图片5',templet:'#Img4'}
            , {field: 'remarkImgPic5', width: 100, title: '评价图片6',templet:'#Img5'}
            , {field: 'remarkVideoPic', width: 100, title: '评论视频',templet:'#Video'}
            , {field: 'createTime', title: '评论时间', templet: '<div>{{ layui.laytpl.toDateString(d.createTime) }}</div>'}
            , {title: '操作', width: 80, align: 'center', fixed: 'right', toolbar: '#table-remark-remark'}
        ]]
        , page: true
        , limit: 20
        , limits: [20, 25, 30, 35, 40]
        , text: '对不起，加载出现异常！'
    });
    //监听工具条
    table.on('tool(LAY-remark-remark)', function (obj) {//表格的名称
        var data = obj.data;
        if (obj.event === 'edit') {//form表单上的图标
            admin.popup({
                title: '修改用户信息'
                , area: ['550px', '550px']
                , id: 'LAY-popup-remark-edit'
                , success: function (layero, index) {
                    view(this.id).render('remark/remark-form', data).done(function () {//跳转的路径
                        form.render(null, 'LAY-remark-remark');//读取表格的信息
                        //监听提交
                        form.on('submit(remark-form-submit)', function (data) {//form 表单提交的按钮
                            var field = data.field; //获取提交的字段
                            console.log(field)
                            $.ajax({
                                type: "POST", //请求方式 post
                                dataType: 'json', //数据类型 json
                                contentType: "application/json; charset=utf-8",
                                url: "/updateWkremark", // 请求地址
                                data: JSON.stringify(field), //请求附带参数
                                success: function () {
                                    layui.table.reload('LAY-remark-remark'); //重载表格
                                    layer.close(index); //执行关闭
                                }
                            });
                        });
                    });
                }
            });
        } else if (obj.event === 'del') {
            layer.confirm('确定删除此技能？', function (index) {
                var remarkId = data.remarkId;
                $.post("/deleteWkRemark", {remarkId: remarkId}, function (data) {
                    obj.del();
                    layer.close(index);
                })
            });
        }
    });
    //对外暴露的接口
    exports('remark', {});
});