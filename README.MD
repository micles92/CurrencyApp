Wymagania do uruchomienia aplikacji:
1. maven >= 3.0.5
2. java sdk >= 6


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
Zadania dostepne sa w pliku TODO.MD
-----------------------------------

** BRANCHE **
* Stage1 - podstawowa aplikacja: master-detail, filtrowanie

* Stage2 - Własne respozytoria + testy

...

