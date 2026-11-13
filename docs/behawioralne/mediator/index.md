---
title: Mediator
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Mediator</h2>
<div class="placeholder-box">

Ogranicza chaotyczne, bezpośrednie zależności między obiektami, zmuszając je do komunikacji wyłącznie za pośrednictwem osobnego obiektu-mediatora. Wzorzec proponuje, by komponenty nie wywoływały się wzajemnie, lecz jedynie powiadamiały mediatora o zdarzeniach, przekazując mu ewentualne dane kontekstowe. Mediator, otrzymawszy powiadomienie, sam decyduje, który komponent i jak powinien zareagować. Dzięki temu hermetyzuje w sobie całą sieć wzajemnych relacji. Komponenty znają jedynie wspólny interfejs mediatora, a nie konkretne klasy innych komponentów ani nawet konkretną klasę samego mediatora, co czyni je łatwiejszymi do ponownego użycia w innych kontekstach. Wystarczy podłączyć je do innej implementacji mediatora. Ograniczeniem jest ryzyko, że mediator z czasem przyjmie zbyt wiele odpowiedzialności i przerodzi się w rozrośnięty, trudny do utrzymania obiekt centralny (tzw.'boski obiekt').

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Komponenty** – różne klasy zawierające jakąś logikę biznesową. Każdy komponent posiada odniesienie do mediatora, zadeklarowane jako typ interfejsu mediatora. Komponent nie jest świadomy faktycznej klasy obiektu mediatora, więc można go używać ponownie w innych programach, łącząc z innym mediatorem.
2. **Interfejs mediatora** – deklaruje metody komunikacji z komponentami, które na ogół ograniczają się do jednej metody powiadamiania. Komponenty mogą przekazywać dowolny kontekst jako argument tej metody, włącznie z samym sobą, ale wyłącznie w sposób, który nie spowoduje sprzęgnięcia komponentu otrzymującego powiadomienie z klasą nadawcy.
3. **Konkretni mediatorzy** – hermetyzują relacje pomiędzy różnorodnymi komponentami. Konkretni mediatorzy często przechowują odniesienia do wszystkich komponentów, jakimi zarządzają, a czasem nawet zarządzają ich cyklem życia.
4. **Komunikacja komponentów** – komponenty nie są świadome istnienia innych komponentów. Jeśli coś istotnego zdarzy się w jednym z nich, musi on powiadomić wyłącznie mediatora. Gdy ten otrzyma powiadomienie, może w prosty sposób zidentyfikować nadawcę i zdecydować, który komponent uruchomić w odpowiedzi. Z perspektywy komponentów wszystko przypomina czarną skrzynkę. Nadawca nie wie, kto ostatecznie obsłuży jego żądanie, a odbiorca nie wie, kto je nadał.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- zmiana jakichś klas jest trudna z powodu ścisłego sprzęgnięcia z innymi klasami.
- nie można ponownie użyć jakiegoś komponentu w innym programie z powodu jego zbytniej zależności od innych komponentów.
- tworzy się mnóstwo podklas komponentu tylko po to, aby móc ponownie użyć jakiegoś zachowania w innych kontekstach.


</div>
</div>
