package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;


import model.Orators;
import service.FileOExel;
import service.ServiceExel;
import service.YouTubeImitator;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class WindowsView extends JFrame {
	private JTextField urlTF;
	private JTextField numberTF;

	public WindowsView() {
		setTitle("Parsing YouTube");
		setBounds(200, 200, 400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel enterLabel = new JLabel("Enter URL YouTube");
		enterLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		enterLabel.setBounds(10, 11, 144, 24);
		getContentPane().add(enterLabel);
		
		urlTF = new JTextField();
		urlTF.setBounds(176, 14, 198, 20);
		getContentPane().add(urlTF);
		urlTF.setColumns(10);
		
		JLabel numberLabel = new JLabel("Enter number of pages to be Shown");
		numberLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		numberLabel.setBounds(10, 46, 252, 24);
		getContentPane().add(numberLabel);
		
		numberTF = new JTextField();
		numberTF.setColumns(10);
		numberTF.setBounds(257, 45, 117, 20);
		getContentPane().add(numberTF);
		
		JLabel infoLabel = new JLabel("");
		infoLabel.setBounds(10, 126, 353, 24);
		getContentPane().add(infoLabel);
		
		JButton StartParsingBtn = new JButton("Start parsing");
		StartParsingBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				YouTubeImitator imitator = new YouTubeImitator();
				ArrayList<Orators> list = imitator.searchOratorsParts(urlTF.getText(), numberTF.getText());
				if (list == null) {
					infoLabel.setText("You havn'n entered URL");
				}else {
					FileOExel.saveExelFile(ServiceExel.SearchOrators(list));
					infoLabel.setText("Program has anded");
				}
			}
		});
		StartParsingBtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		StartParsingBtn.setBounds(120, 92, 124, 23);
		getContentPane().add(StartParsingBtn);
		setVisible(true);
		
	}
}
