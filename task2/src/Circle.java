public class Circle{
    private final Point circleCenter;
    private final float radius;

    public Circle(final Point circleCenter, final float radius) throws Exception {
        this.circleCenter = circleCenter;

        if (radius <= 0) {
            throw new Exception("Circle radius cannot be negative and zero!");
        }

        this.radius = radius;
    }

    public Point getCircleCenter() {
        return circleCenter;
    }

    public float getRadius() {
        return radius;
    }
}