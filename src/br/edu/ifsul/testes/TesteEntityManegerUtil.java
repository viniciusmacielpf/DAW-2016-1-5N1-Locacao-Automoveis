/*
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.jpa.EntityManagerUtil;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import org.hibernate.validator.ap.ConstraintValidationProcessor;

/**
 *
 * @author vinicius vinicius.maciel.pf@hotmail.com
 */
public class TesteEntityManegerUtil {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getEntityManager();
        Marca m = new Marca();
        m.setNome("");
        Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Marca>> erros = validador.validate(m);
        if (erros.size() > 0) {
            for (ConstraintViolation<Marca> erro : erros) {
                System.out.println("Erro:" + erro.getMessage());
            }
        } else {

            em.getTransaction().begin();
            em.persist(m);
            em.getTransaction().commit();
        }

    }

}
