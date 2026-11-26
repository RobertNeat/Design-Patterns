package design_patterns.behawioralne.metoda_szablonowa.dish_preparation;

public class SoupPreparation extends AbstractDishPreparation{
    @Override
    protected String prepareIngredients() {
        System.out.println("Przygotuj warzywa, mięso i inne składniki oraz przyprawy.");
        return "raw ingredients";
    }

    @Override
    protected String preliminaryProcessing(String ingredients) {
        if(ingredients.equals("raw ingredients")) {
        System.out.println("Obierz i pokrój warzywa.");
            return "prepared_ingredients";
        }
        return "none soup ingredients";
    }

    @Override
    protected String mainProcessing(String ingredients) {
        if(ingredients.equals("prepared ingredients")){
            System.out.println("Przygotuj wywar i zagotuj składniki. Dopraw do smaku.");
            return "complete dish";
        }
        return "empty plate";
    }

    @Override
    protected void hookAfterIngredientsPreparation(){
        System.out.println("Porcjonuj mięso.");
    }

    @Override
    protected void hookBeforeMainProcessing(){
        System.out.println("Przygotuj garnek i zacznij podgrzewać wodę.");
    }

    @Override
    protected String finalizeDish(String dish){
        if(dish.equals("complete dish")) {
            System.out.println("Przygotuj głęboki talerz i nalej chochlą zupę");
            return dish;
        }
        return "empty plate";
    }
}
