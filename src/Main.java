import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Song song1 = new Song("Blinding Lights", "The Weeknd", 3.5);
        Song song2 = new Song("Shape of You", "Ed Sheeran", 4.2);
        Song song3 = new Song("Someone Like You", "Adele", 4.5);


        Artist artist1 = new Artist("The Weeknd", 50);
        Artist artist2 = new Artist("Ed Sheeran", 70);


        Playlist playlist = new Playlist("My Favorite Songs");
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);


        System.out.println("Songs:");
        song1.displaySongInfo();
        System.out.println();
        song2.displaySongInfo();
        System.out.println();


        System.out.println("Artists:");
        artist1.displayArtistInfo();
        System.out.println();
        artist2.displayArtistInfo();
        System.out.println();


        System.out.println("Playlist:");
        playlist.displayPlaylistInfo();
    }
}

class Song {
    private String title;
    private String artist;
    private double duration; // в минутах


    public Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }


    public void displaySongInfo() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Duration: " + duration + " minutes");
    }
}

class Artist {
    private String name;
    private int numberOfSongs;


    public Artist(String name, int numberOfSongs) {
        this.name = name;
        this.numberOfSongs = numberOfSongs;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }


    public void displayArtistInfo() {
        System.out.println("Artist Name: " + name);
        System.out.println("Number of Songs: " + numberOfSongs);
    }
}

class Playlist {
    private String name;
    private List<Song> songs;


    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }


    public void addSong(Song song) {
        songs.add(song);
    }


    public void displayPlaylistInfo() {
        System.out.println("Playlist Name: " + name);
        System.out.println("Songs:");
        for (Song song : songs) {
            song.displaySongInfo();
            System.out.println("----");
        }
    }
}
