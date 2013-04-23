
package foodlink;

import foodlink.forms.MainForm;

/**
 *
 * @author J. Santos
 */
public class FoodLink
{
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }
}
