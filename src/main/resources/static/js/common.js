/**
 * 校验失败返回数据展示处理
 * */
function handleValidate(data) {
    var alertInfo = data.msg + '<br>';
    var errors = data.errorList;
    for (var i = 0; i < errors.length; i++) {
        alertInfo += (i + 1) + '. ' + errors[i] + '<br>';
    }
    return alertInfo;
}

/**
 * 列出所有商品下拉框
 * */
function selectItemsLoad() {
    var html = "";
    $.ajax({
        url: '/doll/item/listAll',
        success: function (data) {
            //加载数据
            var rows = data.rows;
            html += '<option value="0">' + '0- 金币' + '</option>'
            for (var i = 0; i < rows.length; i++) {
                html += '<option value="' + rows[i].bizId + '">' + rows[i].bizId + '- ' + rows[i].name + '</option>'
            }
            $(".chosen-select").append(html);
            $(".chosen-select").chosen({
                maxHeight: 200
            });
        }
    });
}

/**
 * 列出所有魔法盒下拉框
 * */
function selectMagicBoxLoad() {
    var html = "";
    $.ajax({
        url: '/doll/magicBox/listAll',
        success: function (data) {
            //加载数据
            var rows = data.rows;
            for (var i = 0; i < rows.length; i++) {
                html += '<option value="' + rows[i].bizId + '">' + rows[i].bizId + '- ' + rows[i].name + '</option>'
            }
            $(".magicBox").append(html);
            $(".magicBox").chosen({
                maxHeight: 200
            });
        }
    });
}