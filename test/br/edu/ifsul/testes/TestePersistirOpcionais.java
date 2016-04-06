/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Automovel;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Opcionais;
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
public class TestePersistirOpcionais {

    EntityManager em;

    public TestePersistirOpcionais() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @Test
    public void teste() {
        Boolean exeption = false;
        try {
            
            
            Automovel a = em.find(Automovel.class, 4);
            Opcionais op = new Opcionais();
            op.setDescricao("Teste");
//            a.getOpcionais().add(op);
            
            

            em.getTransaction().begin();
//            em.persist(m);;
            em.persist(a);
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
