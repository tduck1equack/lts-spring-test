package lts.exam1.utilities;

import com.google.gson.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class Utility {
    public static Gson gson() {
        return new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
            }
        }).create();
    }
    public static Pageable pageable(Integer pageNumber, Integer pageSize){
        return PageRequest.of(pageNumber, pageSize);
    }
}
