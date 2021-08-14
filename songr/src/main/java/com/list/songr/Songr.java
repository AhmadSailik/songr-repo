package com.list.songr;

import javax.persistence.*;

@Entity
@Table(name = "songNam")
public class Songr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;
  private String title;
  private int length;
  private int trackNumber;
  private String albumName;
@ManyToOne
public Album albumSonger;

public Songr(){

}

    public Songr(String title, int length, int trackNumber,String albumName,Album albumSonger ) {
        this.title = title;
        this.length = length;
        this.albumName = albumName;
        this.trackNumber = trackNumber;

        this.albumSonger=albumSonger;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public Album getAlbumSonger() {
        return albumSonger;
    }

    public void setAlbumSonger(Album albumSonger) {
        this.albumSonger = albumSonger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }


}
