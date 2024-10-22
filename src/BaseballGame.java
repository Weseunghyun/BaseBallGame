import java.util.Scanner;

//게임을 시작! 게임 과정이 올바르게 진행되는지 확인, 종료
public class BaseballGame {

    private String answer;
    private BaseballGameDisplay display;
    private RandomNumGenerator generator;
    private UserInputValidator validator;
    //BaseballGame객체를 생성하면 RandomGenerator 클래스를 통해 랜덤 정수 생성
    public BaseballGame(){
        this.generator = new RandomNumGenerator();
        this.answer = generator.generateRandomNum();
        this.display = new BaseballGameDisplay();
        this.validator = new UserInputValidator();
        System.out.println(answer);
    }

    public void play() {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 시작합니다!");
        while (true) {
            System.out.print("숫자를 입력하세요 : ");
            String adjustNum =  sc.nextLine();

            //validator가 true를 리턴하면 올바르게 수행 false라면 오류 메시지 출력
            if(validator.validateUserInput(adjustNum)) {
                //메서드를 통해 스트라이크와 볼 개수 반환
                int strike = countStrike(adjustNum);
                int ball = countBall(adjustNum);
                String response = display.display(strike, ball);
                System.out.println(response);

                if (response.equals("정답입니다!")) {
                    break;
                }
            }else {
                display.displayInvalidInputMessage();
            }
        }
    }

    private int countStrike(String adjustNum){
        int strikeCount = 0;
        for (int i = 0; i < adjustNum.length(); i++) {
            if (adjustNum.charAt(i) == answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }


    private int countBall(String adjustNum) {
        int ballCount = 0;
        Loop1 : for (int i = 0; i < adjustNum.length(); i++) {
            for (int j = 0; j < adjustNum.length(); j++) {
                if (i!=j) {
                    if (adjustNum.charAt(i) == answer.charAt(j)) {
                        ballCount++;
                        continue Loop1;
                    }
                }
            }
        }
        return ballCount;
    }
}
