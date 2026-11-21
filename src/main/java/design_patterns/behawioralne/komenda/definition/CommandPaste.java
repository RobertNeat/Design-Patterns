package design_patterns.behawioralne.komenda.definition;

//KONKRETNE POLECENIE
//implementuje żądanie wklejania
public class CommandPaste implements CommandInterface{
    TextEditor editor;
    int paste_index;//paste-command needs to know the position that the text was pasted
    String pasted_text; //paste-command for undo cannot rely on current clipboard state
    //^ we assume one word paste for simplicity

    public CommandPaste(TextEditor editor,int paste_index){
        this.editor=editor;
        this.paste_index=paste_index;
    }

    @Override
    public void execute() {
        //paste at position (save pasted text and pasted position)
        this.pasted_text = this.editor.getClipboard();
        this.editor.setTextAt(pasted_text,paste_index);
    }

    @Override
    public void undo() {
        //if at paste_index is the word pasted_text then delete element at that position
        if(this.editor.getTextAt(paste_index).equals(pasted_text)){
            this.editor.removeTextAt(paste_index);
        }else{
            System.out.println("[command-paste .. undo] The editor text changed after paste cannot undo paste! ..aborted");
        }
    }
}
