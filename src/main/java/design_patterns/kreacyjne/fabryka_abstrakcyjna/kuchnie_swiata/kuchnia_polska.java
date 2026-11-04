package design_patterns.kreacyjne.fabryka_abstrakcyjna.kuchnie_swiata;

public class kuchnia_polska implements kuchnia{
    @Override
    public zupa create_zupa(){
        return new zupa_polska();
    }
    @Override
    public glowne create_glowne(){
        return new glowne_polskie();
    }
    @Override
    public deser create_deser(){
        return new deser_polski();
    }
}
