
package View_Main;

import Controler.EventShowPopupMenu;
import Controler.Event_Menu_Selected;
import Form.Form1;
import Form.Form_Home;
import Form.Form_Main;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class Main extends javax.swing.JFrame {
    private MigLayout layout;
    private Menu menu;
    private Header header;
    private Form_Main form_main;
    private Animator animator;
    
    
    public Main() {
        initComponents();
        init();
    }
    
    // hàm init xây dựng chức nang giao diện thêm
    public void init(){
        // tùy chỉnh hiển thị và khoảng cách giữa các component: menu , header, Form
          layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
          Panel_Main.setLayout(layout);
          menu = new Menu();
          header = new Header();
          form_main = new Form_Main();
          
          // hiển thị thông tin lên menu file 
          
          // đoạn này có chức nang cụ thể dùng để chuyển đổi giao diện giữa các forrm liên kết, giống kiểu chuyển panel của card layout
           menu.addEvent(new Event_Menu_Selected() {
            @Override
            public void menuSelected(int menuIndex, int subMenuIndex) {
                System.out.println("Menu Index : " + menuIndex + " SubMenu Index " + subMenuIndex);
               // xử lý item mục lớn đầu tiên 
                if (menuIndex == 0) {
                    // lk đến sub item đầu tiên của item lớn
                    if (subMenuIndex == 0) {
                        form_main.showForm(new Form_Home());
                    } else if (subMenuIndex == 1) {
                        form_main.showForm(new Form1());
                    }
                }
                
                // xử lý cho đoạn mục item lớn thứ 2
                else if (menuIndex == 1) {
                      if (subMenuIndex == 0) {
                          form_main.showForm(new Form_Home());
                      } else if (subMenuIndex == 1) {
                          form_main.showForm(new Form1());
                      }
                  }
                
            }
        });
           
        // xử lý event showw popup ẩn hiện sub menu_item khi ẩn menu UI chính
        // tức là khi ẩn menu UI chính vào trong thì nó giúp hiển thị các mục menu_item ra khi rê chuột vào mục menu Ui chính đó
        
         menu.addEventShowPopup(new EventShowPopupMenu() {
            @Override
            public void showPopup(Component com) {
                Menu_Item item = (Menu_Item) com;
                PopupMenu popup = new PopupMenu(Main.this, item.getIndex(), item.getEventSelected(), item.getMenu().getSubMenu());
                int x = Main.this.getX() + 52;
                int y = Main.this.getY() + com.getY() + 86;
                popup.setLocation(x, y);
                popup.setVisible(true);
            }
        });
           
           
           menu.initMenuItem();       
           
           // thêm các header menu và forrm_main vào Main_view
           Panel_Main.add(menu,"w 230!, spany 2");
           Panel_Main.add(header,"h 50!, wrap");
           Panel_Main.add(form_main, "w 100%, h 100%");  
           
           
           
          /*toàn bộ code xử lý chức năng ẩn hiện giấu và showw phần menu ra*/ 
           TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menu.isShowMenu()) {
                    width = 60 + (170 * (1f - fraction));
                } else {
                    width = 60 + (170 * fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
                menu.setEnableMenu(true);
            }

        };
           
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!animator.isRunning()) {
                    animator.start();
                }
                
                // giúp ẩn menu
                menu.setEnableMenu(false);
                if (menu.isShowMenu()) {
                     menu.hideallMenu();
                }
            }
        });
       /*toàn bộ code xử lý chức năng ẩn hiện giấu và show phần menu ra*/ 
        
       
       // gọi giao diện showw Forrm_main ra hiển thị đầu tiên khi chạy chtrinh
        form_main.showForm(new Form_Home());
       
      // kết thúc phần init  
    }

    
    // init component
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_Main = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(100, 20));

        Panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Main.setAutoscrolls(true);
        Panel_Main.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Panel_Main.setFocusCycleRoot(true);
        Panel_Main.setFocusTraversalPolicyProvider(true);
        Panel_Main.setRequestFocusEnabled(false);

        javax.swing.GroupLayout Panel_MainLayout = new javax.swing.GroupLayout(Panel_Main);
        Panel_Main.setLayout(Panel_MainLayout);
        Panel_MainLayout.setHorizontalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1200, Short.MAX_VALUE)
        );
        Panel_MainLayout.setVerticalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_Main;
    // End of variables declaration//GEN-END:variables
}
