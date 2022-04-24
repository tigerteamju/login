package loginpage;

import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class SignUp {
	static String path = "";

	public SignUp() {
		//		Frame login = new login();
		//		login.dispose(); 
		//		�α��� �������� import�ؼ� ����
		//Login Ŭ������ �����ڸ� ȣ���ϸ� �Ʒ��� ��ɵ��� ���� ��
		Frame f = new Frame("ȸ������");
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setSize(350,475);

		String str[] = {"ID", "Password", "Password Again"};
		Font font = new Font("", Font.BOLD, 19);
		Label lb[] = new Label[3];
		TextField tf[] = new TextField[3];

		for(int i = 0; i < lb.length; i++) {
			lb[i] = new Label(str[i]);
			lb[i].setFont(font);
			tf[i] = new TextField();
			tf[i].setFont(font);
		}

		Label ip_check = new Label("�̹� �����ϴ� ���̵��Դϴ�");
		Label pw_check = new Label("��й�ȣ�� ��ġ���� �ʽ��ϴ�");
		Label no_robot = new Label("�κ��� �ƴմϴ�");
		ip_check.setVisible(false);	
		ip_check.setBounds(f.getWidth()/2-90, 135, 175, 20);
		pw_check.setVisible(false);
		pw_check.setBounds(f.getWidth()/2-90, 310, 175, 20);
		no_robot.setBounds(f.getWidth()/2-75, 335, 100, 20 );
		
		Checkbox robot_check = new Checkbox("");
		robot_check.setBounds(f.getWidth()/2 + 50, 333, 75, 20);
		
		lb[0].setBounds(f.getWidth()/2-100, 60, 200,36);//���̵�
		tf[0].setBounds(f.getWidth()/2-100, 100, 200, 32);
		tf[0].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				path = "C:/user_info/" + tf[0].getText();
				File file = new File(path); //-> ������ �����Ǵ� ���� -> Heap���� ����ؼ� ���ο� �޸𸮸� �Ҵ������� �����ϴ� ��ü�� ��� ������ �÷��Ϳ� ���ؼ� ���ŵȴ�

				if(path.equals("C:/user_info/")) {
					ip_check.setVisible(false);
				}
				else if(file.exists()) {
					ip_check.setVisible(true);
				}
				else {
					ip_check.setVisible(false);
				}
			}
		});
		lb[1].setBounds(f.getWidth()/2-100, 160, 200, 36);//��й�ȣ
		tf[1].setBounds(f.getWidth()/2-100, 200, 200, 32);
		lb[2].setBounds(f.getWidth()/2-100, 240, 200, 36);//��й�ȣ Ȯ��
		tf[2].setBounds(f.getWidth()/2-100, 275, 200, 32);
		tf[2].addTextListener(new TextListener() {
			public void textValueChanged(TextEvent e) {
				if(tf[2].getText().equals("") && tf[2].getText().equals("")) {
					pw_check.setVisible(false);
				}
				else if(!tf[2].getText().equals(tf[1].getText())) {
					pw_check.setVisible(true);
				}
				else {
					pw_check.setVisible(false);
				}
			}
		});
		//�ƹ��� ����� ���� üũ�ڽ��� �־����(���� ����) -> ��Ŀ�� �ν�Ʈ�� ��й�ȣ������ ����� �� �ִ�.

		Button sign_btn = new Button("Sign Up");
		sign_btn.setFont(font);
		sign_btn.setBounds(f.getWidth()/2-45, 365, 90, 45);
		sign_btn.addActionListener(new SignUpListener(  tf[0], tf[1], tf[2], f, sign_btn ));

		tf[1].setEchoChar('*');//��й�ȣ
		tf[2].setEchoChar('*');//��й�ȣ �ٽ� �Է�
		for(int i = 0; i < lb.length; i++) {
			f.add(lb[i]);
			f.add(tf[i]);
		}
		f.add(sign_btn);
		f.add(ip_check);
		f.add(pw_check);
		f.add(no_robot);	
		f.add(robot_check);

		f.setVisible(true);
		f.setResizable(false);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f.dispose();
			}
		});

	}//main
}