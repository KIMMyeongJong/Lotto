import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class EventListener implements MouseListener {
	/************************************************************
	 * Project Start : 2018-02-26 Made by : KIM MYEONG JONG Ver 1.0
	 ************************************************************/
	Lotto_GUI GUI;
	int click_Time = 0;
	int user_Lotto_Num[] = new int[6];
	int lotto_Num[] = new int[7];
	int win_Num = 0;
	boolean overlap = false;
	boolean user_Select = false;
	int index_Temp = 0;
	Random rand = new Random();

	public EventListener(Lotto_GUI GUI) {
		this.GUI = GUI;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (e.getSource() == GUI.start_Button) {
			if (user_Select == true) {

				for (int i = 0; i < lotto_Num.length; i++) {
					lotto_Num[i] = rand.nextInt(GUI.button_Array.length) + 1;
					for (int j = 0; j < i; j++) {
						if (lotto_Num[j] == lotto_Num[i]) {
							i--;
							break;
						} // if end
					} // for end
				} // for end

				for (int i = 9; i <= 15; i++) {
					GUI.lotto_Array[i].setText(String.valueOf(lotto_Num[i - 9]));
					GUI.lotto_Array[i].setContentAreaFilled(true);
					GUI.lotto_Array[i].setBackground(Color.white);
					if (i == 15) {
						GUI.lotto_Array[i].setText(String.valueOf(lotto_Num[i - 9]));
						GUI.lotto_Array[i].setContentAreaFilled(true);
						GUI.lotto_Array[i].setBackground(Color.pink);
					}
				}
			} // if select = start button end
			for (int i = 0; i < lotto_Num.length - 1; i++) {
				for (int j = 0; j <= i; j++) {
					if (lotto_Num[i] == user_Lotto_Num[j]) {
						win_Num++;
					}
				}
			}

			switch (win_Num) {
			case 6:
				GUI.lotto_Array[7].setVisible(true);
				GUI.lotto_Array[7].setText("1등");
				GUI.lotto_Array[7].setContentAreaFilled(true);
				GUI.lotto_Array[7].setBackground(Color.blue);
				break;
			case 5:
				for (int i = 0; i < user_Lotto_Num.length; i++) {
					if (lotto_Num[6] == user_Lotto_Num[i]) {
						GUI.lotto_Array[7].setVisible(true);
						GUI.lotto_Array[7].setText("2등");
						GUI.lotto_Array[7].setContentAreaFilled(true);
						GUI.lotto_Array[7].setBackground(Color.blue);
					} else {
						GUI.lotto_Array[7].setVisible(true);
						GUI.lotto_Array[7].setText("3등");
						GUI.lotto_Array[7].setContentAreaFilled(true);
						GUI.lotto_Array[7].setBackground(Color.blue);
					}
				}
				break;
			case 4:
				GUI.lotto_Array[7].setVisible(true);
				GUI.lotto_Array[7].setText("4등");
				GUI.lotto_Array[7].setContentAreaFilled(true);
				GUI.lotto_Array[7].setBackground(Color.blue);
				break;
			case 3:
				GUI.lotto_Array[7].setVisible(true);
				GUI.lotto_Array[7].setText("5등");
				GUI.lotto_Array[7].setContentAreaFilled(true);
				GUI.lotto_Array[7].setBackground(Color.blue);
				break;
			default:
				GUI.lotto_Array[7].setVisible(true);
				GUI.lotto_Array[7].setText("꽝 맞은 갯수 : " + String.valueOf(win_Num));
				GUI.lotto_Array[7].setContentAreaFilled(true);
				GUI.lotto_Array[7].setBackground(Color.red);
				break;
			}
			click_Time = 0;
		} // start select end
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if (e.getSource() == GUI.auto_Button) {
			for (int i = 0; i < user_Lotto_Num.length; i++) {
				user_Lotto_Num[i] = rand.nextInt(GUI.button_Array.length) + 1;
				for (int j = 0; j < i; j++) {
					if (user_Lotto_Num[j] == user_Lotto_Num[i]) {
						i--;
						break;
					} // if end
				} // for end
			} // for end

			for (int i = 1; i <= 6; i++) {
				GUI.lotto_Array[i].setText(String.valueOf(user_Lotto_Num[i - 1]));
				GUI.lotto_Array[i].setContentAreaFilled(true);
				GUI.lotto_Array[i].setBackground(Color.white);
			}
			user_Select = true;
		} // auto button end
			/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		if (click_Time < 6) {
			// only 6time select
			if (overlap == false) {
				for (int i = 0; i < 45; i++) {
					if (e.getSource() == GUI.button_Array[i]) {
						user_Lotto_Num[index_Temp] = i + 1;
						// user_Lotto_Num save i
						for(int k = 0; k<click_Time; k++) {
							if(click_Time==0) {
								break;
							}else {
								if(user_Lotto_Num[k] == user_Lotto_Num[click_Time]) {
									JOptionPane.showMessageDialog(null, "중복입니당");
								}else {
									
								}
							}
						}
						GUI.lotto_Array[index_Temp + 1].setText(String.valueOf(i + 1));
						GUI.lotto_Array[index_Temp + 1].setContentAreaFilled(true);
						GUI.lotto_Array[index_Temp + 1].setBackground(Color.white);
						index_Temp++;
						click_Time++;
					} // if button = select end

				} // if click_Time<7 end
			}
			if (click_Time == 5) {
				user_Select = true;
			}
		} // button select for end
		else {
			JOptionPane.showMessageDialog(null, "전부 선택했습니다");
		} // click_Time>6 end

		if (e.getSource() == GUI.reset_Button) {
			for (int i = 0; i < GUI.lotto_Array.length; i++) {
				GUI.lotto_Array[i].setText(String.valueOf(i));
				if (i == 0 || i == 8) {
					if (i == 0) {
						GUI.lotto_Array[i].setText("사용자 로또 번호");
					} else if (i == 8) {
						GUI.lotto_Array[i].setText("로또 번호");
					}
					GUI.lotto_Array[i].setBorderPainted(false);
					GUI.lotto_Array[i].setBackground(Color.WHITE);
					continue;
				}
				if (i == 7) {
					GUI.lotto_Array[i].setVisible(false);
				}
				if (i == 15) {
					GUI.lotto_Array[i].setText(String.valueOf(i + 1));
					GUI.lotto_Array[i].setBackground(Color.red);
					continue;
				}
				GUI.lotto_Array[i].setContentAreaFilled(false);
			}
			click_Time = 0;
			win_Num = 0;
			overlap = false;
			user_Select = false;
			index_Temp = 0;
		}
	}// mouse click event end

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
