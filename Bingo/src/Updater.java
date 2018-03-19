import java.awt.Font;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JButton;


public class Updater extends TimerTask{
	private JButton btn;
	private List<Integer> numbers;
	private int r;
	public Updater(JButton btn,List numbers) {
		this.btn = btn;
		this.numbers = numbers;
	}
	@Override
	public void run() {
		Random random = new Random();
		
		if(numbers.size() > 0){
			btn.setFont(new Font("Tahoma", Font.BOLD, 35));
			btn.setEnabled(false);
			r = random.nextInt(numbers.size());
			btn.setText(Integer.toString(numbers.get(r)));
			numbers.remove(r);
			System.out.println(numbers.size());
		}
				
	}

}
