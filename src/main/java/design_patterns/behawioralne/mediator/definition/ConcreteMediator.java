package design_patterns.behawioralne.mediator.definition;

//klas mediatorów może być wiele i dzięki temu, że konkretne komponenty-klasy zależą od interfejsu, to konkretni mediatorzy są podmienialni
public class ConcreteMediator implements MediatorInterface{

    private ComponentClass_A componentA;
    private ComponentClass_B componentB;
    private ComponentClass_C componentC;

    public ConcreteMediator(ComponentClass_A componentA,ComponentClass_B componentB,ComponentClass_C componentC){
        this.componentA=componentA;
        this.componentB=componentB;
        this.componentC=componentC;
    }

    //metoda notify implementuje zależności między komponentami, dzięki temu zalezności są skoncentrowane a komponenty nie zależą od siebie
    @Override
    public void notify(AbstractComponent sender, String event) {
        //performActionA -> performActionB
        if(sender instanceof ComponentClass_A && event.equals("ComponentClass_A executed business logic")){
            componentB.performActionB();
        }

        //performActionB -> performActionC
        if(sender instanceof ComponentClass_B && event.equals("ComponentClass_B executed business logic")){
            componentC.performActionC();
        }

        //performActionC -> ...
        if(sender instanceof ComponentClass_C && event.equals("ComponentClass_C executed business logic")){
            System.out.println("C executed ... nothing to do ..");
        }
    }
}
