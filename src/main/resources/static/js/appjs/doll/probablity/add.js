$().ready(function() {
    selectLoad();
    selectItemsLoad();
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
		url : "/doll/probablity/save",
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

function selectLoad() {
    var html = "";
    $.ajax({
        url: '/doll/gashapon/listAll',
        success: function (data) {
            //加载数据
            var rows = data.rows;
            for (var i = 0; i < rows.length; i++) {
                html += '<option value="' + rows[i].bizId + '">' + rows[i].bizId + '- ' + rows[i].name + '</option>'
            }
            $("#bizId").append(html);
            $("#bizId").chosen({
                maxHeight: 200
            });
        }
    });
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