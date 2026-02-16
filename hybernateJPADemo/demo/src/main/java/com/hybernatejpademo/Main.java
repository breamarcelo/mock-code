package com.hybernatejpademo;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {
    public static void main(String[] args) {
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
        // Persistence.generateSchema("finale", null);
        // var emf = Persistence.createEntityManagerFactory("finale");
        // var em = emf.createEntityManager();
    }
}