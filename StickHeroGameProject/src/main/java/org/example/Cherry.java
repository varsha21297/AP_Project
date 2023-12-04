import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Cherry extends Circle {

    public Cherry() {
        super(10, Color.RED);
    }

    public void putCherry(Pillar pillar, int randomHeight) {
        // Calculate the position of the cherry between the gaps of the pillar
        double randomPosition = Math.random() * (pillar.getWidth() - 2 * getRadius()) + getRadius();
        double cherryX = pillar.getX() + randomPosition;
        double cherryY = pillar.getY() - randomHeight - getRadius();

        // Set the position of the cherry
        setCenterX(cherryX);
        setCenterY(cherryY);
    }



    public int checkCollision(StickHero hero) {
        // Check if the hero has collided with the cherry
        if (this.getBoundsInParent().intersects(hero.getBoundsInParent())) {
            // If the hero has collided with the cherry, return 1
            return 10;
        } else {
            // If the hero has not collided with the cherry, return 0
            return 0;
        }
    }


}