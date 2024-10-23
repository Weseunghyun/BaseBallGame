import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Scanner;

//게임을 시작! 게임 과정이 올바르게 진행되는지 확인, 종료
public class BaseballGame {

    private String answer;
    private final BaseballGameDisplay display;
    private final RandomNumGenerator generator;
    private final UserInputValidator validator;
    private final Scanner sc;
    private LinkedHashMap<Integer, Integer> recordMap = new LinkedHashMap<>();
    private static int stage = 1;
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
            int choice = 1;
            try {
                choice = sc.nextInt();
                sc.nextLine();
            }catch (InputMismatchException e){
                System.out.println("0~3까지의 숫자만 입력해주세요");
                sc.next();
                continue;
            }

            switch (choice) {
                case 0:
                    try {
                        System.out.println("설정하고자 하는 자리수를 입력하세요 (3~5)");
                        level = sc.nextInt();
                        display.levelSelect(level);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                        continue;
                    }

                case 1:
                    //게임 기록용 map을 각 스테이지마다 초기화해줌
                    recordMap.put(stage, 0);
                    gameStart();
                    break;
                case 2:
                    display.recordDisplay(recordMap);
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
       for(int tryCount=0 ; ; tryCount++) {

            System.out.print("숫자를 입력하세요 : ");
            String adjustNum = sc.nextLine();

            //validator가 true를 리턴하면 올바르게 수행 false라면 오류 메시지 출력
            if (validator.validateUserInput(adjustNum, level)) {
                //메서드를 통해 스트라이크와 볼 개수 반환
                StageResult result = getResult(adjustNum);
                String response = display.returnResponse(result, level);
                System.out.println(response);
                System.out.println();

                if (response.equals("정답입니다!")) {
                    //시도 횟수가 0부터니까 1을 더하여 해당 스테이지의 value 값으로 넣어줌
                    recordMap.put(stage, tryCount+1);
                    //다음 스테이지 진행을 위해 stage값을 1 늘림.
                    stage++;
                    break;
                }
            } else {
                display.displayInvalidInputMessage();
                //이상한 값을 입력받은 경우에는 시도횟수를 늘리지않는다.
                tryCount--;
            }
        }
    }

    //adjustNum 즉 입력받은 값을 통해 정답과 비교하며 StageResult 객체에 결과를 넣고 생성.
    private StageResult getResult(String adjustNum) {
        int strikeCount = 0;
        int ballCount = 0;
        for (int i=0; i<adjustNum.length(); i++) {
            char num = adjustNum.charAt(i);
            if (num == answer.charAt(i)){
                strikeCount++;
            }else if(answer.contains(String.valueOf(num))){
                ballCount++;
            }
        }

        return new StageResult(strikeCount,ballCount);
    }
}
