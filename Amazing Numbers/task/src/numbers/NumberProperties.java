package numbers;

import java.util.List;
import java.util.Objects;

public class NumberProperties {
    private long number;
    private List<Long> figures;

    public NumberProperties(long number) {
        this.number = number;
        this.figures = Service.getFiguresFromNumber(number);
    }
    public boolean isEven() {
        return number % 2 == 0;
    }
    public boolean isBuzz() {
        boolean isLastDigitSeven = number % 10 == 7;
        boolean isDevisibleBySeven = number % 7 == 0;
        return isLastDigitSeven || isDevisibleBySeven;
    }
    public boolean isDuck() {
        return figures.contains(0L);
    }
    public boolean isPalindromic() {
        boolean isPalindromic = true;
        for (int i = 0; i < figures.size() / 2; i++) {
            if (!Objects.equals(figures.get(i), figures.get(figures.size() - i - 1))) {
                isPalindromic = false;
                break;
            }
        }
        return isPalindromic;
    }
    public boolean isGapful() {
        boolean moreThanTwo = figures.size() > 2;
        boolean specialDivisible =  number % (figures.get(0) * 10 + figures.get(figures.size() - 1)) == 0;
        return moreThanTwo && specialDivisible;
    }
    public boolean isSpy() {
        long sumFigures = 0L;
        long productFigures = 1L;
        for (Long figure : figures) {
            sumFigures += figure;
            productFigures *= figure;
        }
        return sumFigures == productFigures;
    }
    public boolean isSquare() {
        return Math.sqrt(number) % 1 == 0;
    }
    public boolean isSunny() {
        return Math.sqrt(number + 1) % 1 == 0;
    }

    public boolean isJumping() {
        boolean result = true;
        for (int i = 0; i < figures.size() - 1; i++) {
            if (Math.abs(figures.get(i) - figures.get(i+1)) != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
