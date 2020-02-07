package jason.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Album {
    private String title;
    private ArrayList<Song> album;

    public Album(String title) {
        this.title = title;
        this.album = new ArrayList<Song>();
    }

//    // add song to album
//    public void addToAlbum(Song song) {
//        album.add(song);
//    }

    public Song getSong(String songName) {
//        for (int i = 0; i < album.size(); i++) {
//            if (album.get(i).getTitle() == songName) {
//                return album.get(i);
//            }
//        }
        // TODO: for each
        // this is a different way to do a for loop
        // it creates a variable called checkSong for every entry in our ArrayList
        for (Song checkSong: this.album) {
            if (checkSong.getTitle() == songName) {
                return checkSong;
            }
        }
        return null;
    }

    public void addInOrder(Song song) {
        int songTrack = song.getTrackNumber();

        for (int i = 0; i < album.size(); i++) {
            int albumTrack = album.get(i).getTrackNumber();
            if (albumTrack < songTrack) continue;
            if (albumTrack == songTrack) {
                System.out.println("Track " + song.getTitle() + " already exists in album");
                return;
            }
            album.add(i, song);
            return;
        }
        // we looked through all of the elements, and they were all
        // smaller than song, so we add song to the end of the list
        album.add(song);
    }

    public ArrayList<Song> getAlbum() {
        return album;
    }

    private void printAlbum() {
        System.out.println("---- Album ----");
        for (Song song: this.album) {
            System.out.println("song " + song.getTrackNumber() + ": " + song.getTitle());
        }
    }

    public String getTitle() {
        return title;
    }

//    TODO: add songs in order for the album
    // use track numbers
    // around 12 mins in

    // TODO: for each
    // this is a different way to do a for loop
    // it creates a variable called checkSong for every entry in our ArrayList
//    for (Song checkedSong: this.songs) {
//
//    }

}
