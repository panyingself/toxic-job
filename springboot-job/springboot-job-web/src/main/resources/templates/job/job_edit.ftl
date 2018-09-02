
<div>

    <form class="layui-form" action="${request.contextPath}/job/edit" id="job_edit_form">

        <div class="layui-form-item" style="display: none">
            <label class="layui-form-label">id</label>
            <div class="layui-input-block">
                <input type="text" name="id" required  lay-verify="required" placeholder="请输入任务名称" autocomplete="off" class="layui-input" value="${job.id}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">任务名称</label>
            <div class="layui-input-block">
                <input type="text" name="jobName" required  lay-verify="required" placeholder="请输入任务名称" autocomplete="off" class="layui-input" value="${job.jobName}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">任务分组</label>
            <div class="layui-input-inline">
                <input  name="jobGroup" required lay-verify="required" placeholder="请输入任务分组" autocomplete="off" class="layui-input" value="${job.jobGroup}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <input type="text" name="remarks" required  lay-verify="required" placeholder="请输入描述" autocomplete="off" class="layui-input" value="${job.remarks}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">任务状态</label>
            <div class="layui-input-inline">
                <input name="status" required lay-verify="required" placeholder="请输入任务状态" autocomplete="off" class="layui-input" value="${job.status}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">执行bean</label>
            <div class="layui-input-block">
                <input type="text" name="beanName" required  lay-verify="required" placeholder="请输入执行bean" autocomplete="off" class="layui-input" value="${job.beanName}">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">执行方法</label>
            <div class="layui-input-inline">
                <input  name="methodName" required lay-verify="required" placeholder="请输入执行方法" autocomplete="off" class="layui-input" value="${job.methodName}">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">cron表达式</label>
            <div class="layui-input-block">
                <input type="text" name="cron" required  lay-verify="required" placeholder="请输入cron表达式" autocomplete="off" class="layui-input" value="${job.cron}">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn"  onclick="toJobEdit('${request.contextPath}/job/queryList')">立即提交</a>
                <button type="reset" class="layui-btn layui-btn-primary" onclick="jobEditReset()">重置</button>
            </div>
        </div>

    </form>

    <#--<a onclick="toJobEdit('${request.contextPath}/job/queryList')">test-->
    <#--</a>-->
</div>
<script src="${request.contextPath}/js/job/job_edit.js"></script>
<script>
    //Demo
    // layui.use('form', function(){
    //     var form = layui.form;

        //监听提交
        // form.on('submit(formDemo)', function(data){
        //     layer.msg(JSON.stringify(data.field));
        //     return false;
        // });
    // });
</script>