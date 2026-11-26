<p align="center">
  <img src="public/logo.png" width="300" alt="Design Patterns">
</p>

<h1 align="center">Design Patterns</h1>

Terminalowa aplikacja prezentująca zastosowanie klasycznych wzorców projektowych GoF (Design patterns) pod postacią modułu Maven. Głównym motywem jest tematyka restauracji (żeby projekt miał jakiś kontekst), ale przy okazji każdego wzorca będą inne praktyczne zastosowania.

Aplikacja jest podzielona na moduły względem typów wzorców:


| KREACYJNE                                                                                        | Tematyka                                                                                                     |
| ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------ |
| [Metoda wytwórcza](/src/main/java/design_patterns/kreacyjne/metoda_wytwórcza/definition)         | Tworzenie różnych klas dań (zup, przystawek, dań głównych, deserów)                                          |
| [Fabryka abstrakcyjna](/src/main/java/design_patterns/kreacyjne/fabryka_abstrakcyjna/definition) | Tworzenie zestawów dań (zup, przystawek, dań głównych, deserów) z różnych kuchni (niemiecka, polska, włoska) |
| [Budowniczy](/src/main/java/design_patterns/kreacyjne/budowniczy/definition)                     | Etapowe tworzenie dań                                                                                        |
| [Prototyp](/src/main/java/design_patterns/kreacyjne/prototyp/definition)                         | Klonowanie konkretnych potraw                                                                                |
| [Singleton](/src/main/java/design_patterns/kreacyjne/singleton/definition)                       | Przechowywanie globalnych właściwości restauracji                                                            |

| STRUKTURALNE                                                                      | Tematyka                                                                                                                  |
| --------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------- |
| [Adapter](/src/main/java/design_patterns/strukturalne/adapter/definition)         | Wykonywanie płatności w EUR za pomocą PLN (z przewalutowaniem w locie)                                                    |
| [Most](/src/main/java/design_patterns/strukturalne/most/definition)               | Podział logiki rodzaju zamówienia (na miejscu, na wynos, z dostawą) od realizacji (standardowo, priorytetowo, ekspresowo) |
| [Kompozyt](/src/main/java/design_patterns/strukturalne/kompozyt/definition)       | Wyznaczanie ilości poszczególnych składników na pokrycie całego menu                                                      |
| [Dekorator](/src/main/java/design_patterns/strukturalne/dekorator/definition)     | Dodawanie dodatkowych składników do dania (ser, sos, większa porcja) zmieniające stan dania                               |
| [Fasada](/src/main/java/design_patterns/strukturalne/fasada/definition)           | Składanie zamówienia za pomocą jednego uproszczonego punktu wejścia                                                       |
| [Pyłek](/src/main/java/design_patterns/strukturalne/pyłek/definition)             | Współdzielenie alergenów w różnych konfiguracjach między potrawami                                                        |
| [Pełnomocnik](/src/main/java/design_patterns/strukturalne/pełnomocnik/definition) | Kontrola dostępu do zmian cen posiłków (jedynie rola managera)                                                            |

| BEHAWIORALNE                                                                                    | Tematyka                                                                                              |
| ----------------------------------------------------------------------------------------------- | ----------------------------------------------------------------------------------------------------- |
| [Łańcuch Zobowiązań](/src/main/java/design_patterns/behawioralne/łańcuch_zobowiązań/definition) | Kolejne kroki walidacji i rabatów: poprawność zamówienia, dostępność składników, kod promocyjny       |
| [Polecenie](/src/main/java/design_patterns/behawioralne/komenda/definition)                     | Skladanie zamówienia, w którym klient może dodawać lub usuwać swoje pozycje, zamawiać dodatkowe dania |
| [Iterator](/src/main/java/design_patterns/behawioralne/iterator/definition)                     | -brak bo bazuje na strukturach danych-                                                                |
| [Mediator](/src/main/java/design_patterns/behawioralne/mediator/definition)                     | Koordynacja komunikacji między kelnerem, kuchnią i barem przez jeden węzeł                            |
| [Pamiątka](/src/main/java/design_patterns/behawioralne/pamiątka/definition)                     | Zapis i przywracanie stanu zamówienia podczas etapów przygotowywania                                  |
| [Obserwator](/src/main/java/design_patterns/behawioralne/obserwator/definition)                 | Powiadamianie kuchni, kelnera i klienta o zmianie statusu zamówienia                                  |
| [Stan](/src/main/java/design_patterns/behawioralne/stan/definition)                             | Cykl życia zamówienia: nowe, w przygotowaniu, gotowe, wydane, anulowane                               |
| [Strategia](/src/main/java/design_patterns/behawioralne/strategia/definition)                   | Wybór rodzaju zniżki: procentowa, kwotowa, happy hour, karta stałego klienta                          |
| [Metoda szablonowa](/src/main/java/design_patterns/behawioralne/metoda_szablonowa/definition)   | Wspólny szkielet przygotowania dania z różnymi krokami dla każdej kategorii                           |
| [Odwiedzający](/src/main/java/design_patterns/behawioralne/odwiedzający/definition)             | Operacje na elementach menu bez zmiany ich klas: kalkulacja kalorii, raport alergenów, wyceny         |

W /docs można znaleźc notatki do poszczególnych wzorców.
