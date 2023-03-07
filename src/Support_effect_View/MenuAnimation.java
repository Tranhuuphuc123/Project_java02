package Support_effect_View;
// phần tạo hiệu ứng động cho Menu
import View_Main.Menu_Item;
import java.awt.Component;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class MenuAnimation {

    private final MigLayout layout;
    private final Menu_Item menu_Item;
    private Animator animator;
    private boolean open;

    public MenuAnimation(MigLayout layout, Component component) {
        this.layout = layout;
        this.menu_Item = (Menu_Item) component;
        initAnimator(component, 200);
    }

    public MenuAnimation(MigLayout layout, Component component, int duration) {
        this.layout = layout;
        this.menu_Item = (Menu_Item) component;
        initAnimator(component, duration);
    }

    private void initAnimator(Component component, int duration) {
        int height = component.getPreferredSize().height;
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                float h;
                if (open) {
                    h = 40 + ((height - 40) * fraction);
                    menu_Item.setAlpha(fraction);
                } else {
                    h = 40 + ((height - 40) * (1f - fraction));
                    menu_Item.setAlpha(1f - fraction);
                }
                layout.setComponentConstraints(menu_Item, "h " + h + "!");
                component.revalidate();
                component.repaint();
            }
        };
        animator = new Animator(duration, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
    }

    public void openMenu() {
        open = true;
        animator.start();
    }

    public void closeMenu() {
        open = false;
        animator.start();
    }
}
