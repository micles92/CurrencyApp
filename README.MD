-----------------------------------
Uruchomienie projektu
-----------------------------------

Wymagania do uruchomienia aplikacji:

* maven >= 3.0.5

* java sdk >= 6


W celu uruchomienia aplikacji:

1. Uruchom startdb.bat lub  startdb.sh

2. W folderze aplikacji (np: C:\bookstore-app) uruchom z linii polecen:

mvn clean install jetty:run

3. Uruchom przegladarke i przejdz na ponizszy adres:

http://localhost:8080/bookstore


WAZNE:

W celu wygenerowania pliku eclipse'a nalezy wywolac w linii polecen:

mvn eclipse:eclipse

-----------------------------------
Technologie
-----------------------------------
* Java >= 1.6 

* Spring 3.1

* Hibernate 4.2

* JSF 2.1

* JSP 2.1

* Servlet 2.5

* Primefaces 5.1


** BRANCHE **

* master - podstawowa aplikacja: master-detail, filtrowanie, repozytoria, testy

* spring4 - TODO MLE/JFO - spring 4, Servlet 3.1, adnotacje

