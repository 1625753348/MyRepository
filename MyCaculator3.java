package test1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyCaculator3 extends JFrame {

	private int add = 1, sub = 2, mul = 3, div = 4, sin = 5, cos = 6, tan = 7,bin=8,oct=9,hex=10,sqrt=11;
	private int op = 0;
	boolean ifOp;
	private String output = "0";
	// 文本框
	private JPanel jpanel_textfield = new JPanel();
	private JTextField jtextfield = new JTextField("");
	// 按键组
	private JPanel jpanel_buttons = new JPanel();
	private Button[] buttons = new Button[] { new Button("7"), new Button("8"), new Button("9"), new Button("+"),
			new Button("4"), new Button("5"), new Button("6"), new Button("-"), new Button("1"), new Button("2"),
			new Button("3"), new Button("*"), new Button("0"), new Button("."), new Button("="), new Button("/"),
			new Button("tan"), new Button("cos"), new Button("sin"), new Button("C"),
			new Button("2进制"),new Button("8进制"),new Button("16进制"),new Button("sqrt") };

	public MyCaculator3() throws HeadlessException {
		// 文本框用边框布局
		jpanel_textfield.setLayout(new BorderLayout());
		jtextfield.setFont(new Font("宋体", Font.PLAIN, 50));
		// 添加到面板
		jpanel_textfield.add(jtextfield);
		// 添加到框架
		this.add(jpanel_textfield, BorderLayout.NORTH);

		// 文按键组用表格布局yh
		jpanel_buttons.setLayout(new GridLayout(6, 4));
		for (int i = 0; i < buttons.length; i++) {
			jpanel_buttons.add(buttons[i]);
			buttons[i].setFont(new Font("宋体", Font.PLAIN, 25));
		}
		this.add(jpanel_buttons, BorderLayout.CENTER);

		// 添加事件监听
		for (int i = 0; i < buttons.length; i++) {
			jpanel_buttons.add(buttons[i]);
			if (i == 3 || i == 7 || i == 11 || i == 15 || i == 14 || i == 19 || i == 18 || i == 16 || i == 17|| i == 20|| i == 21|| i == 22|| i == 23)

				buttons[i].addActionListener(new setOperate_Act());
			else
				buttons[i].addActionListener(new setLabel_Act());
		}
		// 设置窗口大小
		this.setSize(980, 500);
		// 设置可见
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/*
	 * 为加减乘除添加操作活动 实现ActionListener接口 覆写void actionPerformed(ActionEvent e)发生动作时调用。
	 */
	class setOperate_Act implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == buttons[3]) {
				// 加
				jtextfield.setText(add(jtextfield.getText()));
				ifOp = true;
			} else if (e.getSource() == buttons[7]) {
				// 减
				jtextfield.setText(subtract(jtextfield.getText()));

				ifOp = true;
			} else if (e.getSource() == buttons[11]) {
				// 乘
				jtextfield.setText(multiply(jtextfield.getText()));
				ifOp = true;
			} else if (e.getSource() == buttons[15]) {
				// 除
				jtextfield.setText(divide(jtextfield.getText()));
				ifOp = true;
			} else if (e.getSource() == buttons[14]) {
				// 等于
				try {
					jtextfield.setText(Equals(jtextfield.getText()));
				} catch (Exception e1) {
					jtextfield.setText("异常了，请输正确计算表达式！");
				}
				ifOp = true;
			} else if (e.getSource() == buttons[18]) {
				jtextfield.setText(sin(jtextfield.getText()));
				ifOp = true;
			} else if (e.getSource() == buttons[17]) {
				jtextfield.setText(cos(jtextfield.getText()));
				ifOp = true;
			} else if (e.getSource() == buttons[16]) {
				jtextfield.setText(tan(jtextfield.getText()));
				ifOp = true;
			} else if (e.getSource() == buttons[19]) {
				jtextfield.setText("");

			}else if (e.getSource() == buttons[20]) {
				// bin
				jtextfield.setText(bin(jtextfield.getText()));
				ifOp = true;
			}else if (e.getSource() == buttons[21]) {
				// 8
				jtextfield.setText(oct(jtextfield.getText()));
				ifOp = true;
			}else if (e.getSource() == buttons[22]) {
				// 16
				jtextfield.setText(hex(jtextfield.getText()));
				ifOp = true;
			}else if (e.getSource() == buttons[23]) {
				// sqrt
				jtextfield.setText(sqrt(jtextfield.getText()));
				ifOp = true;
			}
		}
	}

	class setLabel_Act implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Button tempb = (Button) e.getSource();
			if (ifOp) {
				jtextfield.setText(tempb.getLabel());
				ifOp = false;
			} else {
				jtextfield.setText(jtextfield.getText() + tempb.getLabel());
			}
		}
	}

	private void operate(String x) {
		double x1 = Double.valueOf(x);
		double y = Double.valueOf(output);

		switch (op) {
		case 0:
			output = x;
			break;
		case 1:
			output = String.valueOf(y + x1);
			break;
		case 2:
			output = String.valueOf(y - x1);
			break;
		case 3:
			output = String.valueOf(y * x1);
			break;
		case 4:
			if (x1 != 0)
				output = String.valueOf(y / x1);
			else
				output = "不能为0";
			break;
		case 5:
			output = String.valueOf(Math.sin(Math.toRadians(x1)));
			break;
		case 6:
			output = String.valueOf(Math.cos(Math.toRadians(x1)));
			break;
		case 7:
			output = String.valueOf(Math.tan(Math.toRadians(x1)));
			break;
		case 8:
			output = Integer.toBinaryString(Integer.parseInt(x));
			break;
		case 9:
			output = Integer.toOctalString(Integer.parseInt(x));
			break;
		case 10:
			output = Integer.toHexString(Integer.parseInt(x));
			break;
		case 11:
			output = String.valueOf(Math.sqrt(x1));
			break;
		}
	}

	public String add(String x) {
		operate(x);
		op = add;
		return output;
	}

	public String subtract(String x) {
		operate(x);
		op = sub;
		return output;
	}

	public String multiply(String x) {
		operate(x);
		op = mul;
		return output;
	}

	public String divide(String x) {
		operate(x);
		op = div;
		return output;
	}

	public String Equals(String x) {
		operate(x);
		op = 0;
		return output;
	}

	/*
	 * 增加科学计算sin cos tan
	 * 
	 */
	public String sin(String x) {
		operate(x);
		op = sin;
		return output;
	}

	public String cos(String x) {
		operate(x);
		op = cos;
		return output;
	}

	public String tan(String x) {
		operate(x);
		op = tan;
		return output;
	}
public String bin(String x)
{
	operate(x);
	op = bin;
	return output;
}
public String oct(String x)
{
	operate(x);
	op = oct;
	return output;
}
public String hex(String x)
{
	operate(x);
	op = hex;
	return output;
}
public String sqrt(String x)
{
	operate(x);
	op = sqrt;
	return output;
}
public void opClean() {
		op = 0;
		output = "0";
	}

	public static void main(String[] args) {
		MyCaculator3 q = new MyCaculator3();
		for (int i = 0; i < q.buttons.length; i++) {
			q.buttons[i].setBackground(new Color(123, 104, 238));
		}
		q.jtextfield.setBackground(new Color(200, 200, 200));

	}

}