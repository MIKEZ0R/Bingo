import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;




public class Bingo {

	private JFrame frame;
	private CardLayout cl;
	private JPanel startPanel;
	private JPanel cardPanel;
	private JButton start;
	private JLabel startInfo;
	private JPanel gamePanel;
	private JPanel firstCol;
	private JPanel secondCol;
	private JPanel thirdCol;
	private JPanel fourthCol;
	private JPanel fifthCol;
	private JPanel mainPanel;
	private JPanel endPanel;
	private JLabel endText;
	private JButton a,b;
	private JButton mainNum;
	private JPanel upper;
	private List<Integer> numbers;
	private List<Integer> tmp;
	private int n;
	private int widthP = 0;
	private int heightP = 0;
	private List<Integer> listRow0;
	private List<Integer> listRow1;
	private List<Integer> listRow2;
	private List<Integer> listRow3;
	private List<Integer> listRow4;
	private List<Integer> listCol0;
	private List<Integer> listCol1;
	private List<Integer> listCol2;
	private List<Integer> listCol3;
	private List<Integer> listCol4;
	private List<Integer> listSkos;
	private int index;
	private String[] arr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bingo window = new Bingo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bingo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws InterruptedException 
	 */
	private void initialize()  {
		frame = new JFrame("Bingo");
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		gamePanel = new JPanel();
		cardPanel = new JPanel();
		startInfo = new JLabel();
		firstCol = new JPanel();
		secondCol = new JPanel();
		thirdCol = new JPanel();
		fourthCol = new JPanel();
		fifthCol = new JPanel();
		mainPanel = new JPanel();
		endPanel = new JPanel();
		upper = new JPanel();
		endText = new JLabel("BINGO");
		endText.setFont(new Font("Tahoma", Font.BOLD, 35));
		endText.setHorizontalAlignment(SwingConstants.CENTER);
		endText.setForeground(Color.red);
		a = new JButton();
		a.setBackground(Color.black);
		a.setEnabled(false);
		b = new JButton();
		b.setBackground(Color.black);
		b.setEnabled(false);
		mainNum = new JButton();
		mainNum.setBackground(new Color(248, 248, 255));
		mainNum.setForeground(Color.red);
		mainNum.setFont(new Font("Tahoma", Font.BOLD, 16));
		mainNum.setEnabled(true);
		mainNum.setText("Be ready!");
		cl = new CardLayout();
		cardPanel.setLayout(cl);
		startPanel = new JPanel();
		start = new JButton();
		start.setBackground(new Color(248, 248, 255));
		start.setForeground(new Color(34, 139, 34));
		start.setFont(new Font("Tahoma", Font.BOLD, 20));
		start.setText("START");
		startInfo.setText("If you're ready press START !");
		startInfo.setFont(new Font("Tahoma", Font.BOLD, 20));
		startInfo.setHorizontalAlignment(SwingConstants.CENTER);
		startPanel.setLayout(new GridLayout(2,0,1,1));
		gamePanel.setLayout(new GridLayout(5,5,1,1));
		firstCol.setLayout(new GridLayout(5,0,1,1));
		secondCol.setLayout(new GridLayout(5,0,1,1));
		thirdCol.setLayout(new GridLayout(5,0,1,1));
		fourthCol.setLayout(new GridLayout(5,0,1,1));
		fifthCol.setLayout(new GridLayout(5,0,1,1));
		numbers = new ArrayList<Integer>();
		tmp = new ArrayList<Integer>();
		mainPanel.setLayout(new BorderLayout());
		upper.setLayout(new GridLayout(0,3,1,1));
		Random random = new Random();
		Timer timing = new Timer();
		endPanel.setLayout(new GridLayout(0,5,1,1));
		widthP = mainPanel.getWidth()/5;
		heightP = mainPanel.getHeight()/5;
		listRow0 = new ArrayList<Integer>();
		listRow1 = new ArrayList<Integer>();
		listRow2 = new ArrayList<Integer>();
		listRow3 = new ArrayList<Integer>();
		listRow4 = new ArrayList<Integer>();
		listCol0 = new ArrayList<Integer>();
		listCol1 = new ArrayList<Integer>();
		listCol2 = new ArrayList<Integer>();
		listCol3 = new ArrayList<Integer>();
		listCol4 = new ArrayList<Integer>();
		listSkos = new ArrayList<Integer>();
		arr = new String[5];
		arr[0] = "B";
		arr[1] = "I";
		arr[2] = "N";
		arr[3] = "G";
		arr[4] = "O";
		//timing.schedule(new Updater(mainNum,tmp), 3000,3000);
		
		
		startPanel.add(startInfo);
		startPanel.add(start);
		upper.add(a);
		upper.add(mainNum);
		upper.add(b);
		mainPanel.add(upper,BorderLayout.NORTH);
		mainPanel.add(gamePanel,BorderLayout.CENTER);
		
		cardPanel.add(startPanel,"start");
		cardPanel.add(mainPanel,"main");
		cardPanel.add(endPanel,"end");
		
		frame.getContentPane().add(cardPanel);
		cl.show(cardPanel,"start");
		
		
		
		for(int i=1;i<=75;i++){
			numbers.add(i-1,i);
			tmp.add(i-1,i);
		}
		int r;
		for(int i=0;i<5;i++){
			for(int j=0;j<5;j++){
				r = random.nextInt(numbers.size());
				index = 0;
				n = numbers.get(r);
				numbers.remove(r);
				final JButton btnBingo = new JButton();
				final JButton b = new JButton("B");
				btnBingo.setBackground(new Color(248, 248, 255));
				btnBingo.setForeground(Color.black);
				btnBingo.setFont(new Font("Tahoma", Font.BOLD, 20));
				btnBingo.setText(Integer.toString(n));
				gamePanel.add(btnBingo);
				btnBingo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(btnBingo.getText().equals(mainNum.getText())){
							btnBingo.setBackground(Color.green);
							Rectangle r = btnBingo.getBounds();
							Point p = btnBingo.getLocation();
							int col = p.x /r.width;
							int row = p.y / r.height;
							System.out.println(row +" , "+col);
							if(row == 0){
								index = listRow0.size()-1;
								listRow0.add(index+1);
							}
							if(row == 1){
								index = listRow1.size()-1;
								listRow1.add(index+1);
							}
							if(row == 2){
								index = listRow2.size()-1;
								listRow2.add(index+1);
							}
							if(row == 3){
								index = listRow3.size()-1;
								listRow3.add(index+1);
							}
							if(row == 4){
								index = listRow4.size()-1;
								listRow4.add(index+1);
							}
							
							if(listRow0.size()==5 || listRow1.size()==5 || listRow2.size()==5 || listRow3.size()==5 || listRow4.size()==5){
								JButton bt = (JButton)btnBingo.findComponentAt(listRow0.get(0)*r.height,0);
								bt.setText("B");
								cl.show(cardPanel,"end");
							}

							if(col == 0){
								index = listCol0.size()-1;
								listCol0.add(index+1);
							}
							if(col == 1){
								index = listCol1.size()-1;
								listCol1.add(index+1);
							}
							if(col == 2){
								index = listCol2.size()-1;
								listCol2.add(index+1);
							}
							if(col == 3){
								index = listCol3.size()-1;
								listCol3.add(index+1);
							}
							if(col == 4){
								index = listCol4.size()-1;
								listCol4.add(index+1);
							}
							
							if(listCol0.size()==5 || listCol1.size()==5 || listCol2.size()==5 || listCol3.size()==5 || listCol4.size()==5){
								
								cl.show(cardPanel,"end");
							}
							
							if(col == 0 && row == 0){
								index = listCol4.size()-1;
								listSkos.add(index+1);
								btnBingo.setBackground(Color.red);
							}
							if(col == 1 && row == 1){
								index = listCol4.size()-1;
								listSkos.add(index+1);
								btnBingo.setBackground(Color.red);
							}
							if(col == 2 && row == 2){
								index = listCol4.size()-1;
								listSkos.add(index+1);
								btnBingo.setBackground(Color.red);
							}
							if(col == 3 && row == 3){
								index = listCol4.size()-1;
								listSkos.add(index+1);
								btnBingo.setBackground(Color.red);
							}
							if(col == 4 && row == 4){
								index = listCol4.size()-1;
								listSkos.add(index+1);
								btnBingo.setBackground(Color.red);
							}
							
							if(listSkos.size() == 5){
								cl.show(cardPanel,"end");
							}
							
						}
					}
				});
			}
		}
		
		for(int i=0;i<=4;i++){
			final JButton chars = new JButton();
			chars.setText(arr[i]);
			chars.setForeground(Color.black);
			chars.setFont(new Font("Tahoma", Font.BOLD, 25));
			chars.setBackground(Color.YELLOW);
			endPanel.add(chars);

		}
		System.out.println(tmp.size());
		
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(cardPanel, "main");
				timing.schedule(new Updater(mainNum,tmp), 3000,3000);
				}
		});
		
		  
		if(endPanel.isDisplayable()){
			timing.schedule(new ColorUpdater(endPanel),100,100);
		}

		
		if(tmp.size() == 0){
			cl.show(cardPanel,"end");
		}
	
	}

}
