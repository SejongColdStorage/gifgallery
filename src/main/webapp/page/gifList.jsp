<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <title>움짤 갤러리</title>

    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>

<div class="gifListWrapper container-fluid">
    <!--랜더링 결과가 여기로 입력됨-->
    <ul class="gifList"></ul>
    <div class="gifListLoading">
        로딩중입니다!!!
    </div>
</div>

<div class="gif-popup modal fade" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content"  style="height:100%;margin-bottom: 10px" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h2 class="modal-title">Modal title</h2>
            </div>
            <div class="modal-body">
                <div class="col-md-9 gif-image-wrapper">
                    <div class="row text-center">
                        <!--<img src="http://upload.wikimedia.org/wikipedia/commons/thumb/e/e0/Long_March_2D_launching_VRSS-1.jpg/640px-Long_March_2D_launching_VRSS-1.jpg">-->
                        <img src="http://i1.daumcdn.net/thumb/R750x0/?fname=http%3A%2F%2Fcfile30.uf.tistory.com%2Fimage%2F230E8B465325F6591F423F">
                    </div>
                </div>
                <div class="col-md-3">
                    <div>
                        <div class="btn-group" role="group" >
                            <button type="button" class="btn btn-default">좋아요</button>
                            <button type="button" class="btn btn-default">댓글</button>
                            <button type="button" class="btn btn-default">공유</button>
                        </div>
                    </div>
                    <div>
                        테스트 | 2014/12/31 12:33:40
                    </div>
                    <div>
                        400 x 341 2.1mb
                    </div>
                    <div>
                        <span class="label label-default">기쁨</span>
                        <span class="label label-default">율동</span>
                        <span class="label label-default">설렘</span>
                    </div>
                    <hr/>
                    <div>
                        <div>댓글</div>
                        <div>댓글</div>
                        <div>댓글</div>
                        <div>댓글</div>
                        <div>댓글</div>
                        <div>댓글</div>
                        <div>댓글</div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog-->
</div>

<script src="//code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.2/underscore-min.js"></script>
<script src="//cdn.rawgit.com/GBKS/Wookmark-jQuery/master/wookmark.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery.imagesloaded/3.1.8/imagesloaded.pkgd.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.0.0/jquery.magnific-popup.min.js"></script>
<script src="/js/infinite-scroll.js"></script>
<script src="/js/jquery.ba-hashchange.js"></script>

<script src="/js/gifList.js"></script>

</body>
</html>