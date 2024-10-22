//오로지 출력하는 역할
public class BaseballGameDisplay {

    public void startComment(){
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요!");
        System.out.println("1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
    }
    //사용자 입력과 랜덤 정수와의 비교값을 통해 응답 문자열을 return 함.
    public String displayResponse(int strike, int ball) {

        if (strike + ball == 0){
            return  "아웃";
        } else if (strike == 3){
            return "정답입니다!";
        }else{
            return strike + "스트라이크 " + ball + "볼";
        }
    }

    public void displayInvalidInputMessage(){
        // 아직 미구현
        System.out.println("올바르지 않은 입력값입니다.");
    }
}
