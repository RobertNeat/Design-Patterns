package design_patterns.strukturalne.dekorator.definition;

//dekorator dodający swój tekst 'przed' wykonaniem konkretnego komponentu
public class ConcreteDecorator_Prepend extends BaseDecorator{
    private String prependix;

    public ConcreteDecorator_Prepend(ComponentInterface wrapee, String prependix) {
        super(wrapee);
        this.prependix=prependix;
    }

    private String prepend_text(String text, String prependix){
        return prependix+text;
    }

    @Override
    public String execute(){
        return prepend_text(wrapee.execute(),prependix);
    }
}
