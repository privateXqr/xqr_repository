$(function(){

    $("[name = 'fasong']").click(function () {

        $(this).val() == "发送" ? $("[name = 'mailPsuh']").val("1") : $("[name = 'mailPsuh']").val("0");

    })

    $("#account").change(function () {
        console.log("qq");
        var options = $("#account option:selected");
        if (options.val() == "0") {
            console.log("www");
            $("#recive_list").prop("readonly", true);
        } else {
            console.log("sss");
            $("#recive_list").removeAttr("readonly");
        }
    });


				
			/*	*//**
				 * 切换星星
				 *//*
				$(".em").click(function(){
					var $this=$(this).parents("tr").find(".em span");
					
					if($this.hasClass("glyphicon-star-empty")){
						$this.removeClass("glyphicon-star-empty").addClass("glyphicon-star");
					}else{
						$this.removeClass("glyphicon-star").addClass("glyphicon-star-empty");
					}
				});*/
				
				/**
				 * 蓝色左边框
				 */
				$(".nav>li").click(function(){
					if($(this).parent().hasClass("files")){
						$(this).css("border-left","3px solid blue")
					.siblings().css("border-left","3px solid transparent");
					}
				})
				
				/**
				 * 伸缩
				 */
	           	$(".des").click(function(){
					
					var $this=$(this).children();
					
					var $ul=$(this).parents(".box-header").next();
					
					if($(this).hasClass("mm")){
						if($this.hasClass("glyphicon-minus")){
							$this.removeClass("glyphicon-minus").addClass("glyphicon-plus");
						}else{
							
							$this.removeClass("glyphicon-plus").addClass("glyphicon-minus");	
						}
						$ul.slideToggle(1000);
					}else{
						if($this.hasClass("glyphicon-minus")){
							$this.removeClass("glyphicon-minus").addClass("glyphicon-plus");
						}else{
							
							$this.removeClass("glyphicon-plus").addClass("glyphicon-minus");	
						}
							$ul.slideToggle(1000);
					}
				})
	           	
	           	
	           	
	           		/**
				 * 全选/反选
				 */
					$("[name=id]:checkbox").click(function(){
	           				
	           				var flag=true;
				           	$("[name=id]:checkbox").each(function(){
				           			if(!this.checked){
				           				flag=false;
				           			}
				           		});
				           		
				           	$("#checkedAll").prop("checked",flag);
				  })
					
					  	
	           	$("#checkedAll").click(function(){
	           		
	           		$("[name=id]:checkbox").each(function(){
	           			
	           			if($("#checkedAll").is(':checked')){
	           				/*$(this).prop("checked","checked");*/
	           				$(this).prop("checked",!$(this).attr("checked"));
	           				
	           			}else{
	           				$(this).removeAttr("checked");
	           			}
	           				
	           		})
	           	})
	           	
	           	$(".top .btn").click(function() {
	           		var $this = $('.top .btn .glyphicon ');
					if($this.hasClass("glyphicon-chevron-down")) {
						$this.removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-up");
					} else {
						$this.removeClass("glyphicon-chevron-up").addClass("glyphicon-chevron-down");
					}
					$("#MoreDiv").slideToggle(1000);

				});

				$("#ctl00_cphMain_ddlAccount").change(function() {
					var options = $("#ctl00_cphMain_ddlAccount option:selected");
					if(options.val() != "0") {
						$("#ctl00_cphMain_txtReceiver").removeAttr("readonly");

					} else {
						$("#ctl00_cphMain_txtReceiver").attr("readonly", true);
						
					}
				});
			
	          
		})

			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					allowFileManager: true
				});
				K('input[name=getHtml]').click(function(e) {
					alert(editor.html());
				});
				K('input[name=isEmpty]').click(function(e) {
					alert(editor.isEmpty());
				});
				K('input[name=getText]').click(function(e) {
					alert(editor.text());
				});
				K('input[name=selectedHtml]').click(function(e) {
					alert(editor.selectedHtml());
				});
				K('input[name=setHtml]').click(function(e) {
					editor.html('<h3>Hello KindEditor</h3>');
				});
				K('input[name=setText]').click(function(e) {
					editor.text('<h3>Hello KindEditor</h3>');
				});
				K('input[name=insertHtml]').click(function(e) {
					editor.insertHtml('<strong>插入HTML</strong>');
				});
				K('input[name=appendHtml]').click(function(e) {
					editor.appendHtml('<strong>添加HTML</strong>');
				});
				K('input[name=clear]').click(function(e) {
					editor.html('');
				});
				
				
			});

    // 新增联系人
    function addvalue() {
        var id_array = new Array();

        if($('input[name="id"]:checked').length > 0){
            $('input[name="id"]:checked').each(function () {

                var $name = $(this).parents(".col-xs-1").siblings(".na").text();
                console.log($name);
                id_array.push($name);//向数组中添加元素
                var idstr = id_array.join(';');//将数组元素连接起来以构建一个字符串
                $("#recive_list").val(idstr);
                $(".recive_list").val(idstr);
                $(".recive_list").change();
            })
        }else {
            $("#recive_list").val("");
            $(".recive_list").val("");
            $(".recive_list").change();
        }
        $(".fade").css("display", "none");

    }

/*追加到联系人*/
function addvalue2() {
    var id_array = new Array();

    var idstr = null;

    $('input[name="id"]:checked').each(function () {
        var $name = $(this).parents(".col-xs-1").siblings(".na").text();
        id_array.push($name);
        idstr = id_array.join(';');
    })
    var org = $("#recive_list").val();

    if (idstr.indexOf(org) == -1){
        $("#recive_list").val(org + ';' + idstr);
    }
    $(".fade").css("display", "none");
}

//验证邮箱
function isMailNo(mail) {
    var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
    return pattern.test(mail);
}

function alertCheck(errorMess) {

    $('.alert-danger').css('display', 'block');
    // 提示框的错误信息显示
    $('.error-mess').text(errorMess);

}

//表单提交前执行的onsubmit()方法；返回false时，执行相应的提示信息；返回true就提交表单到后台校验与执行
function check() {

    console.log("开始进入了");
    //提示框可能在提交之前是block状态，所以在这之前要设置成none
    $('.alert-danger').css('display', 'none');
    var isRight = 1;
    $('.form-control').each(function (index) {
        // 如果在这些input框中，判断是否能够为空
        if ($(this).val() == "") {

            // 排除哪些字段是可以为空的，在这里排除
            if (index == 5 || index == 6) {
                return true;
            }

            // 获取到input框的兄弟的文本信息，并对应提醒；

            var errorMess = "红色提示框不能为空!";
            // 对齐设置错误信息提醒；红色边框
            $(this).parent().addClass("has-error has-feedback");
            $('.alert-danger').css('display', 'block');
            // 提示框的错误信息显示
            $('.error-mess').text(errorMess);

            isRight = 0;
            return false;

        } else {
            var $account = $("#account").val();

            if ($account != 0) {
                if (index == 3) {
                    var $mail = $(this).val();
                    var patt1 = new RegExp(";");
                    var arr = new Array();
                    if (patt1.test($mail)) {
                        arr = $mail.split(";");
                        for (var i = 0; i < arr.length; i++) {
                            if (isMailNo(arr[i]) == false) {
                                $(this).parent().addClass("has-error has-feedback");
                                alertCheck("请输入正确的邮箱!");
                                isRight = 0;
                                return false;
                            }
                        }
                    } else {
                        arr = $mail.split("；");
                        for (var i = 0; i < arr.length; i++) {
                            if (isMailNo(arr[i]) == false) {
                                $(this).parent().addClass("has-error has-feedback");
                                alertCheck("请输入正确的邮箱!");
                                isRight = 0;
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
    });

    if (isRight == 0) {
        //modalShow(0);
        return false;
    } else if (isRight == 1) {
        //modalShow(1);
        return true;
    }
//	return false;
}

