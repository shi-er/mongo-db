package com.shier.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.shier.mongo.common.MongoHelper;
import com.shier.mongo.dao.MongoDao;
import com.shier.mongo.dao.impl.MongoDaoImpl;
import org.apache.log4j.Logger;
import org.bson.Document;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MongodbTest {
    private static final Logger logger = Logger.getLogger(MongodbTest.class);

    @Test
    public void mongoQueryById() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            Map<String, Object> data = mongoDao.queryByID(db, "user", 2);
            //Map<String, Object> data = mongoDao.queryByID(db, "user", new ObjectId("5b850953c5d74a98117effe6"));
            if (Objects.nonNull(data)) {
                logger.info("********查询结果:" + data.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoQueryByDoc() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("name", "霍元甲");
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            List<Map<String, Object>> data = mongoDao.queryByDoc(db, "user", dbObject);
            if (Objects.nonNull(data)) {
                logger.info("********查询结果:" + data.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoQueryAll() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            List<Map<String, Object>> data = mongoDao.queryAll(db, "user");
            if (Objects.nonNull(data)) {
                logger.info("********查询结果:" + data.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoQueryDocument() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        FindIterable<Document> iterable = db.getCollection("user").find(
                new Document()
                        .append("_id", new Document()
                                .append("$gte", "0")
                                .append("$lte", "3"))
        );
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            List<Document> documents = mongoDao.findIterable(iterable);
            if (Objects.nonNull(documents)) {
                logger.info("********查询结果:" + documents.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoInsert() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        for (int i = 3; i < 20; i++) {
            Document document = new Document();
            document.append("_id", i);
            document.append("name", "李十二" + i);
            document.append("age", 18 + i);
            document.append("address", "富利天猫" + 3 + i);
            try {
                mongoDao.insert(db, "shier", document);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void mongoInsertMany() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        List<Document> documents = new ArrayList<>();
        for (int i = 3; i < 20; i++) {
            Document document = new Document();
            document.append("_id", i);
            document.append("name", "李十二" + i);
            document.append("age", 18 + i);
            document.append("address", "富利天猫" + 3 + i);
            documents.add(document);
        }
        try {
            mongoDao.insertMany(db, "user", documents);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoDelete() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("name", "李云标");
        try {
            mongoDao.delete(db, "user", dbObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoDeleteOne() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        BasicDBObject dbObject = new BasicDBObject();
        dbObject.append("name", "李云标");
        try {
            mongoDao.deleteOne(db, "user", dbObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoUpdate() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        BasicDBObject whereDoc = new BasicDBObject();
        whereDoc.append("name", "霍元甲");
        BasicDBObject updateDoc = new BasicDBObject();
        updateDoc.append("school", "这大");
        try {
            mongoDao.update(db, "user", whereDoc, updateDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void mongoUpdateOne() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        BasicDBObject whereDoc = new BasicDBObject();
        whereDoc.append("name", "霍元甲");
        BasicDBObject updateDoc = new BasicDBObject();
        updateDoc.append("school", "浙理工");
        try {
            mongoDao.updateOne(db, "user", whereDoc, updateDoc);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createTable() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            mongoDao.createCol(db, "shop");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dropTable() {
        MongoHelper mongoHelper = new MongoHelper();
        MongoDatabase db = mongoHelper.getMongoDataBase(mongoHelper.getMongoClient());
        MongoDao mongoDao = new MongoDaoImpl();
        try {
            mongoDao.dropCol(db, "user");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

