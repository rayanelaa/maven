package laaziz.rayane.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import laaziz.rayane.metier.Client;

public class ClientDaoImpl implements IClientDao {


	Connection cnx = SingletonConnection.getConnection(); 
	public Client save(Client c) {
		Connection cnx = SingletonConnection.getConnection();
		try {
			PreparedStatement cps = cnx.prepareStatement("Insert into client (nom, "
																			+ "prenom, "
																			+ "date_naissance, "
																			+ "tel, "
																			+ "adresse, "
																			+ "mail, "
																			+ "civilite) values(?,?,?,?,?,?,?)");
			cps.setString(1, c.getNom());
			cps.setString(2, c.getPrenom());
			cps.setDate(3, c.getDateNaissance());
			cps.setString(4, c.getTel());
			cps.setString(5, c.getAdresse());
			cps.setString(6, c.getMail());
			cps.setString(7, c.getCivilite());
			
			cps.executeUpdate();
			cps =cnx.prepareStatement("select max(id) as last_id from client");
			ResultSet crs = cps.executeQuery();
			
			if(crs.next()) {
				c.setId(crs.getInt("last_id"));
				return c;
			}

			
			return c;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public Client update(Client c) {
		
		return null;
	}

	
	public void delete(Client c) {
		// TODO Auto-generated method stub 
		
	}

	
	public ArrayList<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public ArrayList<Client> getAll(String nom) {
		// TODO Auto-generated method stub
		return null;
	}


	public Client find(int id) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select* from client where id = ?");
			
			cps.setInt(1, id);
			ResultSet crs =cps.executeQuery();
			
			if (crs.next()) {
				Client c  = new Client ();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}


	public Client find(String nom) {
		try {
			PreparedStatement cps = cnx.prepareStatement("select*from client where nom = ?");
			
			cps.setString(1, nom);
			ResultSet crs = cps.executeQuery();
			if(crs.next()) {
				Client c = new Client();
				c.setId(crs.getInt("id"));
				c.setNom(crs.getString("nom"));
				c.setPrenom(crs.getString("prenom"));
				c.setAdresse(crs.getString("adresse"));
				c.setMail(crs.getString("mail"));
				c.setTel(crs.getString("tel"));
				c.setCivilite(crs.getString("civilite"));
				c.setDateNaissance(crs.getDate("date_naissance"));
				return c;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		
		}
		
		return null;
	}

	@Override
	public Client find(String nom, String prenom) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

}
