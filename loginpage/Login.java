package loginpage;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

import test.Frame1;
public class Login extends Frame1{
	private static String id_info = "";
	static String pw_info = "";
	static String path_info = "C:/user_info/";
	static int num;
	//static ������ ���� �� ���� �� ������
	
	public Login () {
		Frame f = new Frame("�α���");
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setSize(350,475);
		Frame1 frame1 = new Frame1();
		
		Font font = new Font("", Font.BOLD, 19);
		Label login = new Label("ID");	
		Label pw = new Label("Password");
		login.setFont(font);
		pw.setFont(font);
		login.setBounds(f.getWidth()/2-100, 100, 200,36);
		pw.setBounds(f.getWidth()/2-100, 180, 200,36);

		TextField tf_id = new TextField();
		TextField tf_pw = new TextField();
		Button login_btn = new Button("Login");
		Button seek_btn = new Button("Find Pw");
		Button signUp_btn = new Button("Sign UP");

		tf_id.setBounds(f.getWidth()/2-100, 140, 200,32);
		tf_id.setFont(font);
		tf_pw.setBounds(f.getWidth()/2-100, 220, 200,32);
		tf_pw.setFont(font);
		tf_pw.setEchoChar('*');
		login_btn.setFont(font);
		login_btn.setBounds(f.getWidth()/2-100, 280, 80, 45);
		seek_btn.setFont(font);
		seek_btn.setBounds(f.getWidth()/2-5, 280, 105, 45);
		signUp_btn.setFont(font);
		signUp_btn.setBounds(f.getWidth()/2-50, 365, 90, 45);
		signUp_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}	
		});

		tf_id.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				setId_info(tf_id.getText());
				path_info += getId_info() + "/";
			}
		});
		tf_pw.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				pw_info =  tf_pw.getText();
			}
		});

		login_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File file = new File(path_info);
				if(!file.exists()) {
					JOptionPane.showMessageDialog(f, "�������� �ʴ� ���̵��Դϴ�");
					path_info = "C:/user_info/";
				}
				else {
					try {
						FileReader fr = new FileReader(path_info + tf_id.getText() + ".txt");
						String res = "";
						int code;
						int count = 0;
						while(  (code = fr.read()) != -1  ) {
							res += (char)code;
							if(count ==2) {
								break;
							}
							if(code == '\n') {
								count++;
								res = "";
							}
						}//while
						if(res.equals(pw_info)) {
							f.dispose();
							frame1.frame1();
						}
						else {
							JOptionPane.showMessageDialog(f, "��й�ȣ�� Ʋ�Ƚ��ϴ�");
						}
						fr.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(f, "ID�� �Է����ּ���");
					}
				}//
				

				
			}
		});

		seek_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Seek();
			}
		});

		f.add(login_btn);
		f.add(seek_btn);
		f.add(signUp_btn);
		f.add(login);
		f.add(pw);
		f.add(tf_id);
		f.add(tf_pw);

		f.setVisible(true);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		//focuseListener focus gained => ������ ���� �������?
	}//constructor

	public static String getId_info() {
		return id_info;
	}

	public static void setId_info(String id_info) {
		Login.id_info = id_info;
	}
}