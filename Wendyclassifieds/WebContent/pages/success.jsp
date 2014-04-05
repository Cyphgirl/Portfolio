<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<html>
<head>
<title>Success</title>
</head>
<body>
<h1>Welcome <bean:write name="LoginForm" property="username"/>!</h1>
<html:form action="/allposts">
<html:hidden name="ViewPost" property="uidTargetAll" value="true"/>
<html:submit value="See all posts" />
</html:form>
<html:form action="/posts">
<html:submit value="See my posts" />
</html:form>
<html:form action="/post">
Title:<html:text property="title"/>
<br/>Location:<html:text property="location"/>
<br/>
<html:textarea property="body"/>
<html:submit/>
</html:form>
</body>
</html>