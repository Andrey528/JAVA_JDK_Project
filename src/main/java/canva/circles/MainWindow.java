package canva.circles;

import canva.common.CanvasRepaintListener;
import canva.common.Interectable;
import canva.common.MainCanvas;
import canva.common.Sprite;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    private final Interectable[] interactables = new Interectable[10];
    private Background background;

    public MainWindow(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Circles");
        background = new Background();

        for (int i = 0; i < interactables.length; i++) {
            interactables[i] = new Ball();
        }

        MainCanvas canvas = new MainCanvas(this);

        add(canvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    public void update(MainCanvas canvas, float deltaTime) {
        background.update(canvas, deltaTime);
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].update(canvas, deltaTime);
        }
    }

    public void render(MainCanvas canvas, Graphics g) {
        background.render(canvas, g);
        for (int i = 0; i < interactables.length; i++) {
            interactables[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
