package jason.company;

public class Main {

    public static void main(String[] args) {
        Song song7 = new Song("song 1", 4.25, 1);
        Song song1 = new Song("song 1", 4.25, 1);
        Song song3 = new Song("song 3", 5.36, 3);
        Song song2 = new Song("song 2", 3.54, 2);
        Song song6 = new Song("song 6", 2.49, 6);
        Song song5 = new Song("song 5", 7.11, 5);
        Song song4 = new Song("song 4", 6.45, 4);
        Album album1 = new Album("Album 1");
        album1.addInOrder(song1);
        album1.addInOrder(song2);
        album1.addInOrder(song3);
        album1.addInOrder(song4);
        album1.addInOrder(song5);
        album1.addInOrder(song6);
        album1.addInOrder(song7);
//        album1.printAlbum();

        Song songD = new Song("song D", 6.45, 4);
        Song songC = new Song("song C", 5.36, 3);
        Song songG = new Song("song F", 2.49, 6);
        Song songB = new Song("song B", 3.54, 2);
        Song songA = new Song("song A", 4.25, 1);
        Song songF = new Song("song F", 2.49, 6);
        Song songE = new Song("song E", 7.11, 5);
        Album albumA = new Album("Album A");
        albumA.addInOrder(songA);
        albumA.addInOrder(songB);
        albumA.addInOrder(songG);
        albumA.addInOrder(songC);
        albumA.addInOrder(songD);
        albumA.addInOrder(songE);
        albumA.addInOrder(songF);
//        albumA.printAlbum();

//        album1.getSong("song 4");

        Playlist playlist = new Playlist();
        playlist.addAlbums(album1);
        playlist.addAlbums(albumA);

//        System.out.println("the LinkedList is " + playlist.getAlbums());

        playlist.addSong("song 1");
        playlist.addSong("song 2");
        playlist.addSong("song 3");
        playlist.addSong("song 4");
        playlist.addSong("song 5");
        playlist.addSong("song 6");
        playlist.addSong("song A");
        playlist.addSong("song B");
        playlist.addSong("song C");
        playlist.addSong("song D");
        playlist.addSong("song E");
        playlist.addSong("song F");
//        playlist.printPlaylist();
//
//
//        playlist.printPlaylist();

        playlist.runPlaylist();
//
//        Playlist playlist = new Playlist();
//        playlist
    }
}
