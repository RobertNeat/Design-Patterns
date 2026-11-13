---
title: Flyweight
category: Strukturalne
---

<span class="badge badge-category mb-3">Strukturalne</span>


<div class="pattern-section">
<h2>Pyłek</h2>
<div class="placeholder-box">

Pozwala zmieścić więcej obiektów w danej ilości pamięci RAM poprzez współdzielenie części ich stanu. Problem pojawia się, gdy trzeba utworzyć bardzo dużo podobnych obiektów, z których każdy przechowuje własną kopię danych, choć dane te są niemal identyczne we wszystkich instancjach, co prowadzi do wyczerpania pamięci. Rozwiązaniem jest podział stanu obiektu na stan wewnętrzny (niezmienny i powtarzalny) oraz stan zewnętrzny (unikalny dla każdej instancji). Tylko stan wewnętrzny zostaje zapisany w obiekcie-pyłku, natomiast stan zewnętrzny przekazuje się jako parametr metod, zwykle za pośrednictwem osobnej klasy kontekstowej, która przechowuje ten stan wraz z odniesieniami do pyłka. Pyłek musi być niezmienny i inicjalizowany tylko raz, za pomocą konstruktora. Za tworzenie i ponowne wykorzystywanie pyłków odpowiada zwykle fabryka pyłków, która przeszukuje pulę istniejących obiektów i zwraca pasujący albo tworzy nowy. Wzorzec stosuje się, gdy aplikacja tworzy ogromną liczbę podobnych obiektów silnie obciążających pamięć, a ich stany dają się rozdzielić na część współdzieloną i unikalną. Zaletą jest oszczędność pamięci RAM, a wadą możliwy wzrost użycia procesora przez wyliczanie danych kontekstowych oraz większa złożoność kodu.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Klasa Pyłek** – zawiera tę część pierwotnego stanu obiektu, która może być współdzielona pomiędzy wieloma instancjami. Ten sam obiekt pyłek może być wykorzystywany w wielu kontekstach. Stan przechowywany w pyłku nazywa się wewnętrznym, natomiast stan przekazywany metodom pyłka to dane zewnętrzne.
2. **Klasa kontekst** – zawiera opis zewnętrznego stanu, unikalnego dla każdego z pierwotnych obiektów. Gdy kontekst zostanie skojarzony z jednym z obiektów-pyłków, otrzymuje się reprezentację pełnego stanu pierwotnego obiektu.
3. Zazwyczaj **obowiązki pierwotnego obiektu** pozostają w klasie pyłka. W takim przypadku w momencie wywołania metody pyłka trzeba przekazać jej również odpowiednie elementy stanu zewnętrznego. Z drugiej strony obowiązki można przenieść do klasy kontekstowej, która korzysta ze skojarzonego pyłka tylko jako obiektu danych.
4. **Klient** – oblicza lub przechowuje zewnętrzny stan pyłków. Z punktu widzenia klienta pyłek to obiekt szablonowy, który może być skonfigurowany w trakcie działania programu poprzez przekazanie odpowiednich danych kontekstowych jako parametrów jego metod.
5. **Fabryka pyłków** – zarządza pulą istniejących pyłków. Dzięki fabryce klienci nie tworzą pyłków bezpośrednio. Zamiast tego wywołują fabrykę i przekazują jej fragmenty danych opisujących wewnętrzny stan pożądanego pyłka. Fabryka przegląda wcześniej utworzone pyłki i albo zwraca odpowiedni, albo tworzy nowy.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- program musi pracować z wielką liczbą obiektów, które ledwo mieszczą się w dostępnej pamięci RAM.
- przed zastosowaniem wzorca należy upewnić się, że program rzeczywiście ma potencjalny problem z wyczerpywaniem pamięci RAM wskutek jednoczesnego istnienia wielkiej liczby podobnych obiektów.
- warto rozważyć, czy problemu nie da się rozwiązać w inny sposób, ponieważ wzorzec Pyłek jest jedynie optymalizacją.

</div>
</div>
