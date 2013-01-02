package bigdecimal

import java.math.MathContext._

class ClientInvoice(var vatAmount: BigDecimal,
                    var invoiceRate: BigDecimal,
                    var vatOutStandingAmount: BigDecimal,
                    var exchangeRate: BigDecimal) {
  // statement run during construction
  printf("Creating ClientInvoice %s\n", this)
  // creates getter and setter
  var erdAmount: BigDecimal = _ // _ means default initializer
}

object ClientInvoice {
  // default invoice rate
  def apply(vatAmount: BigDecimal,
            vatOutStandingAmount: BigDecimal,
            exchangeRate: BigDecimal): ClientInvoice = {
    new ClientInvoice(vatAmount, BigDecimal("2.2", DECIMAL32), vatOutStandingAmount, exchangeRate)
  }
}
