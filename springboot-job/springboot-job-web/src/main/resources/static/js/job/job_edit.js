
function toJobEdit(url){
    //执行job-form表达提交
    alert("!");
    $.ajax({
        url:$("#job_edit_form").attr("action"),
        type:"POST",
        data:$("#job_edit_form").serialize(),
        success:function (result) {
            alert(result);
            console.log(url)
        }
    })
    // $("#api-main").load(url);
}