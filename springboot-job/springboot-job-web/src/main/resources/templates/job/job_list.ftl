<#assign ctx = request.contextPath/>
<table class="layui-table">
    <colgroup>
        <col width="50">
        <col width="100">
        <col>
    </colgroup>
    <thead>
    <tr>
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
                <td><a class="layui-btn layui-bg-green" onclick="toJobEdit('${ctx}/job/edit')">编辑</a></td>
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
