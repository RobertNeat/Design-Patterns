package design_patterns.strukturalne.pyłek.definition;

//zawiera unikalny stan
public class Context {
    private int x;
    private int y;
    private int z;

    //dobrą praktyką jest przechowywanie referencji do pyłka jako 'private final' żeby uniknąć przypadkowej podmiany referencji
    private final Flyweight stan_wspolny;

    public Context(int x, int y, int z, Flyweight flyweight){
        this.x=x;
        this.y=y;
        this.z=z;
        this.stan_wspolny=flyweight;
    }

    public void position_XYZ(){
        stan_wspolny.position(x,y,z);
    }
}
