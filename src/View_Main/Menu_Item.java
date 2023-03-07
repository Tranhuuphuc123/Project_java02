
package View_Main;

import Controler.Event_Menu;
import Controler.Event_Menu_Selected;
import Model.Model_Menu;
import Support_effect_View.MenuButton;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MenuItem;
import java.awt.RenderingHints;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import javax.swing.Icon;

public class Menu_Item extends javax.swing.JPanel {

    private float alpha;
    private Model_Menu model_menu;
    private boolean open;
    private Event_Menu_Selected eventSelected;
    private int index;
    
    
    // contructor  
    public Menu_Item(Model_Menu model_menu, Event_Menu event_menu, Event_Menu_Selected eventSelected, int index) {
        initComponents();
        this.model_menu = model_menu;
        this.eventSelected = eventSelected;
        this.index = index;
        setOpaque(false);
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "[fill, 40!]0[fill, 35!]"));
        MenuButton firstItem = new MenuButton(model_menu.getIcon(), "         " + model_menu.getMenuName());
        firstItem.addActionListener(new ActionListener() {
            // phần xử lý sự kiện khi ấn các muc của menu + MenuAnimation, giúp sổ các submenu con trong các menu lớn
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (model_menu.getSubMenu().length > 0) {
                    if (event_menu.menuPressed(Menu_Item.this, !open)) {
                       open = !open;
                    }
                }
                eventSelected.menuSelected(index, -1);
            }
        });
        
        add(firstItem);
        int subMenuIndex = -1;
        for (String st : model_menu.getSubMenu()) {
            MenuButton item = new MenuButton(st);
            item.setIndex(++subMenuIndex);
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    eventSelected.menuSelected(index, item.getIndex());
                }
            });
          add(item);  
        }
        
        
     // end contructor   
    }
    
    
    
    // method xây dựng thanh sổ và chuyển màu giao diệ cho submennu
     @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getPreferredSize().height;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(50, 50, 50));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.fillRect(0, 2, width, 38);
        g2.setComposite(AlphaComposite.SrcOver);
        g2.fillRect(0, 40, width, height - 40);
        g2.setColor(new Color(100, 100, 100));
        g2.drawLine(30, 40, 30, height - 17);
        for (int i = 0; i < model_menu.getSubMenu().length; i++) {
            int y = ((i + 1) * 35 + 40) - 17;
            g2.drawLine(30, y, 38, y);
        }
        if (model_menu.getSubMenu().length > 0) {
            createArrowButton(g2);
        }
        super.paintComponent(g);
    }
    
    
    
     // method xây dựng thanh sổ và chuyển màu giao diệ cho submennu
    
     private void createArrowButton(Graphics2D g2) {
        int size = 4;
        int y = 19;
        int x = 205;
        g2.setColor(new Color(230, 230, 230));
        float ay = alpha * size;
        float ay1 = (1f - alpha) * size;
        g2.drawLine(x, (int) (y + ay), x + 4, (int) (y + ay1));
        g2.drawLine(x + 4, (int) (y + ay1), x + 8, (int) (y + ay));
    }
    
    
    
    
    

    // get and set
    public Model_Menu getMenu() {
        return model_menu;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Event_Menu_Selected getEventSelected() {
        return eventSelected;
    }

    public void setEventSelected(Event_Menu_Selected eventSelected) {
        this.eventSelected = eventSelected;
    }

    public int getIndex() {
        return index;
    }
  
 
    
    
   
    
   

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
