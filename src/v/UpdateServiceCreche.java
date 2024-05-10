package v;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.awt.event.ActionEvent;

public class UpdateServiceCreche extends JFrame {

	private JPanel contentPane;
	private JTextField input_heureD;
	private JTextField input_heureF;
	private JTextField input_date;
	private JTextField input_nbr_place;
	private JTextField input_nomC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateServiceCreche frame = new UpdateServiceCreche("1");
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
	public UpdateServiceCreche(String input_ID) {
        // Utilisation de try-with-resources pour gérer automatiquement la fermeture des ressources
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://192.168.1.86:8889/Fripouille", "bob", "bob")) {
            // Utilisation d'une requête préparée pour appeler la procédure stockée
            String sql = "CALL select_id_serviceC(?)";
            try (CallableStatement callableStatement = conn.prepareCall(sql)) {
                // Paramètre sécurisé pour la procédure stockée
                callableStatement.setInt(1, Integer.parseInt(input_ID));

                // Exécution de la procédure stockée
                boolean hasResultSet = callableStatement.execute();

                List<String> resultat = new ArrayList<>();

                // Traitement des résultats
                if (hasResultSet) {
                    try (ResultSet resultSet = callableStatement.getResultSet()) {
                        while(resultSet.next()) {
                            StringBuilder tempResultat = new StringBuilder();
                            for (int i = 1; i <= 6; i++) {
                                String tempVariable = resultSet.getString(i);
                                if(tempVariable != null) {
                                    tempResultat.append(tempVariable).append(";");
                                }
                            }
                            resultat.add(tempResultat.toString());
                        }
                    }
                }

                // Fermeture automatique des ressources
            }
        } catch (SQLException ex) {
            // Gestion des erreurs SQL
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            // Gestion des erreurs de conversion de chaîne en entier
            ex.printStackTrace();
        }
    }

		        
				System.out.println(input_ID);
				System.out.println(resultat);       
		        
		        
		setTitle("Modifier Service Crèche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// créations des inputs 
		
		input_heureD = new JTextField();
		input_heureD.setBounds(29, 250, 166, 35);
		contentPane.add(input_heureD);
		input_heureD.setColumns(10);
		
		input_heureF = new JTextField();
		input_heureF.setColumns(10);
		input_heureF.setBounds(365, 250, 166, 35);
		contentPane.add(input_heureF);
		
		input_date = new JTextField();
		input_date.setColumns(10);
		input_date.setBounds(29, 176, 166, 35);
		contentPane.add(input_date);
		
		input_nbr_place = new JTextField();
		input_nbr_place.setColumns(10);
		input_nbr_place.setBounds(365, 176, 166, 35);
		contentPane.add(input_nbr_place);
		
		input_nomC = new JTextField();
		input_nomC.setColumns(10);
		input_nomC.setBounds(196, 109, 166, 35);
		contentPane.add(input_nomC);
		
		
        String[] tempResult = resultat.toArray(new String[0]);
        String[] splitTemp = tempResult[0].split(";");
        
        
        // Ont met les textes dans les différents inputs 
        
        input_date.setText(splitTemp[1]);
        input_heureD.setText(splitTemp[2]);
        input_heureF.setText(splitTemp[3]);
        input_nbr_place.setText(splitTemp[4]);
        input_nomC.setText(splitTemp[5]);

        
        // Création des labels
        
		JLabel txt_nomC = new JLabel("Veuillez saisir le nom de la crèche :");
		txt_nomC.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_nomC.setBounds(163, 84, 335, 14);
		contentPane.add(txt_nomC);
		
		JLabel txt_date = new JLabel("Veuillez saisir une date :");
		txt_date.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_date.setBounds(29, 151, 182, 14);
		contentPane.add(txt_date);
		
		JLabel txt_nbr_place = new JLabel("Veuillez saisir le nombre de place :");
		txt_nbr_place.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_nbr_place.setBounds(338, 155, 249, 14);
		contentPane.add(txt_nbr_place);
		
		JLabel txt_heureD = new JLabel("Veuillez saisir  l'heure du début :");
		txt_heureD.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_heureD.setBounds(10, 222, 242, 14);
		contentPane.add(txt_heureD);
		
		JLabel txt_heureF = new JLabel("Veuillez saisir  l'heure de fin :");
		txt_heureF.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt_heureF.setBounds(353, 225, 211, 14);
		contentPane.add(txt_heureF);
		
		JLabel txt_modifierC = new JLabel("Ici vous pouvez modifier un service de crèche : ");
		txt_modifierC.setFont(new Font("Tahoma", Font.BOLD, 18));
		txt_modifierC.setBounds(87, 36, 444, 22);
		contentPane.add(txt_modifierC);
		
		
		// Création du boutton Modifier 
		
		
		JButton btn_modifier_SC = new JButton("Modifier service creche");
		btn_modifier_SC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Récupération des valeurs des inputs dans des variables 

				String nomC = input_nomC.getText();

				
				String date = input_date.getText();
				
				
				String nb_placesStr = input_nbr_place.getText();
				
				
				int nb_places = Integer.parseInt(nb_placesStr);
				
				
				String heure_debut = input_heureD.getText();
				
				String heure_fin = input_heureF.getText();
				
				int id = 1;
				
				// Variable String qui stocke la procédure ctockée 

				
				String sql = "CALL service_creche_update(?,?,?,?,?,?)";
                
                try {
                	
				      try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				      Connection conn = DriverManager.getConnection(
				    	      "jdbc:mysql://192.168.1.86:8889/Fripouille", "bob", "bob");


                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    
                    preparedStatement.setString(1, date); // Définir la valeur du premier paramètre

                    preparedStatement.setString(2, heure_debut); // Définir la valeur du deuxième paramètre

                    preparedStatement.setString(3, heure_fin); // Définir la valeur du troisième paramètre

                    preparedStatement.setInt(4, nb_places); // Définir la valeur du quatrième paramètre
		            
                    preparedStatement.setString(5, nomC); // Définir la valeur du cinquième paramètre
                    
                    preparedStatement.setInt(6, id); // Définir la valeur du sixième paramètre                            

                    preparedStatement.executeUpdate();
                    conn.close();

		        } catch (SQLException ex) {
		        	System.out.println(ex);	
				}               
			}
		});
		
		btn_modifier_SC.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_modifier_SC.setBounds(156, 323, 264, 45);
		contentPane.add(btn_modifier_SC);
		
		JButton btn_retour3 = new JButton("Retour");
		btn_retour3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// Redirection vers la page choixServiceC
				
	            dispose();
	            choixServiceC fenetre12 = new choixServiceC();
	            fenetre12.setVisible(true);   
			}
		});
		btn_retour3.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_retour3.setBounds(462, 328, 125, 35);
		contentPane.add(btn_retour3);
	}
}


