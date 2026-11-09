package design_patterns.kreacyjne.prototyp.daniespecjalne;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//REJESTR PROTOTYPÓW dań specjalnych
public class RejestrDanSpecjalnych {
    private Map<String, DanieSpecjalneInterfejs> cache = new HashMap<>();

    public RejestrDanSpecjalnych() {
        DanieDnia szablonSteka = new DanieDnia(
                "Stek z antrykotu",
                "Sezonowana wołowina z masłem czosnkowym",
                45.0,
                List.of("wołowina", "masło", "czosnek", "rozmaryn"),
                LocalDate.now(),
                20
        );
        cache.put("STANDARDOWY_STEK", szablonSteka);

        ZupaDnia szablonKremu = new ZupaDnia(
                "Krem z pieczonej dyni",
                "Aromatyczny krem z pestkami dyni i oliwą z oliwek",
                18.0,
                List.of("seler", "śmietana"),
                LocalDate.now(),
                15
        );
        cache.put("STANDARDOWY_KREM",szablonKremu);
    }

    public DanieSpecjalneInterfejs put(String key, DanieSpecjalneInterfejs prototype) {
        cache.put(key, prototype);
        return prototype;
    }

    public DanieSpecjalneInterfejs get(String key) {
        return cache.get(key).clone();
    }
}
