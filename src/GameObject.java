import java.awt.Graphics;

public class GameObject {
int x;
int y;
int width;
int height;

public void update() {
	y++;
	x++;
}
public void draw(Graphics g) {
	g.fillRect(x, y, 100, 100);
}
}