public class Camera {
    int positionX;
    int positionY;
    int width;
    int height;
    public Camera(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        width = 10;
        height = 10;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void moveW() {
        positionY--;
    }

    public void moveA() {
        positionX--;
    }

    public void moveS() {
        positionY++;
    }

    public void moveD() {
        positionX++;
    }
}
