import java.util.LinkedHashMap;
import java.util.Scanner;

//게임을 시작! 게임 과정이 올바르게 진행되는지 확인, 종료
public class BaseballGame {

    private String answer;
    private BaseballGameDisplay display;
    private RandomNumGenerator generator;
    private UserInputValidator validator;
    private Scanner sc;
    private LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    private static int key = 0;
    private static int level = 3; //초기 레벨 3

    public BaseballGame(){
        this.generator = new RandomNumGenerator();
        this.display = new BaseballGameDisplay();
        this.validator = new UserInputValidator();
        this.sc = new Scanner(System.in);
    }

    public void play() {
        while (true) {
            display.startComment();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 0:
                    try {
                        level = display.levelSelect();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 1:
                    map.put(key, 0);
                    gameStart();
                    break;
                case 2:
                    display.recordDisplay(map);
                    break;
                case 3:
                    System.out.println("< 숫자 야구 게임을 종료합니다 >");
                    return;

                default:
                    System.out.println("잘못된 선택입니다. 다시 선택하세요");
                    System.out.println();
            }
        }
    }

    private void gameStart() {
        answer = generator.generateRandomNum(level);
        System.out.println(answer);

        System.out.println("게임을 시작합니다!");
        while (true) {

            System.out.print("숫자를 입력하세요 : ");
            String adjustNum = sc.nextLine();

            //validator가 true를 리턴하면 올바르게 수행 false라면 오류 메시지 출력
            if (validator.validateUserInput(adjustNum, level)) {
                //메서드를 통해 스트라이크와 볼 개수 반환
                int strike = countStrike(adjustNum);
                int ball = countBall(adjustNum);
                String response = display.displayResponse(strike, ball, level);
                System.out.println(response);
                System.out.println();

                map.put(key, map.get(key) + 1);

                if (response.equals("정답입니다!")) {
                    key++;
                    break;
                }
            } else {
                display.displayInvalidInputMessage();
            }
        }
    }

    private int countStrike (String adjustNum){
        int strikeCount = 0;
        for (int i = 0; i < adjustNum.length(); i++) {
            if (adjustNum.charAt(i) == answer.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    private int countBall (String adjustNum){
        int ballCount = 0;
        Loop1:
        for (int i = 0; i < adjustNum.length(); i++) {
            for (int j = 0; j < adjustNum.length(); j++) {
                if (i != j) {
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
