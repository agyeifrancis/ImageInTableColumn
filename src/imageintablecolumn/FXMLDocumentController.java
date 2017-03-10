/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageintablecolumn;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.util.*;

/**
 *
 * @author blj0011
 */
public class FXMLDocumentController implements Initializable
{
    
    //Going to need access to the table view.  I used JavaFx Scene Builder to create the tableview. 
    //You can use the .fxml document also.
    @FXML private AnchorPane apMain;    

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {        
        /* initialize two CustomImage objects and add them to the observable list */
        TableColumn albumArt = new TableColumn("Album Art");
        albumArt.setCellValueFactory(new PropertyValueFactory("album"));
        albumArt.setPrefWidth(200); 
        // SETTING THE CELL FACTORY FOR THE ALBUM ART                 
        albumArt.setCellFactory(new Callback<TableColumn<Music,Album>,TableCell<Music,Album>>(){        
            @Override
            public TableCell<Music, Album> call(TableColumn<Music, Album> param) {                
                TableCell<Music, Album> cell = new TableCell<Music, Album>(){
                    ImageView imageview = new ImageView();
                    @Override
                    public void updateItem(Album item, boolean empty) {                        
                        if(item!=null){                            
                                HBox box= new HBox();
                                box.setSpacing(10) ;
                                VBox vbox = new VBox();
                                vbox.getChildren().add(new Label(item.getArtist()));
                                vbox.getChildren().add(new Label(item.getAlbum())); 

                                imageview.setFitHeight(50);
                                imageview.setFitWidth(50);
                                File file = new File(item.getFilename());
                                imageview.setImage(new Image(file.toURI().toString())); 

                                box.getChildren().addAll(imageview,vbox); 
                                //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                                setGraphic(box);
                        }
                    }
                };
                System.out.println(cell.getIndex());               
                return cell;
            }
        });
        
        TableColumn title = new TableColumn("Title");
        title.setCellValueFactory(new PropertyValueFactory("title"));
        title.setPrefWidth(120); 

        TableColumn artist = new TableColumn("Artist");
        artist.setCellValueFactory(new PropertyValueFactory("artist"));
        artist.setPrefWidth(120); 

        TableColumn rating = new TableColumn("Rating");
        rating.setCellValueFactory(new PropertyValueFactory("rating"));
        rating.setPrefWidth(120);  
        // SETTING THE CELL FACTORY FOR THE RATINGS COLUMN         
        rating.setCellFactory(new Callback<TableColumn<Music,Integer>,TableCell<Music,Integer>>(){        
            @Override
            public TableCell<Music, Integer> call(TableColumn<Music, Integer> param) {                
                TableCell<Music, Integer> cell = new TableCell<Music, Integer>(){
                    @Override
                    public void updateItem(Integer item, boolean empty) {
                        if(item!=null){

                           ChoiceBox choice = new ChoiceBox(FXCollections.observableArrayList("1", "2", "3", "4", "5")
);                                                   
                           choice.getSelectionModel().select(0);
                           //SETTING ALL THE GRAPHICS COMPONENT FOR CELL
                           setGraphic(choice);
                        } 
                    }
                };                           
                return cell;
            }	
        });
        
        TableView<Music> tvMain = new TableView();
        tvMain.setTableMenuButtonVisible(true);
        tvMain.getColumns().addAll(albumArt, title, artist, rating);
        apMain.getChildren().add(tvMain);
        //SAMPLE DATAS
        ObservableList<String> artists = FXCollections.observableArrayList("Adele",
                    "Unknown","Beyounce","Rihanna","Avril","Disturbia","Kid Rock","Jessi J","Unknown","Unknown");    
        ObservableList<String> titles = FXCollections.observableArrayList("Running in the Deep",
                    "Title 01","Title 09","What's my name","What the Hell","Disturbia","Kid Rock","Price Tag","Title 2","09");    

        //ADDING ALL THE COLUMNS TO TABLEVIEW        

        //ADDING ROWS INTO TABLEVIEW
        ObservableList musics = FXCollections.observableArrayList();
        File file = new File("test1.png");
        if(file.exists())
        {
            System.out.println("file loaded!");
        }
        
        for(int i = 0; i<10; i++){
                Album al = new Album(file.getName(),artists.get(i),artists.get(i)); 
                Music m = new Music(artists.get(i),al,titles.get(i),i%5); 
                musics.add(m); 
        }        
        tvMain.setItems(musics);
            }    
    
}
