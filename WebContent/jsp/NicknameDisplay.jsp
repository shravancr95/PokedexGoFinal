<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		"<style>"
			table {
			    font-family: arial, sans-serif;
			    border-collapse: collapse;
			    width: 100%;
			}

			td, th {
			    border: 1px solid #dddddd;
			    text-align: left;
			    padding: 8px;
			}
		tr:nth-child(even) {
		    background-color: #dddddd;
		}
		</style>
		</head>
		<body>
		
		<table>
		  <tr>
		  	<th>Icon</th>
			<th>Pokemon</th>
		    <th>Nickname</th>
		    <th>Explanation</th>
		 
		  </tr>
		  <%=session.getAttribute("rows") %>
		</table>
</body>
</html>