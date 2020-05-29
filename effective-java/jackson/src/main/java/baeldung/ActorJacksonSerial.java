package baeldung;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

/**
 * @author luzj
 * @description: 自定义序列化方案
 * 0 继承标砖序列化模板
 * 1 重写serialize()方法即可
 * @date 2019/3/21
 */
public class ActorJacksonSerial extends StdSerializer<Actor> {

    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public ActorJacksonSerial(Class<Actor> t) {
        super(t);
    }

    /**
     * 定义序列化Actor类的方案
     * @param actor
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(Actor actor, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("imdbId", actor.getImdbId());
        jsonGenerator.writeObjectField("birthday",
                actor.getBirth() != null ? sdf.format(actor.getBirth()) : null);
        jsonGenerator.writeNumberField("N-Film",
                actor.getFilmography() != null ? actor.getFilmography().size() : null);
        jsonGenerator.writeStringField("filmography",
                actor.getFilmography().stream().collect(Collectors.joining("-")));
        jsonGenerator.writeEndObject();
    }
}
