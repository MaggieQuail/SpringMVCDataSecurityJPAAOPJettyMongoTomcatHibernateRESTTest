package com.dbs;

import com.mongodb.*;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.UnknownHostException;

@Component
public class DBMongoConnector {

    private MongoClient client;
    private DB configDb;

    private String bindIp = "localhost";
    private int port = 8090;

    public DBMongoConnector() throws IOException     {
        System.out.println(" Mongo start");
        MongodStarter starter = MongodStarter.getDefaultInstance();
        IMongodConfig mongodConfig = new MongodConfigBuilder()
                .version(Version.Main.PRODUCTION)
                .net(new Net(bindIp, port, Network.localhostIsIPv6()))
                .build();

        MongodExecutable mongo = starter.prepare(mongodConfig);
        mongo.start();

      //  DBCollection collection = getCollection();
       // fillCollections(collection);

     //   System.out.println("db collection CONNECTOR.find: " + collection.count());
     //   mongo.stop();
    }

    public DBCollection getCollection() throws IOException {
        client = new MongoClient(bindIp, port);
        configDb = client.getDB("config");

        DBCollection collection = configDb.getCollection("users1");
      //  fillCollections(collection);

        return collection;
    }

    private void fillCollections(DBCollection collection) {
        //Insert in base
        DBObject person = new BasicDBObject("id", "1")
                .append("name", "Rita");
//                .append("address", new BasicDBObject("street", "123 Fake St")
//                        .append("city", "Faketon")
//                        .append("state", "MA")
//                        .append("zip", 12345));
//        collection1.insert(person);
//        DBObject query = new BasicDBObject();
//        DBCursor cursor = collection1.find(query);
//        for (DBObject dbObject : cursor) {
//          System.out.println("cur " + dbObject);
//        }

      //  collection.insert(person);
        collection.save(person);
        System.out.println("FILLED ");
    }

}
