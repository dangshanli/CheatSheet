package baeldung;

import java.util.Date;
import java.util.List;

/**
 * @author luzj
 * @description: 一个演员
 * @date 2019/3/21
 */
public class Actor {
    private String imdbId;//imdb identity
    private Date birth;//生日
    private List<String> filmography;//参演电影表

    public Actor() {
    }

    public Actor(String imdbId, Date birth, List<String> filmography) {
        this.imdbId = imdbId;
        this.birth = birth;
        this.filmography = filmography;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "imdbId='" + imdbId + '\'' +
                ", birth=" + birth +
                ", filmography=" + filmography +
                '}';
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public List<String> getFilmography() {
        return filmography;
    }

    public void setFilmography(List<String> filmography) {
        this.filmography = filmography;
    }
}
