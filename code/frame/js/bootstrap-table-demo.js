/*!
 * Remark (http://getbootstrapadmin.com/remark)
 * Copyright 2015 amazingsurge
 * Licensed under the Themeforest Standard Licenses
 */
function rowStyle(row, index) {
  var classes = ['active', 'success', 'info', 'warning', 'danger'];

//if (index % 2 === 0 && index / 2 < classes.length) {
//  return {
//    classes: classes[index / 2]
//  };
//}
  return {};
}

window.operateEvents = {
            'click .RoleOfdelete': function (e, value, row, index) {
                alert(row.dno);            
         },
            'click .RoleOfedit': function (e, value, row, index) {
//              $("#editModal").modal('show');
            }
    };

function operateFormatter(value, row, index) {
  return [
  '<button type="button" class="RoleOfdelete btn btn-primary  btn-sm" style="margin-right:15px;">删除</button>',

  '<button type="button" class="RoleOfedit btn btn-primary  btn-sm" style="margin-right:15px;" data-toggle="modal"  href="table_bootstrap.html#modal-form">修改</button>'
  ].join('');
}

function buildTable($el, cells, rows) {
  var i, j, row,
    columns = [],
    data = [];

  for (i = 0; i < cells; i++) {
    columns.push({
      field: '字段' + i,
      title: '单元' + i
    });
  }
  for (i = 0; i < rows; i++) {
    row = {};
    for (j = 0; j < cells; j++) {
      row['字段' + j] = 'Row-' + i + '-' + j;
    }
    data.push(row);
  }
  $el.bootstrapTable('destroy').bootstrapTable({
    columns: columns,
    data: data,
    iconSize: 'outline',
    icons: {
      columns: 'glyphicon-list'
    }
  });
}

(function(document, window, $) {
  'use strict';

  // Example Bootstrap Table Events
  // ------------------------------
  (function() {
    $('#exampleTableEvents').bootstrapTable({
      url: "js/bootstrap_table_test.json",
      search: true,
      pagination: true,
      showRefresh: true,
      showToggle: true,
      showColumns: true,
      striped : true,
      sortable:true, 
      showJumpto:true,
      sortName: "id", 
      sortOrder: "desc", 
      iconSize: 'outline',
      dataType:'json',
      toolbar: '#exampleTableEventsToolbar',
      icons: {
        refresh: 'glyphicon-repeat',
        toggle: 'glyphicon-list-alt',
        columns: 'glyphicon-list'
      },
      pageList:[10, 25, 50, 100],    
      clickToSelect:true,  
        columns: [{ //编辑datagrid的列
                field : 'state',
                checkbox : true
            },{ 
                title : 'ID',
                field : 'id',
                sortable: true
            }, {
                field : 'name',
                title : '名称',
                sortable: true
            }, {
                field : 'price',
                title : '价格',
                sortable: true
            }, {
                field: 'operate',
                title: '操作',
                width :160,
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
                }],
           pagination:true
    });
    
        var $result = $('#examplebtTableEventsResult');

    $('#exampleTableEvents').on('all.bs.table', function(e, name, args) {
        console.log('Event:', name, ', data:', args);
      })
      .on('click-row.bs.table', function(e, row, $element) {
        $result.text('Event: click-row.bs.table');
      })
      .on('dbl-click-row.bs.table', function(e, row, $element) {
        $result.text('Event: dbl-click-row.bs.table');
      })
      .on('sort.bs.table', function(e, name, order) {
        $result.text('Event: sort.bs.table');
      })
      .on('check.bs.table', function(e, row) {
        $result.text('Event: check.bs.table');
      })
      .on('uncheck.bs.table', function(e, row) {
        $result.text('Event: uncheck.bs.table');
      })
      .on('check-all.bs.table', function(e) {
        $result.text('Event: check-all.bs.table');
      })
      .on('uncheck-all.bs.table', function(e) {
        $result.text('Event: uncheck-all.bs.table');
      })
      .on('load-success.bs.table', function(e, data) {
        $result.text('Event: load-success.bs.table');
      })
      .on('load-error.bs.table', function(e, status) {
        $result.text('Event: load-error.bs.table');
      })
      .on('column-switch.bs.table', function(e, field, checked) {
        $result.text('Event: column-switch.bs.table');
      })
      .on('page-change.bs.table', function(e, size, number) {
//    	rowStyle(size, number);
	console.log("--->"+size+" , "+number);
        $result.text('Event: page-change.bs.table');
      })
      .on('search.bs.table', function(e, text) {
        $result.text('Event: search.bs.table');
      });
    
  })();

})(document, window, jQuery);

