var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            // title: $('#title').val(),
            // author: $('#author').val(),
            name: $('#name').val()
        };

        var keywordLength = $('#keyword-length').val();
        var keywordLimit = 10;
        if (keywordLength == keywordLimit) {
            alert("키워드는 최대 " + keywordLimit + "개 까지만 등록할 수 있습니다.");
            return;
        }

        if (data.name.length < 2) {
            alert("2글자 이상의 검색어를 입력해주세요!");
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/keyword',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('키워드가 등록되었습니다!');
            location.reload();
        }).fail(function (error) {
            // alert(error);
            alert("키워드 등록에 실패했습니다.");
        });
    }
};

main.init();