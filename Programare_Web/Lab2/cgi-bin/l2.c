#include <stdio.h>
#include <stdlib.h>
#include <string.h>
void main(){
char calcul[20],rez[10],rasp[3];
int i,j,rezultat,raspuns,nrcorecte,nrintreb;
printf("Content-type: text/html\n\n");
char *answer = getenv("QUERY_STRING");
if(strlen(answer)<2){	//prima intrebare
	nrintreb=0;
	nrcorecte=0;
	strcpy(rasp,"");
}
else{
	char *token;
	token = strtok(answer, "=+&");
	j=0;
	while( token != NULL ) //separ datele din get
  	    {
	    if(j==1)
		strcpy(rasp,token);
	    if(j==2)
		nrintreb=atoi(token);
	    if(j==4)
		nrcorecte=atoi(token);
	    j++;
	    token = strtok(NULL, " =+&");
	    }
}
	FILE *fr;
	fr = fopen ("date.txt", "r");

	if(fr==NULL){
		printf("Eroare deschidere fisier");
		fflush(stdout);
	}
	char* date=malloc(30);
	i=0;
	while(fgets(date, 30, fr) != NULL){
		char *token;
		token = strtok(date, " ");
		if(i==nrintreb-1){	//rezultatul intrebarii anterioare
			j=0;
			while( token != NULL ) 
		  	    {
			    if(j==3)
				strcpy(rez,token);
			    j++;
			    token = strtok(NULL, " ");
			    }
			}
		if(i==nrintreb){	//intrebarea curenta
			j=0;
			while( token != NULL ) 
		  	    {
			    if(j==1)
				strcpy(calcul,token);
			    j++;
			    token = strtok(NULL, " ");
			    }
			}
		i++;
		}
	//printf("calcul=%s<br>rez=%s<br>nrintreb=%d<br>rasp=%s",calcul,rez,nrintreb,rasp);
	int r1=atoi(rez),r2=atoi(rasp);
	if(r1==r2)	//verific raspunsul
		nrcorecte++;
	if(nrintreb==i)	//a raspuns la ultima intrebare
		printf("Felicitari! Ati raspuns corect la %d intrebari",nrcorecte-1);
	else{	
		printf("<html><head><title>Intrebari</title></head><body><form action=\"l2.cgi\" method=\"GET\"><br>Introduceti raspunsul si numarul de ordine pentru intrebarea de mai jos:<br>   %d. %s = <br><input type=\"text\" name=\"rez\"><br><input type=\"hidden\" name=\"nr\" value=%d><br><input type=\"submit\" value=\"Urmatoarea intrebare \"> </form></body></html>",nrintreb+1,calcul,nrcorecte);
	}
}     

