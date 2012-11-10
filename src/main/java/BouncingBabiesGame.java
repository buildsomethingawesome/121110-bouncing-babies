import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: aaron
 * Date: 11/10/12
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class BouncingBabiesGame extends JComponent {

    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("Save the Babies!");
        BouncingBabiesGame game = new BouncingBabiesGame();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 600);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Background
        g.setColor(Color.black);
        g.fillRect(0, 0, 800, 600);

        // Ground
        g.setColor(Color.white.darker());
        g.fillRect(0, 600 - 40, 800, 40);

        // Building
        g.setColor(new Color(212, 81, 58));
        int buildingWidth = 60;
        g.fillRect(0, 60, buildingWidth, 600 - 60 - 40);

        // Ambulance
        g.setColor(Color.white);
        g.fillRect(680, 460, 120, 100);

        // Firemen
        g.setColor(new Color(84, 163, 181));
        int firemanX = 400;
        g.fillRect(firemanX, 600 - 40 - 60, 30, 60);
        g.fillRect(firemanX + 150, 600 - 40 - 60, 30, 60);

        // Trampoline
        g.setColor(Color.white);
        g.fillRect(firemanX + 15, 600 - 40 - 60 + 35, 150, 10);

        // Baby
        g.setColor(new Color(241, 209, 86));
        g.fillRect(400, 300, 25, 25);
    }
}
