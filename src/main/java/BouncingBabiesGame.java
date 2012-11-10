import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: aaron
 * Date: 11/10/12
 * Time: 10:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class BouncingBabiesGame extends JComponent
        implements ActionListener {

    private int gameWidth = 800;
    private int gameHeight = 600;
    private int groundHeight = 40;
    private int buildingWidth = 60;
    private int babyX = 50;
    private double babyY = 100;
    private double babyYSpeed = 0;
    private int gravity = 1;

    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame("Save the Babies!");
        BouncingBabiesGame game = new BouncingBabiesGame();
        window.add(game);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

        Timer t = new Timer(30, game);
        t.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(gameWidth, gameHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Background
        g.setColor(Color.black);
        g.fillRect(0, 0, gameWidth, gameHeight);

        // Ground
        g.setColor(Color.white.darker());
        g.fillRect(0, gameHeight - groundHeight, gameWidth, groundHeight);

        // Building
        g.setColor(new Color(212, 81, 58));
        g.fillRect(0, 60, buildingWidth, gameHeight - 60 - 40);

        // Ambulance
        g.setColor(Color.white);
        g.fillRect(680, 460, 120, 100);

        // Firemen
        g.setColor(new Color(84, 163, 181));
        int firemanX = 400;
        g.fillRect(firemanX, gameHeight - groundHeight - 60, 30, 60);
        g.fillRect(firemanX + 150, gameHeight - groundHeight - 60, 30, 60);

        // Trampoline
        g.setColor(Color.white);
        g.fillRect(firemanX + 15, 600 - 40 - 60 + 35, 150, 10);

        // Baby
        g.setColor(new Color(241, 209, 86));
        g.fillRect(babyX, (int) babyY, 25, 25);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        babyX = babyX + 4;
        babyY = babyY + babyYSpeed;
        babyYSpeed = babyYSpeed + gravity;
        repaint();
    }
}
