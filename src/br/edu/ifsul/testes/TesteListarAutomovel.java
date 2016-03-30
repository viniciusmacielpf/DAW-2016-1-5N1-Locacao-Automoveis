/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Automovel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vini
 */
public class TesteListarAutomovel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DAW-2016-1-5N1-ModelPU");
        EntityManager em = emf.createEntityManager();
        
        List<Automovel> lista = em.createQuery("from Produto order by nome").getResultList();
        for(Automovel p: lista){
          //  System.out.println("\n Produto - "+p.getId()+":"+ p.getNome()+"\n Descritao:"+ p.getDescricao()+"\n Marca:"+p.getMarca().getNome()+"\n Grupo:"+p.getGrupo().getNome());
        }
    }
    
}
