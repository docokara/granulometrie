package application;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class GranuloController implements Initializable{
	
    @FXML
    private Button importButton;

    @FXML
    private Button processingButton;

    @FXML
    private ImageView imageView;
    
    // Variables globales
    private static Image image;
    private static boolean isImported = false;
    
    
    
	public static Image getImage() {
		return image;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		importButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				FileChooser fc = new FileChooser();
				fc.setInitialDirectory(new File("C://Users//"));
				fc.getExtensionFilters().add(new ExtensionFilter("JPG Files", "*.jpg"));
				fc.getExtensionFilters().add(new ExtensionFilter("PNG Files", "*.png"));
				File file = fc.showOpenDialog(null);
				
				if(file != null) {
					image = new Image(file.toURI().toString());
					imageView.setImage(image);
					isImported = true;
				}
				
				else {
					System.out.println("file invalide");
				}
				
			}
		});
		
		
		processingButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if(isImported == true) {
					try {
						FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Graphe.fxml"));
						Parent root1 = (Parent) fxmlLoader.load();
						Stage stage = new Stage();
						stage.setTitle("Graphe");
						stage.setScene(new Scene(root1));
						stage.setResizable(false);
						stage.show();
					} catch (Exception e) {
						System.out.println("Cant load new window");
					}
				}

			}
		});
		
	}
}
