<#assign ctx = request.contextPath/>

<span class="layui-breadcrumb">
  <a href="">功能</a>
  <a><cite>任务列表</cite></a>
</span>

<br><br>

<div>
    <label>任务名</label><input>
    <label>任务分组</label><input>
    <label>执行状态</label><input>
    <button class="layui-btn" onclick="jobListQuery()">搜索</button>
    <button class="layui-btn" onclick="toJobView('${ctx}/job/add')" >新增</button>
</div>

<#--<form class="layui-form" action="">-->
    <#--<div class="layui-form-item">-->
        <#--<label class="layui-form-label">输入框</label>-->
        <#--<div class="layui-input-block">-->
            <#--<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">-->
        <#--</div>-->
        <#--<label class="layui-form-label">输入框</label>-->
        <#--<div class="layui-input-block">-->
            <#--<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">-->
        <#--</div>-->
        <#--<label class="layui-form-label">输入框</label>-->
        <#--<div class="layui-input-block">-->
            <#--<input type="text" name="title" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">-->
        <#--</div>-->
    <#--</div>-->
<#--</form>-->


<table class="layui-table">
    <colgroup>
        <col width="50">
        <col width="150">
        <col>
    </colgroup>
    <thead>

    <tr  style="text-align: center;">
        <th>序号</th>
        <th>操作</th>
        <th>任务名称</th>
        <th>任务分组</th>
        <th>表达式</th>
        <th>任务状态</th>
        <th>执行bean</th>
        <th>执行方法</th>
        <th>描述</th>
        <th>创建时间</th>
    </tr>
    </thead>
    <tbody>
        <#if (jobList)?? >
            <#list jobList as job >
            <tr>
                <td></td>
                <td>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="toJobView('${ctx}/job/edit?id=${job.id}')">编辑</a>
                    <a class="layui-btn layui-btn-sm layui-bg-green" onclick="deleteJob('${ctx}/job/delete?id=${job.id}','${ctx}/job/queryList')">删除</a>
                </td>
                <td><#if (job.jobName)??>${job.jobName}</#if></td>
                <td><a href="#"><#if (job.jobGroup)??>${job.jobGroup}</#if></a></td>
                <td><#if (job.cron)??>${job.cron}</#if></td>
                <td><#if (job.status)??>${job.status}</#if></td>
                <td><#if (job.beanName)??>${job.beanName}</#if></td>
                <td><#if (job.methodName)??>${job.methodName}</#if></td>
                <td><#if (job.remarks)??>${job.remarks}</#if></td>
                <#--<td>${(job.createDateTime?string("yyyy-MM-dd HH:mm:ss"))!}</td>-->
                <td><#if (job.createDateTime)??>${(job.createDateTime?string("yyyy-MM-dd HH:mm:ss"))}</#if></td>

            </tr>
            </#list>
        </#if>
    </tbody>
</table>
<script src="${request.contextPath}/js/job/job_list.js"></script>
