import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject{
	int speed=5;
	boolean left = false;
	boolean right = false;
	boolean up = false;
	boolean down = false;
public Rocketship(int x, int y, int width, int height) {
	super();
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
}
public void update() {
	super.update();
	if(left) {
		x-=speed;
	}
	if(right) {
		x+=speed;
	}
	if(down) {
		y+=speed;
	}
	if(up) {
		y-=speed;
	}
}
public void draw(Graphics g) {
	g.drawImage(this.rocketImg, x, y, width, height, null);
}
}
