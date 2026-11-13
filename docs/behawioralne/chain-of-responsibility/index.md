---
title: Chain of Responsibility
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Łańcuch zobowiązań</h2>
<div class="placeholder-box">

Pozwala przekazywać żądanie wzdłuż łańcucha obiektów obsługujących (handlerów), z których każdy decyduje, czy je obsłużyć, czy przekazać dalej. Wzorzec zakłada wydzielenie wspólnego interfejsu handlera z metodą obsługi żądania oraz metodą ustawiającą kolejny element łańcucha. Każdy konkretny handler, otrzymując żądanie, sprawdza, czy potrafi je obsłużyć. Jeśli tak, wykonuje odpowiednią logikę (i może, ale nie musi, zakończyć dalsze przekazywanie). Jeśli nie, przekazuje żądanie do kolejnego handlera w łańcuchu. Dzięki temu nadawca żądania nie musi znać konkretnego obiektu, który je ostatecznie obsłuży, a kolejność i skład handlerów można dowolnie zmieniać w trakcie działania programu. Ograniczeniem jest to, że żądanie może pozostać nieobsłużone, jeśli żaden z handlerów w łańcuchu go nie przyjmie, dlatego często stosuje się dodatkowy handler domyślny na końcu łańcucha.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Interfejs obiektu obsługującego** – deklaruje wspólny dla wszystkich obiektów obsługujących interfejs, zazwyczaj zawierający tylko jedną metodę do obsługi żądań. Czasem może zawierać też drugą metodę, służącą do wybierania kolejnego obiektu w łańcuchu.
2. **Bazowy obiekt obsługujący** – to opcjonalna klasa, w której można umieścić kod przygotowawczy wspólny dla wszystkich klas obsługujących. Na ogół klasa ta definiuje pole służące do przechowywania odniesienia do kolejnego obiektu obsługującego. Klienci mogą sformować łańcuch, przekazując obiekt obsługujący konstruktorowi lub metodzie setter poprzedniego obiektu. Klasa może też implementować domyślną obsługę, przekazując wykonanie kolejnemu obiektowi obsługującemu, po sprawdzeniu, czy taki istnieje.
3. **Konkretne obiekty obsługujące** – zawierają faktyczny kod służący obsłudze żądań. Otrzymawszy żądanie, każdy obiekt musi zdecydować, czy je obsłużyć i czy przekazywać je dalej. Obiekty obsługujące są zazwyczaj samodzielne i niezmienne, akceptują wszystkie konieczne dane jednorazowo za pośrednictwem konstruktora.
4. **Klient** – może skomponować łańcuch raz albo robić to dynamicznie, zależnie od logiki aplikacji. Warto pamiętać, że żądanie może być przekazywane do dowolnego ogniwa łańcucha, niekoniecznie pierwszego.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- Program ma obsługiwać różne rodzaje żądań na różne sposoby, ale dokładne typy żądań i ich sekwencje nie są wcześniej znane.
- Istotne jest uruchamianie wielu obiektów obsługujących w określonej kolejności.
- Istnieje potrzeba ustawiania kolejności obiektów obsługujących w trakcie działania programu.

</div>
</div>

