<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Booking</title>
</head>
<body>

<h1>Create a booking</h1>

<form action="/webapi/myresource/create" method ="post">

	Start Date: <input type="text" name="start_date"><br/>
	
	End Date: <input type="text" name="end_date"><br/>
	
	Customer ID: <input type="number" name="cust_id"><br/>
	
	Car ID: <input type="number" name="car_id"><br/>
	
	<input type="submit" value="Create Booking">

</form>
</body>
</html>