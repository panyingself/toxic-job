
<div>

    <form class="layui-form" action="${request.contextPath}/job/add" id="job_add_form">

        <div class="layui-form-item">
            <label class="layui-form-label">任务名称</label>
            <div class="layui-input-block">
                <input type="text" name="jobName" required  lay-verify="required" placeholder="请输入任务名称" autocomplete="off" class="layui-input" >
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">任务分组</label>
            <div class="layui-input-inline">
                <input  name="jobGroup" required lay-verify="required" placeholder="请输入任务分组" autocomplete="off" class="layui-input" >
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
            <div class="layui-input-block">
                <input type="text" name="remarks" required  lay-verify="required" placeholder="请输入描述" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">任务状态</label>
            <div class="layui-input-inline">
                <input name="status" required lay-verify="required" placeholder="请输入任务状态" autocomplete="off" class="layui-input" >
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">执行bean</label>
            <div class="layui-input-block">
                <input type="text" name="beanName" required  lay-verify="required" placeholder="请输入执行bean" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">执行方法</label>
            <div class="layui-input-inline">
                <input  name="methodName" required lay-verify="required" placeholder="请输入执行方法" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">辅助文字</div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">cron表达式</label>
            <div class="layui-input-block">
                <input type="text" name="cron" required  lay-verify="required" placeholder="请输入cron表达式" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <a class="layui-btn"  onclick="toJobAdd('${request.contextPath}/job/queryList')">立即提交</a>
                <button type="reset" class="layui-btn layui-btn-primary" onclick="jobEditReset()">重置</button>
            </div>
        </div>

    </form>

</div>
<script src="${request.contextPath}/js/job/job_add.js"></script>
