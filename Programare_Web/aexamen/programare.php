		<?php
			session_start();

			if(isset($_SESSION['logged'])){ //ca util sa nu vada fara sa fie logat
				?>
				<html>
				<head>
					<title>Program</title>
					<script text="javascript">
						url="command.php";	//unde se afla scriptul la care trimit cererea
						function doRequest() { //face cererea
							  if(valideaza(document.getElementById("data").value,format)==false){
							  	alert("Data invalida!");
							  	return;
							  }

							  request = getXmlHttpRequest();
							  request.onreadystatechange = waitResponse;
							  request.open("GET", url + "?" + "do" + "=" + "26"+"&"+"data="+document.getElementById("data").value+"&"+"ora="+document.getElementById("ora").value+"&"+"durata="+document.getElementById("durata").value+"&"+"descriere="+document.getElementById("descriere").value, true);
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
						  document.getElementById("rezultat").innerHTML=request.responseText;
						}
						function valideaza(data, format){
								var valid=true;
								var delimitator='/';
								var splitData = data.split(delimitator);
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
									return false;
								else
									return true;
							}
						var format = "/^(\d{1,2})\/(\d{1,2})\/(\d{4})$/";
						
					</script>
				</head>
				<body>
					Data: <input type="text" id="data"><br>
					Ora: <input type="text" id="ora"><br>
					Durata: <input type="text" id="durata" size="3">h<br>
					Descriere: <input type="text" id="descriere" size="5"><br>
					<input type="button" value="Save" onclick="doRequest()">
					<div id="rezultat">
					</div>
				</body>
				</html>
				<?php
				}
			else
				echo 'Fraiere nu esti logat!';

		?>