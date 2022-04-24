package loginpage;

import java.awt.*;
import java.awt.event.*;
import java.io.File;


public class SignUp {
	static String path = "";

	public SignUp() {
		//		Frame login = new login();
		//		login.dispose(); 
		//		로그인 프래임을 import해서 닫음
		//Login 클래스의 생성자를 호출하면 아래의 명령들이 실행 됌
		Frame f = new Frame("회원가입");
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

		Label ip_check = new Label("이미 존재하는 아이디입니다");
		Label pw_check = new Label("비밀번호가 일치하지 않습니다");
		Label no_robot = new Label("로봇이 아닙니다");
		ip_check.setVisible(false);	
		ip_check.setBounds(f.getWidth()/2-90, 135, 175, 20);
		pw_check.setVisible(false);
		pw_check.setBounds(f.getWidth()/2-90, 310, 175, 20);
		no_robot.setBounds(f.getWidth()/2-75, 335, 100, 20 );
		
		Checkbox robot_check = new Checkbox("");
		robot_check.setBounds(f.getWidth()/2 + 50, 333, 75, 20);
		
		lb[0].setBounds(f.getWidth()/2-100, 60, 200,36);//아이디
		tf[0].setBounds(f.getWidth()/2-100, 100, 200, 32);
		tf[0].addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				path = "C:/user_info/" + tf[0].getText();
				File file = new File(path); //-> 변수가 생성되는 느낌 -> Heap에서 계속해서 새로운 메모리를 할당하지만 참조하는 객체가 없어서 가비지 컬렉터에 의해서 제거된다

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
		lb[1].setBounds(f.getWidth()/2-100, 160, 200, 36);//비밀번호
		tf[1].setBounds(f.getWidth()/2-100, 200, 200, 32);
		lb[2].setBounds(f.getWidth()/2-100, 240, 200, 36);//비밀번호 확인
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
		//아무린 기능이 없는 체크박스를 넣어놔서(성별 선택) -> 포커스 로스트를 비밀번호에서도 사용할 수 있다.

		Button sign_btn = new Button("Sign Up");
		sign_btn.setFont(font);
		sign_btn.setBounds(f.getWidth()/2-45, 365, 90, 45);
		sign_btn.addActionListener(new SignUpListener(  tf[0], tf[1], tf[2], f, sign_btn ));

		tf[1].setEchoChar('*');//비밀번호
		tf[2].setEchoChar('*');//비밀번호 다시 입력
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