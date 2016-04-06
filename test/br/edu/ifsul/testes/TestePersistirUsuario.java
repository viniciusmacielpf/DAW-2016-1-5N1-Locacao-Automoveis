//package br.edu.ifsul.testes;
//
//
//import br.edu.ifsul.jpa.EntityManagerUtil;
//import br.edu.ifsul.modelo.Cidade;
//import br.edu.ifsul.modelo.PessoaFisica;
//import br.edu.ifsul.modelo.Usuario;
//import java.util.Calendar;
//import javax.persistence.EntityManager; 
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test; 
//
///**
// *
// * @author jorge
// */
//public class TestePersistirUsuario {
//
//    EntityManager em;
//
//    public TestePersistirUsuario() {
//    }
//
//    @Before
//    public void setUp() {                       
//        em = em = EntityManagerUtil.getEntityManager(); 
//    }
//
//    @After
//    public void tearDown() {
//        em.close();
//        
//        
//    }
//
//    @Test
//    public void teste() {
//        boolean exception = false;
//        try {
//            Usuario obj = new Usuario();
//            obj.setNome("João");
//            obj.setBairro("Centro");
//            obj.setCep("99999-999");
//            obj.setCidade(em.find(Cidade.class, 1));
//            obj.setComplemento("AP 400");
//            obj.setCpf("633.443.230-32");
//            obj.setEmail("jorge.bavaresco@passofundo.ifsul.edu.br");
//            obj.setEndereco("Rua tal");
//            obj.setNascimento(Calendar.getInstance());
//            obj.setRg("8898584392");
//            obj.setApelido("usuario");
//            obj.setSenha("usuario");
//            obj.setAdministrador(true);
//            obj.setAtivo(true);
//            em.getTransaction().begin();
//            em.persist(obj);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            exception = true;
//            e.printStackTrace();
//        }
//        // verificando se o resultado é igual ao esperado
//        Assert.assertEquals(false, exception);
//    }
//
//}