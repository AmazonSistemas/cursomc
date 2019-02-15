package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa3 {

	public static void main(String[] args) {
//LEr um objeto pelo codigo = para ler nao precisar abrir um transação, begin e commit
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection_postgreSQL");
		EntityManager em = factory.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		System.out.println(p);
		
		System.out.println("Pronto finalizado.");
		
		em.close();
		factory.close();
	}

}
