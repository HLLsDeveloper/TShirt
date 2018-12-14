<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entre em contato</title>
</head>
<body>
	<form action="Email" method="post">
		<label>Nome</label>
		<input type="text" name="nome">
		<label>Email</label>
		<input type="text" name="email">
		<label>Assunto</label>
		<input type="text" name="assunto">
		<label>Mensagem</label>
		<input type="text" name="msg">
		
		<button type="submit">Enviar</button>
	</form>
</body>
</html>