package baeldung;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author luzj
 * @description: 测试类 简易的序列化一个实体类
 * 0 转换成Json字符串
 * 1 非格式化
 * @date 2019/3/21
 */
public class SimpleJackson {
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    /**
     * 序列化Movie对象
     * @return Movie的Json字符串
     */
    String serialMovie() {
        try {
            Actor rudy = new Actor("nm2133679", sdf.parse("12-09-1987"),
                    Arrays.asList("Beatdown", "Wind Walker", "Apocalypto"));

            Movie movie = new Movie("ts0998765", "Mill Gibi", Arrays.asList(rudy));

            ObjectMapper mapper = new ObjectMapper();//jackson的主要工具类
            String movieJson = mapper.writeValueAsString(movie);
            System.out.println(movieJson);
            return movieJson;
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化
     * @return
     */
    Movie deserialMovie(){
        String movie = serialMovie();
        ObjectMapper mapper = new ObjectMapper();
        try {
            Movie obj = mapper.readValue(movie,Movie.class);
            System.out.println(obj);
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //测试序列化与反序列化
    public static void main(String[] args) {
        SimpleJackson sj = new SimpleJackson();
        sj.deserialMovie();
    }
}
