package PathTransition;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author usuario
 */
public class PathTransitionDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        //Geometría
        Circle circle = new Circle(150, 125, 60);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Rectangle rectangle = new Rectangle(circle.getCenterX(), circle.getCenterY(), 25, 50);
        rectangle.setFill(Color.ORANGE);
        
        //Animación
        PathTransition an = new PathTransition();
        an.setDuration(Duration.millis(4000));
        an.setPath(circle);
        an.setNode(rectangle);
        an.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        an.setCycleCount(Timeline.INDEFINITE);
        an.setAutoReverse(true);
        an.play();
        
        
        // Ratón
        circle.setOnMousePressed(e -> an.pause());
        circle.setOnMouseReleased(e -> an.play());
        
        
        //Interfaz
        Pane root = new Pane();
        root.getChildren().add(circle);
        root.getChildren().add(rectangle);
        Scene scene = new Scene(root, 300, 260);
        
        primaryStage.setTitle("PathTransitionDemo");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
