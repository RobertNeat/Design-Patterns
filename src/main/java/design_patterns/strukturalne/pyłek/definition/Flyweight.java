package design_patterns.strukturalne.pyłek.definition;

//zawiera stan wspólny
public class Flyweight {
    //warto pola pyłka zadeklarować jako 'final' żeby jego stan był niezmienny
    private final String name;
    private final String hex_color;

    //jedynie konstruktor inicjalizujący wartości, ponieważ pyłek po stworzeniu nie powinien być modyfikowany
    public Flyweight(String name, String hex_color){
        this.name=name;
        this.hex_color=hex_color;
    }

    public void position(int x, int y, int z){
        System.out.println("Name: "+name+", hex_color: "+hex_color);
        System.out.println("Positioning at X:"+x+", Y:"+y+", Z:"+z);
    }
}
