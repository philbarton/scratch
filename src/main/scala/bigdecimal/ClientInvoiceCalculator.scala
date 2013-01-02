package bigdecimal

object ClientInvoiceCalculator {

    def calculateClientInvoiceAllocationErdAmount(cia : ClientInvoice) {
        if (cia.vatOutStandingAmount >= cia.vatAmount) {
          cia.erdAmount = (cia.vatAmount / cia.exchangeRate) - (cia.vatAmount / cia.invoiceRate)
        } else {
          cia.erdAmount = BigDecimal("0")
        }
    }
}
