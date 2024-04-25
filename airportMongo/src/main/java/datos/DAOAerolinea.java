/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author ID145
 */
public class DAOAerolinea {
    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection <Document> collection;
    
    public DAOAerolinea(){
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("airport");
        collection = database.getCollection("airlines");
    }
    
    
}
