import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HomeWorkOneExternalVariables {
    public static void main(String[] args) {

        Loan loan1 = new Loan();
        loan1.loanReqAmount = new BigDecimal("15000.00");
        loan1.manualTotalAmount = new BigDecimal("11000.00");
        loan1.loanCount();
    }

}

    class Loan{
        BigDecimal loanReqAmount;
        BigDecimal manualTotalAmount;
        @Test
        void loanCount() {
            BigDecimal dividerMonth = new BigDecimal("360");
            BigDecimal multiFirstMonth = new BigDecimal("0.1");
            BigDecimal multiSecondMonth = new BigDecimal("0.08");
            BigDecimal multiThirdMonth = new BigDecimal("0.06");
            BigDecimal multiFirstTenYears = new BigDecimal("120.00");
            BigDecimal multiSecondTenYears = new BigDecimal("240.00");
            BigDecimal bigDecimalRound = new BigDecimal("1");

// noPercentMonthlyPay - represent a monthly payment without tax ( Requested Loan Amount / 30 / 12 )
            BigDecimal noPercentMonthlyPay = loanReqAmount.divide(dividerMonth,10, RoundingMode.HALF_UP);

// percentPerFirstTenYear - represent percent for the first 10 years
            BigDecimal percentPerFirstTenYear = loanReqAmount.multiply(multiFirstMonth);

// totalPayedForFirstTenYears - without tax ( 10 * 12 * noPercentMonthlyPay )
            BigDecimal totalPayedForFirstTenYears = multiFirstTenYears.multiply(noPercentMonthlyPay);

// totalPayedForSecondTenYears - without tax ( 20 * 12 * noPercentMonthlyPay )
            BigDecimal totalPayedForSecondTenYears = multiSecondTenYears.multiply(noPercentMonthlyPay);



// percentPerSecondTenYears - represent percent for the second 10 years
            BigDecimal totalLeftAfterFirstTenYears = loanReqAmount.subtract(totalPayedForFirstTenYears);
            BigDecimal percentPerSecondTenYears = ( multiSecondMonth.multiply(totalLeftAfterFirstTenYears));

// percentPerThirdTenYears - represent percent for the third 10 years
            BigDecimal totalLeftAfterSecondTenYears = loanReqAmount.subtract(totalPayedForSecondTenYears);
            BigDecimal percentPerThirdTenYears = ( multiThirdMonth.multiply(totalLeftAfterSecondTenYears));


            BigDecimal automaticTotalAmount = loanReqAmount.add(percentPerFirstTenYear);
            automaticTotalAmount = automaticTotalAmount.add(percentPerSecondTenYears);
            automaticTotalAmount = automaticTotalAmount.add(percentPerThirdTenYears);
// scale was set as 2 since currency usually is represented by mask (x.yy)
            automaticTotalAmount = automaticTotalAmount.divide(bigDecimalRound,2,RoundingMode.HALF_UP);


            System.out.println("Automatically calculated total amount " + automaticTotalAmount);
            System.out.println("Manually calculated total amount " + manualTotalAmount);
            Assertions.assertEquals( automaticTotalAmount, manualTotalAmount, "Sum is not correct");
    }
}
