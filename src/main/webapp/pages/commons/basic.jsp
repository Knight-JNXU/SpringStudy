<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%-- <%@ include file="/pages/commons/commonvariable.jsp"%> --%>

<link rel="Shortcut Icon" href="${base }/imges/v.jpg"">
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="center" />
	<tiles:insertAttribute name="footer" />
</body>
</html>