import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Song song1 = new Song("Blinding Lights", "The Weeknd", 3.5);
        Song song2 = new Song("Shape of You", "Ed Sheeran", 4.2);
        Song song3 = new Song("Someone Like You", "Adele", 4.5);

        Playlist playlist = new Playlist("My Favorite Songs");
        playlist.addSong(song1);
        playlist.addSong(song2);
        playlist.addSong(song3);

        while (true) {
            System.out.println("\nCommands:");
            System.out.println("1. Display playlist");
            System.out.println("2. Add a song");
            System.out.println("3. Remove a song");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    playlist.displayPlaylistInfo();
                    break;
                case 2:
                    System.out.print("Enter song title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter artist name: ");
                    String artist = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    double duration = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Song newSong = new Song(title, artist, duration);
                    playlist.addSong(newSong);
                    System.out.println("Song added successfully!");
                    break;
                case 3:
                    System.out.print("Enter the title of the song to remove: ");
                    String songToRemove = scanner.nextLine();
                    if (playlist.removeSongByTitle(songToRemove)) {
                        System.out.println("Song removed successfully!");
                    } else {
                        System.out.println("Song not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Song {
    private String title;
    private String artist;
    private double duration; // in minutes

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

    public boolean removeSongByTitle(String title) {
        for (Song song : songs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                songs.remove(song);
                return true;
            }
        }
        return false;
    }

    public void displayPlaylistInfo() {
        System.out.println("Playlist Name: " + name);
        System.out.println("Songs:");
        if (songs.isEmpty()) {
            System.out.println("No songs in the playlist.");
        } else {
            for (Song song : songs) {
                song.displaySongInfo();
                System.out.println("----");
            }
        }
    }
}
