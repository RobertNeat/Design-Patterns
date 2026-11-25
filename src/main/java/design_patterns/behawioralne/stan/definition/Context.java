package design_patterns.behawioralne.stan.definition;

import java.util.Objects;

//Przechowuje aktualny stan.
//Udostępnia metodę pozwalającą zmienić stan.
//Udostępnia metody operacji, które delegują wykonanie do aktualnego stanu.
public class Context {
    //pole przechowujący aktualny konkretny stan (używamy typu interfejsu, żeby móc podmieniać stany)
    private StateInterface state;
    //pole sterujące przejściami (dodane do context dla wygody)
    private boolean inverse;

    // Dane przechowywane przez Context
    private int counter;
    private int score;
    private String text;
    private boolean flag;

    //ustawienie początkowego stanu
    public Context(StateInterface state){
        this.state=Objects.requireNonNull(state);//zabezpieczenie przed inicjalizacją null'em
        inverse=false;

        this.counter=0;
        this.score=0;
        this.text="";
        this.flag=false;
    }

    //możliwość podmian stanów w trakcie działania programu
    public void setState(StateInterface state){
        this.state=Objects.requireNonNull(state);//zabezpieczenie przed inicjalizacją null'em
    }

    //context przekazuje wykonanie operacji bieżącemu stanowi
    public void performAction(){
        state.performAction(this);
    }

    //dodatkowa metoda nie wchodząca w skład wzoca (jedynie do zademonstrowania odwracania kolejności
    public void reverseDirection() {
        this.inverse = !this.inverse;
    }

    //getters & setters
    public boolean isInverse(){
        return inverse;
    }

    public void setInverse(boolean value){
        this.inverse=value;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    // Wyświetlanie danych Context
    public void displayData() {
        System.out.println("\tCounter: " + counter);
        System.out.println("\tScore: " + score);
        System.out.println("\tText: " + text);
        System.out.println("\tFlag: " + flag);
        System.out.println("\tInverse: " + inverse);
    }
}