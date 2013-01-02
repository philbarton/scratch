package bigdecimal;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL32;

public class ClientInvoiceAllocationCalculator {

    public static void calculateClientInvoiceAllocationErdAmount(ClientInvoiceAllocation clientInvoiceAllocation) {
        BigDecimal vatAmount = clientInvoiceAllocation.getVatAmount();
        BigDecimal invoiceRate = clientInvoiceAllocation.getInvoiceRate();
        BigDecimal vatOutStandingAmount = clientInvoiceAllocation.getVatOutStandingAmount();
        BigDecimal exchangeRate = clientInvoiceAllocation.getExchangeRate();

        if (vatOutStandingAmount.compareTo(vatAmount) != -1) {
            clientInvoiceAllocation.setErdAmount(
                    vatAmount.divide(exchangeRate, DECIMAL32)
                            .subtract(vatAmount.divide(invoiceRate, DECIMAL32)));
        } else {
            clientInvoiceAllocation.setErdAmount(BigDecimal.ZERO);
        }
    }

}
