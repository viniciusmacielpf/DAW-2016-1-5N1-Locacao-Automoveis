package br.edu.ifsul.testes;


import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Usuario;
import java.util.Calendar;
import javax.persistence.EntityManager; 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test; 

/**
 *
 * @author jorge
 */
public class TestePersistirDesejo {

    EntityManager em;

    public TestePersistirDesejo() {
    }

    @Before
    public void setUp() {                       
        em = em = EntityManagerUtil.getEntityManager(); 
    }

    @After
    public void tearDown() {
        em.close();
        
        
    }

    @Test
    public void teste() {
        boolean exception = false;
        try {
            PessoaFisica obj = em.find(PessoaFisica.class, 7);
            Produto p = em.find(Produto.class, 2);
            obj.getDesejos().add(p);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}