import java.io.BufferedReader;
import java.io.FileReader;

public class Task2 {
    public static void main(String[] args) throws Exception {
        //Если я правильно понял то в первом файле только координаты одной окружности

        if(args.length != 2) {
            System.out.println("You need to specify data files!");
            return;
        }

        Circle circle = getCircleFromFile(args[0]);
        showPositionOfPointsRelativeToCircle(circle, args[1]);
    }

    public static void showPositionOfPointsRelativeToCircle(final Circle circle, final String filePoints){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePoints)))  {
            reader.lines().limit(100).forEach(
                    pointString -> {
                        Point point = getPointFromString(pointString);
                        ResultCode r = getPositionOfPointOnCircle(point, circle);
                        System.out.println(r.ordinal());
                    }
            );
        } catch (Exception e) {
            System.err.println("File point problems!");
            System.exit(1);
        }
    }

    public static Circle getCircleFromFile(String file) throws Exception {
        float radius = 0;
        Point centerCircle = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))  {
            centerCircle = getPointFromString(reader.readLine());

            String[] lineRadius = reader.readLine().split(" ");
            radius = Float.parseFloat(lineRadius[0]);

        } catch (Exception e) {
            System.err.println("File circle problems!");
            System.exit(1);
        }

        return new Circle(centerCircle, radius);
    }

    public static Point getPointFromString(String string){
        String[] lineXY = string.split(" ");
        float x = Float.parseFloat(lineXY[0]);
        float y = Float.parseFloat(lineXY[1]);

        return new Point(x, y);
    }

    public static ResultCode getPositionOfPointOnCircle(Point point, Circle circle){
        float distance = point.getDistanceBetweenPoints(circle.getCircleCenter());

        return circle.getRadius() > distance ?  ResultCode.POINT_IN_CIRCLE :
               circle.getRadius() == distance ? ResultCode.POINT_ON_CIRCLE :
                                                ResultCode.POINT_OUT_CIRCLE;
    }
}