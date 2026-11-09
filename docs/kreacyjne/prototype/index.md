---
title: Prototype
category: Kreacyjne
---

<span class="badge badge-category mb-3">Kreacyjne</span>

<div class="pattern-section">
<h2>Prototyp</h2>
<div class="placeholder-box">
Umożliwia kopiowanie istniejących obiektów bez tworzenia zależności między kodem a klasami tych obiektów. Kopiowanie "z zwenątrz" bywa niemożliwe, ponieważ część pól jest prywatna, a podanto wymaga znajomości konkretnej klasy obiektu, co uzależnia od niej kod. Wzorzec proponuje delegowac proces klonowania do samych obiektów, poprzez wspólny interfejs z jedną metodą klonuj. Metoda ta tworzy obiekt własnej klasy i kopiuje do niego wartości pól, także prywatnych, ponieważ obiekty tej samej klasy mają do nich dostęp. Obiekt wspierający klonowanie nazywa się prototypem. Klonowanie prefabrykowanych wcześniej skonfigurowanych prototypów (opcjonalnie przechowywanych w rejestrze prototypów) może być alternatywą dla tworzenia podklas różniącaych się tylko spososbem inicjalizacji. Ograniczeniem jest to, że klonowanie złożonych obiektów z odniesieniami cyklicznymi może być trudne. 
</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. **Interfejs prototyp** deklaruje metody klonujące.. W większości przypadków jest to pojedyncza metoda klonuj. 
2. Klasa **konkretny prototyp** implementuje metodę klonującą. Oprócz kopiowania danych pierwotnego obiektu do nowo powstałego, metoda ta może również rozwiązywać kwestie związane z klonowaniem obiektów powiązanych, czy też z zaleznościami rekursywanymi.
3. Klient może stworzyć kopię dowolnego obiektu, który jest zgodny z interfejsem prototypu.

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- zabezpieczenie, żeby kod nie był zależny od konkretnej klasy
- zredukowanie ilości podklas różniących się jedynie sposobem inicjalizacji obiektów

</div>
</div>
