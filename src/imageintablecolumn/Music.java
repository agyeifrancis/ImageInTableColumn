/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageintablecolumn;

import javafx.beans.property.*;

public class Music
{
    //Properties 
    private SimpleStringProperty artist = new SimpleStringProperty();
    private ObjectProperty albumArt= new SimpleObjectProperty();
    private StringProperty title= new SimpleStringProperty();
    private IntegerProperty rating= new SimpleIntegerProperty();

    public Music(String artist,Album album, String title, Integer rating) {
        setArtist(artist);
        setAlbum(album);
        setTitle(title);
        setRating(rating);
    }

    //For Artist
    public void setArtist(String art){
        artist.set(art); 
    }
    public String getArtist(){
        return artist.get();
    }
    public StringProperty artistProperty(){
        return artist;
    }

    //For Album
    public void setAlbum(Album alb){
        albumArt.set(alb); 
    }
    public Object getAlbum(){
        return albumArt.get();
    }
    public ObjectProperty albumProperty(){
        return albumArt;
    }

    //For Title
    public void setTitle(String tit){
        title.set(tit); 
    }
    public String getTitle(){
        return title.get();
    }
    public StringProperty titleProperty(){
        return title;
    }

    //For Rating
    public void setRating(int rat){
        rating.set(rat); 
    }
    public Integer getRating(){
        return rating.get();
    }
    public IntegerProperty ratingProperty(){
        return rating;
    }    
    
}
