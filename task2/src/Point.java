public class Point{
    private final float x;
    private final float y;

    public Point(final float x, final float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getDistanceBetweenPoints(final Point point) {
        float difX = (this.x - point.x);
        float difY = (this.y - point.y);

        return (float) Math.sqrt(difX * difX + difY * difY);
    }
}
