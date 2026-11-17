package design_patterns.strukturalne.dekorator.definition;

//dekorator dodający swój tekst 'po' wykonaniem konkretnego komponentu
public class ConcreteDecorator_Append extends BaseDecorator{
    private String appendix;

    public ConcreteDecorator_Append(ComponentInterface wrapee, String appendix) {
        super(wrapee);
        this.appendix=appendix;
    }

    private String append_text(String text, String appendix){
        return text+appendix;
    }

    @Override
    public String execute(){
        return append_text(wrapee.execute(),appendix);
    }
}
