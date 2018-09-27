<%@ page language="java" pageEncoding="utf-8" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!-- DataTables -->
<script type="text/javascript" src="assets/plugins/data-tables/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" type="text/css" href="assets/plugins/data-tables/css/jquery.dataTables.min.css"/>
<link rel="stylesheet" type="text/css" href="assets/plugins/data-tables/css/dataTables.bootstrap.min.css"/>
<!-- moment -->
<script type="text/javascript" src="assets/plugins/bootstrap-daterangepicker/moment.min.js"></script>
<!-- Editor -->
<script type="text/javascript" src="assets/plugins/data-tables/extensions/Editor/js/dataTables.editor.min.js"></script>
<link rel="stylesheet" type="text/css"
      href="assets/plugins/data-tables/extensions/Editor/css/editor.dataTables.min.css"/>

<script type="text/javascript"
        src="assets/plugins/data-tables/extensions/Buttons/js/dataTables.buttons.min.js"></script>
<link rel="stylesheet" type="text/css"
      href="assets/plugins/data-tables/extensions/Buttons/css/buttons.dataTables.min.css"/>

<script type="text/javascript" src="assets/plugins/data-tables/extensions/Select/js/dataTables.select.min.js"></script>
<link rel="stylesheet" type="text/css"
      href="assets/plugins/data-tables/extensions/Select/css/select.dataTables.min.css"/>

<script type="text/javascript" src="app/smadvertisement/smadvertisement-list.js"></script>

<table id="dtable" class="table table-bordered">
    <thead>
    <tr>
        <th>ID</th>
        <th>位置</th>
        <th>图片</th>
        <th>跳转链接</th>
        <th>显示排序</th>
        <th>状态</th>
        <th>应用类别</th>
        <th>上架时间</th>
        <th>下架时间</th>
        <th>分享标题</th>
        <th>分享描述</th>
    </tr>
    </thead>

</table>


