<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lomake</title>

<style>
	body {
		text-align: center;
	}
</style>

</head>
<body>

<h1>Syötä tiedot alla oleviin kenttiin</h1>

<form action="nayta.jsp" method="post">
	<p><label for="etunimi">Anna etunimi: </label>
	<input type="text" id="etunimi" name="etunimi" /></p>
	
	<p><label for="sukunimi">Anna sukunimi: </label>
	<input type="text" id="sukunimi" name="sukunimi" /></p>
	
	<p><label for="sahkoposti">Anna sähköpostiosoite: </label>
	<input type="text" id="sahkoposti" name="sahkoposti" placeholder="joku@example.com" /></p>
	
	<p><label for="puhelin">Anna puhelinnumero: </label>
	<input type="text" id="puhelin" name="puhelin" /></p>
	
	<p><label for="syntymavuosi">Anna syntymävuosi: </label>
	<input type="text" id="syntymavuosi" name="syntymavuosi" /></p>
	
	<input type="submit" value="Lähetä" />
</form>

</body>
</html>