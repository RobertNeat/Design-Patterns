package design_patterns.behawioralne.pamiątka.definition;

public class Originator<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    //metoda służąca do stworzenia obiektu pamiątki (snapshot stanu originator'a)
    public Memento<T> save(){
        return new Memento<>(this.value);
    }

    //metoda przywracająca stan originator na podstawie obiektu pamiątki (na podstawie snapshot'a)
    public void restore(Memento<T> memento){
        this.value = memento.value;
    }

    //zagnieżdżona klasa pamiątki (musi być protected lub package_private, żeby caretaker mógł przechowywać historię pamiątek)
    protected static class Memento<T>{
        private final T value; //przechowuje niemutowalne wartości pola pozyskane od originator

        //pamiątka ma być niemutowalna, więc stan obiektu pamiątki jest inicjalizowany w konstruktorze
        public Memento(T value){
            this.value=value;
        }
    }
}
