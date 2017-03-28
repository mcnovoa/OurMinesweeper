import javax.swing.JFrame;
import java.awt.Font;
import java.awt.FontMetrics;

public class Main {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame();
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(400, 150);
		myFrame.setSize(400, 400);
		
		//Title at the center
		myFrame.setFont(new Font("System", Font.PLAIN, 14));
		Font f = myFrame.getFont();
		FontMetrics fm = myFrame.getFontMetrics(f);
		int a = fm.stringWidth("Minesweeper");
		int b = fm.stringWidth(" ");
		int c = myFrame.getWidth()/2 -(a/2);
		int d = c/b;
		String cent ="";
		cent = String.format("%"+d+"s", cent);
		myFrame.setTitle(cent+"Minesweeper");
		
		MyPanel myPanel = new MyPanel();
		myFrame.add(myPanel);

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);

		myFrame.setVisible(true);
	}
}	