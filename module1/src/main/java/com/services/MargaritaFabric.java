package com.services;

import com.dbs.DBMongoConnector;
import com.entities.people.Margarita;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.UnknownHostException;

@Component
public class MargaritaFabric {

    @Autowired
    private DBMongoConnector connector;


    private String getNameFromMongoDB() {
        System.out.println("MargaritaFabric connector: " + connector);

        DBCollection collection = null;
        String name = null;
        try {
            collection = connector.getCollection();
            System.out.println("collection: " + collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        DBObject query = new BasicDBObject("id", "1");
        assert collection != null;
        DBCursor cursor = collection.find(query);
        for (DBObject dbObject : cursor) {
            System.out.println("FABRIC dbObject: " + dbObject);
            name = dbObject.get("name").toString();
        }

        System.out.println("carStoreOwner return name: " + name);
        return name;
    }

    Margarita creator() {
        return new Margarita(getNameFromMongoDB(), 5);
    }
}
