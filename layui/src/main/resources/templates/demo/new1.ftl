<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>团体保单查询</title>
	<script src="/static/js/demo/new1.js"></script>
</head>
<body>
<blockquote class="layui-elem-quote layui-text">团体保单信息查询</blockquote>
<form class="layui-form layui-form-pane" action="" style="margin-left: 50px;" lay-filter="example">

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">团体保单号</label>
            <div class="layui-input-inline">
                <input type="text" name="grpcontno" placeholder="请输入团单号"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">团体投保单号</label>
            <div class="layui-input-inline">
                <input type="text" name="prtno"  placeholder="请输入投保单号"  autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">管理机构</label>
            <div class="layui-input-inline">
                <select name="managecom">
                    <option value="">请选择管理机构</option>
                    <option value="8601" selected="">总公司</option>
                    <option value="8602">北京机构</option>
                    <option value="8603">上海机构</option>
                </select>
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">团体险种</label>
            <div class="layui-input-inline">
                <select name="riskcode">
                    <option value="">请选择险种编码</option>
                    <option value="GADD" selected="">GADD</option>
                    <option value="GDDC">GDDC</option>
                    <option value="GSDC">GSDC</option>
                    <option value="GMFC">GMFC</option>
                </select>
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">保单生效日起期</label>
            <div class="layui-input-inline">
                <input type="text" name="cvalidate" id="date1"  placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">保单生效日止期</label>
            <div class="layui-input-inline">
                <input type="text" name="cvalidate" id="date2"  placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-inline">
            <label class="layui-form-label">单位名称</label>
            <div class="layui-input-inline">
                <input type="text" name="grpname" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-inline">
            <label class="layui-form-label">签单日期</label>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="signdate" id="date3" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid">-</div>
            <div class="layui-input-inline" style="width: 100px;">
                <input type="text" name="signdate" id="date4" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">请选择签单日期</div>
        </div>
    </div>

    <!-- pane="" 方框风格-->
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">发送短信</label>
        <div class="layui-input-block">
            <input type="checkbox" name="yyy" lay-skin="switch" lay-text="ON|OFF"  title="开关" checked>
        </div>
    </div>
    <div class="layui-form-item" pane="">
        <label class="layui-form-label">打印方式</label>
        <div class="layui-input-block">
            <input type="radio" name="show" value="纸质保单" title="纸质保单" checked="">
            <input type="radio" name="show" value="电子保单" title="纸质保单">
            <input type="radio" name="show" value="不打印" title="不打印">
        </div>
    </div>
    
    <div class="layui-form-item" pane="">
	    <label class="layui-form-label">开关-默认开</label>
	    <div class="layui-input-block">
	      <input type="checkbox" checked="" name="open" lay-skin="switch" lay-filter="switchTest" lay-text="ON|OFF">
	    </div>
  	</div>

    <div class="layui-form-item">
        <button class="layui-btn" lay-submit="" lay-filter="demo1">查询</button>
        <button class="layui-btn" lay-submit="" lay-filter="demo2">重置</button>
    </div>
</form>

<blockquote class="layui-elem-quote layui-text">团体保单信息</blockquote>

<table class="layui-hide" id="test" lay-filter="test"></table>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
        <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
        <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    </div>
</script>

<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>