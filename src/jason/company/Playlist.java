package jason.company;

import java.util.*;

public class Playlist {
    private ArrayList<Album> albums;
    private LinkedList<Song> playlist;

    public Playlist() {
        this.albums = new ArrayList<Album>();
        this.playlist = new LinkedList<Song>();
    }

    // add albums to playlist
    public void addAlbums(Album album) {
        this.albums.add(album);
    }

    // add song to playlist
    public boolean addSong(String songName) {
        // reject if song already exists
        if (hasSong(songName)) {
            System.out.println("Song is already in playlist");
            return false;
        }

        for (int i = 0; i < albums.size(); i++) {
            if (albums.get(i).getSong(songName) != null) {
                playlist.add(albums.get(i).getSong(songName));
                System.out.println(songName + " from "
                        + albums.get(i).getTitle() + " added to playlist");
                return true;
            }
        }

        System.out.println("Song not found in albums");
        return false;
    }

    // run the playlist
    public void runPlaylist() {
        ListIterator<Song> listIterator = playlist.listIterator();
        Scanner scanner = new Scanner(System.in);
        runMenu();
        boolean quit = false;
        boolean goingForward = true;

        while (!quit) {
            System.out.print("Enter number: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                // Quit
                case 0:
                    System.out.println("Quit");
                    quit = true;
                    break;

                // Forward
                case 1:
                    if (!goingForward && listIterator.hasNext()) {
                        listIterator.next();
                    }
                    goingForward = true;
                    if (listIterator.hasNext()) {
                        nowPlaying(listIterator.next().getTitle());
                    } else {
                        System.out.println("End of playlist");
                        goingForward = false;
                    }
                    break;

                // Backward
                case 2:
                    if (goingForward && listIterator.hasPrevious()) {
                        listIterator.previous();
                    }
                    goingForward = false;
                    if (listIterator.hasPrevious()) {
                        nowPlaying(listIterator.previous().getTitle());
                    } else {
                        System.out.println("Beginning of playlist");
                        goingForward = true;
                    }
                    break;

                // Replay
                case 3:
                        if (goingForward) {
                            if (listIterator.hasPrevious()) {
                                nowPlaying(listIterator.previous().getTitle());
                                goingForward = false;
                            } else {
                                nowPlaying(listIterator.next().getTitle());
                            }
                        } else {
                            if (listIterator.hasNext()) {
                                nowPlaying(listIterator.next().getTitle());
                                goingForward = true;
                            } else {
                                nowPlaying(listIterator.previous().getTitle());
                            }
                        }
                    System.out.println("Replay--");
                    break;

                // Skip
                case 4:
                    if (listIterator.hasNext()) {
                        listIterator.next();
                        if (listIterator.hasNext()) {
                            nowPlaying(listIterator.next().getTitle());
                        } else {
                            System.out.println("Last song");
                            nowPlaying(listIterator.previous().getTitle());
                        }
                    } else {
                        System.out.println("End of playlist");
                    }
                    goingForward = true;
                    break;

                // Remove
                case 5:
                    if (listIterator.hasNext()) {
                        System.out.println(listIterator.next().getTitle() + " removed");
                        listIterator.remove();
                        printPlaylist();
                    } else if (listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                        printPlaylist();
                    } else {
                        System.out.println("--Playlist empty--");
                    }
                    break;

                // Show menu
                case 6:
                    runMenu();
                    break;

                default:
                    quit = true;
                    break;

            }
            System.out.println("");
        }
    }

    private void nowPlaying(String songName) {
        System.out.println("Now playing " + songName);
    }

    // prints the menu options for runPlaylist
    private void runMenu() {
        System.out.println("======== Menu ========");
        System.out.println("\n 0 - Quit" +
                "\n 1 - Forward" +
                "\n 2 - Backward" +
                "\n 3 - Replay" +
                "\n 4 - Skip" +
                "\n 5 - Remove" +
                "\n 6 - Menu");
        System.out.println("======================");
        System.out.println("");
    }

    // print all songs in playlist
    private void printPlaylist() {
        Iterator<Song> i = playlist.iterator();
        int count = 0;
        System.out.println("Songs in playlist:");
        while (i.hasNext()) {
            System.out.println("Song number " + (count + 1)
                    + " in playlist is " + i.next().getTitle());
            count++;
        }
    }

    // check if playlist has the song
    private boolean hasSong(String songName) {
        Iterator<Song> i = playlist.iterator();

        while (i.hasNext()) {
            if (i.next().getTitle() == songName) {
                return true;
            }
        }
        return false;
    }
}
