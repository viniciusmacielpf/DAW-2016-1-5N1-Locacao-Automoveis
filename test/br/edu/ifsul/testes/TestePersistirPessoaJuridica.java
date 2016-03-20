/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaJuridica;
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
public class TestePersistirPessoaJuridica {
    EntityManager em;
    public TestePersistirPessoaJuridica() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    @Test
    public void teste(){
        Boolean exeption = false;
        try {
            PessoaJuridica pf = new PessoaJuridica();
            
            pf.setBairro("Centro");
            pf.setCep("9910010");
            pf.setCidade(em.find(Cidade.class, 1));
            pf.setComplemento("23");
            pf.setCnpj("02513464044");
            pf.setEmail("vinicius@metasig.com.br");
            pf.setEndereco("Bento Gonçalves");
            pf.setIe("151224");
            
            
            pf.setNome("VInicius Maciel juridico");
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
