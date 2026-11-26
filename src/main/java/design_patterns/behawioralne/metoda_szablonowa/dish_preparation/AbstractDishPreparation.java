package design_patterns.behawioralne.metoda_szablonowa.dish_preparation;

//prezentuje metodę szablonową z przepływem danych między etapami algorytmów
public abstract class AbstractDishPreparation {
    public final String prepareDish(){
        String raw_ingredients = prepareIngredients();//przygotowanie składników
        hookAfterIngredientsPreparation();
        String prepared_ingredients = preliminaryProcessing(raw_ingredients);//obróbka wstępna
        hookBeforeMainProcessing();
        String dish = mainProcessing(prepared_ingredients);//główna obróbka (właściwy proces przygotowania dania
        hookBeforeServing();
        return finalizeDish(dish);//podanie dania na talerzu
    }

    protected abstract String prepareIngredients();
    protected abstract String preliminaryProcessing(String ingredients);
    protected abstract String mainProcessing(String ingredients);

    protected String finalizeDish(String dish){
        if(dish.equals("complete dish")) {
            System.out.println("Przygotuj talerz i wyłóż danie");
            return dish;
        }
        return "empty plate";
    }

    //hooks
    protected void hookAfterIngredientsPreparation(){}//pozwala wykonać dodatkowe czynności po przygotowaniu produktów, ale przed obróbką wstępną
    protected void hookBeforeMainProcessing(){}//pozwala wykonać dodatkowe czynności bezpośrednio przed właściwym przygotowaniem dania.
    protected void hookBeforeServing(){}//pozwala wykonać dodatkowe czynności bezpośrednio przed wydaniem dania.
}
