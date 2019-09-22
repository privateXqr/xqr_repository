$(function () {

    //返回主页
    $(".goIndex").click(function () {

        window.parent.location.href = "/sys/initMenu";

    });
    
});

//跳转到指定页面
function changePath(url){

    location.href = url;

}