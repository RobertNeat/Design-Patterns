package design_patterns.behawioralne.komenda.definition;


//KONKRETNE POLECENIE
//implementuje żądanie wycinania
public class CommandCut implements CommandInterface{
    TextEditor editor;

    String cut_text;//co zostało wycięte
    int cut_index;//index na jakim zostało wycięte
    String before_cut_clipboard;//stan schowka sprzed wycięcia

    public CommandCut(TextEditor editor,int cut_index){
        this.editor=editor;
        this.cut_index=cut_index;
    }

    @Override
    public void execute() {
        //save clipboard, cut text at position, remove text at position, save new clipboard,
        if(!this.editor.getText().isEmpty()){//be core to not cut empty editor text
            this.before_cut_clipboard=this.editor.getClipboard();
            this.cut_text = this.editor.getTextAt(cut_index);//omit the checking if index is within editor text bounds for brevity .. but texteditor gains more methods each check and action so maybe the fields should be public
            this.editor.removeTextAt(cut_index);
            this.editor.setClipboard(this.cut_text);
        }else{
            System.out.println("[cut-command] Cannot cut from empty text editor!");
        }
    }

    @Override
    public void undo() {
        if (this.editor.getClipboard().equals(this.cut_text)) {//check if the clipboard have cut text and if so restore state
            this.editor.insertTextAt(this.cut_text, this.cut_index);
            this.editor.setClipboard(this.before_cut_clipboard);
        } else {
            System.out.println(
                    "[cut-command undo] Could not undo cut, clipboard state does not contain cut text!"
            );
        }
    }
}
