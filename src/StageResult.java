//strike 개수 ball 개수를 저장하는 StageResult 클래스 생성
public class StageResult {
    private final int strike;
    private final int ball;

    public StageResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
