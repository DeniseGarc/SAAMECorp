/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author Maryr
 */
public class ConexionBD {

    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;
    private static final String URL = "mongodb+srv://basesDeDatos:Q3csbtApaJCjVWL@basesdedatos.8nugs8t.mongodb.net/?retryWrites=true&w=majority&appName=BasesDeDatos";
    private static final String DATABASE_NAME = "AMECorp";

    private ConexionBD() {
    }

    public static MongoDatabase getDatabase() {
        if (mongoClient == null) {
            CodecRegistry combinedCodecRegistry = CodecRegistries.fromRegistries(
                    MongoClientSettings.getDefaultCodecRegistry(),
                    CodecRegistries.fromCodecs(
                            new LocalDateCodec(),
                            new LocalTimeCodec(),
                            new CalendarCodec()
                    ),
                    CodecRegistries.fromProviders(
                            PojoCodecProvider.builder().automatic(true).build()
                    )
            );

            MongoClientSettings clientSettings = MongoClientSettings.builder()
                    .applyConnectionString(new ConnectionString(URL))
                    .codecRegistry(combinedCodecRegistry)
                    .build();

            mongoClient = MongoClients.create(clientSettings);
            database = mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(combinedCodecRegistry);
        }
        return database;
    }

}
