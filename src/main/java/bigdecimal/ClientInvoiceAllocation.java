package bigdecimal;

import java.math.BigDecimal;

public class ClientInvoiceAllocation {
    private BigDecimal vatAmount;
    private BigDecimal invoiceRate;
    private BigDecimal vatOutStandingAmount;
    private BigDecimal exchangeRate;
    private BigDecimal erdAmount;

    public BigDecimal getVatAmount() {
        return vatAmount;
    }

    public void setVatAmount(BigDecimal vatAmount) {
        this.vatAmount = vatAmount;
    }

    public BigDecimal getInvoiceRate() {
        return invoiceRate;
    }

    public void setInvoiceRate(BigDecimal invoiceRate) {
        this.invoiceRate = invoiceRate;
    }

    public BigDecimal getVatOutStandingAmount() {
        return vatOutStandingAmount;
    }

    public void setVatOutStandingAmount(BigDecimal vatOutStandingAmount) {
        this.vatOutStandingAmount = vatOutStandingAmount;
    }

    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(BigDecimal exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public void setErdAmount(BigDecimal erdAmount) {
        this.erdAmount = erdAmount;
    }

    public BigDecimal getErdAmount() {
        return erdAmount;
    }
}
