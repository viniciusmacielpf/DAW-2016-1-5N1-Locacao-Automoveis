/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Cidade;
import br.edu.ifsul.modelo.Estado;
import br.edu.ifsul.modelo.PessoaJuridica;
import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Representante;
import br.edu.ifsul.modelo.RepresentanteID;
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
            
            PessoaFisica p = em.find(PessoaFisica.class, 5);
            PessoaJuridica pf = new PessoaJuridica();
            
            
            pf.setCidade(em.find(Cidade.class, 1));
            
            pf.setCnpj("02513464044");
            pf.setEmail("vinicius@metasig.com.br");
            pf.setEndereco("Bento Gonçalves");
            pf.setIe("151224");           
            pf.setNome("VInicius Maciel juridico");
            pf.setFundacao(new GregorianCalendar(2006, Calendar.MARCH, 10));
            pf.setRazaosocial("Empresa do vini LTDA");
            
            //Inicio Chave composta
            
            Representante r = new Representante();
            RepresentanteID rid = new RepresentanteID();
            rid.setFisica(p);
            rid.setJuridica(pf);
            r.setDataCadastro(Calendar.getInstance());
            r.setRepresentanteID(rid);            
            pf.getRepresentante().add(r);
            //Fim chave composta
            
            
            
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
