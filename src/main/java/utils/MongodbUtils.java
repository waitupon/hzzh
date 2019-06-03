package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;

public class MongodbUtils {
    static MongoClient mongoClient = null;
    static MongoDatabase mongoDatabase = null;

    static String DEFAULT_COLLECTION = "qcc";

    public static MongoClient getClient(){
        if(mongoClient!=null) return mongoClient;
        ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
        List<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
        MongoCredential credential = MongoCredential.createScramSha1Credential("root", "quant_01", "root".toCharArray());
        List<MongoCredential> credentials = new ArrayList<MongoCredential>();
        credentials.add(credential);

        //通过连接认证获取MongoDB连接
        MongoClient mongoClient = new MongoClient(addrs, credentials);
        return mongoClient;
    }


    public static MongoDatabase getDatabase(){
        if(mongoDatabase!=null) return mongoDatabase;
        MongoClient client = getClient();
        MongoDatabase mongoDatabase = client.getDatabase("quant_01");
        return mongoDatabase;
    }


    public static MongoCollection <Document>getCollection(String name){
        MongoDatabase database = getDatabase();
        return database.getCollection(name);
    }

    public static void save(String dbName,String companyName){
        MongoCollection<Document> collection = getCollection(dbName);
        Document document = new Document();
        document.append("name",companyName);
        collection.insertOne(document);
    }
    public static void save(String companyName){
        MongodbUtils.save(DEFAULT_COLLECTION,companyName);
    }

    public static void saveList(List list){
        MongodbUtils.saveList(DEFAULT_COLLECTION,list);
    }

    public static void saveList(String dbName,List list){
        MongoCollection<Document> collection = getCollection(dbName);
        collection.insertMany(list);
    }


//    public static void main(String[] args) {
//        for (int i=0;i<10;i++)
//        MongodbUtils.save("my","123");
//    }

    public static void main(String[] args){
        try {
            //连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址
            //ServerAddress()两个参数分别为 服务器地址 和 端口
            ServerAddress serverAddress = new ServerAddress("127.0.0.1",27017);
            List<ServerAddress> addrs = new ArrayList<ServerAddress>();
            addrs.add(serverAddress);

            //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码
            MongoCredential credential = MongoCredential.createScramSha1Credential("root", "quant_01", "root".toCharArray());
            List<MongoCredential> credentials = new ArrayList<MongoCredential>();
            credentials.add(credential);

            //通过连接认证获取MongoDB连接
            MongoClient mongoClient = new MongoClient(addrs, credentials);

            //连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("quant_01");
            System.out.println("Connect to database successfully");

//            mongoDatabase.createCollection("xxx");
//            System.out.println("集合创建成功");

            MongoCollection<Document> collection = mongoDatabase.getCollection("basic");
            System.out.println("集合 xxx选择成功");

            //检索所有文档
            /**
             * 1. 获取迭代器FindIterable<Document>
             * 2. 获取游标MongoCursor<Document>
             * 3. 通过游标遍历检索出的文档集合
             * */
            FindIterable<Document> findIterable = collection.find();
            MongoCursor<Document> mongoCursor = findIterable.iterator();
            int i=0;

            FileOutputStream fis = new FileOutputStream("/Users/wenhao/1.txt");
            Set<String> set = new HashSet<String>();


            FileOutputStream fiss = new FileOutputStream("/Users/wenhao/2.txt");
            Set<String> set2 = new HashSet<String>();

            while(mongoCursor.hasNext()){
                Document doc = mongoCursor.next();
                String name = doc.getString("name");
                System.out.println(name);
                set.add(name);

                String industry = doc.getString("industry");
                set2.add(industry);
                System.out.println(industry);
                i++;
            }


            System.out.println(set);
            System.out.println(set2);


            List<Document>documentList = new ArrayList<>();
            set.stream().forEach(name ->{
                Document d = new Document();
                d.append("name",name.replaceAll(" ","").replaceAll("\\*ST","").replaceAll("[a-zA-Z]","").replaceAll("Ａ",""));
                documentList.add(d);

            });

            System.out.println(documentList.size());
            MongodbUtils.saveList(documentList);

//            set2.stream().forEach(name ->{
//                try {
//                    fiss.write((name.replaceAll(" ","").replaceAll("\\*ST","").replaceAll("[a-zA-Z]","").replaceAll("Ａ","") + "\r\n").getBytes());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            });

            System.out.println("i="+i);
                fis.close();
                fiss.close();
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
