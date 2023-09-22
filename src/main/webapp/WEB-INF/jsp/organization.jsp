<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Welcome</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="/static/assets/vendor/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/static/assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/static/assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="/static/assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="/static/assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="/static/assets/css/demo.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="img/citi-logo-2.png">
</head>
<body>
<!-- 主盒子 -->
<div id="wrapper">

    <!-- 上方导航栏 -->
    <nav class="navbar navbar-default navbar-fixed-top">

        <div class="brand">
            <%--<a href="#"><img src="img/citi-logo.png" alt="Klorofil Logo" class="img-responsive logo"></a>--%>
            <strong style="font-size: 30px;">EIA</strong>
        </div>

        <!-- 左侧栏伸缩按钮 -->
        <div class="navbar-btn">
            <button type="button" class="btn-toggle-fullwidth"><i
                    class="lnr lnr-arrow-left-circle"></i></button>
        </div>

        <!-- 标题 -->
        <div class="navbar-header" style="margin-left: 27%;">
            <h1>Springboard Collaborative</h1>
        </div>

        <!-- 右上方欢迎信息 -->
        <div id="navbar-menu">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                        <i class="lnr lnr-alarm"></i>
                        <span class="badge bg-danger">3</span>
                    </a>
                    <ul class="dropdown-menu notifications">
                        <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Pending1</a>
                        </li>
                        <li><a href="#" class="notification-item"><span class="dot bg-danger"></span>Pending2</a>
                        </li>
                        <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Pending3</a>
                        </li>
                    </ul>
                </li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><span>Welcome</span> <i
                            class="icon-submenu lnr lnr-chevron-down"></i></a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="lnr lnr-user"></i> <span>1</span></a></li>
                        <li><a href="#"><i class="lnr lnr-envelope"></i> <span>2</span></a></li>
                        <li><a href="#"><i class="lnr lnr-cog"></i> <span>3</span></a></li>
                        <li><a href="#"><i class="lnr lnr-exit"></i> <span>4</span></a></li>
                    </ul>
                </li>

                <!-- 显示时间 -->
                <div class="navbar-btn navbar-btn-right">
                    <a class="btn btn-success" href="#"><i class="glyphicon glyphicon-time"></i><span
                            id="time"></span></a>
                </div>
            </ul>
        </div>
    </nav>
    <!-- 上方导航栏结束 -->


    <!-- 左侧栏 -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll" style="margin-top: 10%;">
            <nav>
                <ul class="nav">
                    <li><a href="#"><i class="lnr lnr-home"></i> <span>System</span></a></li>
                    <!-- 第一个主权限 -->
                    <!--
                        href="#subPages"和id="subPages"绑定
                        此处#subPages的值可以是任意数据，但是必须和id一致
                        不同li节点的值不能是一样的
                    -->
                    <li>
                        <a href="#" onclick="return participantPage()" data-toggle="collapse" class="collapsed"><i class="lnr lnr-cog"></i>
                            <span>Participant</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>

                    </li>

                    <!-- 第二个主权限 -->
                    <li>
                        <a href="#" onclick="return organization()" data-toggle="collapse" class="collapsed"><i
                                class="lnr lnr-cog"></i> <span>Organization</span> <i
                                class="icon-submenu lnr lnr-chevron-left"></i></a>
                    </li>

                    <!-- 第三个主权限 -->
                    <li>
                        <a href="#subPages2" data-toggle="collapse" class="collapsed"><i
                                class="lnr lnr-cog"></i> <span>Statistics</span> <i
                                class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subPages2" class="collapse ">
                            <ul class="nav">
                                <li><a href="#" class="" onclick="return opiateStatics()">Opiate statics</a></li>
                                <li><a href="#" class="" onclick="return programOutcomes()">Program Outcomes</a></li>
                                <li><a href="#" class="" onclick="return demographicPage()">Demographic data</a></li>
                            </ul>
                        </div>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
    <!-- 左侧栏结束 -->

    <div class="main">
        <!-- 内容区盒子 -->
        <div class="main-content">
            <!-- 表格区盒子 -->
            <div class="panel">
                <!-- 表格头部 -->
                <div class="panel-heading">
                    <!-- 表格标题 -->
                    <h3 class="panel-title">Participant Info</h3>
                    <div class="right">
                        <button type="button" class="btn-toggle-collapse"><i class="lnr lnr-chevron-up"></i></button>
                        <button type="button" class="btn-remove"><i class="lnr lnr-cross"></i></button>
                    </div>
                </div>

                <!-- 表格主体 -->
                <div class="panel-body no-padding">


                    <form class="navbar-form navbar-left" action="#">

                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="SEARCH...">
                        </div>

                        <!-- 按钮和超链接 -->
                        <div class="input-group">
                            <span class="input-group-btn"><button type="submit" class="btn btn-success">Search</button></span>
                            <span class="input-group-btn"><a href="#" class="btn btn-primary" style="margin-left: 5px;">Add</a></span>
                            <span class="input-group-btn"><a href="#" class="btn btn-danger" style="margin-left: 5px;">Delete</a></span>
                        </div>
                    </form>

                    <table class="table table-striped" style="font-size: 20px;">
                        <!-- 表头 -->
                        <thead>
                        <tr>
                            <th>Organization Name</th>
                            <th>Service Category</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orgList}" var="org">
                            <tr>
                                <td>${org.orgName}</td>
                                <td>${org.service}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- 主盒子结束 -->

<!-- Javascript -->
<script src="/static/assets/vendor/jquery/jquery.min.js"></script>
<script src="/static/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="/static/assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="/static/assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="/static/assets/vendor/chartist/js/chartist.min.js"></script>
<script src="/static/assets/scripts/klorofil-common.js"></script>
<script src="/static/assets/js/index.js"></script>

<script type="text/javascript">
    //JQ代码请在此处编写...
    //显示当前时间
    clock();
    var attime;

    function clock() {
        var time = new Date();
        attime = time.toLocaleTimeString();
        $("#time").text(attime);
    }
    setInterval(clock, 1000);
</script>

<script type="text/javascript">
    // $('document').ready(function() {
    //  $('.main').load('view/index-image.html');
    //  return false;
    // });
    // $("#yhgl").click(function() {

    // });
</script>
</body>
</html>
