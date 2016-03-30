/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Automovel;
import br.edu.ifsul.modelo.Usuario;
import br.edu.ifsul.modelo.Venda;
import br.edu.ifsul.modelo.VendaItens;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 *
 * @author Vini
 */
public class TestePersistirParcelas {
    EntityManager em;
    public TestePersistirParcelas() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    @Test
    public void teste(){
        Boolean exeption = false;
        try {
            
            Venda v = em.find(Venda.class, 1);
            v.gerarParcelas();
            em.getTransaction().begin();
            em.persist(v);
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
