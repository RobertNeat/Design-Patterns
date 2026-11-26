package design_patterns.behawioralne.metoda_szablonowa.dish_preparation;

public class PizzaPreparation extends AbstractDishPreparation{
    @Override
    protected String prepareIngredients() {
        System.out.println("Przygotuj mąkę, wodę, oliwę, sos pomidorowy, salami, ser, bazylię");
        return "raw ingredients";
    }

    @Override
    protected String preliminaryProcessing(String ingredients) {
        if(ingredients.equals("raw ingredients")) {
        System.out.println("Zagnieć mąkę z wodą i oliwą na ciasto. Pokrój salami i ser, otwórz sos pomidorowy, umyj bazylię i oderwij łodyżki");
            return "prepared_ingredients";
        }
        return "none pizza ingredients";
    }

    @Override
    protected void hookBeforeMainProcessing(){
        System.out.println("Nagrzej piekarnik do 220 stopni");
    }

    @Override
    protected String mainProcessing(String ingredients) {
        if(ingredients.equals("prepared ingredients")){
            System.out.println("Rozciągnij ciasto, ułóż składniki i włóż do piekarnika do upieczenia");
            return "complete dish";
        }
        return "empty plate";
    }

    @Override
    protected String finalizeDish(String dish){
        if(dish.equals("complete dish")) {
        System.out.println("Dodaj świeżą bazylię i pokrój pizzę na trójkąty");
            return dish;
        }
        return "empty plate";
    }
}
