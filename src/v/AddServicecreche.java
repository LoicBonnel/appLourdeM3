package v;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class AddServicecreche extends JFrame {

	private JLayeredPane contentPane;
	private JTextField input_nb_places;
	private JTextField input_heure_debut;
	private JTextField input_heure_fin;
	private JTextField input_date;
	private JTextField input_creche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddServicecreche frame = new AddServicecreche();
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
	public AddServicecreche() {
		setTitle("Ajouter Service Crèche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 444);
		contentPane = new JLayeredPane();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		// Création des inputs 
		
		input_nb_places = new JTextField();
		input_nb_places.setBounds(333, 200, 229, 38);
		contentPane.add(input_nb_places);
		input_nb_places.setColumns(10);
		
		input_heure_debut = new JTextField();
		input_heure_debut.setColumns(10);
		input_heure_debut.setBounds(24, 289, 211, 38);
		contentPane.add(input_heure_debut);
		
		input_heure_fin = new JTextField();
		input_heure_fin.setColumns(10);
		input_heure_fin.setBounds(333, 289, 229, 38);
		contentPane.add(input_heure_fin);
		
		input_date = new JTextField();
		input_date.setColumns(10);
		input_date.setBounds(24, 200, 211, 38);
		contentPane.add(input_date);
		
		input_creche = new JTextField();
		input_creche.setColumns(10);
		input_creche.setBounds(175, 126, 211, 38);
		contentPane.add(input_creche);
		
		
		// Création des lables

		
		JLabel lblNewLabel = new JLabel("Veuillez saisir une date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(24, 175, 222, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblVeuillezSaisirLheure = new JLabel("Veuillez saisir  l'heure du début :");
		lblVeuillezSaisirLheure.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVeuillezSaisirLheure.setBounds(10, 249, 272, 14);
		contentPane.add(lblVeuillezSaisirLheure);
		
		JLabel lblVeuillezSaisirLheure_1 = new JLabel("Veuillez saisir  l'heure de fin :");
		lblVeuillezSaisirLheure_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVeuillezSaisirLheure_1.setBounds(335, 249, 288, 14);
		contentPane.add(lblVeuillezSaisirLheure_1);
		
		JLabel lblVeuillezSaisirLe = new JLabel("Veuillez saisir  le nombres de places :");
		lblVeuillezSaisirLe.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVeuillezSaisirLe.setBounds(290, 175, 309, 14);
		contentPane.add(lblVeuillezSaisirLe);
		

		
		JLabel lblVeuillezSaisirLe_1 = new JLabel("Veuillez saisir le nom de la crèche :");
		lblVeuillezSaisirLe_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVeuillezSaisirLe_1.setBounds(144, 101, 303, 14);
		contentPane.add(lblVeuillezSaisirLe_1);
		
		
		JButton btnAjouterCreche = new JButton("Ajouter Service creche");
		btnAjouterCreche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
  
				// Instanciation des varaiables + récupération des résulats des inputs 
				
				String nom_creche = input_creche.getText();

				
				String date = input_date.getText();
				
				
				String nb_placesStr = input_nb_places.getText();
				
				
				int nb_places = Integer.parseInt(nb_placesStr);
				
				
				String heure_debut = input_heure_debut.getText();
				
				
				String heure_fin = input_heure_fin.getText();
				
        try {
            // Chargement du driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connexion à la base de données
            Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.86:8889/Fripouille", "bob", "bob");

            // Utilisation d'une requête préparée pour appeler la procédure stockée
            CallableStatement cs = conn.prepareCall("{CALL Service_creche_ajouter(?,?,?,?,?)}");

            // Paramètres sécurisés de la procédure stockée
            cs.setString(1, date);
            cs.setString(2, heure_debut);
            cs.setString(3, heure_fin);
            cs.setInt(4, nb_places);
            cs.setString(5, nom_creche);

            // Exécution de la procédure stockée
            boolean hasResultSet = cs.execute();

            // Traitement des résultats
            if (hasResultSet) {
                ResultSet rs = cs.getResultSet();
                // Traitement des résultats de la requête SQL
            } else {
                int updateCount = cs.getUpdateCount();
                // Traitement des résultats de la mise à jour
            }

            // Fermeture de la connexion
            cs.close();
            conn.close();

        } catch (SQLException ex) {
            // Gestion des erreurs SQL
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Gestion des erreurs de chargement de la classe du driver JDBC
            e.printStackTrace();
        }

		
		// Création du boutton ajouter creche
		
		btnAjouterCreche.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAjouterCreche.setBounds(162, 349, 264, 45);
		contentPane.add(btnAjouterCreche);
		
		JLabel txtAjouterSCreche = new JLabel("Ici vous pouvez ajouter un service de crèche : ");
		txtAjouterSCreche.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtAjouterSCreche.setBounds(78, 51, 432, 22);
		contentPane.add(txtAjouterSCreche);
		
		
		// Création du boutton retour
		
		JButton btn_retour = new JButton("retour");
		btn_retour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                dispose();
                Redirection fenetre4 = new Redirection();
                fenetre4.setVisible(true);
			}
		});
		
		btn_retour.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_retour.setBounds(500, 11, 99, 38);
		contentPane.add(btn_retour);
		
		dispose();
	}
}
