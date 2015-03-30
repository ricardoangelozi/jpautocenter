package resources.testes;

import java.io.BufferedReader;
import java.io.FileReader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import resources.entity.Modelo;

public class TesteConexao {

	private static BufferedReader lerArquivo;

	public static void main(String args[]) {
		for(int i = 1970; i < 2016; i++){
			System.out.println(i);
		}
	}
	

	public static void gravararquivos(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpautocenter");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Modelo modelo = new Modelo();
		modelo.setId(Long.parseLong("1"));
		
//			tx.begin();
//			em.find(Marca.class, modelo.getId());
		em.getTransaction().begin();
			em.persist(modelo);
			em.getTransaction().commit();
	}
	
	public static void carregarArquivo(){
		try {
			FileReader arquivo = new FileReader("C:/Users/Ricardo/Downloads/JPAUTOCENTER/cargatabelas/modelochevrollet.txt");
			lerArquivo = new BufferedReader(arquivo);
			String linha = lerArquivo.readLine();
			String marca [];
			while (linha != null) { 
				marca = linha.split(";");
				for(Integer i = 0; i < marca.length; i++){
					System.out.println("insert TB_MARCA values (" + i + "" + "," + marca[i] + ")"); 
				}
				linha = lerArquivo.readLine(); 
			}
			lerArquivo.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
