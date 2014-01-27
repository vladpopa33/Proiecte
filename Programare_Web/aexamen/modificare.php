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
							  request = getXmlHttpRequest();
							  request.onreadystatechange = waitResponse;
							  request.open("GET", url + "?" + "do" + "=" + "10", true);
						      request.send("");
						}

						function doRequestFinal(v,i,c) { //face cererea
							request = getXmlHttpRequest();
							request.onreadystatechange = waitResponse;
							request.open("GET", url + "?" + "do" + "=" + "92"+"&"+"ind1="+i+"&ind2="+c+"&v="+v, true);
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

							if(request.responseText=="modificat"){
								  	document.getElementById("rezultatfinal").innerHTML="Modificat cu succes!";
								  	return;
							}

							var json=JSON.parse(request.responseText);
							var tab="<table><tr><th> </th><th>Data</th><th>Ora de inceput</th><th>Durata</th><th>Descriere</th></tr>";
							console.log(json.length);

							for(var i=0;i<json.length;i++){
								var tr="<tr id="+i+">";
								var x=json[i].split("~");
								for(var j=0;j<5;j++){
									if(j==3)
										tr=tr+"<td><input type='text' value='"+x[j]+"' onblur='doRequestFinal(this.value,"+i+",1)'></td>";
									if(j==4)
										tr=tr+"<td><input type='text' value='"+x[j]+"' onblur='doRequestFinal(this.value,"+i+",2)'></td>";
									if(j==0||j==1||j==2)
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
				<body  onload="doRequest()">
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