/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import modelos.Aerolinea;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author ID145
 */
public class DAOAerolinea {

    MongoClient mongoClient;
    MongoDatabase database;
    MongoCollection<Document> collection;

    public DAOAerolinea() {
        mongoClient = new MongoClient();
        database = mongoClient.getDatabase("airport");
        collection = database.getCollection("airlines");
    }

    public ArrayList<Aerolinea> obtenerAerolineas() {
        ArrayList<Aerolinea> aerolineas = new ArrayList<>();
        MongoCursor<Document> cursor = collection.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document d = cursor.next();
                boolean lowcost = false;
                if (d.containsKey("lowcost")) {
                    lowcost = d.getBoolean("lowcost");
                }
                Aerolinea a = new Aerolinea(d.getObjectId("_id"), d.getString("name"), d.getString("country"), d.getString("currency"), lowcost);
                aerolineas.add(a);
            }
        } finally {
            cursor.close();
        }
        return aerolineas;
    }

    public void AgregarAerolinea(Aerolinea a) {
        Document aerolinea = new Document("name", a.getNombre())
                .append("country", a.getPais())
                .append("currency", a.getMoneda())
                .append("lowcost", a.isEconomica());
        collection.insertOne(aerolinea);
    }

    public boolean eliminarAerolinea(String id) {
        ObjectId objectId;
        try {
            objectId = new ObjectId(id);
        } catch (IllegalArgumentException e) {
            System.out.println("El ID proporcionado no es válido.");
            return false;
        }

        Document query = new Document("_id", objectId);
        Document result = collection.find(query).first();

        if (result == null) {
            System.out.println("No se encontró ninguna aerolínea con el ID proporcionado.");
            return false;
        }

        collection.deleteOne(query);
        return true;
    }

    public String obtenerPrimerIdAerolinea() {
        Document primero = collection.find().first();
        if (primero != null) {
            ObjectId objectId = primero.getObjectId("_id");
            return objectId.toHexString();
        } else {
            System.out.println("No se encontraron aerolíneas en la colección.");
            return null;
        }
    }

}
