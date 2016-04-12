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
public class TestePersistirAutomovel {

    EntityManager em;

    public TestePersistirAutomovel() {
    }

    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }

    @Test
    public void teste() {
        Boolean exeption = false;
        try {
            PessoaFisica pf = new PessoaFisica();

            Marca m = new Marca();
            m.setNacionalidade("Alema");
            m.setNome("Audi");

            Automovel a = new Automovel();
            
            Opcionais op = new Opcionais();
            Opcionais op2 = new Opcionais();
            Opcionais op3 = new Opcionais();
            
            op.setDescricao("Compudador de bordo");
            op2.setDescricao("Piloto Automatico");
            op3.setDescricao("Direção eletrica");
            
            
            a.setEstadoAtual("Otimo");
            a.setMarca(m);
            a.setModelo("A8");
            a.setAno(2013);
            a.setQuilometragem(50000);
            
            a.getOpcionais().add(op);
            a.getOpcionais().add(op2);
            a.getOpcionais().add(op3);
                    
            em.getTransaction().begin();
            em.persist(op);
            em.persist(op2);
            em.persist(op3);
            em.persist(m);
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
