/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.util.Calendar;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/**
 *
 * @author Maryr
 */
public class CalendarCodec implements Codec<Calendar> {

    @Override
    public void encode(BsonWriter writer, Calendar value, EncoderContext encoderContext) {
        writer.writeDateTime(value.getTimeInMillis());
    }

    @Override
    public Calendar decode(BsonReader reader, DecoderContext decoderContext) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(reader.readDateTime());
        return calendar;
    }

    @Override
    public Class<Calendar> getEncoderClass() {
        return Calendar.class;
    }
}
