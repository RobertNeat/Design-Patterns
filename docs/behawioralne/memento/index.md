---
title: Memento
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Pamiątka</h2>
<div class="placeholder-box">

Pozwala zapisywać i przywracać wcześniejszy stan obiektu bez naruszania jego hermetyzacji. Wzorzec zakłada, że sam obiekt źródłowy (posiadający pełen dostęp do własnego, w tym prywatnego stanu) tworzy migawkę swojego stanu i przekazuje ją specjalnemu obiektowi zwanemu pamiątką, zamiast pozwalać innym obiektom kopiować jego dane 'z zewnątrz'. Pamiątka jest zwykle niezmienna, a jej zawartość udostępniana jest tylko twórcy. Inne obiekty, tak zwani zarządcy, mogą przechowywać pamiątki (na przykład na stosie historii) i odpytywać je jedynie o metadane, bez względu na faktyczny stan źródła. Gdy trzeba cofnąć zmianę, zarządca przekazuje odpowiednią pamiątkę z powrotem źródłu, które na jej podstawie przywraca swój wcześniejszy stan. Ograniczeniem jest zużycie pamięci przy częstym tworzeniu migawek, konieczność ręcznego zarządzania cyklem życia przechowywanych pamiątek oraz fakt, że w wielu językach dynamicznych, takich jak PHP, Python czy JavaScript, nie da się w pełni wymusić niezmienności pamiątki.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

_Implementacja w oparciu o zagnieżdżone klasy:_

1. **Źródło** – może tworzyć migawki swojego stanu, a także przywracać wcześniejszy stan z migawek, gdy zachodzi taka potrzeba.
2. **Pamiątka** – obiekt wartości pełniący rolę zapisu stanu źródła. Popularną praktyką jest uczynienie pamiątki niezmienną i ustawienie jej danych jednorazowo za pośrednictwem konstruktora.
3. **Zarządca** – nie tylko wie 'kiedy' i 'po co' należy zarejestrować stan źródła, ale także kiedy należy przywrócić wcześniejszy stan. Zarządca może śledzić historię źródła, przechowując stos pamiątek. Gdy źródło musi wrócić do wcześniejszego stanu, zarządca pobiera najnowszą pamiątkę ze stosu i przekazuje ją metodzie przywracającej stan źródła.
4. **Zagnieżdżona klasa pamiątki** – w tej implementacji klasa pamiątki jest zagnieżdżona wewnątrz klasy źródła. Pozwala to źródłu mieć dostęp do pól i metod pamiątki, pomimo że są zadeklarowane jako prywatne. Z drugiej strony zarządca ma bardzo ograniczony dostęp do pól i metod pamiątki, co pozwala mu przechowywać je w formie stosu, ale bez możliwości zmiany ich stanu.

_Implementacja na podstawie interfejsu pośredniego:_

1. **Interfejs pośredni** – wobec niemożliwości zagnieżdżania klas można ograniczyć dostęp do pól pamiątki, stosując konwencję, według której zarządcy współdziałają z pamiątkami wyłącznie za pośrednictwem jasno zadeklarowanego interfejsu pośredniego. Taki interfejs deklarowałby tylko metody związane z metadanymi pamiątki.
2. **Źródło** – może współpracować z pamiątkami bezpośrednio, poprzez dostęp do pól i metod w nich zadeklarowanych. Wadą takiego podejścia jest konieczność deklaracji wszystkich składowych pamiątki jako publicznych.

_Implementacja z jeszcze ściślejszą hermetyzacją:_

1. **Źródło i pamiątka** – ta implementacja pozwala mieć wiele typów źródeł i pamiątek. Każde źródło współdziała z odpowiednią dla niego klasą pamiątki. Ani źródło, ani pamiątka nie eksponują swojego stanu innym obiektom.
2. **Zarządca** – uniemożliwiono mu zmianę stanu przechowywanego w pamiątkach. Co więcej, klasa zarządcy staje się niezależna od źródła, ponieważ metoda przywracająca stan jest teraz zdefiniowana w klasie pamiątki.
3. **Powiązanie pamiątki ze źródłem** – każda pamiątka staje się powiązana ze źródłem, które ją utworzyło. Źródło przekazuje siebie do konstruktora pamiątki wraz z wartościami opisującymi jego stan. Dzięki bliskiemu związkowi pomiędzy tymi klasami pamiątka może przywrócić stan źródła, gdy to drugie ma zdefiniowane stosowne metody setter.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- tworzenie migawki stanu obiektu i przywracanie poprzedniego stanu.
- sytuacje, w których bezpośredni dostęp do pól obiektu za pomocą getterów i setterów narusza jego hermetyzację.

</div>
</div>
