import java.util.HashSet;
import java.util.Set;

public class RandomNumGenerator {

    public String generateRandomNum(){
        Set<Integer> randomNumSet = new HashSet<>();

        while (randomNumSet.size() < 3) {
            int randomNum = (int) (Math.random() * 9 + 1);
            randomNumSet.add(randomNum);
        }

        StringBuilder randomNumBuilder = new StringBuilder();
        for (int randomNum : randomNumSet) {
            randomNumBuilder.append(randomNum);
        }

        return randomNumBuilder.toString();
    }

}
