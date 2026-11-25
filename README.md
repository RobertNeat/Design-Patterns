<p align="center">
  <img src="public/logo.png" width="300" alt="Design Patterns">
</p>

<h1 align="center">Design Patterns</h1>

Terminalowa aplikacja prezentująca zastosowanie klasycznych wzorców projektowych GoF (Design patterns) pod postacią modułu Maven. Głównym motywem jest tematyka restauracji (żeby projekt miał jakiś kontekst), ale przy okazji każdego wzorca będą inne praktyczne zastosowania.

Aplikacja jest podzielona na moduły względem typów wzorców:


| KREACYJNE            | Tematyka                                                                                                      |
|----------------------|---------------------------------------------------------------------------------------------------------------|
| Metoda wytwórcza     | Tworzenie różnych klas dań (zup, przystawek, dań głównych, deserów)                                           |
| Fabryka abstrakcyjna | Tworzenie zestawów dań (zup, przystawek, dań głównych, deserów) z różnych kuchni (niemiecka, polska, włoska)  |
| Budowniczy           | Etapowe tworzenie dań                                                                                         |
| Prototyp             | Klonowanie konkretnych potraw                                                                                 |
| Singleton            | Przechowywanie globalnych właściwości restauracji                                                             |


| STRUKTURALNE  | Tematyka                                                                                                                  |
|---------------|---------------------------------------------------------------------------------------------------------------------------|
| Adapter       | Wykonywanie płatności w EUR za pomocą PLN (z przewalutowaniem w locie)                                                    |
| Most          | Podział logiki rodzaju zamówienia (na miejscu, na wynos, z dostawą) od realizacji (standardowo, priorytetowo, ekspresowo) |
| Kompozyt      | Wyznaczanie ilości poszczególnych składników na pokrycie całego menu                                                      |
| Dekorator     | Dodawanie dodatkowych składników do dania (ser, sos, większa porcja) zmieniające stan dania                               |
| Fasada        | Składanie zamówienia za pomocą jednego uproszczonego punktu wejścia                                                       |
| Pyłek         | Współdzielenie alergenów w różnych konfiguracjach między potrawami                                                        |
| Pełnomocnik   | Kontrola dostępu do zmian cen posiłków (jedynie rola managera)                                                            |


| BEHAWIORALNE        | Tematyka                                                                                              |
|---------------------|-------------------------------------------------------------------------------------------------------|
| Łańcuch Zobowiązań  | Kolejne kroki walidacji i rabatów: poprawność zamówienia, dostępność składników, kod promocyjny       |
| Polecenie           | Skladanie zamówienia, w którym klient może dodawać lub usuwać swoje pozycje, zamawiać dodatkowe dania |
| Iterator            | -brak bo bazuje na strukturach danych-                                                                |
| Mediator            | Koordynacja komunikacji między kelnerem, kuchnią i barem przez jeden węzeł                            |
| Pamiątka            | Zapis i przywracanie stanu zamówienia podczas etapów przygotowywania                                  |
| Obserwator          | Powiadamianie kuchni, kelnera i klienta o zmianie statusu zamówienia                                  |
| Stan                |                                                                                                       |
| Strategia           |                                                                                                       |
| Metoda szablonowa   |                                                                                                       |
| Odwiedzający        |                                                                                                       |


| Wzorzec     | Zastosowanie w restauracji                                                                                        |
| ----------- | ----------------------------------------------------------------------------------------------------------------- |
| Strategy    | Wybór rodzaju zniżki: procentowa, kwotowa, happy hour, karta stałego klienta                                      |
| State       | Cykl życia zamówienia: nowe, w przygotowaniu, gotowe, wydane, anulowane                                           |
| Template    | Method Wspólny szkielet przygotowania dania z różnymi krokami dla każdej kategorii                                |
| Visitor     | Operacje na elementach menu bez zmiany ich klas: kalkulacja kalorii, raport alergenów, wyceny                     |
| Interpreter | Prosty język reguł rabatowych, na przykład “WTOREK AND SUMA > 100 THEN 10%”                                       |

W /docs można znaleźc notatki do poszczególnych wzorców.
