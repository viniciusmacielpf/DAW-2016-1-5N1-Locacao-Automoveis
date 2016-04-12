/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Automovel;
import br.edu.ifsul.modelo.Locacao;
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
public class TestePersistirLocacao {

    EntityManager em;

    public TestePersistirLocacao() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @Test
    public void teste() {
        Boolean exeption = false;
        try {

            Locacao lo = new Locacao();
            lo.setAutomovel(em.find(Automovel.class, 8));
            lo.setPessoa(em.find(PessoaFisica.class, 5));
            lo.setRetirada(new GregorianCalendar(2015, Calendar.APRIL, 10));
            lo.setValorDiaria(55.60);

            lo.atualizaLocacao(new GregorianCalendar(2015, Calendar.APRIL, 14));

            em.getTransaction().begin();
            em.persist(lo);

            Automovel au = em.find(Automovel.class, 8);
            au.setQuilometragem(au.getQuilometragem() + 759);
            em.merge(au);
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
