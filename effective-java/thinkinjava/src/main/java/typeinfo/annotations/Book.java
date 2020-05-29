package typeinfo.annotations;

@ClassAnnotation(name = "book",value = 665)
public class Book {
    @FieldAnnotation(bookFeel = "booker")
    private String name;
    private int size;
    private int current;
    private boolean isOver;

    public Book(String name, int size) {
        this.name = name;
        this.size = size;
        current = 0;
        isOver = false;
    }

    @MethodAnnotation(isGood = true)
    int readPage(@ParamAnnotation(charm = "veryLong") int length) {
        if (!isOver)
            current += length;
        if (current >=size)
            isOver = true;
        return  current;
    }

    @MethodAnnotation(isGood = false)
    void readAgain(){
        current = 0;
        isOver = false;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public int getCurrent() {
        return current;
    }

    public boolean isOver() {
        return isOver;
    }
}
