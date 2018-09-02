function toJobView(url){
    $("#api-main").load(url);
}

function jobListQuery() {
    alert("jobListQuery start");
}

function deleteJob(url,returnUrl) {
    $.ajax({
        url:url,
        type:"POST",
        success:function (result) {
            $("#api-main").load(returnUrl);
        }
    })
}

