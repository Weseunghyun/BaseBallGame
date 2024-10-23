
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//랜덤 세자리 정수를 생성해주는 클래스
public class RandomNumGenerator {

    public String generateRandomNum(int level){

        //알아서 중복인 값을 적용하지 않도록 Set으로 시작
        Set<Integer> randomNumSet = new HashSet<>();

        while (randomNumSet.size() < level) {
            int randomNum = (int) (Math.random() * 9 + 1);
            randomNumSet.add(randomNum);
        }

        /*toList는 반환되는 리스트가 수정할 수 없는 리스트이다.
        * shuffle은 수정가능한 리스트에서만 작동한다. 그냥 toList를 하고 shuffle을 호출하면
        * UnspportedOperationException이 발생할 수 있다.*/
        //List<Integer> randomNumList = randomNumSet.stream().toList();
        List<Integer> randomNumList = new ArrayList<>(randomNumSet.stream().toList());
        Collections.shuffle(randomNumList);

        StringBuilder randomNumBuilder = new StringBuilder();
        for (int randomNum : randomNumList) {
            randomNumBuilder.append(randomNum);
        }

        return randomNumBuilder.toString();
    }

}
