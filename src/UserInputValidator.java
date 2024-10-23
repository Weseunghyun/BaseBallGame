import java.util.HashSet;
import java.util.Set;

public class UserInputValidator {

    public UserInputValidator(){}

    //입력값이 올바른 값인지 검증해주는 메서드
    public boolean validateUserInput(String userInput, int level) {
        //길이가 level이 아니면 false
        if (userInput.length()!=level){
            return false;
        }

        //에러로 흐름제어를 하는 것은 금기시되어 있음. 정규식을 통하도록 확인
        if (!userInput.matches("(^[1-9]*$)")){
            return false;
        }

        // 중복 숫자 확인을 위한 Set
        Set<Character> uniqueDigits = new HashSet<>();

        // 각 자리의 문자를 확인
        for (char digit : userInput.toCharArray()) {
            // 0이 포함되어있으면 false
            if (digit == '0') {
                return false;
            }

            // Set에 숫자가 이미 존재하면 중복된 것이므로 false
            if (!uniqueDigits.add(digit)) {
                return false;
            }
        }

        return true;
    }

}
