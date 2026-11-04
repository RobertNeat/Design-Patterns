---
title: Abstract Factory
category: Kreacyjne
---

<span class="badge badge-category mb-3">Kreacyjne</span>


<div class="pattern-section">
<h2>Fabryka abstrakcyjna</h2>
<div class="placeholder-box">
Pozwala tworzyć rodziny spokrewnionych ze sobą obiektów (za pomocą interfejsu) bez określania ich konkretnych klas. Wzorzec proponuje najpierw wyodrębnić interfejsy dla każdego typu produktu z rodziny i sprawić, aby wszytskie warianty produktów je implementowały. Następnie deklaruje się interfejs fabryki abstrakcyjnej z metodami tworzącymi wszystkie produkty jednej rodziny, które zwracają wyłącznie typy abstrakcyjne. Dla każdego wariantu powstaje osobna konkretna fabryka, produkująca tylko produkty tego wariantu, dzięki czemu są one ze sobą zwsze kompatybilne. Kod kliencki korzysta z fabryk i produktów wyłącznie przez interfejsy, więc można zmienić wariant bez modyfikowania klienta. Konkretną fabrykę wybiera się zwykle na etapie inicjalizacji aplikacji, na podstawie konfiguracji lub środowiska. Ograniczeniem jest wzrost złożoności kodu, poniważ wzorzec wymaga wprowadzenia nowych interfejsów i klas.
</div>

<h2>#_Image</h2>

1. **Produkty abstrakcyjne** (interfejsy) - deklarują interfejsy odmiennych produktów, które składają się na wspólną rodzinę
2. **Konkretne produkty** (implementacje interfejsów) - konkretne implementacje produktów danej rodziny produktów, każdy konkretny produkt implementuje interfejs produktu abstrakcyjnego
3. Interfejs **Fabryki Abstrakcyjnej** deklaruje zestaw metod służących tworzeniu każdego z abstrakcyjnych produktów.
4. **Konkretne Fabryki** implementują metody kreacyjne fabryki abstrakcyjnej. Każda konkretna fabryka jest związana z jakimś określonym wariantem produktu.
5. Mimo, że konkretne fabryki tworzą konkretne egzemplarze produktu, sygnatury ich metod kreacyjnych muszą zwracać stosowne abstrakcyjne produkty. Dzięki temu kod kliencki, który korzysta z fabryki, nie zostanie sprzęgnięty z jakimś konkretnym wariantem produktu, jaki otrzymuje z fabryki. **Klient** może działać na dowolnym konkretnym wariancie fabryki/produktu, o ile będzie korzystał z interfejsów abstrakcyjnych ich obiektów,

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- kod ma działać na produktach z różnych rodzin, ale jednocześnie ma ściśle zależeć od konkretnych klas produktów.
- istnienie klasy posiadającej zestaw Metod Wytwórczych, które zbytnio przyćmiewają główną odpowiedzialność tej klasy.

</div>


</div>
