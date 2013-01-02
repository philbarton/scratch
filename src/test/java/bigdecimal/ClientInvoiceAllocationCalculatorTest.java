package bigdecimal;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static bigdecimal.ClientInvoiceAllocationCalculator.calculateClientInvoiceAllocationErdAmount;
import static org.junit.Assert.assertTrue;

public class ClientInvoiceAllocationCalculatorTest {

    private ClientInvoiceAllocation cia;

    @Before
    public void setUp() throws Exception {
        cia = new ClientInvoiceAllocation();
        cia.setVatAmount(new BigDecimal("20"));
        cia.setInvoiceRate(new BigDecimal("2.2"));
        cia.setVatOutStandingAmount(new BigDecimal("200"));
        cia.setExchangeRate(new BigDecimal("1.6666"));
    }

    @Test
    public void testCalculateClientInvoiceAllocationErdAmount1() throws Exception {
        calculateClientInvoiceAllocationErdAmount(cia);
        assertTrue(cia.getErdAmount().compareTo(new BigDecimal("2.909571")) == 0);
    }

    @Test
    public void testCalculateClientInvoiceAllocationErdAmount2() throws Exception {
        cia.setVatAmount(new BigDecimal("2000"));
        calculateClientInvoiceAllocationErdAmount(cia);
        assertTrue(cia.getErdAmount().compareTo(BigDecimal.ZERO) == 0);
    }
}
