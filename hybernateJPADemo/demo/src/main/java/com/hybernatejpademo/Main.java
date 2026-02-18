package com.hybernatejpademo;

import java.util.List;

import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        /* 
        try{
            MysqlDataSource ds = new MysqlDataSource();
            ds.setUrl("jdbc:mysql://192.168.1.20/repasosql");
            ds.setUser("marcelo");
            ds.setPassword("R2daH$R4urL");
            
            Connection con = ds.getConnection();
            ResultSet res = con.createStatement().executeQuery("SELECT * FROM TPersona");
            
            while(res.next()){
                System.out.println(
                    "ID:" + " " + res.getString("pkID") + " \n" + 
                    "Nombre:" + " " + res.getString("Nombre") + " \n" +
                    "Apellidos:" + " " + res.getString("Apellidos") + " \n" +
                    "Teléfono:" + " " + res.getString("Telefono") + " \n" +
                    "Fecha de Nacimiento:" + " " + res.getString("FechaNac") + " \n" +
                    "-----------------------------------------------------"
                );
            }
            
            System.out.println("Connected!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        */
        
        Persistence.generateSchema("finale", null);
        var emf = Persistence.createEntityManagerFactory("finale");
        var em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            // Persistir
            Titular nuevo = new Titular("Carlos", "Santana");
            em.persist(nuevo);
            // Buscar
            Titular persona = em.find(Titular.class, 1);
            if( persona != null){
                System.out.println("Encontrado: " + persona.getNombre() + " " + persona.getApellidos());
            }
            // Eliminar
            em.remove(em.find(Titular.class, 2));
            // Actualizar
            Titular cambiar = em.find(Titular.class, 3);
            cambiar.setNombre("Pedro");
            em.merge(cambiar);
            em.getTransaction().commit();

            List<Titular> lista = em.createQuery("SELECT t FROM Titular t", Titular.class).getResultList();
            for(Titular t : lista){
                System.out.println("ID: " + t.getId() + " | Nombre completo: " + t.getNombre() + " " + t.getApellidos());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }
}