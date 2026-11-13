---
title: Visitor
category: Behawioralne
---

<span class="badge badge-category mb-3">Behawioralne</span>

<div class="pattern-section">
<h2>Odwiedzający</h2>
<div class="placeholder-box">

Pozwala oddzielić algorytmy od obiektów, na których działają, dzięki umieszczeniu nowych zachowań w osobnej klasie zwanej odwiedzającym, zamiast dodawania ich do istniejących klas. Obiekt, na którym ma zostać wykonana operacja, jest przekazywany jako argument do jednej z metod odwiedzającego, który deklaruje osobną metodę odwiedzania dla każdej konkretnej klasy elementu. Aby wywołać właściwą metodę bez instrukcji warunkowych, wzorzec stosuje podwójną dyspozycję. Każdy element implementuje metodę `accept`, która przyjmuje odwiedzającego i wywołuje jego metodę odpowiadającą klasie tego elementu. Dzięki temu do struktury obiektów (np. drzewa kompozytowego) można dodawać nowe operacje jedynie przez tworzenie kolejnych klas odwiedzających, bez konieczności ponownej zmiany klas elementów. Ograniczeniem jest to, że dodanie lub usunięcie klas elementów wymusza aktualizację wszystkich odwiedzających. Ponadto odwiedzający mogą nie mieć dostępu do prywatnych pól i metod elementów, więc trzeba je upublicznić kosztem hermetyzacji lub zagnieździć klasę odwiedzającego.

</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Interfejs odwiedzającego** – deklaruje zestaw metod odwiedzania, które przyjmują w charakterze argumentów konkretne elementy struktury obiektów. Metody te mogą mieć takie same nazwy, jeśli stosowany jest język programowania obsługujący przeciążanie, ale typ parametrów musi być różny.
2. **Konkretni odwiedzający** – implementują wiele wersji tego samego zachowania, dostosowanych do różnych konkretnych klas elementów.
3. **Interfejs elementu** – deklaruje metodę służącą do 'przyjmowania' odwiedzających. Typem przyjmowanego parametru takiej metody powinien być interfejs odwiedzającego.
4. **Konkretne elementy** – każdy konkretny element musi implementować metodę przyjmowania odwiedzającego. Zadaniem tej metody jest przekierowanie wywołania do właściwej metody odwiedzającego, odpowiadającej bieżącej klasie elementu. Trzeba pamiętać, że nawet jeśli bazowa klasa elementu implementuje tę metodę, wszystkie podklasy muszą ją nadpisywać w swoich klasach i wywoływać stosowną metodę obiektu odwiedzającego.
5. **Klient** – na ogół jest nim kolekcja lub inny złożony obiekt. Klienci zazwyczaj nie są świadomi wszystkich konkretnych klas swoich elementów, gdyż współpracują z nimi za pośrednictwem jakiegoś abstrakcyjnego interfejsu.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- wykonywanie określonego działania na wszystkich elementach złożonej struktury obiektów.
- uporządkowanie logiki biznesowej i oddzielenie od niej czynności pomocniczych.
- jakieś zachowanie ma sens tylko w kontekście niektórych klas wchodzących w skład hierarchii klas, ale nie wszystkich.

</div>
</div>

