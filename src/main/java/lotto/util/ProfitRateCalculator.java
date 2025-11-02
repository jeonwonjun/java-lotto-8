package lotto.util;

public class ProfitRateCalculator {
    public static double calculate(double totalPrize, double purchaseAmount) {
        return (totalPrize / purchaseAmount) * 100.0;
    }
}
