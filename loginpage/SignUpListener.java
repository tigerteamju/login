package loginpage;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.JOptionPane;

public class SignUpListener implements ActionListener{
	TextField id;
	TextField pw;
	TextField pw2;
	Frame f;	
	Button btn;
	String a;
	//보안성을 높이기 위해 Private String으로 id.gettext()를 받는다?
	
	public SignUpListener(TextField id, TextField pw, TextField pw2, Frame f, Button sign_btn) {
		this.id = id;
		this.pw = pw;
		this.pw2 = pw2;
		this.f = f;
		this.btn = sign_btn;
	}//
	
	public void actionPerformed(ActionEvent e) {
		if(   !id.getText().equals("") && !pw.getText().equals("") && !pw2.getText().equals("")   ){
			
			if(   !pw.getText().equals( pw2.getText() )   ) 
			{
				JOptionPane.showMessageDialog(f, "동일한 비밀번호를 입력해주세요");
			}
			else 
			{
				File file = new File("C:/user_info/" + id.getText());
				if(!file.exists()) 
				{//else if로 줄일 수 있을 듯
					file.mkdirs();
					try 
					{
						FileWriter fw  = new FileWriter("C:/user_info/" + id.getText() + "/" + id.getText() + ".txt");
						fw.write(id.getText());
						fw.write("\n");
						fw.write(pw.getText());
						
						fw.close();
						JOptionPane.showMessageDialog(f, "가입 완료!");
						id.setText("");
						pw.setText("");
						pw2.setText("");						//TextField의 값 비우기
						f.dispose();
					} catch (Exception e1) 
					{
						e1.printStackTrace();
						//어떤 오류가 났는지 사용자에게 출력해주면 좋을 것 같음
					}
				}
				else {
					JOptionPane.showMessageDialog(f, "존재하는 아이디입니다");
				}
			}//outer
		}//outer if
		else {
			JOptionPane.showMessageDialog(f, "정보를 전부 입력해주세요");
		}


	}//


	//아이디랑 비밀번호를 key, value에 저장?
}