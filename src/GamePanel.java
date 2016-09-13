import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
Timer timer;
GameObject object;
public GamePanel() {
	timer = new Timer(1000/60,this);
	object = new GameObject();
}
@Override
public void actionPerformed(ActionEvent e) {
	repaint();
	object.update();
}
public void startGame() {
	timer.start();
}
public void paintComponent(Graphics g){
	object.draw(g);
}

@Override
public void keyTyped(KeyEvent e) {
	System.out.println("hi");
	
}
@Override
public void keyPressed(KeyEvent e) {
	System.out.println("hi");
	
}
@Override
public void keyReleased(KeyEvent e) {
	System.out.println("hi");
	
}

}
