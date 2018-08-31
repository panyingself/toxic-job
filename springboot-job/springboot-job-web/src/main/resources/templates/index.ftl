<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>定时管理平台</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${request.contextPath}/plugin/layui/css/layui.css"  media="all">
    <link rel="stylesheet" href="http://res.layui.com/layui/dist/css/modules/layer/default/layer.css?v=3.1.1">
    <link rel="stylesheet" href="//res.layui.com/layui/dist/css/layui.css?t=1535557734124" media="all">
    <#--<link rel="stylesheet" href="layui/css/modules/layer/default/layer.css">-->
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">定时任务管理平台</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">快捷定时</a></li>
            <li class="layui-nav-item"><a href="">代扣定时</a></li>
            <li class="layui-nav-item"><a href="">鉴权定时</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它产品</a>
                <dl class="layui-nav-child">
                    <dd><a href="">产品1</a></dd>
                    <dd><a href="">产品2</a></dd>
                    <dd><a href="">产品3</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                    py大神
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="">惊不惊喜</a></dd>
                    <dd><a href="">刺不刺激</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item"><a href="">退了</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">功能分组</a>
                    <dl class="layui-nav-child">
                        <dd><a href="javascript:;">任务列表</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;" id="api-main">
            <!--内容主体区域 body-->
            <#--<div class="layui-collapse" lay-accordion>-->
                <#--<div class="layui-colla-item">-->
                    <#--<h2 class="layui-colla-title">接口名称</h2>-->
                    <#--<div class="layui-colla-content layui-show">内容区域</div>-->
                <#--</div>-->
            <#--</div>-->
            <!--内容主体区域end-->
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © py.com - 底部固定区域
    </div>
</div>
<script src="http://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="${request.contextPath}/plugin/layui/layui.js"></script>
<script src="${request.contextPath}/js/index.js"></script>
</body>
</html>