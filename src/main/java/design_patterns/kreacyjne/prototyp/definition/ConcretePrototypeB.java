package design_patterns.kreacyjne.prototyp.definition;

import java.util.Objects;

public class ConcretePrototypeB implements PrototypeInterface{
    // concrete prototype inner fields
    private float arg1;
    private boolean arg2;

    ConcretePrototypeB(float arg1, boolean arg2){
        this.arg1=arg1;
        this.arg2=arg2;
    }

    // konstruktor który wywoływany jest w kontekście klonowania obiektu
    // object_to_clone <- obiekt oryginalny (źródło)
    // this <- obiekt docelowy (cel)
    ConcretePrototypeB(ConcretePrototypeB object_to_clone){
        this.arg1=object_to_clone.arg1;
        this.arg2=object_to_clone.arg2;
    }

    // metoda wywoływana na obiektcie-źródło z którego dane będą kopiowane
    // this <- obiekt oryginalny (źródło)
    @Override
    public PrototypeInterface clone() {
        return new ConcretePrototypeB(this);
    }

    //nadpisanie metody equals, żeby porównywać stan zawartości obiektów a nie referencje do obiektów
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ConcretePrototypeB)) return false;
        ConcretePrototypeB proto_inf = (ConcretePrototypeB) obj;
        return proto_inf.arg1 == this.arg1 && proto_inf.arg2 == this.arg2;
    }
}

/*
 * Sidenote (baseline refresh):
 * - konstruktor jest metodą która nie zwraca wyniku, bo się wykonuje w kontekście inicjalizowanego obiektu ('this' jest zainicjalizowanym obiektem na którym wykonywane są operacje)
 * - 'this' jest zawsze obiektem w kontekście którego aktualnie wykonuje się kod, to wykorzystanie metody decyduje czym docelowo jest 'this' (czy metoda jest wykonywana na obiekcie czy obiekt jest przekazywany jako parametr do metody innego obiektu)
 * */
