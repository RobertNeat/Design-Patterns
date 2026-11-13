---
title: Facade
category: Strukturalne
---

<span class="badge badge-category mb-3">Strukturalne</span>


<div class="pattern-section">
<h2>Fasada</h2>
<div class="placeholder-box">
Wyposaża złożoną bibliotekę, framework lub zestaw klas w uproszczony interfejs. Problem pojawia się, gdy kod musi współdziałać z wieloma obiektami skomplikowanego podsystemu - trzeba je inicjalizować we właściwej kolejności, śledzić zależności i wywoływać metody w odpowiednim porządku, co ściśle sprzęga logikę biznesową ze szczegółami implementacji tego podsystemu. Rozwiązaniem jest stworzenie klasy fasady, która daje prosty interfejs do wąskiego zakresu funkcji, faktycznie potrzebnych klientowi, ukrywając resztę złożoności podsystemu. Klasy podsystemu nie wiedzą o istnieniu fasady i mogą nadal komunikować się między sobą bezpośrednio. Gdy jedna fasada zaczyna się rozrastać można wydzielić dodatkowe fasady dla poszczególnych warstw podsystemu, dzięki czemu warstwy komunikują się ze sobą wyłącznie poprzez fasady (co przypomina wzorzec Mediator). Zaletą jest odizolowanie kodu klienckiego od złożoności podsystemu - aktualizacja lub wymiana podsystemu wymaga zmiany tylko w kodzie fasady. Wadą jest ryzyko, że fasada stanie się 'boskim obiektem' sprzężonym ze wszystkimi klasami aplikacji.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Fasada** – daje wygodny dostęp do pewnego zakresu funkcjonalności podsystemu. Wie, dokąd przekierować żądanie klienta i jak pokierować wszystkimi szczegółami.
2. Można stworzyć klasę **dodatkowa fasada**, aby zapobiec zaśmiecaniu pojedynczej fasady niepotrzebnymi funkcjami, które ponownie ograniczyłyby prostotę używania. Dodatkowe fasady mogą być wykorzystywane zarówno przez klienta, jak i przez inne fasady.
3. **Złożony podsystem** – składa się z wielu różnych obiektów. Aby mogły one wszystkie wykonywać coś pożytecznego, trzeba je zainicjalizować we właściwej kolejności i przekazać im dane w odpowiednim formacie. Klasy podsystemu nie są świadome istnienia fasady. Działają wewnątrz systemu i współpracują ze sobą bezpośrednio.
4. **Klient** – korzysta z fasady zamiast wywoływać obiekty podsystemu bezpośrednio.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- potrzeba ograniczonego, ale łatwego w użyciu interfejsu do złożonego podsystemu,
- potrzeba ustrukturyzować podsystem w warstwy.

</div>
</div>

