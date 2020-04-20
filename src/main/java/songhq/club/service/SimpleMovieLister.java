package songhq.club.service;

import org.springframework.beans.factory.annotation.Required;

public class SimpleMovieLister {

    private MovieFinder movieFinder;

	@Required
    public void setMovieFinder(MovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    // ...
}