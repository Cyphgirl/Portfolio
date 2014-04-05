<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<html>
<head>
<title>New Member</title>
</head>
<body>
	<h1>New Member Registration</h1>
	<html:form action="/createmem.do">
User name: <html:text name="CreateMember" property="username" />
		<br />
Password: <html:text name="CreateMember" property="pswd" />
		<br />
Confirm Password: <html:text name="CreateMember" property="pswdconf" />
		<logic:present name="CreateMember" property="pswdconf">Passwords must match </logic:present>
		<br />
Name: <html:text name="CreateMember" property="name" />
		<br />
E-Mail:<html:text name="CreateMember" property="email" />
		<br />
Location:<html:text name="CreateMember" property="location" />
		<br />
Telephone: <html:text name="CreateMember" property="telno" />
		<br />
About me:<html:textarea name="CreateMember" property="bio" />
		<br />
		<html:submit />
	</html:form>

</body>
</html>