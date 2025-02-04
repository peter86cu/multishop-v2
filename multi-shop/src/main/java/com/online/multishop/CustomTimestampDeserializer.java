package com.online.multishop;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class CustomTimestampDeserializer extends JsonDeserializer<Timestamp> {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy, h:mm:ss a", Locale.ENGLISH);

    @Override
    public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dateStr = p.getText().replace("\u202F", " ").trim(); // Eliminar caracteres invisibles
        try {
            return new Timestamp(dateFormat.parse(dateStr).getTime());
        } catch (ParseException e) {
            throw new IOException("Error parsing date: " + dateStr, e);
        }
    }
}
