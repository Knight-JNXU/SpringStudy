<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/4/11
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

base:${base }<br>
国际化：<spring:message code="menu.welcome"/><br>
<img src="${base }/imges/v.jpg"/><br>
<input type="text" id="menuInputId" value="memupage">

<script src="${base }/js/commons/jquery-3.2.1.min.js"></script>
<script src="${base }/js/menu/menupagejs.js"></script>
