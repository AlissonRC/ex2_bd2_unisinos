package teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Classificacao;
import model.Fruta;
import model.Fruteira;

public class FruteiraTeste {

	public static void main(String[] args) {
		// Inicializacao da fabrica de objetos
		// persistenceUnitName = "exemplo1", ou seja, relaciona com a conexao na
		// persistence.xml (podera ter "n" unidades de persistencia)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo1");
		EntityManager em = emf.createEntityManager();
		
		// Os comandos a seguir devem ser executados "um por vez"
		// Inserindo...
		
//        try {
//    		em.getTransaction().begin();
//    		em.persist(new Fruta(null, "maça", 2.44));
//    		em.getTransaction().commit();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            em.getTransaction().rollback();
//        }

		
List<Classificacao> classificacaos1 = new ArrayList<Classificacao>();
List<Fruteira> fruteiras1 = new ArrayList<Fruteira>();
Fruteira fruteira1 = new Fruteira();
fruteira1.setNome("do Carlos");
fruteira1.setEndereco("rua x");
Fruteira fruteira2 = new Fruteira();
fruteira2.setNome("do João");
fruteira2.setEndereco("rua y");
fruteiras1.add(fruteira1);
fruteiras1.add(fruteira2);

Classificacao classificacao1 = new Classificacao();
classificacao1.setNome("verde");
Classificacao classificacao2 = new Classificacao();
classificacao2.setNome("amarela");
classificacaos1.add(classificacao1);
classificacaos1.add(classificacao2);


Fruta f1 = new Fruta();
f1.setNome("banana");
f1.setPreco(2.45);
f1.setFrutas(fruteiras1);
f1.setClassificacao(classificacaos1);
        try {
    		em.getTransaction().begin();
    		em.persist(f1);
    		em.persist(fruteira1);
    		em.persist(fruteira2);
    		em.persist(classificacao1);
    		em.persist(classificacao2);
    		em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            em.getTransaction().rollback();
        }


        // Atualizando...
		// Buscara a fruteira com id = 1. Observe o numero do id pelo postgreSQL/pgAdmin!
		Fruteira fruteira = em.find(Fruteira.class, 1L); 
		if (fruteira != null) {
	        try {
				em.getTransaction().begin();
				fruteira.setNome("Da Maria");
				em.merge(fruteira);
				em.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	        }
		}

		// Recuperando "n" objetos...
		TypedQuery<Fruteira> q = em.createQuery("SELECT f FROM Fruteira f", Fruteira.class);
		for (Fruteira fruteiras : q.getResultList()) {
			System.out.println(fruteiras.toString());
		}		

		// Excluindo...
		// Buscara a fruteira com id = 2. Observe o numero do id pelo postgreSQL/pgAdmin!
		fruteira = em.find(Fruteira.class, 1L); 
		if (fruteira != null) {
	        try {
				em.getTransaction().begin();
				em.remove(fruteira);
				em.getTransaction().commit();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	            em.getTransaction().rollback();
	        }
		}

		// Recuperando "n" objetos...
		q = em.createQuery("FROM Fruteira f", Fruteira.class);
		for (Fruteira fruteiras : q.getResultList()) {
			System.out.println(fruteiras.toString());
		}
		
		System.exit(0);
	}

}
