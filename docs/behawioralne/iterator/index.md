---
title: Iterator
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Iterator</h2>
<div class="placeholder-box">

Pozwala sekwencyjnie przechodzić przez elementy kolekcji bez ujawniania jej wewnętrznej struktury (lista, drzewo, graf itd.). Wzorzec proponuje wyodrębnienie logiki przechodzenia po elementach do osobnego obiektu–iteratora, zamiast trzymać ją w samej kolekcji. Iterator hermetyzuje szczegóły procesu, takie jak bieżąca pozycja czy liczba pozostałych elementów, i udostępnia zwykle jedną główną metodę pobierającą kolejny element, wywoływaną przez klienta aż do wyczerpania zbioru. Wszystkie iteratory implementują wspólny interfejs, dzięki czemu kod klienta może współpracować z dowolną kolekcją i dowolnym sposobem jej przeglądania, nie znając ich konkretnych klas. Umożliwia to też jednoczesne, niezależne przeglądanie tej samej kolekcji przez wiele iteratorów, z których każdy posiada własny stan. Ograniczeniem jest to, że wprowadzenie wzorca do prostych kolekcji bywa przesadą, a dostęp przez iterator może być mniej wydajny niż bezpośrednie przechodzenie po elementach wyspecjalizowanej struktury danych.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Interfejs iteratora** – deklaruje wywołania niezbędne do sekwencyjnego przechodzenia przez elementy kolekcji, takie jak pobieranie kolejnego elementu, ustalenie bieżącej pozycji, powrót do pierwszego elementu itp.
2. **Konkretne iteratory** – implementują specyficzne algorytmy przeglądania kolekcji. Obiekt iteratora powinien samodzielnie śledzić postęp tego procesu. Pozwala to wielu iteratorom na jednoczesne przeglądanie tej samej kolekcji.
3. **Interfejs kolekcji** – deklaruje jedną lub więcej metod służących zapewnieniu kompatybilności kolekcji z iteratorami. Zwracany typ metody musi być zadeklarowany jako interfejs iteratora, aby konkretne kolekcje mogły zwracać różne rodzaje iteratorów.
4. **Konkretne kolekcje** – zwracają nowe instancje konkretnych klas iteratorów za każdym razem, gdy klient ich zażąda.
5. **Klient** – współpracuje zarówno z kolekcjami, jak i iteratorami za pośrednictwem ich interfejsów. Dzięki temu nie jest sprzężony z konkretnymi klasami, co pozwala na pracę z różnymi kolekcjami i iteratorami w tym samym kodzie klienta.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- kolekcja posiada skomplikowaną strukturę, która powinna być ukryta przed klientem.
- redukcja duplikowania kodu odpowiedzialnego za przeglądanie elementów zbiorów w różnych częściach programu.
- kod powinien być w stanie przeglądać elementy różnych struktur danych lub nie znać szczegółów ich wewnętrznej struktury.


</div>
</div>
