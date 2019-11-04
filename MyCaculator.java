package 计算器;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCaculator extends JFrame{
	
	private int add=1,sub=2,mul=3,div=4;
	private int op=0;
	boolean ifOp;
	private String output="0";
	//文本框
	private JPanel jpanel_textfield = new JPanel();
	private JTextField jtextfield = new  JTextField("");
	//按键组
	private JPanel jpanel_buttons = new JPanel();
	private Button[] buttons = new Button[]{
			new Button("7"),new Button("8"),new Button("9"),new Button("+"),
			new Button("4"),new Button("5"),new Button("6"),new Button("-"),
			new Button("1"),new Button("2"),new Button("3"),new Button("*"),
			new Button("0"),new Button("."),new Button("="),new Button("/"),
			new Button("C")
	};
		
	public MyCaculator() throws HeadlessException {
		//文本框用边框布局
		jpanel_textfield.setLayout(new BorderLayout());
		jtextfield.setFont(new Font("宋体", Font.PLAIN, 100));
		//添加到面板
		jpanel_textfield.add(jtextfield);
		//添加到框架
		this.add(jpanel_textfield,BorderLayout.NORTH);
		
		
		
		//文按键组用表格布局
		jpanel_buttons.setLayout(new GridLayout(4, 4));
		for (int i = 0; i < buttons.length; i++) {
			jpanel_buttons.add(buttons[i]);
			buttons[i].setFont(new Font("宋体", Font.PLAIN, 25));
		}
		this.add(jpanel_buttons,BorderLayout.CENTER);
		
		//添加事件监听
		for(int i=0;i<buttons.length;i++){
			jpanel_buttons.add(buttons[i]);
			if(i==3||i==7||i==11||i==15||i==14)
				buttons[i].addActionListener(new setOperate_Act());
			else
				buttons[i].addActionListener(new setLabel_Act());
			}
		//设置窗口大小
		this.setSize(1800,500);
		//设置可见
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/*
	 * 为加减乘除添加操作活动
	 * 实现ActionListener接口
	 * 覆写void actionPerformed(ActionEvent e)发生动作时调用。 

	 */
	class setOperate_Act implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==buttons[3]){
			//加
			jtextfield.setText(add(jtextfield.getText()));
		ifOp=true;
		}
		else if(e.getSource()==buttons[7]){
			//减
			jtextfield.setText(subtract(jtextfield.getText()));
			
		ifOp=true;
		}
		else if(e.getSource()==buttons[11]){
			//乘
			jtextfield.setText(multiply(jtextfield.getText()));
		ifOp=true;
		}
		else if(e.getSource()==buttons[15]){
			//除
			jtextfield.setText(divide(jtextfield.getText()));
		ifOp=true;
		}
		else if(e.getSource()==buttons[14]){
			//等于
			jtextfield.setText(Equals(jtextfield.getText()));
		ifOp=true;
		}
		else if(e.getSource()==buttons[16]){
			//清除
			//jtextfield.setText();
		ifOp=true;
		}
		}
		}
		class setLabel_Act implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		Button tempb=(Button)e.getSource();
		if(ifOp){
			jtextfield.setText(tempb.getLabel());
		ifOp=false;
		}else {
			jtextfield.setText(jtextfield.getText()+tempb.getLabel());
		}
		}
		}
	private void operate(String x){
		double x1=Double.valueOf(x);
		double y=Double.valueOf(output);
		
		switch(op){
		case 0:output=x;break;
		case 1:output=String.valueOf(y+x1);break;
		case 2:output =String.valueOf(y-x1);break;
		case 3:output =String.valueOf(y*x1);break;
		case 4:
		if(x1!=0) output=String.valueOf(y/x1);
		else	output="不能为0";
		break;
		}
		}
		public String add(String x){
		operate(x);
		op=add;
		return output;
		}
		public String subtract(String x){
		operate(x);
		op=sub;
		return output;
		}
		public String multiply(String x){
		operate(x);
		op=mul;
		return output;
		}
		public String divide(String x){
		operate(x);
		op=div;
		return output;
		}
		public String Equals(String x){
		operate(x);
		op=0;
		return output;
		}
		public void opClean(){
		op=0;
		output="0";
		}
		


	public static void main(String[] args) {
		new MyCaculator();
	}
	
	

}
