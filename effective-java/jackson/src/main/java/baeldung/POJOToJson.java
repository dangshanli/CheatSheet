package baeldung;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author luzj
 * @description:
 * @date 2019/4/4
 */
public class POJOToJson {

    public static final String FILE_SOURCE = "jsons/todo.json";

    public static void main(String[] args) {
        POJOToJson pojoToJson = new POJOToJson();
        //字节流测试
        InputStream stream = POJOToJson.class.getClassLoader().getResourceAsStream(FILE_SOURCE);
        Todo todo = (Todo) pojoToJson.readToObj(stream,Todo.class);
        System.out.println(todo);

        //URL测试,URL查询略耗时，单开一个线程让他慢慢跑
        new Thread(()->{
            String u = "https://jsonplaceholder.typicode.com/todos/50";
            try {
                Todo todos = (Todo) pojoToJson.readToObj(new URL(u),Todo.class);
                System.out.println(todos);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }).start();

        //字符串测试
        String todoString = "{\n" +
                "  \"id\":\"50\",\n" +
                "  \"userId\":\"3000\",\n" +
                "  \"title\":\"are you ok,quiet?\",\n" +
                "  \"completed\":\"false\"\n" +
                "}";
        todo = (Todo) pojoToJson.readToObj(todoString,Todo.class);
        System.out.println(todo);

        //序列化测试
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(todo);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }

    /**
     * 读取数据源，反序列化json
     * @param obj 数据源：File Stream URL String
     * @param c POJO类型
     * @return
     */
    Object readToObj(Object obj, Class c) {
        ObjectMapper mapper = new ObjectMapper();
        Object object = null;
        try {
            if (obj instanceof File) {
                return mapper.readValue((File) obj, c);
            } else if (obj instanceof URL) {
                return mapper.readValue((URL) obj, c);
            } else if (obj instanceof String) {
                return mapper.readValue((String) obj, c);
            } else if (obj instanceof InputStream) {
                return mapper.readValue((InputStream) obj, c);
            } else {
                return null;
            }
        } catch (IOException e) {

        }
        return null;
    }

}


