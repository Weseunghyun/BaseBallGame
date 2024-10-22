public class BaseballGameDisplay {

    //사용자 입력과 랜덤 정수와의 비교값을 통해 응답 문자열을 return 함.
    public String display(int strike, int ball) {

        String displayResponse = "";

        if (strike + ball == 0){
            displayResponse = "아웃";
        } else if (strike == 3){
            displayResponse = "정답입니다!";
        }else{
            displayResponse = strike + "스트라이크 " + ball + "볼";

        }

        return displayResponse;
    }

    public void displayInvalidInputMessage(){
        // 아직 미구현
    }
}
