import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomeWorkOne {

    @Test

    public void loanCount() {
        double loanReqAmount = 10000;
        double manualTotalAmount = 11733.333333333334;
        double noPercentMonthlyPay = loanReqAmount / 12 / 30;
        double percentPerFirstTenYear = loanReqAmount * 0.10;
        double percentPerSecondTenYears = ( 0.08 * ( loanReqAmount - ( 10 * 12 * noPercentMonthlyPay ) ) );
        double percentPerThirdTenYears = ( 0.06 * ( loanReqAmount - ( 20 * 12 * noPercentMonthlyPay ) ) );
        double automaticTotalAmount = loanReqAmount + percentPerFirstTenYear + percentPerSecondTenYears + percentPerThirdTenYears;
        System.out.println("Automatically calculated total amount " + automaticTotalAmount);
        System.out.println("Manually calculated total amount " + manualTotalAmount);
        Assertions.assertEquals( automaticTotalAmount, manualTotalAmount, "Sum is not correct");

    }



}