
package Form;

// forrm chính xử lý tác vụ chuyển giao diện các forrm khi ấn mục sở thị tg ứng tên forrm đó

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.border.EmptyBorder;

public class Form_Main extends javax.swing.JPanel {

    public Form_Main() {
        initComponents();
        setOpaque(false);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(0, 2, 0, 2));
    }

    
    // mehtod showwmenu showw các menu forrm khi ấn lk tg ứng tên
     public void showForm(Component form) {
        removeAll();
        add(form);
        repaint();
        revalidate();
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
