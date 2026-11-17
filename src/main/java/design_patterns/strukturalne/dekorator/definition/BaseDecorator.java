package design_patterns.strukturalne.dekorator.definition;

//najważniejsza klasa we wzorcu, pozwala na przchowywanie odwołań do opakowywanych obiektów i implementuje interfejs komponentu
public class BaseDecorator implements ComponentInterface{
    ComponentInterface wrapee;

    public BaseDecorator(ComponentInterface wrapee){
        this.wrapee=wrapee;
    }

    @Override
    public String execute() {
        return wrapee.execute();
    }
}
