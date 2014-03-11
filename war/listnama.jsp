<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head><title>Daftar Biodata</title></head>
	<body>
		<h1>Daftar Biodata</h1>
		<table border="1">
			<tr>
				<th>Nama </th>
				<th>NIM </th>
			</tr>	
			<c:forEach var="satuNama" items="${daftarNama}">
				<tr>
					<td>${satuNama.properties.fieldNama}</td>
					</c:forEach>
					<c:forEach var="satuNim" items="${daftarNim}">
					<td>${satuNim.properties.fieldNim}</td>
				</tr>
			</c:forEach>
		</table>		
	</body>
</html>