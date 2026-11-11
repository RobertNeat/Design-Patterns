---
title: Bridge
category: Strukturalne
---
<span class="badge badge-category mb-3">Strukturalne</span>


<div class="pattern-section">
<h2>Most</h2>
<div class="placeholder-box">
Pozwala rozdzielić dużą klasę lub zestaw spokrewnionych klas na dwie niezależne hierarchie: abstrakcję i implementację. Problem powstaje, gdy klasę rozbudowuje się w kilku niezależnych wymiarach, bo dziedziczenie prowadzi wtedy do wykładniczego wzrostu liczby podklas. Wzorzec proponuje przejście z dziedziczenia na kompozycję, jeden z wymiarów wydzielamy do osobnej hierarchii, a klasa pierwotna (abstrakcja) przechowuje odniesienie do obiektu z tej hierarchii (implementacji) i deleguje mu faktyczną pracę. Abstrakcja to wysokopoziomowa warstwa sterująca, a implementacja to warstwa niższa, specyficzna dla platformy. Obie hierarchie łączy wspólny interfejs implementacji, dzięki czemu implementacje są wymienne, także w trakcie działania programu. Nowe abstrakcje i implementacje można wtedy dodawać niezależnie od siebie. Worzec stosuje się zwykle od początku projektu, w przeciwieństwie do Adaptera, który służy do łączenia niekompatybilnych klas w istniejącej aplikacji. Ograniczeniem jest większa złożoność kodu, jeśli zastosuje się go do klasy o wysokiej spójności.  
</div>

<h2>#_Image</h2>
<div class="placeholder-box">

1. Abstrakcja obejmuje logikę kontrolną wysokiego poziomu. Potrzebuje obiektu implementacyjnego by wykonywać faktyczne działania.
2. Implementacja deklaruje interfejs, który jest wspólny dla wszystkich konkretnych implementacji. Abstrakcja może komunikować się z obiektem implementacyjnym wyłacznie za pomocą zadeklarowanych tu metod. Abstrakcja moze zawierac listę tych samych metod, co implementacja, ale zazwyczaj deklaruje bardziej złożone działania, na które składa się wiele prostszych działań deklarowanych przez implementację.
3. Konkretne implementacje zawierają kod specyficzny dla danej platformy.
4. Wzbogacona abstrakcja udostępnia warianty logiki kontrolnej. Tak jak ich klasa-rodzic, współdziałają z różnymi implementacjami poprzez ogólny interfejs implementacyjny.
5. Zazwyczaj klienta interesuje tylko współpraca z abstrakcją. Ale to zadaniem klienta jest połączenie obiektu abstrakcji z jednym z obiektów implementacji. 

</div>

<h2>Zastosowanie</h2>
<div class="placeholder-box">

- rozdzielenie i przeorganizowanie monolitycznej klasy posiadającej wiele wariantów takiej samej funkcjonalności
- rozszerzenie klasy na kilku niezależnych płaszczyznach
- udostępnienie możliwości wyboru implementacji w trakcie działania programu

</div>
</div>
