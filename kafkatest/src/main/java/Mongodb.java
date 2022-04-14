import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.util.JSON;
import org.bson.Document;

import java.util.*;

public class Mongodb {
    // 생성자
    // DB 연결시킴
    public MongoCollection<Document> result;
    public DBCollection collection;

    public DBCollection selectMongo(){
        return collection;


    }
    public Mongodb() {
        //접속정보
        String MongoDB_IP = "localhost";
        int MongoDB_PORT = 27017;
        String DB_NAME = "admin";
        String Databasename = "inventory";
        String user = "debezium";
        char[] pw = {'d','b','z'};

        MongoCredential credential = MongoCredential.createCredential(user,DB_NAME,pw);
        //connect to db
        MongoClient mongoClient = new MongoClient(new ServerAddress(MongoDB_IP,MongoDB_PORT), Arrays.asList(credential));

        List<String> database = mongoClient.getDatabaseNames();
        System.out.println("=====Database List===== ");
        int num =1 ;
        for (String dbName : database) {
            System.out.println( num  + ". " + dbName);
            num++;
        }

        DB db = mongoClient.getDB("inventory");
        Set<String> collections = db.getCollectionNames();

        System.out.println("Database : " + Databasename);
        for (String colName : collections) {
            System.out.println(" + Collection: " + colName);
        }

        DBCollection collection = db.getCollection("book");
        this.collection = collection;

        /*
        //=========== Make Data01 by BasicDBObject ===========
        BasicDBObject document = new BasicDBObject();
        document.put("one", "data01");
        document.put("two", "BasicDBObject");

        BasicDBObject documentDetail = new BasicDBObject();
        documentDetail.put("three-one", 99);
        documentDetail.put("three-two", "BasicDBObject");
        documentDetail.put("three-three", "true");
        document.put("three", documentDetail);

        //Insert Data01
        collection.insert(document);

        //=========== Make Data02 by BasicDBObjectBuilder ===========
        BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start()
                .add("one", "data02").add("two", "BasicDBObjectBuilder");
        BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start()
                .add("three-one", 98).add("three-two", "BasicDBObjectBuilder").add("three-three", "fasle");
        documentBuilder.add("three", documentBuilderDetail.get());

        //Insert Data02
        collection.insert(documentBuilder.get());

        //=========== Make Data03 by BasicDBObjectBuilder ===========
        Map<String, Object> documentMap = new HashMap<String, Object>();
        documentMap.put("one", "data03");
        documentMap.put("two", "Map");

        Map<String, Object> documentMapDetail = new HashMap<String, Object>();
        documentMapDetail.put("three-one", 97);
        documentMapDetail.put("three-two", "Map");
        documentMapDetail.put("three-three", "true");
        documentMap.put("three", documentMapDetail);

        //Insert Data03
        collection.insert(new BasicDBObject(documentMap));
*/


    }


}
