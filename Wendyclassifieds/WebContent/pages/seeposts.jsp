<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
</head>
<body>
<h1>Posts by <bean:write name="LoginForm" property="username"/></h1>
 
<logic:iterate name="listPosts" id="listPostId">
<p>
	<bean:write name="listPostId" property="date"/> <br/> 
	<h2><bean:write name="listPostId" property="title"/></h2>
	<h2>Location: <bean:write name="listPostId" property="location"/></h2>
	<bean:write name="listPostId" property="body"/><br/>
</p>
<br/>
<br/>
</logic:iterate>
 
</body>
</html>