/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Grupo;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Automovel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vini
 */
public class TestePersistirProduto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        Marca m = em.find(Marca.class, 1);
        Grupo g = em.find(Grupo.class, 1);
        
        
        Automovel p = new Automovel();
//        
//        p.setNome("Notebook");
//        p.setDescricao("Core i5, 4gb ram, 1tb HD");
//        p.setEstoque(10.0);
//        p.setPreco(1800.00);
//        p.setGrupo(g);
        p.setMarca(m);
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
