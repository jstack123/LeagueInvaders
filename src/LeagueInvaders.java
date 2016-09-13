import javax.swing.JFrame;
import javax.swing.JPanel;

public class LeagueInvaders {
	final int width = 500;
	final int height = 800;
	JFrame frame;
	GamePanel game;
public static void main(String[] args) {
	LeagueInvaders invade = new LeagueInvaders();
}
public LeagueInvaders() {
	frame = new JFrame("LeagueInvaders");
	game = new GamePanel();
	setup();
}
public void setup() {
	frame.add(game);
	frame.addKeyListener(game);
	frame.setVisible(true);
	frame.setSize(width, height);
	game.startGame();
	frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
}
}
