public class UserInputValidator {
    public UserInputValidator(){

    }
    public boolean validateUserInput(String userInput) {
        //길이가 3이 아니면 false
        if (userInput.length()!=3){
            return false;
        }

        //정수로 변환하는 작업 수행, 에러 발생하면 false 리턴
        try {
            Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            return false;
        }

        //0이 포함되어있다면
        char[] findZero = userInput.toCharArray();
        for (char compare : findZero){
            if (compare=='0'){
                return false;
            }
        }


        if (findZero[0]==findZero[1] || findZero[0]==findZero[2] || findZero[1] == findZero[2]){
            return false;
        }

        return true;
    }

}
