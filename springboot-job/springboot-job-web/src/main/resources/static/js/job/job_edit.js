
function toJobEdit(url){
    //执行job-form表达提交
    $.ajax({
        url:$("#job_edit_form").attr("action"),
        type:"POST",
        data:$("#job_edit_form").serialize(),
        success:function (result) {
            $("#api-main").load(url);
        }
    })

}

function jobEditReset() {
    $("#job_edit_form").reset();
}