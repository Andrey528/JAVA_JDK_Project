package canva.common;

import java.awt.*;

public interface Interectable {
    void update(MainCanvas canvas, float deltaTime);
    void render(MainCanvas canvas, Graphics g);
}
