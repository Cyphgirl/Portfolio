<%@taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Login Page</title>
</head>
<body>
<div style="color:red">
<html:errors />
</div>
<html:form action="/login" >
User Name :<html:text name="LoginForm" property="username" />
Password  :<html:password name="LoginForm" property="password" />
<html:submit value="login" />
</html:form>
</body>
</html>