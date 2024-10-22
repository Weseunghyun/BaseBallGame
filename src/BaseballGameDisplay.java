import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//오로지 출력하는 역할
public class BaseballGameDisplay {
    Scanner sc = new Scanner(System.in);
    //게임 시작 코멘트
    public void startComment(){
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요!");
        System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
    }

    public int levelSelect(){
        System.out.println("설정하고자 하는 자리수를 입력하세요 (3~5)");
        int level =  sc.nextInt();
        System.out.println(level + "자리수 난이도로 설정되었습니다.");
        return level;
    }

    //사용자 입력과 랜덤 정수와의 비교값을 통해 응답 문자열을 return 함.
    public String displayResponse(int strike, int ball, int level) {

        if (strike + ball == 0){
            return  "아웃";
        } else if (strike == level){
            return "정답입니다!";
        } else if (strike >=1 && ball == 0){
            return strike+"스트라이크";
        } else if (strike ==0 && ball >= 0) {
            return ball + "볼";
        }else{
            return strike + "스트라이크 " + ball + "볼";
        }
    }

    //올바르지않은 입력값을 입력받았을 때 호출되는 메서드
    public void displayInvalidInputMessage(){
        System.out.println("올바르지 않은 입력값입니다.");
        System.out.println();
    }

    //게임 기록을 출력해주는 메서드
    public void recordDisplay(LinkedHashMap<Integer,Integer> map){
        if (map.isEmpty()){
            System.out.println("게임을 진행해주세요! 기록이 존재하지 않습니다!");
            System.out.println();
            return;
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + "번째 게임 : " + "시도 횟수 - " +entry.getValue());
        }
        System.out.println();
    }
}
