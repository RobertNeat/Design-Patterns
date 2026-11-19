package design_patterns.strukturalne.pełnomocnik.definition;

//stworzony interfejs który jest zgodny z klasą "Service" co pozwoli na późniejsze wymienienie Proxy zamiast użycia Service
public interface ServiceInterface {
    public String resolve(String domain);
}
