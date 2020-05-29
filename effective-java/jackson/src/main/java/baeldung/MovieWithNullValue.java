package baeldung;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * @author luzj
 * @description: Movie对象可空 忽略director域
 * @date 2019/3/21
 */
public class MovieWithNullValue {
    private String imdbId;

    @JsonIgnore
    private String director;

    private List<Actor> actors;

    public MovieWithNullValue() {
    }

    public MovieWithNullValue(String imdbId, String director, List<Actor> actors) {
        this.imdbId = imdbId;
        this.director = director;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieWithNullValue{" +
                "imdbId='" + imdbId + '\'' +
                ", director='" + director + '\'' +
                ", actors=" + actors +
                '}';
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
