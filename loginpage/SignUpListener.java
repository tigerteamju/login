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
	//���ȼ��� ���̱� ���� Private String���� id.gettext()�� �޴´�?
	
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
				JOptionPane.showMessageDialog(f, "������ ��й�ȣ�� �Է����ּ���");
			}
			else 
			{
				File file = new File("C:/user_info/" + id.getText());
				if(!file.exists()) 
				{//else if�� ���� �� ���� ��
					file.mkdirs();
					try 
					{
						FileWriter fw  = new FileWriter("C:/user_info/" + id.getText() + "/" + id.getText() + ".txt");
						fw.write(id.getText());
						fw.write("\n");
						fw.write(pw.getText());
						
						fw.close();
						JOptionPane.showMessageDialog(f, "���� �Ϸ�!");
						id.setText("");
						pw.setText("");
						pw2.setText("");						//TextField�� �� ����
						f.dispose();
					} catch (Exception e1) 
					{
						e1.printStackTrace();
						//� ������ ������ ����ڿ��� ������ָ� ���� �� ����
					}
				}
				else {
					JOptionPane.showMessageDialog(f, "�����ϴ� ���̵��Դϴ�");
				}
			}//outer
		}//outer if
		else {
			JOptionPane.showMessageDialog(f, "������ ���� �Է����ּ���");
		}


	}//


	//���̵�� ��й�ȣ�� key, value�� ����?
}