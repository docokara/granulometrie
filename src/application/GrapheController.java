package application;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BubbleChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

	public class GrapheController implements Initializable{

	    @FXML
	    private BubbleChart<?, ?> grapheSelonTaille;

	    @FXML
	    private BubbleChart<?, ?> grapheSelonSurface;

	    @FXML
	    private Button exportImageButton;

	    @FXML
	    private TextArea comment;

	    @FXML
	    private Button saveButton;

	    @FXML
	    private TextField tailleMaxTextField;

	    @FXML
	    private TextField tailleMinTextField;

	    @FXML
	    private TextField largeurTextField;

	    @FXML
	    private Button exportDataButton;


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			exportImageButton.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {
					 Image imageToBeSaved = GranuloController.getImage();
					 FileChooser fileChooser = new FileChooser();
			         FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JPG file (*.jpg)", "*.jpg");
			         fileChooser.getExtensionFilters().add(extFilter);
			         File file = fileChooser.showSaveDialog(null);
			         try {
						ImageIO.write(SwingFXUtils.fromFXImage(imageToBeSaved, null), "jpg", file);
					} catch (IOException e) {
						e.printStackTrace();
					}
			         
				}
			});
		}
		
			

		}



