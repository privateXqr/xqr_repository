$(function () {

    //异步加载通讯录
    $.post("/mail/queryAddressList", function (data) {
        initUserTable(data["listAoaUser"]);

        $("#pageNum").html(data["firstResult"]);
        $("#count").html(data["count"]);
        $("#total").html(data["total"]);
        $("#maxResult").html(data["maxResult"]);
    });

    //首页
    $(".tablefirst").click(function () {

        $.post("/mail/queryAddressList", {"firstResult": 1}, function (data) {

            initUserTable(data["listAoaUser"]);

            $("#pageNum").html(data["firstResult"]);
            $("#count").html(data["count"]);
            $("#total").html(data["total"]);
            $("#maxResult").html(data["maxResult"]);

        });
    });

    //上一页
    $(".tableup").click(function () {

        var firstResult = $("#pageNum").html();

        firstResult = parseInt(firstResult);

        firstResult = firstResult - 1 < 1 ? 1 : firstResult - 1;

        $.post("/mail/queryAddressList", {"firstResult": firstResult}, function (data) {

            initUserTable(data["listAoaUser"]);

            $("#pageNum").html(data["firstResult"]);
            $("#count").html(data["count"]);
            $("#total").html(data["total"]);
            $("#maxResult").html(data["maxResult"]);

        });
    });

    //下一页
    $(".tabledown").click(function () {

        var firstResult = $("#pageNum").html();
        var total = $("#total").html();

        firstResult = parseInt(firstResult);

        firstResult = firstResult + 1 > total ? total : firstResult + 1;

        $.post("/mail/queryAddressList", {"firstResult": firstResult}, function (data) {

            initUserTable(data["listAoaUser"]);

            $("#pageNum").html(data["firstResult"]);
            $("#count").html(data["count"]);
            $("#total").html(data["total"]);
            $("#maxResult").html(data["maxResult"]);

        });
    });

    //末页
    $(".tablelast").click(function () {

        var total = $("#total").html();

        $.post("/mail/queryAddressList", {"firstResult": total}, function (data) {

            initUserTable(data["listAoaUser"]);

            $("#pageNum").html(data["firstResult"]);
            $("#count").html(data["count"]);
            $("#total").html(data["total"]);
            $("#maxResult").html(data["maxResult"]);

        });
    });
});

function initUserTable(listAoaUser) {

    var tableHtmlStr = "";
    //遍历集合
    $(listAoaUser).each(function (index, user) {

        tableHtmlStr += "<tr class='row' >\n" +
            "                <td class='col-xs-1'>\n" +
            "                <span class='labels'><label><input name='id'\n" +
            "            type='checkbox'><i>✓</i></label></span>\n" +
            "            </td>\n" +
            "            <td class=' col-xs-1'>\n" +
            "                <span class='imgs center-block'>\n" +
            "                <img style='width: 30px;height: 30px;'\n" +
            "        class='profile-user-img img-responsive img-circle'\n" +
            "            src='/images/647cbde6-3fba-4d8c-a50f-1a07f9bee417.jpg'>\n" +
            "                </span>\n" +
            "                </td>\n" +
            "                <td class='col-xs-2' >" + user.aoaDept.deptName + "</td>\n" +
            "                <td class=' col-xs-2' >" + user.realName + "</td>\n" +
            "                <td class='col-xs-2 na' >" + user.userName + "</td>\n" +
            "                <td class=' col-xs-2' >" + user.aoaPosition.name + "</td>\n" +
            "                <td class=' col-xs-2' >" + user.userTel + "</td>\n" +
            "\n" +
            "                </tr>";
    });
    $("tbody").html(tableHtmlStr);
}