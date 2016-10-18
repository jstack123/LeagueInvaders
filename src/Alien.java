import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject{
	int speed = 5;

public Alien(int x, int y, int width, int height) {
	super();
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
}
public void update() {
	super.update();
	y+=speed;
}
//finished but still have to make the player lose when the alien hits the ground and the the instructions
public void draw(Graphics g) {
	g.drawImage(this.alienImg, x, y, width,height, null);
}
}
