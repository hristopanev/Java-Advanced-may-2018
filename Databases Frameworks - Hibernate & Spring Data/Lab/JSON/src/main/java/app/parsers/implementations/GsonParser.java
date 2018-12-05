package app.parsers.implementations;

import app.parsers.Parser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class GsonParser implements Parser {

    static Gson gson;
    static {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Override
    public String toJson(Object obj) {
        return gson.toJson(obj);
    }
}
