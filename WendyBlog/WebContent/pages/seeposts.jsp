<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<html>
<head>
</head>
<body>
	<h1>
		Posts by
		<logic:equal name="ViewPost" property="uidTargetAll" value="true"> all Members </logic:equal>
		<logic:notEqual name="ViewPost" property="uidTargetAll" value="true">
			<bean:write name="LoginForm" property="username" />
		</logic:notEqual>
	</h1>
<html:link page="/pages/success.jsp"> Go Back </html:link><br/>
	<logic:iterate name="listPosts" id="listPostId">
		
			<bean:write name="listPostId" property="date" />
			<br />
			by: <bean:write name="listPostId" property="name" />
		<h2>
			<bean:write name="listPostId" property="title" />
		</h2>
		<h2>
			Location:
			<bean:write name="listPostId" property="location" />
		</h2>
		<bean:write name="listPostId" property="body" />
		<br />
		
		<br />
		<br />
	</logic:iterate>
<html:link page="/pages/success.jsp"> Go Back </html:link>

</body>
</html>