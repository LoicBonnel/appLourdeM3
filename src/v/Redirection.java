package v;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Redirection extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Redirection frame = new Redirection();
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
	public Redirection() {
		setTitle("Accueil Servie Creche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 654, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel txt_modifierC = new JLabel("Bienvenue sur l'application lourde de gestion des services de crèche ");
		txt_modifierC.setBounds(10, 0, 627, 22);
		txt_modifierC.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(txt_modifierC);
		

		// Création du boutton ajouter Service
		
		
		JButton btn_modifier_SC = new JButton("Ajouter un nouveau service ");
		btn_modifier_SC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Redirection vers la page AddServicecreche

                dispose();
                AddServicecreche fenetre2 = new AddServicecreche();
                fenetre2.setVisible(true);
			}
		});
		
		
		// Création du boutton ajouter Service

		
		btn_modifier_SC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_modifier_SC.setBounds(10, 242, 264, 45);
		contentPane.add(btn_modifier_SC);
		
		JButton btn_modifier_SC_1 = new JButton("Modifier un service existant");
		btn_modifier_SC_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Redirection vers la page choixServiceC

                dispose();
                choixServiceC fenetre3 = new choixServiceC();
                fenetre3.setVisible(true);   
			}
		});
		btn_modifier_SC_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_modifier_SC_1.setBounds(346, 242, 264, 45);
		contentPane.add(btn_modifier_SC_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\thege\\Desktop\\person-love-people-summer-35537-removebg-preview.png"));
		lblNewLabel.setBounds(147, 0, 627, 435);
		contentPane.add(lblNewLabel);
	}

}
