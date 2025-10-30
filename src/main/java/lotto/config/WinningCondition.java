package lotto.config;

public enum WinningCondition {
    //당첨 번호 일치 갯수, 보너스번호 일치갯수, 상금
    FIRST(6,0,2000_000_000L),
    SECOND(5,1,30_000_000L),
    THIRD(5,0,1_500_000L),
    FOURTH(4,0,50_000L),
    FIFTH(3,0,5_000L),
    NONE(0,0,0L);

    private final int matchCount;
    private final int bonusMatchCount;
    private final long prize;

    WinningCondition(int matchCount, int bonusMatchCount, long prize) {
        this.matchCount = matchCount;
        this.bonusMatchCount = bonusMatchCount;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getBonusMatchCount() {
        return bonusMatchCount;
    }

    public long getPrize() {
        return prize;
    }
    
}
