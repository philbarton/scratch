package bigdecimal;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL32;

public class ClientInvoiceAllocationCalculator {

    public static void calculateClientInvoiceAllocationErdAmount(ClientInvoiceAllocation cia) {

        if (cia.getVatOutStandingAmount().compareTo(cia.getVatAmount()) != -1) {
            cia.setErdAmount(
                    cia.getVatAmount().divide(cia.getExchangeRate(), DECIMAL32)
                            .subtract(cia.getVatAmount().divide(cia.getInvoiceRate(), DECIMAL32)));
        } else {
            cia.setErdAmount(BigDecimal.ZERO);
        }
    }

}
