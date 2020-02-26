package com.dbs;

//import org.redisson.Redisson;
//import org.redisson.api.RBucket;
//import org.redisson.api.RMap;
//import org.redisson.api.RedissonClient;
//import org.redisson.client.RedisClient;
//import org.redisson.client.RedisConnection;
//import org.redisson.config.Config;
//import redis.clients.jedis.Jedis;

public class DBRedisConnector {

//    public static void main(String[] args) {
////        //Connecting to Redis server on localhost
////        Jedis jedis = new Jedis("redis-12448.c13.us-east-1-3.ec2.cloud.redislabs.com:12448");
////        System.out.println("Connection to server sucessfully");
////        //check whether server is running or not
////        System.out.println("Server is running: "+jedis.ping());
//
//        Config config = new Config();
//        // use single Redis server
//        config.useSingleServer().setAddress("redis://redis-12448.c13.us-east-1-3.ec2.cloud.redislabs.com:12448");
//        RedissonClient redisson = Redisson.create(config);
//        // perform operations
//        RBucket<String> bucket = redisson.getBucket("simpleObject");
//        bucket.set("This is object value");
//        RMap<String, String> map = redisson.getMap("simpleMap");
//        map.put("mapKey", "This is map value");
//        String objectValue = bucket.get();
//        System.out.println("stored object value: " + objectValue);
//        String mapValue = map.get("mapKey");
//        System.out.println("stored map value: " + mapValue);
//        redisson.shutdown();
//    }
}
