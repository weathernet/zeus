<div class="layui-form" lay-filter="${modelNameLowerCamel}-form" id="${modelNameLowerCamel}-form" style="padding: 20px 30px 0 0;">
      <#list modeListDetails as iteam>
          <#if iteam.type !="datetime">
              <#if iteam_index != 0>
                  <#if iteam.name?contains("image")>
     <div class="layui-form-item">
         <label class="layui-form-label">图片</label>
         <div class="layui-input-inline">
             <script type="text/html" template>
                 <input type="text" name="${iteam.name}" value="{{ d.params.${iteam.name}|| '' }}" lay-verify="required"
                        placeholder="请上传图片" autocomplete="off" class="layui-input" id="img_url" disabled="true ">
             </script>
         </div>
         <button style="float: left;" type="button" class="layui-btn" id="${modelNameLowerCamel}-upload-${modelNameLowerCamel}">上传图片</button>
     </div>
                <#else>
    <div class="layui-form-item">
        <label class="layui-form-label">${iteam.remark}</label>
        <div class="layui-input-inline">
            <script type="text/html" template>
                <input type="text" name="${iteam.name}" value="{{ d.params.${iteam.name} || '' }}" lay-verify="required" placeholder="请输入${iteam.remark}" autocomplete="off" class="layui-input">
            </script>
        </div>
    </div>
                  </#if>
              </#if>
          </#if>
      </#list>
    <script type="text/html" template>
        <input type="hidden" name="${modeListDetails[0].name}" value="{{ d.params.${modeListDetails[0].name}|| '' }}">
    </script>
    <div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <input type="button" lay-submit lay-filter="${modelNameLowerCamel}-form-submit" value="确认" class="layui-btn">
        </div>
    </div>
</div>
<script>
    layui.use([ 'admin', 'form', 'upload' ], function() {
        var $ = layui.$, form = layui.form, upload = layui.upload;

        form.render();//使select可以显示option
        //-------------文件上传开始----------
        upload.render({
            elem : '#${modelNameLowerCamel}-upload-${modelNameLowerCamel}',
            url : '${baseRequestMapping}/upload',
            done : function(res) {
                //如果上传失败
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
                //上传成功
                console.log(res.data.src);
                document.getElementById("img_url").value = res.data.src;//
            }
        });
        //-------------文件上传结束----------
    })
</script>
