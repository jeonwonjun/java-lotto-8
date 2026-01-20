package lotto.config;

public enum RankInfo {
    FIFTH(3,"3개 일치 (5,000원) - %d개", 5_000),
    FOURTH(4, "4개 일치 (50,000원) - %d개", 50_000),
    THIRD(5, "5개 일치 (1,500,000원) - %d개", 1_500_000),
    SECOND(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30_000_000),
    FIRST(6, "6개 일치 (2,000,000,000원) - %d개", 2_000_000_000);

    private final int count;
    private final String format;
    private final int prize;

    RankInfo(int count, String format, int prize) {
        this.count = count;
        this.format = format;
        this.prize = prize;
    }

    public int getCount() {
        return count;
    }
    public String getFormat() {
        return format;
    }

    public int getPrize() {
        return prize;
    }
}
