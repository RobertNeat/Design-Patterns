---
title: Observer
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>


<div class="pattern-section">
<h2>Obserwator</h2>
<div class="placeholder-box">

Definiuje mechanizm subskrypcji, dzięki któremu wiele obiektów może być powiadamianych o zdarzeniach zachodzących w obserwowanym obiekcie. Obiekt posiadający interesujący stan (publikujący) przechowuje listę subskrybentów oraz udostępnia metody pozwalające dodawać i usuwać z niej wpisy. Gdy dzieje się coś ważnego, przegląda tę listę i wywołuje na każdym subskrybencie metodę powiadamiania, przekazując ewentualne dane kontekstowe. Wszyscy subskrybenci implementują wspólny interfejs (zwykle z metodą aktualizuj), więc publikujący nie jest sprzężony z konkretnymi klasami i nie musi ich z góry znać. Dzięki temu związki między obiektami można tworzyć i zrywać w trakcie działania programu, a nowych subskrybentów dodawać bez zmian w kodzie publikującego. Ograniczeniem jest to, że subskrybenci są powiadamiani w przypadkowej kolejności.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Publikujący** – rozsyła zdarzenia interesujące inne obiekty. Zdarzenia te zachodzą, gdy publikujący zmieni swój stan lub wykona jakieś działania. Publikujący posiada infrastrukturę dającą możliwość subskrybowania jego zdarzeń lub przerywania subskrypcji.
2. **Powiadamianie subskrybentów** – gdy nastąpi nowe zdarzenie, publikujący przegląda listę subskrybentów i wywołuje metody powiadamiania zadeklarowane w ich interfejsach.
3. **Interfejs subskrybenta** – deklaruje interfejs powiadamiania. W większości przypadków składa się on z jednej metody aktualizuj. Metoda ta może przyjmować wiele parametrów pozwalających publikującemu przekazać za ich pomocą szczegóły dotyczące aktualizacji.
4. **Konkretni subskrybenci** – wykonują określone czynności w odpowiedzi na powiadomienia wywołane przez publikującego. Wszystkie te klasy muszą implementować ten sam interfejs, aby publikujący nie był sprzężony z każdą z ich konkretnych klas.
5. **Dane kontekstowe** – zazwyczaj subskrybenci potrzebują konkretnych informacji, aby poprawnie obsłużyć aktualizację, dlatego publikujący na ogół przekazuje dane kontekstowe jako argumenty metody powiadamiania. Publikujący może również przekazać samego siebie jako argument, umożliwiając subskrybentom pobranie potrzebnych danych bezpośrednio.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- zmiany stanu jednego obiektu mogą wymagać zmian w innych obiektach, a konkretny zestaw obiektów nie jest zawczasu znany lub ulega dynamicznym zmianom.
- niektóre obiekty w aplikacji muszą obserwować inne, ale tylko przez jakiś czas lub w określonych przypadkach.

</div>
</div>
