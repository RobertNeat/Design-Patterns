---
title: Command
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Polecenie</h2>
<div class="placeholder-box">

Zmienia żądanie w samodzielny obiekt zawierający wszystkie informacje o tym żądaniu: obiekt docelowy, nazwę metody i argumenty wywołania. Zamiast wywoływać metodę logiki biznesowej bezpośrednio, obiekt nadawcy uruchamia obiekt-polecenia posiadający jedną wspólną metodę wykonania. Konkretne polecenie samo nie wykonuje pracy, lecz przekazuje ją odbiorcy, czyli obiektowi zawierającemu właściwą logikę biznesową. Dzięki temu nadawca nie musi wiedzieć, jaki odbiorca obsłuży żądanie ani w jaki sposób. Te same polecenia można podpinać pod różne elementy interfejsu, unikając duplikacji kodu. Ponieważ polecenie jest samodzielnym obiektem, można je przechowywać w historii, kolejkować, opóźniać jego wykonanie, a nawet serializować i wysyłać przez sieć. Pozwala to łatwo implementować funkcję cofnij i ponów, o ile polecenie zapisze wcześniej kopię zapasową stanu odbiorcy. Wadą jest wprowadzenie dodatkowej warstwy pośredniczącej między nadawcami a odbiorcami, co zwiększa złożoność kodu.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Nadawca (wywołujący)** – jest odpowiedzialny za inicjalizowanie żądań. Musi zawierać pole przechowujące odniesienie do obiektu polecenia. Nadawca uruchamia polecenie zamiast przesyłać żądanie bezpośrednio do odbiorcy. Warto zauważyć, że nadawca nie jest odpowiedzialny za tworzenie obiektu polecenia. Zazwyczaj otrzymuje wcześniej przygotowane polecenia od klienta za pośrednictwem konstruktora.
2. **Interfejs polecenia** – zwykle deklaruje pojedynczą metodę służącą do wykonania polecenia.
3. **Konkretne polecenia** – implementują różne rodzaje żądań. Konkretne polecenie nie powinno wykonywać pracy samodzielnie, lecz przekazywać ją do jednego z obiektów logiki biznesowej. Jednak dla uproszczenia kodu klasy te można połączyć. Parametry potrzebne do uruchomienia metody na obiekcie odbiorcy można zadeklarować w formie pól konkretnego polecenia. Obiekty poleceń można uczynić niezmiennymi, zezwalając na inicjalizację tych pól wyłącznie za pośrednictwem konstruktora.
4. **Odbiorca** – zawiera właściwą logikę biznesową. Prawie każdy obiekt może pełnić rolę odbiorcy. Większość poleceń obsługuje tylko szczegóły przekazania żądania do odbiorcy, zaś faktyczną pracę wykonuje ten ostatni.
5. **Klient** – tworzy i konfiguruje konkretne obiekty poleceń. Musi przekazywać wszystkie parametry żądania, włącznie z istniejącą instancją odbiorcy do konstruktora polecenia. Następnie otrzymane polecenie można skojarzyć z jednym lub wieloma nadawcami.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- parametryzacja obiektów za pomocą działań.
- układanie kolejki zadań, ustalanie harmonogramu ich wykonania lub zdalne uruchamianie.
- implementacja operacji odwracalnych (funkcji cofnij i ponów).

</div>
</div>
