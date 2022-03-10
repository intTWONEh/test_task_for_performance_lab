import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import java.util.LinkedList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<Integer> integerList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0])))  {
            reader.lines().forEach(number -> integerList.add(Integer.parseInt(number)));
        } catch (Exception e) {
            System.err.println("File problems!");
            System.exit(1);
        }

        int meanValue = integerList.stream().reduce(0, Integer::sum) / integerList.size();
        int result = 0;

        for(Integer number: integerList){
            result += Math.abs(meanValue - number);
        }

        System.out.println(result);
    }
}
