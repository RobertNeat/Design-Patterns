---
title: State
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Stan</h2>
<div class="placeholder-box">

Pozwala obiektowi zmieniać swoje zachowanie, gdy zmieni się jego stan wewnętrzny, tak jakby obiekt zmienił klasę. Wzorzec proponuje zastąpienie rozbudowanych instrukcji warunkowych `if-switch`, które w każdej metodzie wybierają zachowanie na podstawie pola przechowującego stan, osobnymi klasami dla każdego możliwego stanu. Zachowania zależne od stanu są przenoszone do tych klas, a pierwszy obiekt, zwany kontekstem, przechowuje referencję do aktualnego obiektu stanu i deleguje mu odpowiednie zadania. Zmiana stanu polega na podmianie obiektu stanu w kontekście na inny. Jest to możliwe tylko wtedy, gdy wszystkie stany implementują wspólny interfejs, a kontekst komunikuje się z nimi wyłącznie za jego pośrednictwem. Od wzorca Strategia różni się tym, że poszczególne stany mogą się znać nawzajem i same inicjalizować przejścia do innych stanów, natomiast strategie są od siebie niezależne. Ograniczeniem jest to, że przy niewielkiej liczbie stanów i rzadkich zmianach stanu wzorzec może być przesadą.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Kontekst** – przechowuje odniesienie do jednego z konkretnych obiektów stanu i deleguje mu zadania specyficzne dla danego stanu. Kontekst porozumiewa się z obiektem stanu za pośrednictwem interfejsu stanu. Kontekst eksponuje metodę setter, przez którą przekazuje się obiekt nowego stanu dla kontekstu.
2. **Interfejs stanu** – deklaruje metody specyficzne dla stanu. Metody te powinny być sensowne dla konkretnych stanów, ponieważ nie chcemy, aby którykolwiek ze stanów posiadał bezużyteczne metody, które nigdy nie zostaną wywołane.
3. **Konkretne stany** – dostarczają własne implementacje metod specyficznych dla danego stanu. W przypadku wielu stanów można utworzyć pośrednie klasy abstrakcyjne, które hermetyzują pewne wspólne zachowania. Obiekty stanu mogą przechowywać referencje wsteczne do obiektu kontekstu. Za pośrednictwem tego odniesienia stan może pobierać dowolne informacje z obiektu kontekstu, a także inicjować zmianę stanu.
4. **Zmiana stanu** – zarówno kontekst, jak i konkretne stany mogą ustawić kolejny stan kontekstu i wykonać samą zmianę stanu poprzez zastąpienie obiektu stanu powiązanego z kontekstem innym obiektem stanu.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- występuje obiekt, którego zachowanie jest zależne od jego stanu, liczba możliwych stanów jest duża, a kod specyficzny dla danego stanu często ulega zmianom.
- występuje klasa zaśmiecona rozbudowanymi instrukcjami warunkowymi, zmieniającymi zachowanie klasy zależnie od wartości jej pól.
- występuje duża ilość powtarzającego się kodu w wielu stanach i występują przejścia między stanami skończonymi, których logika opiera się na instrukcjach warunkowych.


</div>
</div>
