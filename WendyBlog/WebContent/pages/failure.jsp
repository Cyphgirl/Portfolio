<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
<title>
Failure
</title>
</head>
<body>
<h1>Sorry <bean:write name="LoginForm" property="username"/> that is the wrong password</h1>
<br />
<bean:write name="LoginForm" property="uid"/>UID
</body>
</html>