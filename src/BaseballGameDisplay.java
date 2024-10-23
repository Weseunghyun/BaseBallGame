import java.util.LinkedHashMap;
import java.util.Map;

//게임과 관련된 display를 출력하거나 사용자 입력의 응답값을 리턴해주는 클래스
public class BaseballGameDisplay {
    //게임 시작 코멘트
    public void startComment(){
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요!");
        System.out.println("0. 자리수 설정 1. 게임 시작하기 2. 게임 기록 보기 3. 종료하기");
    }

    public void levelSelect(int level) throws Exception {
        String levelString = String.valueOf(level);
        if(!levelString.matches("^[3-5]$")){
            throw new Exception("3,4,5 만 입력가능합니다.");
        }
        System.out.println(level + "자리수 난이도로 설정되었습니다.");
        System.out.println();
    }

    //사용자 입력과 랜덤 정수와의 비교값을 통해 응답 문자열을 return 함.
    public String returnResponse(StageResult result, int level) {
        int strikeCount = result.getStrike();
        int ballCount = result.getBall();

        if (strikeCount + ballCount == 0){
            return  "아웃";
        } else if (strikeCount == level){
            return "정답입니다!";
        } else if (strikeCount >=1 && ballCount == 0){
            return strikeCount+"스트라이크";
        } else if (strikeCount ==0 && ballCount >= 0) {
            return ballCount + "볼";
        }else{
            return strikeCount + "스트라이크 " + ballCount + "볼";
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
