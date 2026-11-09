package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class dania_builder implements builder{
    int talerz;
    String skladniki;
    @Override
    public builder reset() {
        talerz=1;
        return this;
    }

    @Override
    public builder przyjecie() {
        talerz=-1;
        skladniki="";
        return this;
    }

    @Override
    public builder realizacja() {
        skladniki+="salata,ogorek,smietana";
        return  this;
    }

    @Override
    public builder przekazanie() {
        skladniki+=",sos";
        return this;
    }

    public posilek getResult(){
        posilek pos=new posilek(this);
        this.reset();
        return pos;
    }
}
