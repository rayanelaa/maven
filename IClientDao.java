package laaziz.rayane.dao;

import java.util.ArrayList;

import laaziz.rayane.metier.Client;

public interface IClientDao {
	Client save(Client c);// definition == signature == prototype == entete ==> Insert into
	Client update(Client c);//==> update
	void delete (Client c);// ===> delete
	
	ArrayList<Client> getAll(); // ===> select
	ArrayList<Client> getAll(String nom);// ===> select + where nom + like
	
	Client find(int id); // Surcharge // ===> select + where id
	Client find (String nom);// ===> select + where =
	Client find (String nom, String prenom);// ===> select + where + = =
	
	int count(); // select count

}
