package typeinfo.findsetget;

public class Singer {
    private String name;
    private double weight;
    private boolean isPop;
    private String[] songs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isPop() {
        return isPop;
    }

    public void setPop(boolean pop) {
        isPop = pop;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] songs) {
        this.songs = songs;
    }
}
