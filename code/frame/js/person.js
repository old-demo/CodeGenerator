window.operateEvents = {
    'click .RoleOfdelete': function (e, value, row, index) {
        layer.confirm('您是否确定删除此数据？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var id = {id: row.id};
            $.ajax({
                type: "post",
                url: "person/deletePersonByKey",
                contentType: 'application/json;charset=utf-8',
                data: JSON.stringify(id),
                dataType: "json",
                success: function(data){
                    if(data.code == 1) {
                        $("#exampleTableEvents").bootstrapTable('refresh', {url: 'person/listPersonByParamAndPage'});
                        layer.msg(data.msg, {icon: 6});
                    } else {
                        layer.msg(data.msg, {icon: 5});
                    }
                }
            });
        });
    },
    'click .RoleOfshow': function (e, value, row, index) {
        $('#person-name').attr("value", row.name).attr("disabled","disabled");
        $('#person-age').attr("value", row.age).attr("disabled","disabled");
        $("#person-address").attr("value", row.address).attr("disabled","disabled");
        layer.open({
            type: 1 //Page层类型
            ,id: 'show' //设定一个id，防止重复弹出
            ,title: "查看信息" //不显示标题栏   title : false/标题
            ,area: ['400px', '300px']
            ,shade: 0.6 //遮罩透明度
            ,maxmin: true //允许全屏最小化
            ,anim: 1 //0-6的动画形式，-1不开启
            ,content: $('#modal-form').html()
        });
    },
    'click .RoleOfedit': function (e, value, row, index) {
        $('#person-name').attr("value", row.name).removeAttr("disabled");
        $('#person-age').attr("value", row.age).removeAttr("disabled");
        $("#person-address").attr("value", row.address).removeAttr("disabled");
        layer.open({
            type: 1 //Page层类型
            ,id: 'edit' //设定一个id，防止重复弹出
            ,title: "编辑信息" //不显示标题栏   title : false/标题
            ,area: ['400px', '300px']
            ,shade: 0.6 //遮罩透明度
            ,maxmin: true //允许全屏最小化
            ,anim: 1 //0-6的动画形式，-1不开启
            ,content: $('#modal-form').html()
            ,btn: ['确定', '取消']
            ,btn1: function(index, layero){
                var name = $(layero).find('#person-name').val();
                var age =  $(layero).find('#person-age').val();
                var address = $(layero).find('#person-address').val();
                var person = {
                    id : row.id,
                    name : name,
                    age : age,
                    address : address,
                };
                console.log(person);
                console.log(JSON.stringify(person));
                $.ajax({
                    type: "post",
                    url: "person/updatePersonByKey",
                    contentType: 'application/json;charset=utf-8',
                    data: JSON.stringify(person),
                    dataType: "json",
                    success: function(data){
                        if(data.code == 1) {
                            $("#exampleTableEvents").bootstrapTable('refresh', {url: 'person/listPersonByParamAndPage'});
                            layer.msg(data.msg, {icon: 6});
                        } else {
                            layer.msg(data.msg, {icon: 5});
                        }
                    }
                });
            }
        });
    }
};

function operateFormatter(value, row, index) {
    return [
        '<button type="button" class="RoleOfshow btn btn-primary  btn-sm" style="margin-right:15px;">查看</button>',
        '<button type="button" class="RoleOfedit btn btn-primary  btn-sm" style="margin-right:15px;">修改</button>',
        '<button type="button" class="RoleOfdelete btn btn-primary  btn-sm" style="margin-right:15px;">删除</button>'
    ].join('');
}

/** 查询数据 */
function searchData() {
    layer.open({
        type: 1 //Page层类型
        ,id: 'add' //设定一个id，防止重复弹出
        ,title: "查询信息" //不显示标题栏   title : false/标题
        ,area: ['400px', '300px']
        ,shade: 0.6 //遮罩透明度
        ,maxmin: true //允许全屏最小化
        ,anim: 1 //0-6的动画形式，-1不开启
        ,content: $('#modal-form').html()
        ,btn: ['确定', '取消']
        ,btn1: function(index, layero){
            var name = $(layero).find('#person-name').val();
            var age =  $(layero).find('#person-age').val();
            var address = $(layero).find('#person-address').val();

            var opt = {
                url: "person/listPersonByParamAndPage",
                silent: true,
                query:{
                    name:name,
                    age:age,
                    address:address
                }
            };
            $("#exampleTableEvents").bootstrapTable('refresh', opt);
        }
    });
}


/** 添加数据 */
function addData() {
    layer.open({
        type: 1 //Page层类型
        ,id: 'add' //设定一个id，防止重复弹出
        ,title: "添加信息" //不显示标题栏   title : false/标题
        ,area: ['400px', '300px']
        ,shade: 0.6 //遮罩透明度
        ,maxmin: true //允许全屏最小化
        ,anim: 1 //0-6的动画形式，-1不开启
        ,content: $('#modal-form').html()
        ,btn: ['确定', '取消']
        ,btn1: function(index, layero){
            var name = $(layero).find('#person-name').val();
            var age =  $(layero).find('#person-age').val();
            var address = $(layero).find('#person-address').val();
            var person = {
                name : name,
                age : age,
                address : address,
            };
            $.ajax({
                type: "post",
                url: "person/savePerson",
                contentType: 'application/json;charset=utf-8',
                data : JSON.stringify(person),
                dataType: "json",
                success: function(data){
                    if(data.code == 1) {
                        $("#exampleTableEvents").bootstrapTable('refresh', {url: 'person/listPersonByParamAndPage'});
                        layer.msg(data.msg, {icon: 6});
                    } else {
                        layer.msg(data.msg, {icon: 5});
                    }
                }
            });
        }
    });
}

/** 批量删除数据 */
function deleteData() {
    var selectRow = $("#exampleTableEvents").bootstrapTable('getSelections');
    if(selectRow.length < 1) {
        layer.msg("请至少选择一条数据！", {icon: 5});
    } else {
        layer.confirm('您是否确定删除此数据？', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var idList = [];
            for(var i=0; i<selectRow.length; i++) {
                idList.push(selectRow[i].id);
            }
            $.ajax({
                type: "post",
                url: "person/deleteBatchPersonByKey",
                contentType: 'application/json;charset=utf-8',
                data: '{ idList:'+JSON.stringify(idList)+'}',
                dataType: "json",
                success: function(data){
                    if(data.code == 1) {
                        $("#exampleTableEvents").bootstrapTable('refresh', {url: 'person/listPersonByParamAndPage'});
                        layer.msg(data.msg, {icon: 6});
                    } else {
                        layer.msg(data.msg, {icon: 5});
                    }
                }
            });
        });
    }
}

(function(document, window, $) {
    'use strict';

    // Example Bootstrap Table Events
    // ------------------------------
    (function() {
        $('#exampleTableEvents').bootstrapTable({
            // url: "js/person.json",
            url: "person/listPersonByParamAndPage", // 请求地址
            contentType : "application/json",   // 设置请求类型
            method : 'post',    // 设置请求方式
            dataField : "data",
            dataType:'json',    // 设置返回类型为json
            queryParamsType: "",    // 设置为 ''  在这种情况下传给服务器的参数为：pageSize,pageNumber
            queryParams:queryParams,    // 请求服务器时所传的参数
            responseHandler: function(res) {
                if(res.code == 1) {
                    return {
                        data : res.data.list,
                        total : res.data.total,
                        rows : res.data.page_size
                    };
                } else {
                    layer.alert(res.msg, {icon: 2});
                }
            },
            pageList:[10, 25, 50, 100], // 每页最大数量
            sidePagination : "server", // 服务端处理分页
            pagination:true,    // 是否显示分页条
            clickToSelect:true, // 在点击行时，自动选择 rediobox 和 checkbox
            striped : true, // 是否会有隔行变色效果
            toolbar: '#exampleTableEventsToolbar',  // 工具栏id
            showRefresh: true,  // 展示刷新
            showToggle: true,   // 是否显示切换视图（table/card）按钮
            showColumns: true,  // 是否显示内容列下拉框
            iconSize: 'outline',
            icons: {
                refresh: 'glyphicon-repeat',
                toggle: 'glyphicon-list-alt',
                columns: 'glyphicon-list'
            },
            fixedColumns: true,
            fixedNumber: 2,
            columns: [{
                field: 'operate',
                title: '操作',
                width :160,
                align: 'center',
                valign: "middle",
                halign: "center",
                events: operateEvents,
                formatter: operateFormatter
            }, { //编辑datagrid的列
                field : 'state',
                checkbox : true
            }, {
                title : 'id',
                field : 'id',
                sortable: true
            }, {
                field : 'name',
                title : '姓名',
                sortable: true
            }, {
                field : 'age',
                title : '年龄',
                sortable: true
            }, {
                field : 'address',
                title : '地址',
                sortable: true
            }

                // , {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }, {
                //     field : 'address',
                //     title : '地址',
                //     sortable: true
                // }

            ]
        });

        //请求服务数据时所传参数
        function queryParams(params){
            return{
                //每页多少条数据
                page_size: params.pageSize,
                //请求第几页
                page_num:params.pageNumber,
                // Name:$('#search_name').val(),
                // Tel:$('#search_tel').val()
            }
        }

        // var $result = $('#examplebtTableEventsResult');

//         $('#exampleTableEvents').on('all.bs.table', function(e, name, args) {
//             console.log('Event:', name, ', data:', args);
//         })
//             .on('click-row.bs.table', function(e, row, $element) {
//                 $result.text('Event: click-row.bs.table');
//             })
//             .on('dbl-click-row.bs.table', function(e, row, $element) {
//                 $result.text('Event: dbl-click-row.bs.table');
//             })
//             .on('sort.bs.table', function(e, name, order) {
//                 $result.text('Event: sort.bs.table');
//             })
//             .on('check.bs.table', function(e, row) {
//                 $result.text('Event: check.bs.table');
//             })
//             .on('uncheck.bs.table', function(e, row) {
//                 $result.text('Event: uncheck.bs.table');
//             })
//             .on('check-all.bs.table', function(e) {
//                 $result.text('Event: check-all.bs.table');
//             })
//             .on('uncheck-all.bs.table', function(e) {
//                 $result.text('Event: uncheck-all.bs.table');
//             })
//             .on('load-success.bs.table', function(e, data) {
//                 $result.text('Event: load-success.bs.table');
//             })
//             .on('load-error.bs.table', function(e, status) {
//                 $result.text('Event: load-error.bs.table');
//             })
//             .on('column-switch.bs.table', function(e, field, checked) {
//                 $result.text('Event: column-switch.bs.table');
//             })
//             .on('page-change.bs.table', function(e, size, number) {
// //    	rowStyle(size, number);
//                 console.log("--->"+size+" , "+number);
//                 $result.text('Event: page-change.bs.table');
//             })
//             .on('search.bs.table', function(e, text) {
//                 $result.text('Event: search.bs.table');
//             });

    })();

})(document, window, jQuery);

