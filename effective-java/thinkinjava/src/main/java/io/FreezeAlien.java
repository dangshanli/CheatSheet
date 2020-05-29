package io;

import java.io.*;

public class FreezeAlien {
    public static void main(String[] args) throws IOException {
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream("src/main/resources/public/X.file"));
        Object quellek = new Alien();
        out.writeObject(quellek);
    }
}
