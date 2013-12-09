<%@ page language="java" contentType="text/html; charset=utf-8"  import="java.util.List,com.fanaifan.countdown.model.Email"  pageEncoding="utf-8"%>
<%
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>

<!doctype html>
<html lang="en">
<base href="<%=basePath%>">
<head>
  <meta charset="utf-8">
  <title>订阅管理</title>
  <link rel="shortcut icon" href="favicon.gif">
  <!---CSS Files-->
  <link rel="stylesheet" href="css/master.css">
  <link rel="stylesheet" href="css/tables.css">
  <!---jQuery Files-->
  <script src="js/jquery-1.7.1.min.js"></script>
  <script src="js/jquery-ui-1.8.17.min.js"></script>
  <script src="js/styler.js"></script>
  <script src="js/jquery.tipTip.js"></script>
  <script src="js/colorpicker.js"></script>
  <script src="js/sticky.full.js"></script>
  <script src="js/global.js"></script>
  <script src="js/jquery.dataTables.min.js"></script>
  <!---Fonts-->
  <link href='http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700' rel='stylesheet' type='text/css'>
  <!--[if lt IE 9]>
  <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  <![endif]-->
  <!--[if lte IE 8]>
  <script language="javascript" type="text/javascript" src="js/flot/excanvas.min.js"></script>
  <![endif]-->
</head>
<body>

  <!--- HEADER -->

    <div class="header">
   
  </div>

  <div class="top-bar">
      <ul id="nav">
        <li id="user-panel">
          <img src="img/nav/usr-avatar.jpg" id="usr-avatar" alt="" />
          <div id="usr-info">
            <p id="usr-name">你好,管理员.</p>
            <p><a href="/logout">Log out</a></p>
          </div>
        </li>
        <li>
        <ul id="top-nav">
         <li class="nav-item">
           <a href="#"><img src="img/nav/dash-active.png" alt="" /><p>主页面</p></a>
         </li>
       </ul>
      </li>
     </ul>
  </div>

  <!--- CONTENT AREA -->

  <div class="content container_12">

      <div class="box grid_12">
        <div class="box-head"><h2>订阅管理</h2></div>
        <div class="box-content no-pad">
        <table class="display" id="dt3">
        <thead>
          <tr>
            <th>编号</th>
            <th>邮箱</th>
            <th>是否发送</th>
            <th>创建时间</th>
            <th>发送时间</th>
            <th>操作</th>
          </tr>
        </thead>
        <tbody>
       <% List<Email> emails = (List<Email>) request.getAttribute("emails");
       		 for(Email email : emails){
       %> 
          <tr class="odd gradeX">
            <td class="center"><%=email.getId() %></td>
            <td class="center"><%=email.getEmail() %></td>
            <td class="center"><% if(email.isIs_send()){out.print("已发送");}else{out.print("未发送");} %></td>
            <td class="center"><%=email.getCreate_at() %></td>
            <td class="center"><%=email.getSend_at() %></td>
            <td class="center">
            <%if(!email.isIs_send()){ %>
            <a href="/api/meng-cms/send/<%=email.getId() %>">发送</a>
            <%} %>
            </td>
          </tr>
          <%} %>
        </tbody>
      </table>
        </div>
      </div>

  </div>

<div class="footer">
  <p>Powered by <a href="http://www.fanaifan.com">Fanaifan.com</a></p>
</div>

<script> /* SCRIPTS */
  $(function () {
    $('#dt3').dataTable( {
        "bJQueryUI": true,
        "sPaginationType": "full_numbers"   
    }); /* For the data tables */
  });
</script>
</body>
</html>