package Main;

import Play.PlayController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Created by corey on 4/2/16.
 */
public class MainMenuController {

    private Stage stage;

    @FXML
    Ellipse level_1_note;
    @FXML
    Ellipse level_2_note;
    @FXML
    Ellipse level_3_note;
    @FXML
    Ellipse level_4_note;
    @FXML
    Ellipse level_5_note;
    @FXML
    Ellipse level_6_note;
    @FXML
    Ellipse level_7_note;
    @FXML
    Ellipse level_8_note;



    @FXML
    public void initialize(){

        level_1_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeLevel(level_1_note, 1);
            }
        });

        level_2_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeLevel(level_2_note, 2);
            }
        });

        level_3_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeLevel(level_3_note, 3);
            }
        });

        level_4_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeLevel(level_4_note, 4);
            }
        });

        level_5_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeLevel(level_5_note, 5);
            }
        });

        level_6_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ChangeLevel(level_6_note, 6);
            }
        });

        level_7_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Level Locked!");
                alert.setTitle("Sorry");
                alert.setContentText("You Cannot Play This Level Yet.");
                alert.showAndWait();
            }
        });

        level_8_note.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Level Locked!");
                alert.setTitle("Sorry");
                alert.setContentText("You Cannot Play This Level Yet.");
                alert.showAndWait();
            }
        });

        level_1_note.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                URL resource = getClass().getResource("/res/sounds/39167__jobro__piano-ff-020.wav");
                Media media = new Media(resource.toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(.7d);
                mediaPlayer.play();
            }
        });
        level_2_note.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                URL resource = getClass().getResource("/res/sounds/39168__jobro__piano-ff-021.wav");
                Media media = new Media(resource.toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(.7d);
                mediaPlayer.play();
            }
        });
        level_3_note.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                URL resource = getClass().getResource("/res/sounds/39170__jobro__piano-ff-023.wav");
                Media media = new Media(resource.toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(.7d);
                mediaPlayer.play();
            }
        });
        level_4_note.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                URL resource = getClass().getResource("/res/sounds/39172__jobro__piano-ff-025.wav");
                Media media = new Media(resource.toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(.7d);
                mediaPlayer.play();
            }
        });
        level_5_note.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                URL resource = getClass().getResource("/res/sounds/39174__jobro__piano-ff-027.wav");
                Media media = new Media(resource.toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(.7d);
                mediaPlayer.play();
            }
        });
        level_6_note.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                URL resource = getClass().getResource("/res/sounds/39175__jobro__piano-ff-028.wav");
                Media media = new Media(resource.toString());
                MediaPlayer mediaPlayer = new MediaPlayer(media);
                mediaPlayer.setVolume(.7d);
                mediaPlayer.play();
            }
        });
    }

    public void setStage(Stage stage)
    {
        this.stage = stage;
    }

    private void ChangeLevel(Ellipse ellipse, int level)
    {
        Parent root;
        PlayController gameController;
        Main.currentLevel = level;

        stage=(Stage)ellipse.getScene().getWindow();
        try{


            //Question question =
            //FXMLLoader loader = new FXMLLoader(getClass().getResource("main_menu.fxml"));
            //maincontroller = loader.getController();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Play/play.fxml"));
            root = loader.load();
            gameController =  loader.getController();
            gameController.setStage(this.stage);
            gameController.setCurrentQuestion(Main.db.getUnusedQuestion(level));
            gameController.setQuestionImages();
            //root = FXMLLoader.load(getClass().getResource("play.fxml"));
            Scene scene = new Scene(root);
            this.stage.setScene(scene);
            this.stage.show();
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void playNocturne(){
        Main.musicPlayer.playNocturne();
    }
    public void playKissTheRain(){
        Main.musicPlayer.playKissTheRain();
    }
    public void playFurElise(){
        Main.musicPlayer.playFurElise();
    }

}
