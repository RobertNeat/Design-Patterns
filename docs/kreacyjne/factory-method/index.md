---
title: Factory Method
category: Kreacyjne
---

<span class="badge badge-category mb-3">Kreacyjne</span>

<div class="pattern-section">
<h2>Metoda wytwórcza</h2>
<div class="placeholder-box">
Udostępnia interfejs do tworzenia obiektów w ramach klasy bazowej, ale pozwala podklasom zmieniać typ tworzonych obiektów.
Wzorzec proponuje zmianę bezpośrednich wywołań konstruktorów obiektów (wykorzystujących operator new) na wywołania specjalnej metody wytwótrczaj.
Metoda wytwórcza wewnętrznie wywołuje operator new i zwraca obiekt (nazywany potocznie produktem). Dzięki przeniesieniu wywołania konstruktora możliwe jest nadpisanie metody wytwórczej w podklasie i tym samym zmienić klasę produktów zwracanych przez metodę. Ograniczeniem jest to, że podklasy mogą zwracać różne typy produktów tylko wtedy, gdy produkty te mają wspólną klasę bazową lub wspólny interfejs. Zwracany typ metody wytwórczej w klasie bazowej powinien być zgodny z tym interfejsem.
</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Produkt** deklaruje interfejs, który jest wspólny dla wszystkich obiektów zwracanych przez twórcę oraz jego podklasy.

2. **Konkretne produkty** są różnymi implementacjami interfejsu produktów.

3. klasa **Twórca** deklaruje metodę wytwórczą, która zwraca nowe obiekty-produkty. Istotne jest to, że typ zwracany przez tę metodę jest zgodny z interfejsem produktu.

4. konkretni **Twórcy** nadpisują bazową metodę wytwórczą, co sprawia, że zwraca inny typ obiektu.

Metoda wytwórcza nie musi tworzyć nowych instancji, ale może zwrócić istniejący już obiekt z pamięci podręcznej, puli obiektów lub z innego źródła.
</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- gdy nie wiadomo, jakie typy obiektów pojawią się w programie i jakie będą między nimi zależności,

- gdy trzeba pozwolić na rozbudowę biblioteki lub frameworka,

- oszczędzanie zasobów systemowych poprzez ponowne wykorzystanie istniejących obiektów zamiast budować nowe od zera.

</div>
</div>
