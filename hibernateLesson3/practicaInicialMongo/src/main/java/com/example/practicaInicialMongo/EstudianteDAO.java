package com.example.practicaInicialMongo;

import org.bson.Document;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class EstudianteDAO {
	private static final String DB_NAME = "escuela";
	private static final String COLLECTION_NAME = "estudiantes";
	
	private MongoCollection<Document> collection;
	
	public EstudianteDAO(MongoClient client) {
		MongoDatabase database = client.getDatabase(DB_NAME);
		
	}
}
