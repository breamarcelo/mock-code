package com.example.practicaInicialMongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

/**
 * Hello world!
 *
 */
public class Principal 
{
    public static void main( String[] args ) {
    	String url = "mongodb://192.168.1.41:27017";
    	
    	try(MongoClient client = MongoClients.create(url)) {
    		System.out.println("Conexión exitosa");
    		EstudianteDAO estudiante = new EstudianteDAO(client);
    	} catch(Exception e) {
    		
    	}
    }
}
