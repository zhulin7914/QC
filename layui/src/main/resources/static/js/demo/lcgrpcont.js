layui.use(['form', 'layedit', 'laydate', 'table'], function () {
    var form = layui.form
    	, $ = layui.jquery
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        , table = layui.table;

    // 日期
    laydate.render({
        elem: '#date1'
    });
    laydate.render({
        elem: '#date2'
    });
    laydate.render({
        elem: '#date3'
    });
    laydate.render({
        elem: '#date4'
    });

    // 监听指定开关
    form.on('switch(switchTest)', function (data) {
        layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
            offset: '6px'
        });
        layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });

    // 表单初始赋值
    form.val('example', {
        "grpcontno": "8028000000991788" 
        , "prtno": "123456"
        , "managecom": "GDDC"
        , "yyy": true // 开关状态
        , "show": "电子保单"
    })

    table.render({
        elem: '#test' // 绑定元素
        , url: '/dao/lcgrpcont/all' //数据接口
    	, id: 'dataCheck' // 设定容器唯一 id
        , toolbar: '#toolbarDemo'  // 指向自定义工具栏模板选择器
        , defaultToolbar: ['filter', 'print', 'exports']
        , title: '保单信息表' // 标题
//        , limits : [30, 60, 90, 150, 300] //每页条数的选择项，非必选
//        , limit : 10 //每页显示的条数，非必选，默认：10
        , page: true  // 开启分页
        , cols: [[
            {type: 'checkbox', fixed: 'left'}
            , {field: 'prtno', title: '投保单号码', width: 200, fixed: 'left'}
            , {field: 'grpcontno', title: '团单号', width: 200, fixed: 'left'}
            , {field: 'managecom', title: '管理机构', width: 150,  sort: true}
            , {field: 'appntno', title: '投保人客户编码', width: 150}
            , {field: 'grpname', title: '投保人名称'}
            , {field: 'cvalidate', title: '生效日期', width: 150}
            , {field: 'signdate', title: '签单日期', width: 150}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 120}
        ]]
    });
    
    // 根据条件查询表格数据重新加载
    form.on('submit(demo1)', function (data) {
	    	// data.field当前容器的全部表单字段，名值对形式：{name: value}
		   var grpcontno = data.field.grpcontno;
	       // 执行重载
	       table.reload('dataCheck', {
	    	   	  page: {curr: 1}// 重新从第 1 页开始 
		        , url: '/dao/lcgrpcont/show' //默认会自动传递两个参数：?page=1&limit=10
		        , where: { grpcontno:grpcontno}
	       });
	       return false;// 阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
        
    // 根据条件查询表格数据重新加载
    // 这里有坑，$ 必须在最上面重新定义，不能直接引用， $ = layui.jquery
    // 不知道为什么，用这个事件能正常获取数据，当是页面瞬间就有还原了
//	$('#demo1').on('click',function(){
//			// 获取保单号
//		   var grpcontno = $("input[name='grpcontno']").val();
//	       // 执行重载
//	       table.reload('dataCheck', {
//		          url: '/dao/lcgrpcont/show' //默认会自动传递两个参数：?page=1&limit=10
//		        , where: { grpcontno:grpcontno}
//	      });
//	}); 

    // 头工具栏事件
    table.on('toolbar(test)', function (obj) {// 注：toolbar是工具条名，test是table原始容器的属性
												// lay-filter="对应的值"
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;
        }
        ;
    });

    // 监听行工具事件，自动监听每一行事件
    table.on('tool(test)', function (obj) {// 注：tool是工具条事件名，test是table原始容器的属性
											// lay-filter="对应的值"
        var data = obj.data; // 获得当前行数据
        if (obj.event === 'del') { // 删除
            layer.confirm('真的删除行么', function (index) {
                obj.del();  // 删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);  // 向服务端发送删除指令
            });
        } else if (obj.event === 'edit') {// 编辑
            layer.prompt({
                formType: 2                , value: data.email
            }, function (value, index) {
                obj.update({  // 同步更新缓存对应的值
                    email: value
                });
                layer.close(index);
            });
        }
    });

});
