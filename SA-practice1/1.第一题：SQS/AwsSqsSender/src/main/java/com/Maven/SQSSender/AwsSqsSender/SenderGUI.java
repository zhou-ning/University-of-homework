package com.Maven.SQSSender.AwsSqsSender;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class SenderGUI extends JFrame{
		
	JTextField jtf =null;
	JTextArea jta =null;
	SQSSender sender  = new  SQSSender();
	
		public SenderGUI() {
				init();
		}
		
		void init() {
			
			this.setTitle("发送方");
			this.setLocation(300,300);
			this.setSize(500, 500);
			this.setLayout(null);
			
			//添加和队列相关的控件
			JLabel queuelabel = new JLabel("队列名字");
			this.add(queuelabel);
			queuelabel.setBounds(0,10,70,20);
			 jtf =new JTextField();
			this.add(jtf);
			jtf.setBounds(80, 10, 400, 30);
			
			//添加发送消息相关的控件
			JLabel MsgLabel = new JLabel("消息:");
			this.add(MsgLabel);
			MsgLabel.setBounds(0, 80, 70, 20);
			
			 jta =new JTextArea(10,10);
			jta.setLineWrap(true);
			JScrollPane jp=new JScrollPane();
			jp.setViewportView(jta);
			jp.setBounds(40, 90, 400, 300);
			this.add(jp);
				
			
			//添加按钮
			JButton  btn =new JButton("发送");
			this.add(btn);
			btn.setBounds(200, 400, 100, 30);
			btn.addActionListener(new ActionListener() {
	            // 事件处理
	            public void actionPerformed(ActionEvent e) {

	            		System.out.println(jtf.getText());
	            		System.out.println(jta.getText());
	            		String Queuename = jtf.getText();		//得到队列名字
	            		String msg = jta.getText();						//得到消息
	            			            	
	        			String  s=sender.sendMessage(Queuename,msg);
	            		s=s+"\n";
	            		jta.append(s);
	            }
	        });
			
			
			this.setVisible(true);
			this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		}
		
		public static void main(String [] args) {
			SenderGUI senderGUI =new SenderGUI();
		}
}
