package org.example.configs;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.ConnectionString;
import lombok.extern.log4j.Log4j2;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


@Log4j2
public class MongoConfig {

    private static MongoClient mongoClient;

    public static MongoClient getMongoClient() {
        if (mongoClient == null){

            AppConfig configObject = new AppConfig();
            String mongoUri = configObject.getConfigValue("database.url");

            CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
            CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

            ServerApi serverApi = ServerApi.builder()
                    .version(ServerApiVersion.V1)
                    .build();

            MongoClientSettings settings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(mongoUri))
                    .serverApi(serverApi)
                    .codecRegistry(codecRegistry)
                    .build();

            mongoClient = MongoClients.create(settings);
            log.info("Mongo Client Acquired Successfully");
        }

        return mongoClient;
    }

    public static void closeMongoClient(){
        if (mongoClient != null){
            mongoClient.close();
            log.info("Mongo connection is closed");
        }
    }

}
