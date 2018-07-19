$().ready(function() {
	validateRule();
});

$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/doll/item/save",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
                if (data.errorList)
                    parent.layer.alert(handleValidate(data));
                else
                    parent.layer.alert(data.msg);
			}

		}
	});

}

function handleValidate(data) {
    var alertInfo = data.msg + '<br>';
    var errors = data.errorList;
    for (var i = 0; i < errors.length; i++) {
        alertInfo += (i + 1) + '. ' + errors[i] + '<br>';
    }
    return alertInfo;
}

function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入姓名"
			}
		}
	})
}