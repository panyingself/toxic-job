
function toJobAdd(url){
    //执行job-form表达提交
    $.ajax({
        url:$("#job_add_form").attr("action"),
        type:"POST",
        data:$("#job_add_form").serialize(),
        success:function (result) {
            $("#api-main").load(url);
        }
    })

}

function jobEditReset() {
    $("#job_add_form").reset();
}