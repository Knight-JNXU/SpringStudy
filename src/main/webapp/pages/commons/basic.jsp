<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/pages/commons/variables.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="Shortcut Icon" href="${base }/imges/v.jpg">
<title></title>
<meta charset="utf-8" />
</head>
<body>
		<%-- 顶部导航部分 --%>
		<tiles:insertAttribute name="header" />
		<%-- 内容部分 --%>
		<tiles:insertAttribute name="center" />
		<%-- 底部导航部分 --%>
		<tiles:insertAttribute name="footer" />
</body>
</html>