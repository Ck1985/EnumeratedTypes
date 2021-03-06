package enumerate;

import static enumerate.OutCome.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum RoShamBo2 implements Competitor<RoShamBo2> {
    PAPER(DRAW,LOSE,WIN),
    SCISSORS(WIN,DRAW,LOSE),
    ROCK(LOSE,WIN,DRAW);
    private OutCome vPAPER, vSCISSORS, vROCK;
    RoShamBo2(OutCome paper, OutCome scissors, OutCome rock) {
        this.vPAPER = paper;
        this.vSCISSORS = scissors;
        this.vROCK = rock;
    }
    public OutCome compete(RoShamBo2 it) {
        switch (it) {
            default:
            case PAPER:
                return vPAPER;
            case SCISSORS:
                return vSCISSORS;
            case ROCK:
                return vROCK;
        }
    }
    public static void main(String[] args) {
        RoShamBo.play(RoShamBo2.class, 20);
    }
}
