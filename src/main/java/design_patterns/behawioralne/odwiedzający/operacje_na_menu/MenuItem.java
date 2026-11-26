package design_patterns.behawioralne.odwiedzający.operacje_na_menu;


public interface MenuItem {
    void accept(MenuVisitor visitor);
}
