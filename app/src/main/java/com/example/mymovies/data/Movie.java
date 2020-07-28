package com.example.mymovies.data;

import com.example.mymovies.R;

import java.util.HashMap;

public class Movie {

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return "Director: " + director;
    }

    public String[] getStars() {
        return stars;
    }

    private int imageId;

    public String getApiKey() {
        return apiKey;
    }

    public String[] getTags(){ return this.tags; }

    private String apiKey;
    private String description;
    private String director;
    private String[] stars;
    private String[] tags;

    public static final HashMap<String, Movie> movies = new HashMap<String, Movie>(){
        {
            put("Animal House", new Movie(
                    R.drawable.movie_poster_animal_house,
                    "At a 1962 college, Dean Vernon Wormer is determined to expel the entire Delta Tau Chi Fraternity, but those troublemakers have other plans for him",
                    "John Landis",
                    new String[] {"John Belushi", "Karen Allen", "Tom Hulce"},
                    "KWjtI6n5xWM",
                    new String[] {"Comedy", "Action"}
            ));
            put("Rush Hour", new Movie(
                    R.drawable.movie_poster_rush_hour,
                    "A loyal and dedicated Hong Kong Inspector teams up with a reckless and loudmouthed L.A.P.D. detective to rescue the Chinese Consul's kidnapped daughter, while trying to arrest a dangerous crime lord along the way",
                    "Brett Ratner",
                    new String[] {"Jackie Chan", "Chris Tucker", "Ken Leung"},
                    "JMiFsFQcFLE",
                    new String[] {"Comedy", "Action"}
            ));
            put("Team America: World Police", new Movie(
                    R.drawable.movie_poster_team_america,
                    "Popular Broadway actor Gary Johnston is recruited by the elite counter-terrorism organization Team America: World Police. As the world begins to crumble around him, he must battle with terrorists, celebrities and falling in love",
                    "Trey Parker",
                    new String[] {"Trey Parker", "Matt Stone", "Elle Russ"},
                    "RPBX47zSktc",
                    new String[] {"Comedy", "Action"}
            ));
            put("Four Lions", new Movie(
                    R.drawable.movie_poster_four_lions,
                    "Four incompetent British terrorists set out to train for and commit an act of terror",
                    "Christopher Morris",
                    new String[] {"Will Adamsdale", "Riz Ahmed", "Adeel Akhtar"},
                    "nxJlqapu3zE",
                    new String[] {"Comedy"}
            ));
            put("Superbad", new Movie(
                    R.drawable.movie_poster_super_bad,
                    "Two co-dependent high school seniors are forced to deal with separation anxiety after their plan to stage a booze-soaked party goes awry",
                    "Greg Mottola",
                    new String[] {"Michael Cera", "Jonah Hill", "Christopher Mintz-Plasse"},
                    "4eaZ_48ZYog",
                    new String[] {"Comedy"}
            ));
            put("You Don't Mess with the Zohan", new Movie(
                    R.drawable.movie_poster_zohan,
                    "An Israeli Special Forces Soldier fakes his death so he can re-emerge in New York City as a hair stylist",
                    "Dennis Dugan",
                    new String[] {"Adam Sandler", "John Turturro", "Emmanuelle Chriqui"},
                    "ucmnTmYpGhI",
                    new String[] {"Comedy", "Action"}
            ));
            put("Parasite", new Movie(
                    R.drawable.movie_poster_parasite,
                    "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan",
                    "Bong Joon Ho",
                    new String[] {"Kang-ho Song", "Sun-kyun Lee", "Yeo-jeong Jo"},
                    "5xH0HfJHsaY",
                    new String[] {"Drama"}
            ));
            put("Snowpiercer", new Movie(R.drawable.movie_poster_snow_piercer,
                    "In a future where a failed climate-change experiment has killed all life except for the lucky few who boarded the Snowpiercer, a train that travels around the globe, a new class system emerges",
                    "Bong Joon Ho",
                    new String[] {"Chris Evans", "Jamie Bell", "Tilda Swinton"},
                    "nX5PwfEMBM0",
                    new String[] {"Action", "Sci-Fi"}
            ));
        }
    };

    private Movie(int imageId, String description, String director, String[] stars, String apiKey, String[] tags){

        //this.title = title;
        this.imageId = imageId;
        this.description = description;
        this.director = director;
        this.stars = stars;
        this.apiKey = apiKey;
        this.tags = tags;
    }
}