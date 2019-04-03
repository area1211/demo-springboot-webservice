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
            name: $('#name').val().trim()
        };

        if (data.name.length < 2) {
            // alert("2글자 이상의 검색어를 입력해주세요!");
            swal ( "키워드 등록에 실패했습니다." ,  "2글자 이상의 검색어를 입력해주세요!" ,  "error" )
            return;
        }

        var keywordLength = $('#keyword-length').val();
        var keywordLimit = 5;
        if (keywordLength == keywordLimit) {
            // alert("키워드는 최대 " + keywordLimit + "개 까지만 등록할 수 있습니다.");
            swal ( "키워드 등록에 실패했습니다." ,  "키워드는 최대 " + keywordLimit + "개 까지만 등록할 수 있습니다." ,  "error" )
            return;
        }

        $.ajax({
            type: 'POST',
            url: '/keyword',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            // alert('키워드가 등록되었습니다!');
            swal('키워드가 등록되었습니다!', "최신 뉴스 검색 결과를 주기적으로 보여드릴게요!", "success")
                .then((value) => {
                    location.reload();
                })
        }).fail(function (error) {
            // alert(error);
            // alert("키워드 등록에 실패했습니다.");
            swal ( "키워드 등록에 실패했습니다." ,  "잠시후 다시 시도해주세요." ,  "error" )
        });
    }
};

main.init();