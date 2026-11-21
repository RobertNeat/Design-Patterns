package design_patterns.behawioralne.komenda.definition;

import java.util.ArrayList;
import java.util.List;

// KLASA ODBIORCA – odbiorca operacji
// Przechowuje stan dokumentu i udostępnia operacje na tekście.
public class TextEditor {
    private List<String> text;
    private String clipboard;

    public TextEditor() {
        this.text = new ArrayList<>();
        this.clipboard = "";
    }

    public List<String> getText(){
        return List.copyOf(text);
    }

    public String getTextAt(int index){
        return text.get(index);
    }

    public void removeTextAt(int index){
        this.text.remove(index);
    }

    //metoda setTextAt sprawdza czy indeks jest w ramach o do index+1 (jeśli index+1 to dodaje element na końcu)
    public List<String> setTextAt(String text, int index) {
        if (index < 0 || index > this.text.size()) {
            throw new IndexOutOfBoundsException(
                    "Invalid index: " + index +
                            ", current list size: " + this.text.size()
            );
        }

        if (index == this.text.size()) {
            this.text.add(text);
        } else {
            this.text.set(index, text);
        }

        return this.text;
    }

    public String getClipboard(){
        return clipboard;
    }

    public void setClipboard(String text){
        this.clipboard=text;
    }

    public void insertTextAt(String text, int index) {
        this.text.add(index, text);
    }

}
