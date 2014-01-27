		<?php
			session_start();

			if(isset($_SESSION['logged'])){ //ca util sa nu vada fara sa fie logat
				?>
				<html>
				<head>
					<title>Program</title>
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

						function valideaza(data, format){
								var valid=true;
								var delimitator='/';
								var splitData = data.datamea.value.split(delimitator);
								if(splitData.length != 3){
									alert("Nu e ok");
									return false;
								}
								var zi=splitData[0];    var day=parseInt(zi);
								var luna=splitData[1];  var month=parseInt(luna);
								var an=splitData[2];    var year=parseInt(an);
							
								if((month < 1)||(month > 12)) //verific daca luna ii buna
									valid = false;
								if((day < 1) || (day > 31)) //verific daca ziua ii buna
									valid = false;
								if(((month == 2) || (month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day > 30)) //verific luniile cu 31 de zile
									valid = false;
								if((month == 2) && (day > 28) && ((year % 4 != 0) || (year%100==0) || (year%400 !=0))) //verific daca e 29/02 in an bisect
									valid = false;
								if (valid == false)
									alert("Data invalida");
								else
									alert("Data valida");
							}
							var format = "/^(\d{1,2})\/(\d{1,2})\/(\d{4})$/";
						
						function doRequest() { //face cererea

							  request = getXmlHttpRequest();
							  request.onreadystatechange = waitResponse;
							  request.open("GET", url + "?" + "do" + "=" + "10",true);
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
							var json=JSON.parse(request.responseText);
							var tab="<table><tr><th> </th><th>Data</th><th>Ora de inceput</th><th>Durata</th><th>Descriere</th></tr>";
							console.log(json.length);

							for(var i=0;i<json.length;i++){
								var tr="<tr>";
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
				</body>
				</html>
				<?php
			}
			else
				echo 'Fraiere nu esti logat!';

		?>