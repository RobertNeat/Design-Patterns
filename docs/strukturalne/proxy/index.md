---
title: Proxy
category: Strukturalne
---

<span class="badge badge-category mb-3">Strukturalne</span>


<div class="pattern-section">
<h2>Pełnomocnik</h2>
<div class="placeholder-box">

Tworzy obiekt zastępczy w miejsce innego obiektu, nadzoruje dostęp do niego i pozwala wykonywać określone czynności przed lub po przekazaniu żądania. Problem dotyczy zasobożernych obiektów usługowych, które są potrzebne tylko od czasu do czasu - leniwa inicjalizacja rozwiązywałaby ten problem, ale wymagałaby powielania kodu u każdego klienta, a często nie ma nawet dostępu do kodu źródłowego usługi (np. w przypadku zamkniętej biblioteki). Rozwiązaniem jest stworzenie klasy pełnomocnika o tym samym interfejsie co pierwotny obiekt usługi (np. z zamknietej biblioteki), klienci otrzymują pełnomocnika zamiast prawdziwego obiektu, a ten po wykonaniu własnej logiki deleguje żądanie do faktycznego obiektu usługi. Najpopularniejsze zastosowania to pełnomocnik wirtualny (leniwa inicjalizacja zasobożernego obiektu), pełnomocnik ochronny (kontrola dostępu na podstawie poświadczeń klienta), pełnomocnik zdalny (przekazywanie żądań przez sieć do obiektu na zdalnym serwerze), pełnomocnik prowadzący dziennik (logowanie żądań) oraz pełnomocnik z pamięcią podręczną (cachowanie wyników powtarzających się żądań). Wzorzec pozwala też na stosowanie tak zwanych sprytnych referencji, czyli śledzenie aktywnych klientów obiektu usługi i zwalnianie zasobów, gdy nikt go już nie potrzebuje. Zaletą jest możliwość sterowania obiektem usługi i zarządzania jego cyklem życia bez wiedzy klienta, zgodnie z zasadą otwarte-zamknięte. Wadą jest wzrost złożoności kodu (konieczność stworzenia nowych klas) oraz możliwe opóźnienie odpowiedzi usługi.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Interfejs usługi** – deklaruje interfejs, z którym pełnomocnik musi być zgodny, aby móc udawać obiekt usługi.
2. **Usługa** – klasa udostępniająca jakąś użyteczną logikę biznesową.
3. Klasa **Pełnomocnik** zawiera pole z odniesieniem do konkretnego obiektu udostępniającego usługę. Po wykonaniu swoich zadań (leniwa inicjalizacja, zapis w dzienniku, kontrola dostępu, przechowywanie w pamięci podręcznej itp.), pełnomocnik przekazuje żądanie do tego obiektu. Pełnomocnicy zazwyczaj zarządzają całym cyklem życia samych obiektów usługowych.
4. **Klient** – powinien móc pracować zarówno z usługami, jak i z pełnomocnikami za pośrednictwem takiego samego interfejsu. Dzięki temu można umieścić pełnomocnika w dowolnym kodzie, który ma współpracować z obiektem usługowym.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- **Leniwa inicjalizacja** – gdy obiekt usługi jest zasobożerny i potrzebny tylko od czasu do czasu.
- **Kontrola dostępu** – zezwalanie tylko niektórym klientom na korzystanie z obiektu usługi.
- **Lokalne uruchomienie zdalnej usługi** – przydatne, gdy obiekt udostępniający usługę znajduje się na zdalnym serwerze.
- **Prowadzenie dziennika zdarzeń** – pozwala gromadzić rejestr żądań przesyłanych do obiektu usługi.
- **Przechowywanie wyników działań w pamięci podręcznej** – pozwala przechowywać wyniki przekazywanych żądań i zarządzać cyklem życia pamięci podręcznej.
- **Sprytne referencje** – likwidowanie zasobożernego obiektu, gdy nie ma klientów, którzy go potrzebują.

</div>
</div>
