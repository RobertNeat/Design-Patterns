---
title: Decorator
category: Strukturalne
---

<span class="badge badge-category mb-3">Strukturalne</span>

<div class="pattern-section">
<h2>Dekorator</h2>
<div class="placeholder-box">

Pozwala dynamicznie dodawać obiektom nowe obowiązki poprzez umieszczenie ich w specjalnych obiektach opakowujących (nakładkach). Rozwiązuje problem, w którym rozszerzenie zachowania przez dziedziczenie prowadzi do kombinatorycznej eksplozji podklas (np. osobna podklasa dla każdej kombinacji sposobów powiadamiania), a samo dziedziczenie jest statyczne i pozwala mieć tylko jedną klasę-rodzica. Zamiast tego wzorzec stosuje kompozycję: dekorator implementuje ten sam interfejs co opakowywany obiekt (komponent), przechowuje do niego referencję i deleguje mu wywołania, dodając własne działanie przed lub po przekazaniu żądania. Dzięki wspólnemu interfejsowi dekoratory można nakładać na siebie warstwami, tworząc stos. Klient korzysta z ostatniego dekoratora w stosie tak samo jak z obiektu bazowego, nie wiedząc, czy jest on 'udekorowany'. Wzorzec stosuje się, gdy potrzeba przypisywać dodatkowe obowiązki w trakcie działania programu, bez psucia kodu klienckiego, albo gdy rozszerzenie klasy poprzez dziedziczenie jest niepraktyczne lub niemożliwe. Wadami są trudność w usunięciu pojedynczej nakładki ze środka stosu, trudność w uniezależnieniu zachowania dekoratora od kolejności nakładania oraz nieelegancki kod konfigurujący wiele warstw.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Komponent** – deklaruje interfejs wspólny zarówno dla nakładek, jak i opakowywanych obiektów.
2. **Konkretny komponent** – klasa opakowywanych obiektów. Definiuje podstawowe zachowanie, które następnie można zmieniać za pomocą dekoratorów.
3. Klasa **bazowy dekorator** – posiada pole przeznaczone na referencję do opakowywanego obiektu. Typ pola powinien być zadeklarowany jako interfejs komponentu, aby mogło przechowywać zarówno konkretne komponenty, jak i inne dekoratory. Dekorator bazowy deleguje wszystkie działania opakowywanemu obiektowi.
4. **Konkretni dekoratorzy** – definiują dodatkowe zachowania, które można przypisać do komponentów dynamicznie. Nadpisują metody dekoratora bazowego i wykonują swoje działania albo przed, albo po wywołaniu metody klasy-rodzica.
5. **Klient** – może opakowywać komponenty w wiele warstw dekoratorów, o ile działa na wszystkich obiektach przez interfejs komponentu.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- potrzeba przypisywać dodatkowe obowiązki obiektom w trakcie działania programu bez psucia kodu, który z tych obiektów korzysta,
- rozszerzenie zakresu obowiązków obiektu za pomocą dziedziczenia byłoby niepraktyczne lub niemożliwe.

</div>
</div>
