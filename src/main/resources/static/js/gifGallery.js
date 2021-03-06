//갤러리 레이아웃 및 읽어오기
var gifWrappers = [];
var gifWrapperMap = {};

var addGifWrappers = function (quriedResultGifWrappers) {
    _.each(quriedResultGifWrappers, function (gifWrapper) {
        gifWrappers.add(gifWrapper);
        gifWrapperMap[gifWrapper.id] = gifWrapper;
    });
};

//gif 팝업
$(function () {
    var _isPopupOpen = false;
    var _currentScroll = 0;
    var _gifPopupTemplate = "";

    //template를 가지고 온다.
    $.ajax({
        url: "snippet/gifPopup.snippet",
        async: false,
        success: function (text) {
            _gifPopupTemplate = _.template(text);
        }
    });

    var _getGifInfo = function (gifWrapperId, callback) {
        if(_.contains(gifWrappers, gifWrapperId)){
            callback(gifWrappers[gifWrapperId]);
            console.log("gifWrappers[gifWrapperId]");
            console.log(gifWrappers[gifWrapperId]);
        }else{
            $.get("/api/gif/" + gifWrapperId).success(function(data){
                console.log(data);
                callback(data);
            });
        }
    };

    $(window).hashchange(function () {
        var hash = location.hash;
        var gifWrapperId = hash.replace("#", "");

        if (hash == "") {
            if (_isPopupOpen) {
                $(window).scrollTop(_currentScroll);
                $(".gif-popup").modal('hide');
                _isPopupOpen = false;
            }
        } else {
            _getGifInfo(gifWrapperId, function(data){
                var popupHtml = _gifPopupTemplate(data);
                $(".gif-popup").html(popupHtml).modal("show");
                _isPopupOpen = true;
                _currentScroll = $(window).scrollTop();
            });
        }
    });

    $(window).hashchange();

    //image는 추후 조정하도록 하자!
    //$(window).on('resize', set_body_height);
    $('.gif-popup').on('hidden.bs.modal', function (e) {
        location.hash = "";
    });

    $(".gifList").on("click", ".gif-wrapper", function () {
        console.log("test");
        console.log($(this));
        var gifWrapperId = $(this).attr("data-gifwrapper-id");
        location.hash = gifWrapperId;
    });

});

$(function () {
    var _pageNumber = 0;
    var _gifWrapperTemplate = "";
    var _wookmark;
    var _container = ".gifList";
    var _columnWidth = (function getColumnWidth() {
        var size = Math.max(document.documentElement.clientWidth, window.innerWidth || 0);
        var columnSize;
        var MAX_COLUMN_SIZE = 300;

        //720보다 작을 경우 컬럼사이즈는 2;
        if (size <= 720)     columnSize = size / 2;

        //1024보다 작을 경우 컬럼사이즈는 3;
        else if (size <= 1024) columnSize = size / 3;

        //1024보다 클 경우 컬럼사이즈는 4;
        else columnSize = size / 4;

        //컬럼의 크기가 300보다 클 경우, 300으로 고정합니다.
        if (columnSize > MAX_COLUMN_SIZE) columnSize = MAX_COLUMN_SIZE;

        return columnSize;
    })();

    //template를 가지고 온다.
    $.ajax({
        url: "snippet/gifWrapper.snippet",
        async: false,
        success: function (text) {
            _gifWrapperTemplate = _.template(text);
        }
    });

    $(".gifList").infinitus({
        workOnStart: true,
        test: false,
        trigger: function (done) {
            var $self = $(this);

            $.get("api/page/" + _pageNumber, function (data) {
                var contents = data.content;
                var compiledHtml = "";
                for (var idx = 0; idx < contents.length; idx++) {
                    contents[idx].columnWidth = _columnWidth - 16;
                    compiledHtml = compiledHtml + _gifWrapperTemplate(contents[idx]);
                }

                $self.append(compiledHtml);

                if (data.last) $self.infinitus("pause");
                else _pageNumber += 1;

                applyLayout();

                done();
            });
        },
        onStart: function () {
            $('.gifListLoading').show();
        },
        onEnd: function () {
            $('.gifListLoading').hide();
        }
    });

    var applyLayout = function () {
        imagesLoaded(_container, function () {
            if (_wookmark === undefined) {
                _wookmark = new Wookmark(_container, {
                    offset: 5, // Optional, the distance between grid items
                    outerOffset: 0 // Optional, the distance to the containers border
                });
            } else {
                _wookmark.initItems();
                _wookmark.layout(true);
            }
        });
    };
});