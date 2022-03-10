import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        System.out.print("Enter the size of the array: ");
        int sizeArray = inputData();
        System.out.print("Enter interval: ");
        int interval = inputData();

        getPathArrayByInterval(sizeArray, interval).forEach(System.out::print);
        //getPathArrayByInterval(sizeArray, interval).forEach(e -> System.out.print(e + " "));
    }

    public static int inputData(){
        Scanner input = new Scanner(System.in);
        int number;

        do{
            try {
                number = input.nextInt();
                if(number > 0) break;
                else System.out.println("You must enter a positive number!");
            } catch (Exception e){
                System.out.println("Invalid input!");
                input.nextLine();
            }
        } while (true);

        return number;
    }

    public static Set<Integer> getPathArrayByInterval(final int arraySize, final int interval){
        if(arraySize < interval){
            System.out.println("Array size cannot be less than interval!");
            return Collections.emptySet();
        }

        if(interval == 1) return Stream.iterate(1, n -> n + 1).limit(arraySize).collect(Collectors.toSet());

        Set<Integer> resultPath = new LinkedHashSet<>();

        resultPath.add(1);
        resultPath.add(interval);
        int step = interval - 1;
        int currentPosition = interval;

        do {
            currentPosition += step;
            if(currentPosition > arraySize) currentPosition -= arraySize;
        } while (resultPath.add(currentPosition));

        return resultPath;
    }
}