package bigdecimal;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static bigdecimal.ClientInvoiceAllocationCalculator.calculateClientInvoiceAllocationErdAmount;
import static java.math.MathContext.DECIMAL32;
import static org.junit.Assert.assertTrue;

public class ClientInvoiceAllocationCalculatorJunitTest {

    private ClientInvoiceAllocation cia;

    @Before
    public void setUp() throws Exception {
        System.out.println("ClientInvoiceAllocationCalculatorJunitTest");
        cia = new ClientInvoiceAllocation();
        cia.setVatAmount(new BigDecimal("20", DECIMAL32));
        cia.setInvoiceRate(new BigDecimal("2.2", DECIMAL32));
        cia.setVatOutStandingAmount(new BigDecimal("200", DECIMAL32));
        cia.setExchangeRate(new BigDecimal("1.6666", DECIMAL32));
    }

    @Test
    public void testCalculateClientInvoiceAllocationErdAmount() throws Exception {
        calculateClientInvoiceAllocationErdAmount(cia);
        assertTrue(cia.getErdAmount().compareTo(new BigDecimal("2.909571")) == 0);
    }

    @Test
    public void testCalculateClientInvoiceAllocationErdAmountVATLarger() throws Exception {
        cia.setVatAmount(new BigDecimal("2000"));
        calculateClientInvoiceAllocationErdAmount(cia);
        assertTrue(cia.getErdAmount().compareTo(BigDecimal.ZERO) == 0);
    }

    @Test
    public void testCalculateClientInvoiceAllocationErdAmountVATSame() throws Exception {
        cia.setVatAmount(new BigDecimal("200", DECIMAL32));
        calculateClientInvoiceAllocationErdAmount(cia);
        assertTrue(cia.getErdAmount().compareTo(new BigDecimal("29.09571")) == 0);
    }
}
