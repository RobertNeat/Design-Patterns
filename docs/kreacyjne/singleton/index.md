---
title: Singleton
category: Kreacyjne
---

<span class="badge badge-category mb-3">Kreacyjne</span>

<div class="pattern-section">
<h2>Singleton</h2>
<div class="placeholder-box">
Zapewnia istnienie wyłącznie jednej instancji danej klasy i daje globalny punkt dostępu do tej instancji. Rozwiązuje dwa problemy jednocześnie kontrolę liczby obiektów (najczęściej po to, by kontrolować dostęp do współdzielonego zasobu, np. bazy danych lub pliku) oraz globalny dostęp do obiektu, bez ryzyka jego nadpisania, które niosą zmienne globalne. Zwykły konstruktor nie może tego zapewnić, bo z definicji zawsze zwraca nowy obiekt. Wzorzec proponuje uczynić konstruktor prywatnym oraz utworzyć statyczną metodę kreacyjną (np. getInstance), która przy pierwszym wywołaniu tworzy obiekt i zapisuje go w polu statycznym, a przy kolejnych zwraca już istniejący egzemplarz (leniwa inicjalizacja). Ograniczeniem jest to, że wzorzec łamie zasadę pojedynczej odpowiedzialności, może maskować zły projekt (komponenty wiedzą o sobie zbyt wiele), wymaga specjalnej uwagi w środowisku wielowątkowym i utrudnia testy jednostkowe, ponieważ trudno stworzyć atrapę singletona.
</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. Klasa **singletona** deklaruje statyczną meyodę getInstance, która zawsze zwraca tę samą instancję swej klasy. Konstruktor klasy singleton musi być ukryty przed kodem klienckim. Tylko i wyłącznie wywołanie metody getInstance powinno dawać dostęp do takiego obiektu. 

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- potrzeba wykonania pojedynczego ogólno dostępnego obiektu danej klasy (np. połaczenia z bazą danych),
- ścisła kontrola nad zmiennymi globalnymi,

</div>
</div>

