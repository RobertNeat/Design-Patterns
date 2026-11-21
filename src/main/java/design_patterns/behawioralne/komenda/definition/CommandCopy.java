package design_patterns.behawioralne.komenda.definition;

//KONKRETNE POLECENIE
//implementuje żądanie kopiowania
public class CommandCopy implements CommandInterface{
    TextEditor editor;
    int index;
    String historic_clipboard;//after copy undo the clipboard should be restored

    public CommandCopy(TextEditor editor,int index_to_copy){
        this.editor=editor;
        this.index=index_to_copy;
    }

    @Override
    public void execute() {
        this.historic_clipboard= editor.getClipboard();
        editor.setClipboard(editor.getTextAt(this.index));
    }

    @Override
    public void undo() {
        this.editor.setClipboard(historic_clipboard);
        this.historic_clipboard="";
    }
}
