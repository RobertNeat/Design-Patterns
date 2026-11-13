---
title: Strategy
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>


<div class="pattern-section">
<h2>Strategia</h2>
<div class="placeholder-box">

Pozwala zdefiniować rodzinę algorytmów, umieścić każdy z nich w osobnej klasie i uczynić ich obiekty wymienialnymi. Wzorzec proponuje wyekstraktowanie różnych wariantów wykonywania tego samego zadania do odrębnych klas zwanych strategiami, które implementują wspólny interfejs z jedną metodą uruchamiającą algorytm. Pierwszy obiekt, zwany kontekstem, przechowuje referencję do jednej ze strategii i deleguje jej pracę zamiast wykonywać ją samodzielnie. Nie wie przy tym, z którą konkretną strategią współpracuje ani jak ona działa. To klient wybiera strategię i przekazuje ją kontekstowi. Może też ją zmienić w trakcie działania programu za pomocą settera. Dzięki temu można dodawać nowe algorytmy bez zmian w kodzie kontekstu, a duże instrukcje warunkowe wybierające wariant algorytmu przestają być potrzebne. Od wzorca Stan różni się tym, że strategie są od siebie niezależne i nie wiedzą o sobie nawzajem. Ograniczeniem jest to, że klient musi znać różnice między strategiami, aby wybrać właściwą, a przy kilku rzadko zmieniających się algorytmach wzorzec niepotrzebnie komplikuje kod (w wielu językach wystarczają też funkcje anonimowe).

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Kontekst** – przechowuje odniesienie do jednej z konkretnych strategii i komunikuje się z jej obiektem za pośrednictwem interfejsu Strategia.
2. **Interfejs Strategia** – jest wspólny dla wszystkich konkretnych strategii. Deklaruje metodę, za pomocą której kontekst uruchamia daną strategię.
3. **Konkretne strategie** – implementują różne warianty algorytmu, z którego korzysta kontekst.
4. **Uruchamianie strategii** – kontekst wywołuje metodę uruchamiającą, eksponowaną przez powiązany z nim obiekt strategii, za każdym razem, gdy chce uruchomić algorytm. Kontekst nie wie, z jaką strategią ma do czynienia ani jak działa algorytm.
5. **Klient** – tworzy określony obiekt strategii i przekazuje go kontekstowi. Kontekst eksponuje metodę setter, pozwalającą klientowi zmieniać strategię skojarzoną z tym kontekstem w trakcie działania programu.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- używanie różnych wariantów jednego algorytmu w obrębie obiektu i możliwość zmiany wyboru wariantu w trakcie działania programu.
- występowanie wielu podobnych klas różniących się sposobem wykonywania zadań.
- potrzeba odizolowania 'logiki biznesowej' klas od szczegółów implementacji algorytmów, które nie są istotne w kontekście tej logiki.
- klasa zawiera duży operator warunkowy, którego zadaniem jest wybór odpowiedniego wariantu tego samego algorytmu.

</div>
</div>
