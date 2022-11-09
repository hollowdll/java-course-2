<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Calendar" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>N�yt� tiedot</title>

<style>
	body {
		text-align: center;
	}
</style>

</head>
<body>

<h1>Antamasi tiedot</h1>

<%
	String etunimi = request.getParameter("etunimi");
	String sukunimi = request.getParameter("sukunimi");
	String sahkoposti = request.getParameter("sahkoposti");
	String puhelin = request.getParameter("puhelin");
	String syntymavuosi = request.getParameter("syntymavuosi");
	
	// nykyinen vuosi
	Calendar calendar = Calendar.getInstance();
	int vuosi = calendar.get(Calendar.YEAR);
	int ika;
	
	try {
		ika = vuosi - Integer.parseInt(syntymavuosi);
		
	} catch (Exception e) {
		System.out.println(e);
		//e.printStackTrace();
		ika = 0;
	}
	
	if (ika >= 18) {
		out.print("<p>Etunimi: " + etunimi + "</p>\n");
		out.print("<p>Sukunimi: " + sukunimi + "</p>\n");
		out.print("<p>S�hk�postiosoite: " + sahkoposti + "</p>\n");
		out.print("<p>Puhelinnumero: " + puhelin + "</p>\n");
		out.print("<p>Ik�: " + ika + "</p>\n");
		
	} else {	// alaik�inen
		out.print("<p id='alaikainen'>Alaik�inen</p>\n");
		out.print("<p>Palaat takaisin lomakkeeseen: <span id='redirect-countdown'></span></p>\n");
	}
%>

<a href="kysy.jsp">Takaisin</a>

<script>
	const alaikainen = document.getElementById("alaikainen");
	const redirectCountdown = document.getElementById("redirect-countdown");
	
	if (alaikainen !== null && redirectCountdown !== null) {	// Jos alaik�inen
		let countdown = 5;
		redirectCountdown.innerText = countdown;
		const redirectTimer = setInterval(() => {		// L�het� takaisin 5 sekunnin viiveell�
			countdown -= 1;
			redirectCountdown.innerText = countdown;
			if (countdown == 0) {
				clearInterval(redirectTimer);
				window.location = "kysy.jsp";
			}
		}, 1000);
	}
</script>

</body>
</html>