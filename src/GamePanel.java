import java.awt.Color;
import java.awt.Font;
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
final int MENU_STATE = 0;
final int GAME_STATE = 1;
final int END_STATE = 2;
int currentState = MENU_STATE;
Font titleFont;
Font startAndEndMenu;
Rocketship rocket = new Rocketship(250,700,50,50);
ObjectManager manager = new ObjectManager();
String myScore;
public GamePanel() {
	timer = new Timer(1000/60,this);
	titleFont = new Font("Arial", Font.PLAIN, 48);
	startAndEndMenu = new Font("Arial", Font.PLAIN, 25);
	manager.addObject(rocket);
}
@Override
public void actionPerformed(ActionEvent e) {
	repaint();
	if(currentState == MENU_STATE) {
		updateMenuState();
	} else if(currentState == GAME_STATE) {
		updateGameState();
	} else if(currentState == END_STATE) {
		updateEndState();
	}
}
public void startGame() {
	timer.start();
}
public void paintComponent(Graphics g){
	if(currentState == MENU_STATE) {
		drawMenuState(g);
	} else if(currentState == GAME_STATE) {
		drawGameState(g);
	} else if(currentState == END_STATE) {
		drawEndState(g);
	}
}
public void updateMenuState() {
	
}
public void updateGameState() {
	manager.update();
	manager.manageEnemies();
	manager.checkCollision();
	if(rocket.isAlive==false) {
		currentState=END_STATE;
		manager.getScore();
		manager.reset();
		rocket = new Rocketship(250,700,50,50);
		manager.addObject(rocket);
	}
	myScore = "" + manager.getScore();

}
public void updateEndState() {

}
public void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
	g.drawString("LEAGUE INVADERS", 25,200);
	g.setColor(Color.YELLOW);
	g.setFont(startAndEndMenu);
	g.drawString("Press ENTER to start", 130, 300);
	g.drawString("Press SPACE for instructions", 100, 400);
}
public void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	manager.draw(g);
}
public void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	g.drawString("GAME OVER", 100, 125);
	g.setFont(startAndEndMenu);
	g.drawString("You killed "+ myScore +" aliens.", 125, 300);
	g.setFont(startAndEndMenu);
	g.drawString("Press BACKSPACE to Restart", 75, 500);
}

@Override
public void keyTyped(KeyEvent e) {
	System.out.println("KEYTYPED");
	
}
@Override
public void keyPressed(KeyEvent e) {
	
	if(e.getKeyCode()==KeyEvent.VK_ENTER){
		currentState++;
		if(currentState == GAME_STATE) {
			manager.setScore(0);
		}
	
	} 
	if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
		currentState = MENU_STATE;

	}
	if(currentState > END_STATE){
		currentState = MENU_STATE;
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		System.out.println("keypressed");
		rocket.left=true;
	} 
	if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		System.out.println("keypressed");
		rocket.right=true;
	}
	if(e.getKeyCode()==KeyEvent.VK_UP) {
		System.out.println("keypressed");
		rocket.up=true;
	} 
	if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		System.out.println("keypressed");
		rocket.down=true;
	}
	if(e.getKeyCode()==KeyEvent.VK_SPACE) {
		manager.addObject(new Projectile(rocket.x+20, rocket.y, 10, 10));
	}
}

@Override
public void keyReleased(KeyEvent e) {
	System.out.println("keyreleased");
	if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		rocket.left=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		rocket.right=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_UP) {
		rocket.up=false;
	}
	if(e.getKeyCode()==KeyEvent.VK_DOWN) {
		rocket.down=false;
	}
}

}
