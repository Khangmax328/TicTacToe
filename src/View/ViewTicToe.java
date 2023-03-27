package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controller.ListenerTicToe;
import Model.ModelTicToe;

public class ViewTicToe extends JFrame{
	private static Clip clip;
	private static FloatControl volume;
	public ModelTicToe mtt;
	private JPanel main_jpanel;
	private JLabel main_jlabel;
	private JButton help_button;
	private JButton play_button;
	private JButton Setting_button;
	private JPanel help_jpanel;
	private ListenerTicToe ltt;
	private JLabel help_jlabel;
	private JButton help_back_button;
	private Font font;
	private JPanel setting_jpanel;
	private JButton setting_back_button;
	private JLabel setting_jlabel;
	private JLabel setting_music_jlabel;
	private JLabel setting_level_jlabel;
	private JLabel setting_music_jlabel_value;
	private JButton setting_inc_jbutton;
	private JButton setting_dec_jbutton;
	private JRadioButton setting_easy_jradiobutton;
	private JRadioButton setting_difficult_jradiobutton;
	private ButtonGroup bg;
	private JPanel game_play_jpanel;
	private JButton game_play_back_button;
	private JLabel game_play_jlabel;
	private JLabel game_play_jlabel_value_level;
	private JButton game_play_reset_button;
	private JButton game_play_button_1;
	private JButton game_play_button_2;
	private JButton game_play_button_3;
	private JButton game_play_button_5;
	private JButton game_play_button_9;
	private JButton game_play_button_8;
	private JButton game_play_button_4;
	private JButton game_play_button_6;
	private JButton game_play_button_7;
	private JButton game_play_button_1_x;
	private JButton game_play_button_2_x;
	private JButton game_play_button_3_x;
	private JButton game_play_button_4_x;
	private JButton game_play_button_5_x;
	private JButton game_play_button_6_x;
	private JButton game_play_button_7_x;
	private JButton game_play_button_8_x;
	private JButton game_play_button_9_x;
	private JButton game_play_button_1_o;
	private JButton game_play_button_2_o;
	private JButton game_play_button_3_o;
	private JButton game_play_button_4_o;
	private JButton game_play_button_5_o;
	private JButton game_play_button_6_o;
	private JButton game_play_button_7_o;
	private JButton game_play_button_8_o;
	private JButton game_play_button_9_o;
	public JLabel game_play_jlabel_result;
	private JRadioButton setting_ultimate_jradiobutton;
	private JLabel setting_go_first_jlabel;
	private JRadioButton setting_computer_jradiobutton;
	private JRadioButton setting_player_jradiobutton;
	private ButtonGroup gf;
	private JLabel game_play_jlabel_go_first;
	private JLabel timer_count_down_jlabel;
	private Thread timer;
	public int second=00;
	private JTextField setting_time_jtextfield;
	private JLabel setting_time_jlabel;
	public int time_count_value=0;
	
	public ViewTicToe() {
		mtt = new ModelTicToe();
		this.init();
		timer.start();
		play();
	}
	public void init() {
		ltt = new ListenerTicToe(this);
		this.setTitle("Tic Tac Toe");
		Image img = Toolkit.getDefaultToolkit().createImage("title.png");
		this.setIconImage(img);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		font = new Font("Ariel",Font.BOLD,20);
		this.setLayout(null);
		this.setResizable(false);
		
		help_jpanel = new JPanel();
		help_jpanel.setSize(500,500);
		help_jpanel.setLayout(null);
		help_back_button = new JButton("Back");
		help_back_button.addActionListener(ltt);
		help_jlabel = new JLabel();
		
		setting_jpanel = new JPanel();
		setting_jpanel.setSize(500,500);
		setting_jpanel.setLayout(null);
		setting_back_button = new JButton("Back");
		setting_back_button.addActionListener(ltt);
		setting_jlabel = new JLabel();
		setting_music_jlabel_value = new JLabel("25%");
		setting_inc_jbutton = new JButton("+");
		setting_inc_jbutton.addActionListener(ltt);
		setting_dec_jbutton = new JButton("-");
		setting_dec_jbutton.addActionListener(ltt);
		
		game_play_jpanel = new JPanel();
		game_play_jpanel.setSize(500,500);
		game_play_jpanel.setLayout(null);
		game_play_back_button = new JButton("Back");
		game_play_back_button.addActionListener(ltt);
		game_play_jlabel = new JLabel();
		game_play_jlabel_value_level = new JLabel();
		game_play_jlabel_go_first = new JLabel();
		game_play_reset_button = new JButton("Reset");
		game_play_reset_button.addActionListener(ltt);
		game_play_button_1 = new JButton("o1");
		game_play_button_1.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_1.addActionListener(ltt);
		game_play_button_2 = new JButton("o2");
		game_play_button_2.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_2.addActionListener(ltt);
		game_play_button_3 = new JButton("o3");
		game_play_button_3.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_3.addActionListener(ltt);
		game_play_button_4 = new JButton("o4");
		game_play_button_4.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_4.addActionListener(ltt);
		game_play_button_5 = new JButton("o5");
		game_play_button_5.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_5.addActionListener(ltt);
		game_play_button_6 = new JButton("o6");
		game_play_button_6.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_6.addActionListener(ltt);
		game_play_button_7 = new JButton("o7");
		game_play_button_7.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_7.addActionListener(ltt);
		game_play_button_8 = new JButton("o8");
		game_play_button_8.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_8.addActionListener(ltt);
		game_play_button_9 = new JButton("o9");
		game_play_button_9.setFont(new Font("Arial",Font.BOLD,0));
		game_play_button_9.addActionListener(ltt);
		game_play_button_1_x = new JButton("X");
		game_play_button_1_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_1_x.addActionListener(ltt);
		game_play_button_2_x = new JButton("X");
		game_play_button_2_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_2_x.addActionListener(ltt);
		game_play_button_3_x = new JButton("X");
		game_play_button_3_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_3_x.addActionListener(ltt);
		game_play_button_4_x = new JButton("X");
		game_play_button_4_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_4_x.addActionListener(ltt);
		game_play_button_5_x = new JButton("X");
		game_play_button_5_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_5_x.addActionListener(ltt);
		game_play_button_6_x = new JButton("X");
		game_play_button_6_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_6_x.addActionListener(ltt);
		game_play_button_7_x = new JButton("X");
		game_play_button_7_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_7_x.addActionListener(ltt);
		game_play_button_8_x = new JButton("X");
		game_play_button_8_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_8_x.addActionListener(ltt);
		game_play_button_9_x = new JButton("X");
		game_play_button_9_x.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_9_x.addActionListener(ltt);
		game_play_button_1_o = new JButton("O");
		game_play_button_1_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_1_o.setForeground(Color.red);
		game_play_button_1_o.addActionListener(ltt);
		game_play_button_2_o = new JButton("O");
		game_play_button_2_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_2_o.addActionListener(ltt);
		game_play_button_2_o.setForeground(Color.red);
		game_play_button_3_o = new JButton("O");
		game_play_button_3_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_3_o.addActionListener(ltt);
		game_play_button_3_o.setForeground(Color.red);
		game_play_button_4_o = new JButton("O");
		game_play_button_4_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_4_o.addActionListener(ltt);
		game_play_button_4_o.setForeground(Color.red);
		game_play_button_5_o = new JButton("O");
		game_play_button_5_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_5_o.addActionListener(ltt);
		game_play_button_5_o.setForeground(Color.red);
		game_play_button_6_o = new JButton("O");
		game_play_button_6_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_6_o.addActionListener(ltt);
		game_play_button_6_o.setForeground(Color.red);
		game_play_button_7_o = new JButton("O");
		game_play_button_7_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_7_o.addActionListener(ltt);
		game_play_button_7_o.setForeground(Color.red);
		game_play_button_8_o = new JButton("O");
		game_play_button_8_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_8_o.addActionListener(ltt);
		game_play_button_8_o.setForeground(Color.red);
		game_play_button_9_o = new JButton("O");
		game_play_button_9_o.setFont(new Font("Arial",Font.BOLD,100));
		game_play_button_9_o.addActionListener(ltt);
		game_play_button_9_o.setForeground(Color.red);
		game_play_jlabel_result = new JLabel("You Win");
		timer_count_down_jlabel = new JLabel();
		timer = new Thread(new Runnable() {
			@Override
			public void run() {
				timer_count();
			}
			
		});
		setting_time_jtextfield = new JTextField("60");
		setting_time_jlabel = new JLabel("Waiting Time : (s)");
		time_count_value = Integer.parseInt(setting_time_jtextfield.getText());
		second = time_count_value;
		
		main_jpanel = new JPanel();
		main_jpanel.setLayout(null);
		main_jpanel.setSize(500,500);
		
		main_jlabel = new JLabel();
		main_jlabel.setBounds(0,0,500,500);
		main_jlabel.setIcon(new ImageIcon("background.gif"));
		
		help_button = new JButton("Help");
		help_button.setBounds(320,375,130,50);
		help_button.setForeground(Color.BLACK);
		help_button.setBackground(Color.CYAN);
		help_button.setFont(font);
		help_button.addActionListener(ltt);
		play_button = new JButton("Play Now");
		play_button.setForeground(Color.BLACK);
		play_button.setBackground(Color.CYAN);
		play_button.setBounds(320,250,130,50);
		play_button.setFont(font);
		play_button.addActionListener(ltt);
		Setting_button = new JButton("Setting");
		Setting_button.setForeground(Color.BLACK);
		Setting_button.setBackground(Color.CYAN);
		Setting_button.setBounds(320,312,130,50);
		Setting_button.setFont(font);
		Setting_button.addActionListener(ltt);
		setting_easy_jradiobutton = new JRadioButton("Easy");
		setting_difficult_jradiobutton = new JRadioButton("Medium");
		setting_ultimate_jradiobutton = new JRadioButton("Difficult");
		setting_computer_jradiobutton = new JRadioButton("Computer");
		
		setting_player_jradiobutton = new JRadioButton("Player");
		setting_computer_jradiobutton.addActionListener(ltt);
		setting_player_jradiobutton.addActionListener(ltt);
		setting_easy_jradiobutton.addActionListener(ltt);
		setting_difficult_jradiobutton.addActionListener(ltt);
		setting_ultimate_jradiobutton.addActionListener(ltt);
		gf = new ButtonGroup();
		gf.add(setting_computer_jradiobutton);
		gf.add(setting_player_jradiobutton);
		setting_player_jradiobutton.setSelected(true);
		mtt.go_first_value = 1;
		bg = new ButtonGroup();
		bg.add(setting_easy_jradiobutton);
		bg.add(setting_difficult_jradiobutton);
		bg.add(setting_ultimate_jradiobutton);
		setting_easy_jradiobutton.setSelected(true);
		this.mtt.setLevel_value(0);
		
		main_jpanel.add(play_button);
		main_jpanel.add(Setting_button);
		main_jpanel.add(help_button);
		main_jpanel.add(main_jlabel);
		
		this.add(main_jpanel);
		
		this.setVisible(true);
	}
	public void help_monitor() {
		main_jpanel.setVisible(false);
		help_jpanel.setVisible(true);
		
		help_jlabel.setBounds(0,0,500,500);
		help_jlabel.setIcon(new ImageIcon("help.png"));
		
		
		help_back_button.setBounds(370,400,100,30);
		help_back_button.setBackground(Color.cyan);
		help_back_button.setFont(font);
		
		help_jpanel.add(help_back_button);
		help_jpanel.add(help_jlabel);
		
		this.add(help_jpanel);
	}
	public void main_monitor() {
		help_jpanel.setVisible(false);
		setting_jpanel.setVisible(false);
		game_play_jpanel.setVisible(false);
		main_jpanel.setVisible(true);
		
	}
	public void setting_monitor() {
		main_jpanel.setVisible(false);
		setting_jpanel.setVisible(true);
		
		setting_jlabel.setBounds(0,0,500,500);
		setting_jlabel.setIcon(new ImageIcon("setting_background.gif"));
		
		setting_back_button.setBounds(370,400,100,30);
		setting_back_button.setBackground(Color.cyan);
		setting_back_button.setFont(font);
		
		setting_go_first_jlabel = new JLabel("Go First :");
		setting_go_first_jlabel.setFont(new Font("Arial",Font.BOLD,38));
		setting_go_first_jlabel.setBounds(20,290,200,100);
		
		setting_music_jlabel = new JLabel("Music :");
		setting_music_jlabel.setFont(new Font("Arial",Font.BOLD,40));
		setting_music_jlabel.setBounds(20,170,200,100);
		setting_music_jlabel_value.setFont(new Font("Arial",Font.BOLD,40));
		setting_music_jlabel_value.setBounds(260,170,200,100);
		setting_level_jlabel = new JLabel("Level :");
		setting_level_jlabel.setFont(new Font("Arial",Font.BOLD,40));
		setting_level_jlabel.setBounds(20,230,200,100);
		setting_inc_jbutton.setFont(new Font("Arial",Font.BOLD,40));
		setting_inc_jbutton.setBounds(370,200,60,40);
		setting_inc_jbutton.setBackground(Color.green);
		setting_dec_jbutton.setFont(new Font("Arial",Font.BOLD,40));
		setting_dec_jbutton.setBounds(170,200,60,40);
		setting_dec_jbutton.setBackground(Color.green);
		setting_easy_jradiobutton.setBounds(150,265,80,40);
		setting_computer_jradiobutton.setBounds(200,320,100,40);
		setting_player_jradiobutton.setBounds(320,320,80,40);
		setting_difficult_jradiobutton.setBounds(250,265,100,40);
		setting_easy_jradiobutton.setFont(new Font("Arial",Font.BOLD,15));
		setting_computer_jradiobutton.setFont(new Font("Arial",Font.BOLD,15));
		setting_player_jradiobutton.setFont(new Font("Arial",Font.BOLD,15));
		setting_difficult_jradiobutton.setFont(new Font("Arial",Font.BOLD,15));
		setting_easy_jradiobutton.setBackground(Color.decode("#DFF24B"));
		setting_computer_jradiobutton.setBackground(Color.decode("#DFF24B"));
		setting_player_jradiobutton.setBackground(Color.decode("#DFF24B"));
		setting_difficult_jradiobutton.setBackground(Color.decode("#DFF24B"));
		setting_ultimate_jradiobutton.setBounds(350,265,120,40);
		setting_ultimate_jradiobutton.setFont(new Font("Arial",Font.BOLD,15));
		setting_ultimate_jradiobutton.setBackground(Color.decode("#DFF24B"));
		
		setting_time_jlabel.setBounds(20,40,350,50);
		setting_time_jlabel.setFont(new Font("Arial",Font.BOLD,30));
		setting_time_jtextfield.setBounds(20,100,100,50); 
		setting_time_jtextfield.setFont(new Font("Arial",Font.BOLD,25));
		setting_time_jtextfield.setForeground(Color.blue);
		time_count_value = Integer.parseInt(setting_time_jtextfield.getText()) ;
		second = time_count_value;
		
		setting_jpanel.add(setting_time_jtextfield);
		setting_jpanel.add(setting_time_jlabel);
		setting_jpanel.add(setting_computer_jradiobutton);
		setting_jpanel.add(setting_player_jradiobutton);
		setting_jpanel.add(setting_go_first_jlabel);
		setting_jpanel.add(setting_ultimate_jradiobutton);
		setting_jpanel.add(setting_easy_jradiobutton);
		setting_jpanel.add(setting_difficult_jradiobutton);
		setting_jpanel.add(setting_dec_jbutton);
		setting_jpanel.add(setting_inc_jbutton);
		setting_jpanel.add(setting_music_jlabel_value);
		setting_jpanel.add(setting_music_jlabel);
		setting_jpanel.add(setting_level_jlabel);
		setting_jpanel.add(setting_back_button);
		setting_jpanel.add(setting_jlabel);
		
		this.add(setting_jpanel);
		
	}
	public void update_time() {
		time_count_value = Integer.parseInt(setting_time_jtextfield.getText()) ;
		second = time_count_value;
	}
	public void game_play_monitor() {
		main_jpanel.setVisible(false);
		game_play_jpanel.setVisible(true);
		
		if (this.mtt.getLevel_value()==2) game_play_jlabel_value_level.setText("Medium Mode"); 
		else if (this.mtt.getLevel_value()==0) game_play_jlabel_value_level.setText("Easy Mode");
		else game_play_jlabel_value_level.setText("Difficult Mode");
		game_play_jlabel_value_level.setBounds(10,5,200,30);
		game_play_jlabel_value_level.setFont(new Font("Arial",Font.BOLD,25));
		
		if (mtt.go_first_value==1) {
			game_play_jlabel_go_first.setText("You Go First");
			game_play_jlabel_go_first.setForeground(Color.red);
		}
		else if (mtt.go_first_value==0) {
			game_play_jlabel_go_first.setText("You Go Second");
			game_play_jlabel_go_first.setForeground(Color.blue);
		}
		game_play_jlabel_go_first.setBounds(300,5,200,30);
		game_play_jlabel_go_first.setFont(new Font("Arial",Font.BOLD,25));
		
		game_play_jlabel.setBounds(0,0,500,500);
		game_play_jlabel.setIcon(new ImageIcon("game_play.png"));
		
		game_play_back_button.setBounds(370,415,100,30);
		game_play_back_button.setBackground(Color.cyan);
		game_play_back_button.setFont(font);
		game_play_reset_button.setBounds(20,415,100,30);
		game_play_reset_button.setBackground(Color.cyan);
		game_play_reset_button.setFont(font);
		
		game_play_button_1.setBounds(66,38,116,116);
		game_play_button_1.setBackground(Color.decode("#C0DD11"));
		game_play_button_2.setBounds(66+126,38,116,116);
		game_play_button_2.setBackground(Color.decode("#74B01A"));
		game_play_button_3.setBounds(66+126+126,38,116,116);
		game_play_button_3.setBackground(Color.decode("#C0DD11"));
		game_play_button_4.setBounds(66,38+126,116,116);
		game_play_button_4.setBackground(Color.decode("#74B01A"));
		game_play_button_5.setBounds(66+126,38+126,116,116);
		game_play_button_5.setBackground(Color.decode("#C0DD11"));
		game_play_button_6.setBounds(66+126+126,38+126,116,116);
		game_play_button_6.setBackground(Color.decode("#74B01A"));
		game_play_button_7.setBounds(66,38+126+126,116,116);
		game_play_button_7.setBackground(Color.decode("#C0DD11"));
		game_play_button_8.setBounds(66+126,38+126+126,116,116);
		game_play_button_8.setBackground(Color.decode("#74B01A"));
		game_play_button_9.setBounds(66+126+126,38+126+126,116,116);
		game_play_button_9.setBackground(Color.decode("#C0DD11"));
		game_play_button_1_x.setBounds(66,38,116,116);
		game_play_button_1_x.setBackground(Color.decode("#C0DD11"));
		game_play_button_2_x.setBounds(66+126,38,116,116);
		game_play_button_2_x.setBackground(Color.decode("#74B01A"));
		game_play_button_3_x.setBounds(66+126+126,38,116,116);
		game_play_button_3_x.setBackground(Color.decode("#C0DD11"));
		game_play_button_4_x.setBounds(66,38+126,116,116);
		game_play_button_4_x.setBackground(Color.decode("#74B01A"));
		game_play_button_5_x.setBounds(66+126,38+126,116,116);
		game_play_button_5_x.setBackground(Color.decode("#C0DD11"));
		game_play_button_6_x.setBounds(66+126+126,38+126,116,116);
		game_play_button_6_x.setBackground(Color.decode("#74B01A"));
		game_play_button_7_x.setBounds(66,38+126+126,116,116);
		game_play_button_7_x.setBackground(Color.decode("#C0DD11"));
		game_play_button_8_x.setBounds(66+126,38+126+126,116,116);
		game_play_button_8_x.setBackground(Color.decode("#74B01A"));
		game_play_button_9_x.setBounds(66+126+126,38+126+126,116,116);
		game_play_button_9_x.setBackground(Color.decode("#C0DD11"));
		game_play_button_1_o.setBounds(66,38,116,116);
		game_play_button_1_o.setBackground(Color.decode("#C0DD11"));
		game_play_button_2_o.setBounds(66+126,38,116,116);
		game_play_button_2_o.setBackground(Color.decode("#74B01A"));
		game_play_button_3_o.setBounds(66+126+126,38,116,116);
		game_play_button_3_o.setBackground(Color.decode("#C0DD11"));
		game_play_button_4_o.setBounds(66,38+126,116,116);
		game_play_button_4_o.setBackground(Color.decode("#74B01A"));
		game_play_button_5_o.setBounds(66+126,38+126,116,116);
		game_play_button_5_o.setBackground(Color.decode("#C0DD11"));
		game_play_button_6_o.setBounds(66+126+126,38+126,116,116);
		game_play_button_6_o.setBackground(Color.decode("#74B01A"));
		game_play_button_7_o.setBounds(66,38+126+126,116,116);
		game_play_button_7_o.setBackground(Color.decode("#C0DD11"));
		game_play_button_8_o.setBounds(66+126,38+126+126,116,116);
		game_play_button_8_o.setBackground(Color.decode("#74B01A"));
		game_play_button_9_o.setBounds(66+126+126,38+126+126,116,116);
		game_play_button_9_o.setBackground(Color.decode("#C0DD11"));
		
		game_play_jlabel_result.setBounds(180,5,200,30);
		game_play_jlabel_result.setFont(new Font("Arial",Font.BOLD,25));
		game_play_jlabel_result.setForeground(Color.cyan);
		
		timer_count_down_jlabel.setText(second+"s");
		timer_count_down_jlabel.setFont(new Font("Arial",Font.BOLD,30));
		timer_count_down_jlabel.setForeground(Color.MAGENTA);
		timer_count_down_jlabel.setBounds(230,410,200,50);
		
		game_play_jpanel.add(timer_count_down_jlabel);
		game_play_jpanel.add(game_play_jlabel_go_first);
		game_play_jpanel.add(game_play_jlabel_result);
		game_play_jlabel_result.setVisible(false);
		game_play_jpanel.add(game_play_button_1);
		game_play_jpanel.add(game_play_button_2);
		game_play_jpanel.add(game_play_button_3);
		game_play_jpanel.add(game_play_button_4);
		game_play_jpanel.add(game_play_button_5);
		game_play_jpanel.add(game_play_button_6);
		game_play_jpanel.add(game_play_button_7);
		game_play_jpanel.add(game_play_button_8);
		game_play_jpanel.add(game_play_button_9);
		game_play_jpanel.add(game_play_button_1_x);
		game_play_jpanel.add(game_play_button_2_x);
		game_play_jpanel.add(game_play_button_3_x);
		game_play_jpanel.add(game_play_button_4_x);
		game_play_jpanel.add(game_play_button_5_x);
		game_play_jpanel.add(game_play_button_6_x);
		game_play_jpanel.add(game_play_button_7_x);
		game_play_jpanel.add(game_play_button_8_x);
		game_play_jpanel.add(game_play_button_9_x);
		game_play_jpanel.add(game_play_button_1_o);
		game_play_jpanel.add(game_play_button_2_o);
		game_play_jpanel.add(game_play_button_3_o);
		game_play_jpanel.add(game_play_button_4_o);
		game_play_jpanel.add(game_play_button_5_o);
		game_play_jpanel.add(game_play_button_6_o);
		game_play_jpanel.add(game_play_button_7_o);
		game_play_jpanel.add(game_play_button_8_o);
		game_play_jpanel.add(game_play_button_9_o);
		game_play_button_1_x.setVisible(false);
		game_play_button_2_x.setVisible(false);
		game_play_button_3_x.setVisible(false);
		game_play_button_4_x.setVisible(false);
		game_play_button_5_x.setVisible(false);
		game_play_button_6_x.setVisible(false);
		game_play_button_7_x.setVisible(false);
		game_play_button_8_x.setVisible(false);
		game_play_button_9_x.setVisible(false);
		game_play_button_1_o.setVisible(false);
		game_play_button_2_o.setVisible(false);
		game_play_button_3_o.setVisible(false);
		game_play_button_4_o.setVisible(false);
		game_play_button_5_o.setVisible(false);
		game_play_button_6_o.setVisible(false);
		game_play_button_7_o.setVisible(false);
		game_play_button_8_o.setVisible(false);
		game_play_button_9_o.setVisible(false);
		game_play_jpanel.add(game_play_reset_button);
		game_play_jpanel.add(game_play_jlabel_value_level);
		game_play_jpanel.add(game_play_back_button);
		game_play_jpanel.add(game_play_jlabel);
		
		this.add(game_play_jpanel);	
	}
	public void enable_matrix(int check) {
		if (check==1) {
			game_play_button_1.setEnabled(true);
			game_play_button_2.setEnabled(true);
			game_play_button_3.setEnabled(true);
			game_play_button_4.setEnabled(true);
			game_play_button_5.setEnabled(true);
			game_play_button_6.setEnabled(true);
			game_play_button_7.setEnabled(true);
			game_play_button_8.setEnabled(true);
			game_play_button_9.setEnabled(true);
			game_play_button_1_x.setEnabled(true);
			game_play_button_2_x.setEnabled(true);
			game_play_button_3_x.setEnabled(true);
			game_play_button_4_x.setEnabled(true);
			game_play_button_5_x.setEnabled(true);
			game_play_button_6_x.setEnabled(true);
			game_play_button_7_x.setEnabled(true);
			game_play_button_8_x.setEnabled(true);
			game_play_button_9_x.setEnabled(true);
			game_play_button_1_o.setEnabled(true);
			game_play_button_2_o.setEnabled(true);
			game_play_button_3_o.setEnabled(true);
			game_play_button_4_o.setEnabled(true);
			game_play_button_5_o.setEnabled(true);
			game_play_button_6_o.setEnabled(true);
			game_play_button_7_o.setEnabled(true);
			game_play_button_8_o.setEnabled(true);
			game_play_button_9_o.setEnabled(true);
		} else if (check==2) {
			game_play_button_1.setEnabled(false);
			game_play_button_2.setEnabled(false);
			game_play_button_3.setEnabled(false);
			game_play_button_4.setEnabled(false);
			game_play_button_5.setEnabled(false);
			game_play_button_6.setEnabled(false);
			game_play_button_7.setEnabled(false);
			game_play_button_8.setEnabled(false);
			game_play_button_9.setEnabled(false);
			game_play_button_1_x.setEnabled(false);
			game_play_button_2_x.setEnabled(false);
			game_play_button_3_x.setEnabled(false);
			game_play_button_4_x.setEnabled(false);
			game_play_button_5_x.setEnabled(false);
			game_play_button_6_x.setEnabled(false);
			game_play_button_7_x.setEnabled(false);
			game_play_button_8_x.setEnabled(false);
			game_play_button_9_x.setEnabled(false);
			game_play_button_1_o.setEnabled(false);
			game_play_button_2_o.setEnabled(false);
			game_play_button_3_o.setEnabled(false);
			game_play_button_4_o.setEnabled(false);
			game_play_button_5_o.setEnabled(false);
			game_play_button_6_o.setEnabled(false);
			game_play_button_7_o.setEnabled(false);
			game_play_button_8_o.setEnabled(false);
			game_play_button_9_o.setEnabled(false);
		}
	}
	public void check_matrix() {
		if (second==0) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][0]==1 && mtt.matrix_tic_toe[0][1]==1 && mtt.matrix_tic_toe[0][2]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[1][0]==1 && mtt.matrix_tic_toe[1][1]==1 && mtt.matrix_tic_toe[1][2]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[2][0]==1 && mtt.matrix_tic_toe[2][1]==1 && mtt.matrix_tic_toe[2][2]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][0]==1 && mtt.matrix_tic_toe[1][0]==1 && mtt.matrix_tic_toe[2][0]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][1]==1 && mtt.matrix_tic_toe[1][1]==1 && mtt.matrix_tic_toe[2][1]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][2]==1 && mtt.matrix_tic_toe[1][2]==1 && mtt.matrix_tic_toe[2][2]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][0]==1 && mtt.matrix_tic_toe[1][1]==1 && mtt.matrix_tic_toe[2][2]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][2]==1 && mtt.matrix_tic_toe[1][1]==1 && mtt.matrix_tic_toe[2][0]==1) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Win");
			game_play_jlabel_result.setVisible(true);
		} else
		//////////
		if (mtt.matrix_tic_toe[0][0]==2 && mtt.matrix_tic_toe[0][1]==2 && mtt.matrix_tic_toe[0][2]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[1][0]==2 && mtt.matrix_tic_toe[1][1]==2 && mtt.matrix_tic_toe[1][2]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[2][0]==2 && mtt.matrix_tic_toe[2][1]==2 && mtt.matrix_tic_toe[2][2]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][0]==2 && mtt.matrix_tic_toe[1][0]==2 && mtt.matrix_tic_toe[2][0]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][1]==2 && mtt.matrix_tic_toe[1][1]==2 && mtt.matrix_tic_toe[2][1]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][2]==2 && mtt.matrix_tic_toe[1][2]==2 && mtt.matrix_tic_toe[2][2]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][0]==2 && mtt.matrix_tic_toe[1][1]==2 && mtt.matrix_tic_toe[2][2]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else
		if (mtt.matrix_tic_toe[0][2]==2 && mtt.matrix_tic_toe[1][1]==2 && mtt.matrix_tic_toe[2][0]==2) {
			enable_matrix(2);
			game_play_jlabel_result.setText("You Lose");
			game_play_jlabel_result.setVisible(true);
		} else {
			if (mtt.check_matrix_empty()==false) {
				enable_matrix(2);
				game_play_jlabel_result.setText("Draw");
				game_play_jlabel_result.setVisible(true);
			}
		}
	}
	public void show_matrix () {
		///////// 0 0
		if (mtt.matrix_tic_toe[0][0]==0) {
			game_play_button_1.setVisible(true);
			game_play_button_1_x.setVisible(false);
			game_play_button_1_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[0][0]==1) {
			game_play_button_1.setVisible(false);
			game_play_button_1_x.setVisible(false);
			game_play_button_1_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[0][0]==2) {
			game_play_button_1.setVisible(false);
			game_play_button_1_x.setVisible(true);
			game_play_button_1_o.setVisible(false);
		}
		///////// 0 1
		if (mtt.matrix_tic_toe[0][1]==0) {
			game_play_button_2.setVisible(true);
			game_play_button_2_x.setVisible(false);
			game_play_button_2_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[0][1]==1) {
			game_play_button_2.setVisible(false);
			game_play_button_2_x.setVisible(false);
			game_play_button_2_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[0][1]==2) {
			game_play_button_2.setVisible(false);
			game_play_button_2_x.setVisible(true);
			game_play_button_2_o.setVisible(false);
		}
		//////// 0 2
		if (mtt.matrix_tic_toe[0][2]==0) {
			game_play_button_3.setVisible(true);
			game_play_button_3_x.setVisible(false);
			game_play_button_3_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[0][2]==1) {
			game_play_button_3.setVisible(false);
			game_play_button_3_x.setVisible(false);
			game_play_button_3_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[0][2]==2) {
			game_play_button_3.setVisible(false);
			game_play_button_3_x.setVisible(true);
			game_play_button_3_o.setVisible(false);
		}
		////////// 1 0
		if (mtt.matrix_tic_toe[1][0]==0) {
			game_play_button_4.setVisible(true);
			game_play_button_4_x.setVisible(false);
			game_play_button_4_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[1][0]==1) {
			game_play_button_4.setVisible(false);
			game_play_button_4_x.setVisible(false);
			game_play_button_4_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[1][0]==2) {
			game_play_button_4.setVisible(false);
			game_play_button_4_x.setVisible(true);
			game_play_button_4_o.setVisible(false);
		}
		/////////////// 1 1
		if (mtt.matrix_tic_toe[1][1]==0) {
			game_play_button_5.setVisible(true);
			game_play_button_5_x.setVisible(false);
			game_play_button_5_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[1][1]==1) {
			game_play_button_5.setVisible(false);
			game_play_button_5_x.setVisible(false);
			game_play_button_5_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[1][1]==2) {
			game_play_button_5.setVisible(false);
			game_play_button_5_x.setVisible(true);
			game_play_button_5_o.setVisible(false);
		}
		/////////////// 1 2
		if (mtt.matrix_tic_toe[1][2]==0) {
			game_play_button_6.setVisible(true);
			game_play_button_6_x.setVisible(false);
			game_play_button_6_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[1][2]==1) {
			game_play_button_6.setVisible(false);
			game_play_button_6_x.setVisible(false);
			game_play_button_6_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[1][2]==2) {
			game_play_button_6.setVisible(false);
			game_play_button_6_x.setVisible(true);
			game_play_button_6_o.setVisible(false);
		}
		/////////////////// 2 0
		if (mtt.matrix_tic_toe[2][0]==0) {
			game_play_button_7.setVisible(true);
			game_play_button_7_x.setVisible(false);
			game_play_button_7_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[2][0]==1) {
			game_play_button_7.setVisible(false);
			game_play_button_7_x.setVisible(false);
			game_play_button_7_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[2][0]==2) {
			game_play_button_7.setVisible(false);
			game_play_button_7_x.setVisible(true);
			game_play_button_7_o.setVisible(false);
		}
		///////////////////// 2 1
		if (mtt.matrix_tic_toe[2][1]==0) {
			game_play_button_8.setVisible(true);
			game_play_button_8_x.setVisible(false);
			game_play_button_8_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[2][1]==1) {
			game_play_button_8.setVisible(false);
			game_play_button_8_x.setVisible(false);
			game_play_button_8_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[2][1]==2) {
			game_play_button_8.setVisible(false);
			game_play_button_8_x.setVisible(true);
			game_play_button_8_o.setVisible(false);
		}
		///////////////////// 2 2
		if (mtt.matrix_tic_toe[2][2]==0) {
			game_play_button_9.setVisible(true);
			game_play_button_9_x.setVisible(false);
			game_play_button_9_o.setVisible(false);
		} else if (mtt.matrix_tic_toe[2][2]==1) {
			game_play_button_9.setVisible(false);
			game_play_button_9_x.setVisible(false);
			game_play_button_9_o.setVisible(true);
		} else if (mtt.matrix_tic_toe[2][2]==2) {
			game_play_button_9.setVisible(false);
			game_play_button_9_x.setVisible(true);
			game_play_button_9_o.setVisible(false);
		}
		
	}
	public void go_line(int player,String str) { //toa do
		if (player==1) {
			if (str=="o1") {
				mtt.matrix_tic_toe[0][0]=1;
			} else if (str=="o2") {
				mtt.matrix_tic_toe[0][1]=1;
			} else if (str=="o3") {
				mtt.matrix_tic_toe[0][2]=1;
			} else if (str=="o4") {
				mtt.matrix_tic_toe[1][0]=1;
			} else if (str=="o5") {
				mtt.matrix_tic_toe[1][1]=1;
			} else if (str=="o6") {
				mtt.matrix_tic_toe[1][2]=1;
			} else if (str=="o7") {
				mtt.matrix_tic_toe[2][0]=1;
			} else if (str=="o8") {
				mtt.matrix_tic_toe[2][1]=1;
			} else if (str=="o9") {
				mtt.matrix_tic_toe[2][2]=1;
			}
		}
		else if (player==2) {
			if (str=="o1") {
				mtt.matrix_tic_toe[0][0]=2;
			} else if (str=="o2") {
				mtt.matrix_tic_toe[0][1]=2;
			} else if (str=="o3") {
				mtt.matrix_tic_toe[0][2]=2;
			} else if (str=="o4") {
				mtt.matrix_tic_toe[1][0]=2;
			} else if (str=="o5") {
				mtt.matrix_tic_toe[1][1]=2;
			} else if (str=="o6") {
				mtt.matrix_tic_toe[1][2]=2;
			} else if (str=="o7") {
				mtt.matrix_tic_toe[2][0]=2;
			} else if (str=="o8") {
				mtt.matrix_tic_toe[2][1]=2;
			} else if (str=="o9") {
				mtt.matrix_tic_toe[2][2]=2;
			}
		}
	}
	public void inc_volume() {
		//             -80---30  -20 -12 -4 4
		if (volume.getValue()!=4f) {
			if (volume.getValue()==-80) volume.setValue(-20);
			else volume.setValue(volume.getValue()+8.0f);
			if (volume.getValue()==-20) {
				setting_music_jlabel_value.setText("25%");
			} else if (volume.getValue()==-12) {
				setting_music_jlabel_value.setText("50%");
			} else if (volume.getValue()==-3.9999998f) {
				setting_music_jlabel_value.setText("75%");
			} else if (volume.getValue()==-80) {
				setting_music_jlabel_value.setText("0%");
			} else if (volume.getValue()==4) {
				setting_music_jlabel_value.setText("100%");
			}
		}
	}
	public void dec_volume() {
		if (volume.getValue()!=-80) {
			if (volume.getValue()==-20) volume.setValue(-80);
			else volume.setValue(volume.getValue()-8.0f);
			if (volume.getValue()==-20) {
				setting_music_jlabel_value.setText("25%");
			} else if (volume.getValue()==-12) {
				setting_music_jlabel_value.setText("50%");
			} else if (volume.getValue()==-3.9999998f) {
				setting_music_jlabel_value.setText("75%");
			} else if (volume.getValue()==-80) {
				setting_music_jlabel_value.setText("0%");
			} else if (volume.getValue()==4) {
				setting_music_jlabel_value.setText("100%");
			}
		}
	}
	public static void play() {
		  try {
		   File file = new File("song" + ".wav");
		   clip = AudioSystem.getClip();
		   clip.open(AudioSystem.getAudioInputStream(file));
//		   Thread.sleep(10);
		   clip.loop(Clip.LOOP_CONTINUOUSLY); // infinite loop play music 
		   
		   volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		   volume.setValue(-20f);
		   // -80 -40 -20 -10 -5 -2 -1 0 1 2 4
		   // -80vs0  2vs100 25vs-20 50vs-10 75vs1
		   Thread.sleep(clip.getMicrosecondLength());
		  } catch (Exception e) {
		   System.err.println(e.getMessage());
		  }
	}
	public static void wait(int ms){
	    try{
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex){
	        Thread.currentThread().interrupt();
	    }
	}
	public void timer_count() {
		while(true) {
			if (second >-1) {
				timer_count_down_jlabel.setText(second+"s");
				if (game_play_jlabel_result.isVisible()==false) second--;
				wait(1000);
			}		
			if (second==0 && game_play_jlabel_result.isVisible()==false) check_matrix();
		}
	}

}
