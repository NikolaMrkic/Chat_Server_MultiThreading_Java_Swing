package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kontroler.Kontroler;
import niti.NitSat;
import niti.NitServer;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ServerForma extends JFrame {

	private JPanel contentPane;
	private JLabel lblSat;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerForma frame = new ServerForma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerForma() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 445);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(105, 105, 105));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setForeground(Color.DARK_GRAY);
		panel.setBounds(24, 11, 697, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnPokreniServer = new JButton("Pokreni Server");
		btnPokreniServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				NitSat ns = new NitSat(lblSat);
				ns.start();
				NitServer ns1 = new NitServer(textArea);
				ns1.start();
			}
		});
		btnPokreniServer.setForeground(Color.WHITE);
		btnPokreniServer.setBackground(Color.RED);
		btnPokreniServer.setBounds(86, 36, 165, 23);
		panel.add(btnPokreniServer);
		
		lblSat = new JLabel("");
		lblSat.setForeground(Color.WHITE);
		lblSat.setBounds(421, 36, 198, 23);
		panel.add(lblSat);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(105, 105, 105));
		panel_1.setBounds(23, 113, 698, 265);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setText("");
		textArea.setBounds(10, 11, 678, 243);
		panel_1.add(textArea);
		Kontroler.getInstanca().postaviFormu(this);
	}
	
	public void postaviTekst(String text){
		textArea.append(text);
	}
}
