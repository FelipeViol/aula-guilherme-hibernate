package com.example.exemplohibernatejpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Cliente;

import java.util.List;

public class AplicacaoMain {
    public static void main(String[] args) {
        System.out.println("Iniciando APP");
        Cliente c = new Cliente();
        c.setNome("Caio maluco");
        c.setEmail("gazola@gmail.com");
        EntityManagerFactory entityManFac =
                Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManFac.createEntityManager();
        // inciando a transação com o banco de dados
        entityManager.getTransaction().begin();
        // persistindo (gravando) o objeto c no banco de dados
        //entityManager.persist(c);
        //fazendo uma busca pela chave primária de id número 2
        //Cliente clibusca = entityManager.find(Cliente.class,2);
        //System.out.println("Cliente encontrado: "+clibusca.getNome());

        String busca = "Luc";

        //Query q1 =
                //entityManager.createQuery("select e from Cliente e" + " where e.nome LIKE :parametroNome ");
        //q1.setParameter("parametroNome", busca + "%");
        //List<Cliente> listaResultado = q1.getResultList();
        //for(Cliente e:listaResultado){
            //System.out.println("Nome: " + e.getNome());
        //}

        Query q2 = entityManager.createQuery(("select e from Cliente e "+ " where e.email like :parametroEmail"));
        q2.setParameter("parametroEmail", busca +"%");
        List<Cliente> listaResultadoEmail = q2.getResultList();

        //alterando os dados do clibusca (cliente id 3), mudando nome
        //clibusca.setNome("Novo nome");

        // excluir o registro (cliente de id 3)
        //entityManager.remove(clibusca);

        // "comitando" (efetivando) a atualização no banco de dados
        entityManager.getTransaction().commit();
        // finalizando as comunicações com o banco de dados
        entityManager.close();
        entityManFac.close();
    }

}
