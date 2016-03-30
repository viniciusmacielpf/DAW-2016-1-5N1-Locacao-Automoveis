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
public class TestePersistirVenda {
    EntityManager em;
    public TestePersistirVenda() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    @Test
    public void teste(){
        Boolean exeption = false;
        try {
            Venda v = new Venda();
            v.setPessoaFisica(em.find(PessoaFisica.class, 11));
            v.setUsuario(em.find(Usuario.class,11));
            v.setData(new GregorianCalendar(2016, Calendar.MARCH, 14));
            v.setPagamentos("a prazo");
            v.setQtdParcelas(3);
//            v.setValorTotal(5000.00);
            VendaItens vi = new VendaItens();
            vi.setProduto(em.find(Automovel.class,1));
           
           //vi.setValorUnitario(vi.getProduto().getPreco());
            vi.setQuantidade(2.0);
            vi.setValorTotal(vi.getQuantidade() * vi.getValorUnitario());
            vi.setVenda(v);
            v.addItem(vi);
           
            
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
