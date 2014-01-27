		<?php
			session_start();

			if(isset($_SESSION['logged'])){ //ca util sa nu vada fara sa fie logat
				?><html>
				<head>
					<title>Stergere</title>
					<style>
					    th{
					    	background-color: #006400;
					    }
						table,tr,td,th{
							border: 3px solid black;
							border-collapse: collapse;
						}
						td{
							background-color: yellow;
						}
						td:first-child{ 
							background-color: red;
						}
					</style>
					<script text="javascript">
						url="command.php";	//unde se afla scriptul la care trimit cererea
						function doRequest() { //face cererea
							  request = getXmlHttpRequest();
							  request.onreadystatechange = waitResponse;
							  request.open("GET", url + "?" + "do" + "=" + "10",true);
						      request.send("");
						}
						function doRequestFinal(i) { //face cererea
							  request = getXmlHttpRequest();
							  request.onreadystatechange = waitResponse;
							  request.open("GET", url + "?" + "do" + "=" + "18"+"&ind="+i,true);
						      request.send("");
						}
						function getXmlHttpRequest() { // furnizeaza obiectul XMLHttpRequest
						  try {
						    request = new XMLHttpRequest();
						  } catch (e) {
						    alert("Browserul nu poate lucra cu AJAX: " + e);
						    request = false;
						  }
						  return request;
						}

						function waitResponse() {
						  if (request.readyState == 4) { // cerere rezolvata
						    if (request.status == 200) // raspuns Ok
						      showResponse();
						    else
						      alert("Eroare request.status: " + request.status);
						  }
						}
						function showResponse() {
							if(request.responseText=="sters"){
						  		document.getElementById("rezultatfinal").innerHTML="Stergere efectuata cu succes!";
						  		setTimeout(doRequest(),1000);
						  		return;

							}
							var json=JSON.parse(request.responseText);
							var tab="<table><tr><th> </th><th>Data</th><th>Ora de inceput</th><th>Durata</th><th>Descriere</th></tr>";
							console.log(json.length);

							for(var i=0;i<json.length;i++){
								var tr="<tr onclick='doRequestFinal("+i+")'>";
								var x=json[i].split("~");
								for(var j=0;j<5;j++){
									tr=tr+"<td>"+x[j]+"</td>";
								}
								console.log(tr);
								tab=tab+tr+"</tr>";
							}
							tab=tab+"</table>";
						  	document.getElementById("rezultat").innerHTML=tab;
						}
					</script>
				</head>
				<body onload="doRequest()"> <!--ca sa nu mai apas pe buton, cand intra pe pag sa apeleze fct asta-->
					Aici e programul tau!<br>
					<div id="rezultat">
					</div>
					<div id="rezultatfinal">
					</div>
				</body>
				</html>
				<?php
			}
			else
				echo 'Fraiere nu esti logat!';

		?>