<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<form action="createBlog" >
<input type="submit" value="Create new blog">
</form>
<p> ${blogConent} </p>
</body>
</html>
