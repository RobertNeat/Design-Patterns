package design_patterns.kreacyjne.fabryka_abstrakcyjna.kuchnie_swiata;

public class kuchnia_niemiecka implements kuchnia{
    @Override
    public zupa create_zupa(){
        return new zupa_niemiecka();
    }
    @Override
    public glowne create_glowne(){
        return new glowne_niemieckie();
    }
    @Override
    public deser create_deser(){
        return new deser_niemiecki();
    }
}
