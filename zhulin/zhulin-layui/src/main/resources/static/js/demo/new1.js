layui.use(['form', 'layedit', 'laydate', 'table'], function () {
    var form = layui.form
        , layer = layui.layer
        , layedit = layui.layedit
        , laydate = layui.laydate
        , table = layui.table;

    //日期
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

    //创建一个编辑器
    var editIndex = layedit.build('LAY_demo_editor');

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
        }
        , pass: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]
        , content: function (value) {
            layedit.sync(editIndex);
        }
    });

    //监听指定开关
    form.on('switch(switchTest)', function (data) {
        layer.msg('开关checked：' + (this.checked ? 'true' : 'false'), {
            offset: '6px'
        });
        layer.tips('温馨提示：请注意开关状态的文字可以随意定义，而不仅仅是ON|OFF', data.othis)
    });

    //监听提交
    form.on('submit(demo1)', function (data) {
        layer.alert(JSON.stringify(data.field), {
            title: '最终的提交信息'
        })
        return false;
    });

    //表单初始赋值
    form.val('example', {
        "username": "贤心" // "name": "value"
        , "password": "123456"
        , "interest": 1
        , "like[write]": true //复选框选中状态
        , "close": true //开关状态
        , "sex": "女"
        , "desc": "我爱 layui"
    })

    table.render({
        elem: '#test' //绑定元素
        , url: '/static/js/demo/new1.json' //数据接口
        //toolbar开启表格头部工具栏区域，若需要“列显示隐藏”、“导出”、“打印”等功能，则必须开启该参数
        , toolbar: '#toolbarDemo'  //指向自定义工具栏模板选择器
        //自由配置头部工具栏右侧的图标，数组支持以下可选值：
        // filter: 显示筛选图标
        // exports: 显示导出图标
        // print: 显示打印图标
        //开启表格头部工具栏区域后，自动默认存在，可不用显示调用
        , defaultToolbar: ['filter', 'print', 'exports']
        , title: '保单信息表' //标题
        , page: true  //开启分页
        , cols: [[
            //type: 'checkbox'复选框列，fixed固定列，
            // 注意：如果是固定在左 left，该列必须放在表头最前面；如果是固定在右 right，该列必须放在表头最后面。
            {type: 'checkbox', fixed: 'left'}
            , {field: 'grpcontno', title: '保单号', width: 200, fixed: 'left', unresize: true, sort: true}
            , {field: 'managecom', title: '管理机构代码', width: 120, edit: 'text'}
            //templet 自定义列模板，模板遵循 laytpl 语法。
            // 这是一个非常实用的功能，你可借助它实现逻辑处理，以及将原始数据转化成其它格式，如时间戳转化为日期字符等
            , {
                field: 'email', title: '邮箱', width: 150, edit: 'text',  templet: function (res) {
                    return '<em>' + res.email + '</em>'
                }
            }
            //edit 单元格编辑类型（默认不开启）目前只支持：text（输入框）
            , {field: 'prem', title: '保费', width: 80, edit: 'text', sort: true}
            , {field: 'grpname', title: '单位名称', width: 100}
            , {field: 'appntname', title: '投保人姓名'}
            //sort 是否允许排序（默认：false）。如果设置 true，则在对应的表头显示排序icon，从而对列开启排序功能。
            , {field: 'experience', title: '积分', width: 80, sort: true}
            , {field: 'ip', title: 'IP', width: 120}
            , {field: 'logins', title: '登入次数', width: 100, sort: true}
            , {field: 'signdate', title: '签单日期', width: 120}
            , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 150}
        ]]
    });

    //头工具栏事件
    table.on('toolbar(test)', function (obj) {//注：toolbar是工具条名，test是table原始容器的属性 lay-filter="对应的值"
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

    //监听行工具事件，自动监听每一行事件
    table.on('tool(test)', function (obj) {//注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data; //获得当前行数据
        //console.log(obj)
        //var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        // if(layEvent === 'detail'){ //查看
        //     //do somehing
        // }
        if (obj.event === 'del') { //删除
            layer.confirm('真的删除行么', function (index) {
                obj.del();  //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);  //向服务端发送删除指令
            });
        } else if (obj.event === 'edit') {//编辑
            layer.prompt({
                formType: 2                , value: data.email
            }, function (value, index) {
                obj.update({  //同步更新缓存对应的值
                    email: value
                });
                layer.close(index);
            });
        }
    });

});
