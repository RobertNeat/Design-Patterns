---
title: Adapter
category: Strukturalne
---

<span class="badge badge-category mb-3">Strukturalne</span>


<div class="pattern-section">
<h2>Adapter</h2>
<div class="placeholder-box">
Pozwala współpracować obiektom o niekompatybilnych interfejsach. Wzorzec proponuje stworzenie specjalnego obiektu, adaptera, który opakowuje jeden z obiektów (usługę) i konwertuje jego interfejs na taki, jaki rozumie klient. Adapter implementuje interfejs klienta, a otrzymane wywołania tłumaczy na format obsługiwany przez opakowany obiekt i deleguje mu faktyczną pracę. Dzięki temu klient komunikuje się z usługą wyłącznie przez interfejs klienta, a opakowywany obiekt może nawet nie wiedzieć o istnieniu adaptera. Wzorzec stosuje się w istniejącej aplikacji, gdy chcemy uzyć klasy (np. zewnętrznej lub przestarzałej), której nie możemy zmienić, a jej interfejs nie pasuje do reszty kodu. Ograniczeniem jest wzrost ogólnej złożoności kodu, bo trzeba wprowadzić nowe intefejsy i klasy. Czasem prościej jest zamienić samą klasę osługową, jeśli mamy do niej dostęp. 
</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. Klient jest klasą zawierającą logikę biznesową programu
2. Interfejs klienta opisuje protokół którego muszą sie trzymać pozostałe klasy by móc współdziałąć z kodem klienckim
3. Usługa to jakaś użyteczna klasa (na ogół od innego producenta lub starsza). Klient nie jest w stanie użyć jej bezpośrednio z powodu niekompatybilnego interfejsu.
4. Adapter to klasa, która jest w stanie współdziałać zarówno z klientem, jak i usługą: implementuje interfejs klienta, opakowując obiekt-usługę. Adapter otrzymuje wywołania od klienta za pośrednictwem interfejsu klienta i tłumaczy je na wywołania których format zrozumie obiekt udostępniajacy usługę
5. Kod kliencki nie ulegnie sprzężeniu z konkretną klasą adaptera, o ile może współpracować z adapterem za pośrednictwem interfejsu klienta. Dzięki temu można wprowadziać nowe typy adapterów do programu bez psucia istniejącego kodu klienckiego. To przydatne, gdy interfejs klasy udostępniającej usługę ulegnie zmianie, bo wówczas wystaczy dodać nową klasę adapter bez konieczności zmiany kodu klienckiego.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- wykorzystanie istniejącej klasy, której interfejs nie jest kompatybilny z resztą programu 
- wykorzystanie ponowne istniejących podklas, którym brakuje jakiejś wspólnej funkcjonalności, niedającej się dodać do ich nadklasy 

</div>
</div>
