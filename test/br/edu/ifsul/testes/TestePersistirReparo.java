/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Automovel;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Reparos;
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
public class TestePersistirReparo {

    EntityManager em;

    public TestePersistirReparo() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @Test
    public void teste() {
        Boolean exeption = false;
        try {
            Reparos rp = new Reparos();
            rp.setAutomovel(em.find(Automovel.class, 4));
            rp.setDataReparo(new GregorianCalendar(2016, Calendar.APRIL, 04));
            rp.setDescricao("Reparo no bloco do motor");
            rp.setPrevisaoEntrega(new GregorianCalendar(2016, Calendar.APRIL, 20));
            rp.setValor(974.43);
            
            em.getTransaction().begin();
            em.persist(rp);
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
