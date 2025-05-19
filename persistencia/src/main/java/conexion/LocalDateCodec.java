/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/**
 *
 * @author Maryr
 */
public class LocalDateCodec implements Codec<LocalDate> {

    @Override
    public LocalDate decode(BsonReader reader, DecoderContext decoderContext) {
        Date date = reader.readDateTime() != 0 ? new Date(reader.readDateTime()) : null;
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Override
    public void encode(BsonWriter writer, LocalDate value, EncoderContext encoderContext) {
        Instant instant = value.atStartOfDay(ZoneId.systemDefault()).toInstant();
        writer.writeDateTime(Date.from(instant).getTime());
    }

    @Override
    public Class<LocalDate> getEncoderClass() {
        return LocalDate.class;
    }
}
