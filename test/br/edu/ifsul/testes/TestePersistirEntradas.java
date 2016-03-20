/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Entrada;
import br.edu.ifsul.modelo.EntradaItem;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.PessoaJuridica;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
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
public class TestePersistirEntradas {
    EntityManager em;
    public TestePersistirEntradas() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    @Test
    public void teste(){
        Boolean exeption = false;
        try {
            PessoaJuridica pf = em.find(PessoaJuridica.class, 9);
            Entrada e = new Entrada();
            //para criar a entrada antes de criar o items
            e.setData(new GregorianCalendar(2016, Calendar.MARCH, 10));
            e.setNota("1235J");
            e.setPessoa(pf);
            e.setValorTotal(0.0);
            
//            e = em.find(Entrada.class, 3);
            EntradaItem ei = new EntradaItem();
            ei.setEntrada(e);
            ei.setQuantidade(3.0);
            ei.setValorUnitario(3.0);
            ei.setValorTotal(ei.getQuantidade() * ei.getValorUnitario());
            ei.setProduto(em.find(Produto.class, 2)); 
            e.addItem(ei);
   
            em.getTransaction().begin();
            em.persist(e);
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
