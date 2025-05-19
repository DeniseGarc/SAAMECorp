/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.time.LocalTime;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/**
 *
 * @author Maryr
 */
public class LocalTimeCodec implements Codec<LocalTime> {

    @Override
    public LocalTime decode(BsonReader reader, DecoderContext decoderContext) {
        String timeString = reader.readString();
        return LocalTime.parse(timeString);
    }

    @Override
    public void encode(BsonWriter writer, LocalTime value, EncoderContext encoderContext) {
        writer.writeString(value.toString()); // Ejemplo: "14:30:00"
    }

    @Override
    public Class<LocalTime> getEncoderClass() {
        return LocalTime.class;
    }
}
