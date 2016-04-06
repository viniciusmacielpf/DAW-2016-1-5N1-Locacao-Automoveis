/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vini
 */
public class TestePersistirTelefone {
    EntityManager em;
    public TestePersistirTelefone() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    @Test
    public void teste(){
        Boolean exeption = false;
        try {
            PessoaFisica pf = em.find(PessoaFisica.class, 5);
            Telefone t = new Telefone();
            t.setNumero("5491141641");
            t.setOperadora("Tim");
            pf.addTelefone(t);
        
            em.getTransaction().begin();
            em.persist(pf);
            em.getTransaction().commit();
            
            
        } catch (Exception e) {
             exeption = true;
            e.printStackTrace();
        }
        
        
        Assert.assertEquals(false, exeption);
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
}
