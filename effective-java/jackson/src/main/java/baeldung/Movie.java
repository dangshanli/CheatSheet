package baeldung;

import java.util.List;

/**
 * @author luzj
 * @description: 一部电影
 * @date 2019/3/21
 */
public class Movie {
    private String imdbId;//imdb identity
    private String director;//导演
    private List<Actor> actors;//演员表

    public Movie() {
    }

    public Movie(String imdbId, String director, List<Actor> actors) {
        this.imdbId = imdbId;
        this.director = director;
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
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
