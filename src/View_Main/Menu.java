
package View_Main;

import Controler.EventShowPopupMenu;
import Controler.Event_Menu;
import Controler.Event_Menu_Selected;
import Model.Model_Menu;
import Support_effect_View.MenuAnimation;
import Support_effect_View.ScrollBarCustom;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;


public class Menu extends javax.swing.JPanel {   


    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(Event_Menu_Selected event) {
        this.event = event;
    }



    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }


    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }
    
    private final MigLayout layout;
    private Event_Menu_Selected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;
    
    
    public Menu() {
        initComponents();
        setOpaque(false);
        
        // ScrollBarCusstom class xây dựng để tạo chuyển động khi Scroll cho mượt, nhanh nằm mục Support_efect_View
        jScrollPane_Menu.getViewport().setOpaque(false);
        jScrollPane_Menu.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]0[]");
        panel_menu.setLayout(layout);
    }

    
    public void initMenuItem() {
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/Icon/1.png")), "Dashboard", "Home", "Log in", "Log out","Register","Help?"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/Icon/2.png")), "Charts", "?", "?", "?"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/Icon/5.png")), "Staff", "User", "Worrk"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/Icon/6.png")), "Student", "Information", "handling function"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/Icon/7.png")), "Library", "Information", "Menu 002", "Menu 003"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/Icon/12.png")), "File Manager", "Open", "Save", "Edit"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/Icon/14.png")), "About","introduce","User manual"));
    }
    
    
    
    
    
      private void addMenu(Model_Menu model_menu) {
         panel_menu.add(new Menu_Item(model_menu, getEventMenu(), event, panel_menu.getComponentCount()), "h 40!");
    }
    
      
   // method xử lý MenuAnimation hiệu ứng thao tác khi ấn vào các mục của menu
    private Event_Menu getEventMenu() {
        return new Event_Menu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        // chỗ xử lý ẩn hiện mêu sub_menuItem khi an menu uI chính
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }
    
    
    
    // method xu ly an menu ket hop voi TimingTarget ben Main.java
    public void hideallMenu() {
        for (Component com : panel_menu.getComponents()) {
            Menu_Item item = (Menu_Item) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 500).closeMenu();
                item.setOpen(false);
            }
        }
    }
    // giao diện component
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane_Menu = new javax.swing.JScrollPane();
        panel_menu = new javax.swing.JPanel();
        logo_Project1 = new View_Main.Logo_Project();

        jScrollPane_Menu.setBorder(null);
        jScrollPane_Menu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panel_menu.setOpaque(false);

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 281, Short.MAX_VALUE)
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        jScrollPane_Menu.setViewportView(panel_menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logo_Project1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, Short.MAX_VALUE)
            .addComponent(jScrollPane_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logo_Project1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane_Menu, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

  
    
    
    
    
    // xử lý chuyển màu cho menu 
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, 0, new Color(205, 102, 29), getWidth(), 0, new Color(255, 64, 64));
        g2.setPaint(gra);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane_Menu;
    private View_Main.Logo_Project logo_Project1;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables
}
