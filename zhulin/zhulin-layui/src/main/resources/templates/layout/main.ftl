<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
     <!--加载公共js/css-->
    <#include "partials/head.ftl" >
    <!-- 标题 -->
    <title><sitemesh:write property='title'/></title>
    <!-- head头 -->
    <sitemesh:write property='head' />
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">

<!--top头部区域-->
<#include "partials/top.ftl" >

<!--left左侧导航区域-->
<#include "partials/left.ftl" >

<!--right右侧内容区域-->
<div class="layui-body">
    <sitemesh:write property='body'/>
</div>

<!--foot底部固定区域-->
<#include "partials/foot.ftl" >

</div>
</body>
</html>