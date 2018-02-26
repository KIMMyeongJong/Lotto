import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lotto_GUI extends JFrame {

	JPanel panel_Main, panel_Top, panel_Bottom, panel_Frame, panel_Status;
	JButton[] button_Array = new JButton[45];
	JButton[] lotto_Array = new JButton[16];
	JButton start_Button, cancle_Button, auto_Button, reset_Button;
	EventListener event = new EventListener(this);

	public Lotto_GUI() {

		this.setSize(1200, 900);

		panel_Main = new JPanel(new GridLayout(2, 0));
		panel_Top = new JPanel(new GridLayout(2, 8));
		panel_Bottom = new JPanel(new GridLayout(9, 5));
		panel_Frame = new JPanel();
		panel_Status = new JPanel(new GridLayout(0, 3));

		for (int i = 0; i < 45; i++) {
			button_Array[i] = new JButton(String.valueOf(i + 1));
			panel_Bottom.add(button_Array[i]);
			button_Array[i].addMouseListener(event);
		}
		for (int i = 0; i < 16; i++) {
			if (i == 0 || i == 8) {
				if (i == 0) {
					lotto_Array[i] = new JButton("사용자 로또 번호");
				} else if (i == 8) {
					lotto_Array[i] = new JButton("로또 번호");
				}
				lotto_Array[i].setBorderPainted(false);
				lotto_Array[i].setBackground(Color.WHITE);
				panel_Top.add(lotto_Array[i]);
				continue;
			} // if end
			lotto_Array[i] = new JButton(String.valueOf(i));
			if(i==15) {
				lotto_Array[i].setBackground(Color.red);
				panel_Top.add(lotto_Array[i]);
				continue;
			}else if(i==7) {
				lotto_Array[i].setVisible(false);
				panel_Top.add(lotto_Array[i]);
			}
			lotto_Array[i].setContentAreaFilled(false);
			panel_Top.add(lotto_Array[i]);
		} // for end

		start_Button = new JButton("START");
		auto_Button = new JButton("AUTO");
		reset_Button = new JButton("RESET");
		
		start_Button.addMouseListener(event);
		auto_Button.addMouseListener(event);
		reset_Button.addMouseListener(event);
		
		panel_Bottom.setBackground(Color.blue);
		panel_Status.setBackground(Color.WHITE);
		panel_Main.setPreferredSize(new Dimension(1200, 800));
		panel_Status.setPreferredSize(new Dimension(1200, 35));

		panel_Status.add(start_Button);
		panel_Status.add(auto_Button);
		panel_Status.add(reset_Button);
		
		panel_Frame.setBackground(Color.GRAY);
		panel_Top.setBackground(Color.GRAY);
		
		panel_Main.add(panel_Top);
		panel_Main.add(panel_Bottom);
		panel_Frame.add(panel_Main);
		panel_Frame.add(panel_Status);
		this.add(panel_Frame);

		this.setVisible(true);

	}

}
