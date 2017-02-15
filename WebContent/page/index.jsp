<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="HK" uri="jstlTest" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
    <title>index</title>
    <HK:lang key="tt"/>
    <HK:tokenTag></HK:tokenTag>
    <HK:role action="ddd" menu="111">3333333333</HK:role>
  </head>
  <body>
index
  </body>
</html>
