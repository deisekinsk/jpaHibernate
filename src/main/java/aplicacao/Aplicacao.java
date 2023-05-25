package aplicacao;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.awt.*;

public class Aplicacao {
    public static void main(String[] args) {
        final String Green = "\u001B[32m";
        final String RST = "\u001B[0m";
        final String color = "\u001B[34m";

        //id null
        Pessoa p1 = new Pessoa(null,"Will Smith","will@gmail.com");
        Pessoa p2 = new Pessoa(null,"Carla Akotirene","carla@gmail.com");
        Pessoa p3 = new Pessoa(null,"Ana Miranda","ana@gmail.com");

        EntityManagerFactory instanciaJPA = Persistence.createEntityManagerFactory("pessoas-jpa");
        EntityManager instanciaConecta = instanciaJPA.createEntityManager();

        try {
            instanciaConecta.getTransaction().begin();
            System.out.println(Green +"Conexão realizada.\n"+RST );
//            instanciaConecta.persist(p3);
            System.out.println(Green +"Inseriu dado.\n"+RST );
            instanciaConecta.getTransaction().commit();
            System.out.println(Green +"Comitou. Finaliza.\n"+RST );

            Pessoa p = instanciaConecta.find(Pessoa.class,2);
            System.out.println(color + p);
            instanciaConecta.getTransaction().begin();
            instanciaConecta.remove(p);
            System.out.println(Green +"Inseriu dado.\n"+RST );
            instanciaConecta.getTransaction().commit();

            instanciaJPA.close();
            instanciaConecta.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}