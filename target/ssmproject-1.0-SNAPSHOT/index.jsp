<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="demo/css/index.css">

    <title>首页</title>

    <style>
        .list-content{
            width: 100%;
            height: auto;
        }
        .list-row{
            width: 100%;
            height: 40px;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: flex-start;
            text-decoration: none;
            color: #333333;
        }
        .sp-line{
            width: 100%;
            height: 1px;
            background: #d0d0d0;
        }
    </style>
</head>
<body>
<h1>用来做一些测试的   呵呵</h1>
<div class="list-content">
    <a class="list-row" href="demo/sorttable.html">点击排序</a>
    <div class="sp-line"></div>
    <a class="list-row" href="demo/imgcropper.html">上传图片并裁剪</a>
    <div class="sp-line"></div>

</div>
</body>
</html>
