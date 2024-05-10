package v;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class choixServiceC extends JFrame {

	private JPanel contentPane;
	private JTextField input_ID;
	private JLabel txt_saisissezID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choixServiceC frame = new choixServiceC();
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
	public choixServiceC() {
		setTitle("Choix Service Creche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 368);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		input_ID = new JTextField();
		input_ID.setBounds(171, 95, 254, 53);
		contentPane.add(input_ID);
		input_ID.setColumns(10);
		
		
		// Création du boutton ChoixServiceC
		
		JButton ChoixServiceC = new JButton("Recherchez");
		ChoixServiceC.setBounds(171, 218, 254, 53);
		contentPane.add(ChoixServiceC);

		
		txt_saisissezID = new JLabel("Saisisez l'identifiant du service de crèche que vous souhaitez modifier : ");
		txt_saisissezID.setFont(new Font("Tahoma", Font.BOLD, 15));
		txt_saisissezID.setBounds(26, 24, 639, 22);
		contentPane.add(txt_saisissezID);
		
		JButton btn_retour2 = new JButton("Retour");
		btn_retour2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// Redirection vers la page Redirection 

	            dispose();
	            Redirection fenetre11 = new Redirection();
	            fenetre11.setVisible(true);   
			}
		});
		
		
		
		btn_retour2.setBounds(10, 102, 129, 38);
		contentPane.add(btn_retour2);
		
		ChoixServiceC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	            dispose();
	            UpdateServiceCreche fenetre10 = new UpdateServiceCreche(input_ID.getText());
	            fenetre10.setVisible(true);   

        		
			}
		});
	}
}
