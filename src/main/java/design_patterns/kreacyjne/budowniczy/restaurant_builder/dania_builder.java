package design_patterns.kreacyjne.budowniczy.restaurant_builder;

public class dania_builder implements builder{
    int talerz;
    String skladniki;
    @Override
    public void reset() {
        talerz=1;
    }

    @Override
    public void przyjecie() {
        talerz=-1;
        skladniki="";
    }

    @Override
    public void realizacja() {
        skladniki+="salata,ogorek,smietana";
    }

    @Override
    public void przekazanie() {
        skladniki+=",sos";
    }

    public posilek getResult(){
        posilek pos=new posilek(talerz, skladniki);
        this.reset();
        return pos;
    }
}
