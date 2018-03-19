import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ColorUpdater extends TimerTask{
	private JPanel panel;
	private int r;
	public ColorUpdater(JPanel panel) {
		this.panel = panel;
	}
	@Override
	public void run() {
		Component[] comp = panel.getComponents();
		for(int i=0;i<comp.length;i++){
			comp[i].setBackground(Color.GREEN);
		}
	}

}
