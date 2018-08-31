//JavaScript代码区域
layui.use(['element', 'layer','form','jquery'], function(){
    var element = layui.element
        ,layer = layui.layer;
    var form = layui.form;
    var $ = layui.jquery;
    var windowWidth    = $(document.body).outerWidth(true);
    var windowHeight   = $(window).height();
    var contentHeight = windowHeight-$('.layui-header').outerHeight(true);
    $("#api-main").height(contentHeight-$('.site-content-header').outerHeight(true));
    $(".site-tree").height(contentHeight);


    $(".layui-nav-tree").find("a").on("click",function(){
        var hs = $(this)
        if (hs) {
            //固定当前活动页
            $(".layui-nav-tree").find("a").removeClass("active");
            hs.addClass("active");
            $("#api-main").load("/job/queryList");
        }else{

        }
    })

    $("#taggle").on("click",function(){
        var dis = $(".site-tree").css('display');
        if (dis=="none") {
            var treeWidth = $('.site-tree').outerWidth(true)
            $(".site-content").width(windowWidth-treeWidth);
            $(".site-tree").show();
        }else{
            $(".site-tree").hide();
            $(".site-content").width(windowWidth);
        }
    })
    form.render();
});
