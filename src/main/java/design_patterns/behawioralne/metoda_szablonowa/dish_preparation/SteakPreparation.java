package design_patterns.behawioralne.metoda_szablonowa.dish_preparation;

public class SteakPreparation extends AbstractDishPreparation{
    @Override
    protected String prepareIngredients() {
        System.out.println("Przygotuj kawałek mięsa, sól, pieprz i dodatki.");
        return "raw ingredients";
    }

    @Override
    protected String preliminaryProcessing(String ingredients) {
        if(ingredients.equals("raw ingredients")) {
            System.out.println("Oczyść i osusz mięso, przypraw według gustu.");
            return "prepared ingredients";
        }
        return "none steak ingredients";
    }

    @Override
    protected String mainProcessing(String ingredients) {
        if(ingredients.equals("prepared ingredients")){
            System.out.println("Usmaż lub ugrilluj mięso do odpowiedniego stopnia wysmażenia.");
            return "complete dish";
        }
        return "empty plate";
    }
}
