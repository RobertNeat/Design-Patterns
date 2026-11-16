package design_patterns.strukturalne.kompozyt.definition;

public class Leaf implements Komponent {
    private int value;

    public Leaf (int value){
        this.value=value;
    }

    //wykonanie pracy przez liść
    @Override
    public int execute() {
        return value;
    }
}
