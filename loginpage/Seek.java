package loginpage;

import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

class Seek {
	static String id_seek = "";
	static String path = "C:/user_info/";
	static String pw = "";
	
	public Seek(){
		Font font = new Font("",Font.BOLD, 19);
		Frame f = new Frame("비밀번호 찾기");
		f.setLayout(null);
		f.setSize(300, 150);
		f.setLocationRelativeTo(null);

		Label put_id = new Label("ID를 입력하세요");
		Label lb_seekPw = new Label();
		TextField tf_putId = new TextField();
		put_id.setFont(font);
		tf_putId.setFont(font);
		put_id.setBounds(20, 30, 200, 40);
		tf_putId.setBounds(20, 70, 200, 30);
		lb_seekPw.setBounds(20, 105, 200, 30);


		tf_putId.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				id_seek = tf_putId.getText();
				path += id_seek + "/";
			}
		});

		Button ok = new Button("OK");
		ok.setFont(font);
		ok.setBounds(230, 70, 40, 30);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(path);
				if(!file.exists()) {
					JOptionPane.showMessageDialog(f, "존재하지 않는 아이디입니다");
					path = "C:/user_info/";
				}
				else {
					try {
						FileReader fr = new FileReader(path + id_seek + ".txt/");
						String res = "";
						int code;
						int count = 0;
						while(  (code = fr.read()) != -1  ) {
							res += (char)code;
							if(count == 2) {
								break;
							}
							if(code == '\n') {
								count++;
								res = "";
							}
						}//while
						fr.close();
						lb_seekPw.setText("비밀번호는 " + res + "입니다");
						lb_seekPw.setVisible(true);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(f, "ID를 입력해주세요");
					} 
				}
				
			}
		});

		f.add(put_id);
		f.add(tf_putId);
		f.add(ok);
		f.add(lb_seekPw);

		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});
	}//constructor

}//class