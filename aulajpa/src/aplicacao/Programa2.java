package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa2 {

	public static void main(String[] args) {
//Remover um objeto pelo codigo = tem que abrir uma transação (begin, commit)
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("connection_postgreSQL");
		EntityManager em = factory.createEntityManager();
		
		Pessoa p = em.find(Pessoa.class, 2);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		
		System.out.println("Pronto finalizado.");
		
		em.close();
		factory.close();
	}

}
