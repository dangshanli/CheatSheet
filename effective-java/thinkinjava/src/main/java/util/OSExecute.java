package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 这是一个用于执行命令行且想标准输出流打印进程执行信息的简易工具
 * 通过ProcessBuilder构建命令行，且启动进程
 * 通过Process对象getInputStream获取进程产生的输出
 * 通过getErrorStream，在进程产生错误信息的时候，获取错误信息
 * 如果产生了错误信息流，则向上抛出自定义异常OSExecuteException
 */
public class OSExecute {
    public static void command(String command) {
        boolean err = false;
        try {
            //构建进程对象
            Process process = new ProcessBuilder(command.split(" ")).start();
            //获取进程输出
            try (BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                 BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
                String s;
                while ((s = in.readLine()) != null){
                    System.out.println(s);
                }
                while ((s = errors.readLine()) != null){
                    System.err.println(s);
                    err = true;
                }
            }
        } catch (Exception e) {
            //异常处理
            if (!command.startsWith("CMD /C"))
                command("CMD /C "+command);
            else throw new RuntimeException(e);
        }
        if (err){
            throw new OSExecuteException("执行"+command+"错误!");
        }
    }

    public static void main(String[] args) {
        //通过javap工具，执行命令行测试
        OSExecute.command("javap target/classes/practices/thinkinjava/util/TextFile.class");
    }
}
