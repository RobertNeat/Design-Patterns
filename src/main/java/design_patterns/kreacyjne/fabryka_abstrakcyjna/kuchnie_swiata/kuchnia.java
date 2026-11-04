package design_patterns.kreacyjne.fabryka_abstrakcyjna.kuchnie_swiata;

public interface kuchnia {
    zupa create_zupa();
    glowne create_glowne();
    deser create_deser();
}
