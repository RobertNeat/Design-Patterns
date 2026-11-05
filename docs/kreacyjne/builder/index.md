---
title: Builder
category: Kreacyjne
---

<span class="badge badge-category mb-3">Kreacyjne</span>

<div class="pattern-section">
<h2>Budowniczy</h2>
<div class="placeholder-box">

Pozwala tworzyć złożone obiekty etapami, krok po kroku, oraz produkować różne typy i reprezentacje obiektu przy użyciu tego samego kodu konstrukcyjnego. Wzorzec proponuje wyodrębnić kod konstrukcyjny z klasy produktu i umieścić go w osobnych obiektach, zwanych budowniczymi. Konstrukcja jest podzielona na etapy, z których wywołuje się tylko te, które są potrzebne do uzyskania danej konfiguracji obiektu. Dzięki temu unika się zarówno mnożenia podklas, jak i "teleskopowych konstrutorów" przyjmujących mnóstwo opcjonalnych parametrów. Różni konkretni budowniczowie implementują te same etapy w odmienny sposób, więc ten sam proces może dać różne reprezentacje produktu, pod warunkiem, że wszyscy współdzielą wspólny interfejs budowniczego. Opcjonalnie kolejność wywołań etapów można przenieść do klasy kierownika, która ukrywa szczegóły konstrukcji przed klientem. Wynik pobiera się od budowniczego, a nie od kierownika, ponieważ produkty różnych budowniczych nie muszą mieć wspólnego interfejsu. Ograniczeniem jest wzrost złożoności kodu, ponieważ wdrożenie wzorca wymaga dodawania wielu klas.
</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Interfejs budowniczego** deklaruje etapy konstrukcji produktu wspólne dla wszystkich typów budowniczych.
2. **Konkretni budowniczy** zapewniają różne implementacje etapów konstrukcji. Konkretni budowniczy mogą tworzyć produkty, które nie mają wspólnego interfejsu.
3. **Produkty** to powstałe obiekty. Produkty konstruowane przez różnych budowniczych nie muszą należeć do tej samej hierarchii klas, czy interfejsu.
4. **Klasa kierownik** definiuje kolejność w jakiej należy wywołać etapy konstrukcyjne, aby móc stworzyć i następnie użyć ponownie określone konfiguracje produktów.
5. **Klient** musi dopasować jeden z obiektów budowniczych do kierownika. Następnie kierownik za pomocą obiektu budowniczego wykonuje dalszą konstrukcję. Jednakże istnieje alternatywne podejście w przypadku przekazania obiektu budowniczego metodzie produkcyjnej kierownika . W takim przypadku kierownik może skorzystać z różnych budowniczych.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- pozbycie się "teleskopowych konstruktorów"
- potrzeba możliwości tworzenia różnych reprezentacji jakiegoś produktu
- konstruowanie drzew Kompozytowych lub innych złożonych obiektów

</div>
</div>
