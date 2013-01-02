package bigdecimal;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL32;

public class ClientInvoiceAllocationCalculator {

    public static void calculateClientInvoiceAllocationErdAmount(ClientInvoiceAllocation cia) {
        BigDecimal vatAmount = cia.getVatAmount();
        BigDecimal invoiceRate = cia.getInvoiceRate();
        BigDecimal vatOutStandingAmount = cia.getVatOutStandingAmount();
        BigDecimal exchangeRate = cia.getExchangeRate();

        if (vatOutStandingAmount.compareTo(vatAmount) != -1) {
            cia.setErdAmount(
                    vatAmount.divide(exchangeRate, DECIMAL32)
                            .subtract(vatAmount.divide(invoiceRate, DECIMAL32)));
        } else {
            cia.setErdAmount(BigDecimal.ZERO);
        }
    }

}
