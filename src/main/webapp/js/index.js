$(".findall_btna").click(function () {
    $.ajax({
        url: "/ssm/account/findAlla",
        type: "post",
        contentType: "application/json",
        dataType: "json",
        data: "",
        success: function (data) {
            for (var item of data) {
                console.log(item.id + item.name + item.money);
            }
        },
        error: function (data) {
            alert("响应出错！" + data);
        }
    })
});

$(".submita").click(function () {
    if ($(".namea").val() != null && $(".namea").val() != "") {
        $.ajax({
            url: "/ssm/account/testAjax",
            type: "post",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify({
                name: $(".namea").val(),
                money: $(".moneya").val()
            }),
            success: function (data) {
                console.log(data);
            },
            error: function (data) {
                alert("响应出错！" + data);
            }
        });
    } else {
        alert("请填写字段！");
    }
});

$(".del").click(function () {
    if ($(".id_del").val() != null && $(".id_del").val() != "") {
        console.log($(".id_del").val());
        $.ajax({
            url: "/ssm/account/idDel",
            type: "post",
            dataType: "json",
            data:{
                id: $(".id_del").val()
            },
            success: function (data) {
                if (data.state == "ok") {
                    console.log("删除成功！")
                }
            },
            error: function (data) {
                alert("响应出错！" + data);
            }
        });
    } else {
        alert("请填写字段！");
    }
});

$(".updatea").click(function () {
    if ($(".idu").val() != null && $(".idu").val() != "") {
        console.log($(".idu").val());
        $.ajax({
            url: "/ssm/account/idUpdate",
            type: "post",
            dataType: "json",
            contentType: "application/json",
            data:JSON.stringify({
                id: $(".idu").val(),
                name: $(".nameu").val(),
                money: $(".moneyu").val(),
            }),
            success: function (data) {
                if (data.state == "ok") {
                    console.log("更新成功！")
                }
            },
            error: function (data) {
                alert("响应出错！" + data);
            }
        });
    } else {
        alert("请填写字段！");
    }
});