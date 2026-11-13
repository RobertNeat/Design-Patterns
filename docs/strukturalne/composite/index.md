---
title: Composite
category: Strukturalne
---
<span class="badge badge-category mb-3">Strukturalne</span>

<div class="pattern-section">
<h2>Kompozyt</h2>

Pozwala komponować obiekty w struktury drzewiaste i traktować je tak, jakby były pojedynczymi obiektami. Ma sens, gdy model aplikacji da się przedstawić jako drzewo (np.proste produkty i opakowania, które mogą zawierać zarówno produkty, jak i inne mniejsze opakowania). Wzorzec proponuje wspólny interfejs dla elementów prostych (liści) i złożonych (kontenerów), deklarujący operacje sensowne dla obu typów. Liść wykonuje pracę bezpośrednio, natomiast kontener nie zna konkretnych klas swojej zawartości - deleguje żądanie wszystkim elementom podrzędnym poprzez interfejs komponentu, zbiera wyniki pośrednie i zwraca wynik końcowy. Ponieważ kontener sam może zawierać inne kontenery, operacja wykonuje się rekurencyjnie po całym drzewie. Dzięki temu klient korzysta ze wszystkich elementów przez jeden wspólny interfejs i nie musi wiedzieć, czy ma do czynienia z prostym elementem, czy ze złożoną strukturą. Ograniczeniem jest to, że ustalenie jednego wspólnego interfejsu dla klas o bardzo różnych funkcjonalnościach bywa trudne i może wymagać jego nadmiernego uogólnienia.

<div class="placeholder-box">

</div>

<h2>#_Image</h2>

<div class="placeholder-box">

1. **Interfejs komponentu** – opisuje operacje wspólne zarówno dla prostych, jak i złożonych elementów drzewa.
2. **Liść** – jest podstawowym elementem drzewa i nie posiada elementów podrzędnych. Zazwyczaj to właśnie komponenty liście wykonują większość faktycznej pracy.
3. **Kontener (kompozyt)** – element posiadającym elementy podrzędne: liście lub inne kontenery. Kontener nie zna konkretnych klas swojej zawartości. Komunikuje się ze wszystkimi elementami podrzędnymi tylko poprzez interfejs komponentu. Otrzymawszy żądanie, deleguje pracę do swoich elementów podrzędnych, przetwarza wyniki pośrednie i zwraca ostateczny wynik klientowi.
4. **Klient** – współpracuje ze wszystkimi elementami za pośrednictwem interfejsu komponentu. W rezultacie może działać w taki sam sposób zarówno na prostych, jak i złożonych elementach drzewa.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- potrzeba implementacji drzewiastej struktury obiektów,
- potrzeba, aby kod kliencki traktował zarówno proste, jak i złożone elementy jednakowo.

</div>
</div>
