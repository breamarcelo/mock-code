/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package budgetsgenerator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author marcelobrea
 */
public class BudgetsGenerator extends Application{
    
    @Override
    public void start(Stage arg0) throws Exception {
        Stage window = new Stage();
        BorderPane root = new BorderPane();
        root.setCenter(new GridPane());
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
