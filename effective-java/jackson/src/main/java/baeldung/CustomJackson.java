package baeldung;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author luzj
 * @description: 使用自定义序列化方案
 * @date 2019/3/21
 */
public class CustomJackson {
    final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * 启用自定义序列化方案
     *
     * @return
     */
    String serial() {
        try {
            //准备实体类
            Actor rudy = new Actor("nm199876", sdf.parse("21-09-1987"),
                    Arrays.asList("Applo", "Wind Walker", "Great Gatsbi"));
            MovieWithNullValue movieNull = new MovieWithNullValue(null,
                    "Mel Down", Arrays.asList(rudy));

            //装备自定义序列化类
            SimpleModule module = new SimpleModule();
            module.addSerializer(new ActorJacksonSerial(Actor.class));
            ObjectMapper mapper = new ObjectMapper();
            String movieJson = mapper.registerModule(module)
                    .writer(new DefaultPrettyPrinter())
                    .writeValueAsString(movieNull);

            return movieJson;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * 自定义反序列化方案
     * 这里只是设置了时间格式
     * 由此可见，自定义的方案装配都在ObjectMapper上
     *
     * @return
     */
    Movie deserial() {
        SimpleJackson simpleJackson = new SimpleJackson();
        String mo = simpleJackson.serialMovie();

        ObjectMapper mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        mapper.setDateFormat(df);
        try {
            Movie movie = mapper.readValue(mo, Movie.class);
            System.out.println(movie);
            if (movie != null)
                return movie;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        CustomJackson cj = new CustomJackson();
        String movieJson = cj.serial();
        System.out.println(movieJson);
        cj.deserial();

    }

}
