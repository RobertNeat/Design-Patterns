package design_patterns.behawioralne.metoda_szablonowa.definition;

//KLASA ABSTRAKCYJNA
public abstract class AbstractTemplate {

    //Metoda szablonowa
    public final void templateMethod(){
        stepOne();//etap abstrakcyjny - do zdefiniowana w konkretnej klasie
        hookAfterStepOne();//opcjonalny etap umożliwiający na rozszerzenie algorytmu przez podklasy
        hookBeforeStepTwo();
        stepTwo();//etap abstrakcyjny - do zdefiniowana w konkretnej klasie
        hookAfterStepTwo();//opcjonalny etap umożliwiający na rozszerzenie algorytmu przez podklasy
        stepThree();//etap opcjonalny - zawiera wspólną logikę między algorytmami, ale można nadpisać w podklasie
    }

    // Etap abstrakcyjny (możliwe do nadpisania i wykorzystania jedynie przez podklasy)
    protected abstract void stepOne();

    // Etap abstrakcyjny (możliwe do nadpisania i wykorzystania jedynie przez podklasy)
    protected abstract void stepTwo();

    // Etap opcjonalny (możliwe do nadpisania i wykorzystania jedynie przez podklasy)
    protected void stepThree() {
        System.out.println("Default implementation of stepThree");
    }

    // Hook'i (możliwe do nadpisania i wykorzystania jedynie przez podklasy), muszą mieć ciało, żeby nie wymuszać na podklasach ich implementacji
    protected void hookAfterStepOne(){}
    protected void hookBeforeStepTwo(){}
    protected void hookAfterStepTwo(){}
}
