---
title: Template Method
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Metoda szablonowa</h2>
<div class="placeholder-box">

Definiuje szkielet algorytmu w klasie bazowej, ale pozwala podklasom nadpisywać poszczególne etapy bez zmiany jego struktury. Wzorzec proponuje podzielenie algorytmu na etapy, przekształcenie ich w metody i umieszczenie ciągu ich wywołań w jednej metodzie szablonowej. Etapy mogą być abstrakcyjne (podklasa musi je zaimplementować) albo posiadać domyślną implementację (podklasa może ją nadpisać). Dodatkowo można stosować hooki, czyli proste opcjonalne etapy umieszczane przed i po istotnych krokach algorytmu, które dają podklasom punkty zaczepienia do jego rozbudowy. Dzięki temu wspólny kod trafia do klasy bazowej, a podklasy zawierają tylko to, co je różni. Ograniczeniem jest to, że wzorzec opiera się na dziedziczeniu, więc działa na poziomie klasy i nie pozwala zmieniać zachowania w trakcie działania programu (w przeciwieństwie do wzorca Strategia). Ponadto szkielet algorytmu może być dla niektórych klientów zbyt sztywny, a nadpisywanie domyślnych etapów może naruszać zasadę podstawienia Liskov. Metodę szablonową trudniej też utrzymywać wraz ze wzrostem liczby etapów.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Klasa abstrakcyjna** – deklaruje metody stanowiące etapy algorytmu oraz właściwą metodę szablonową, która wywołuje poszczególne etapy w określonej kolejności. Etapy mogą być zadeklarowane jako abstrakcyjne albo posiadać domyślną implementację.
2. **Konkretne klasy** – mogą nadpisywać każdy z etapów algorytmu, z wyjątkiem samej metody szablonowej.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- zezwolenie klientom na rozszerzanie niektórych etapów algorytmu (nie całego algorytmu ani jego struktury).
- wiele klas zawiera niemal identyczne algorytmy, różniące się jedynie szczegółami.

</div>
</div>
