
package Model;
// xây dựng cơ sở cho sub_View Menu

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {
    
    private Icon icon;
    private String menuName;
    private String subMenu[];
    
    // contructor

    public Model_Menu() {
    }

    public Model_Menu(Icon icon, String menuName, String... subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }
    
    // get and set

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName= menuName;
    }

    public String[] getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }
    
}
