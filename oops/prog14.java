//Write a Java program to create a class called "MusicLibrary" with a collection of songs and methods to add and remove songs, and to play a random song.package oops;

package oops;

import java.util.*;

class Song {
    private String name;
    private String singer;

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;

    }

    public String getSong() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

}

class Playlist {
    private ArrayList<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<Song>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
        System.out
                .println("Song " + song.getSong() + " is added to the playlist");
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
        System.out.println("Song " + song.getSong() + " is removed from the playlist");
    }

    public void details() {
        System.out.println("PlayList is as follows: ");
        for (Song f : songs) {
            System.out.println("Song " + f.getSong() + " sung by " + f.getSinger());
        }
    }

    public void play() {
        if (songs.size() == 0) {
            System.out.println("PlayList is Empty");
        } else {
            Random ran = new Random();
            System.out.println("Playing " + songs.get(ran.nextInt(songs.size())).getSong());
        }
    }

}

public class prog14 {
    public static void main(String[] args) {

        Playlist pl = new Playlist();
        Song s1 = new Song("Espresso", "Sabrina Carpenter");
        Song s2 = new Song("love you like a love song", "Selena Gomez");
        Song s3 = new Song("Bejeweled", "Taylor Swift");
        Song s4 = new Song("Dont Blame Me", "Taylor Swift");
        Song s5 = new Song("One of the girls", "Weekend");
        pl.addSong(s1);
        pl.addSong(s2);
        pl.addSong(s3);
        pl.addSong(s4);
        pl.addSong(s5);
        pl.details();
        pl.play();
    }

}
