Autor: Popa Razvan-Vlad
Grupa: 235
Data:  23.10.2013
User:  prir1147

PDPJ : Programare distribuita - platforme Java 

Laborator 1
Procese externe

_______________________________________________________________________________________
ENUNTUL PROBLEMEI

A. Sa se scrie un program Java care porneste un proces extern si afiseaza rezultatul executiei procesului. 
Procesul extern va afisa setarile de retea (IPv4, Netmask, Gateway, DNS, Physical Address) ale statiei
locale. Se va folosi comanda ipconfig pentru Windows si ifconfig pentru
Unix/Linux.
Rezultatul executiei procesului se va prelucra in procesul Java si se va afisa in formatul urmator:
"IPv4"     "Netmask"      "Gateway"    "DNS"    "Physical Address".

Apoi tot din programul Java se vor porni trei thread-uri. Fiecare din ele vor prelua rezultatele de mai sus
si le vor afisa dupa cum urmeaza:

B.
Primul thread va scrie valoarea/valorile din coloana "IPv4" intr-un fisier: "ips.txt"
Informatia scrisa in fisier va fi sub forma: "ip","timpul scrierii" (exemplu: "192.168.1.1","1314348462672")
Thread-ul va scrie in fisier la intervale aleatoare de timp.

C.
Al doilea thread va scrie valoarea/valorile din coloana "Physical Address" intr-un fisier: "macs.txt"
Informatia scrisa in fisier va fi sub forma: "Physical Address","timpul scrierii" (exemplu: "1C-6F-65-AC-AB-62","1314348462682")
Thread-ul va scrie in fisier la intervale aleatoare de timp.

D.
Al treilea thread astepta terminarea celor 2 thread-uri de mai sus si va afisa intr-un fisier "rezultate.txt" numarul de ip-uri distincte, numarul de mac-uri distincte
precum si maximul din coloana "timpul scrierii" din ambele fisiere("ips.txt", "macs.txt").
Ex.: "rezultate.txt"
Ip-uri distincte: 1
Mac-uri distincte: 2
Timp maxim: 1314348462682

Observatii:
 1. Se va folosi un template de proiect: exemplu de template se poate gasi la partea de documentatie/instructiuni.
 2. Template-ul folosit va trebui sa contina un fisier de build pentru utilitarul ANT.
 3. Toate afisarile vor trebui facute folosind utilitarul log4j.


_____________________________________________________________________________________________
ASPECTE TEORETICE

 - s-au folosit urmatoarele tehnologii:
   1. JAVA - procese externe si threaduri
   2. ANT
   3. log4j

_____________________________________________________________________________________________
PREZENTAREA SOLUTIEI

Problema functioneaza...

_____________________________________________________________________________________________
INSTRUCTIUNI DE RULARE
Apasa run

