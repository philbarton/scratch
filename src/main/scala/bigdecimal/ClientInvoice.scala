package bigdecimal

class ClientInvoice(var vatAmount: BigDecimal,
                    var invoiceRate: BigDecimal,
                    var vatOutStandingAmount: BigDecimal,
                    var exchangeRate: BigDecimal) {
  // statement run during construction
  printf("Creating ClientInvoice %s\n", this)
  // creates getter and setter
  var erdAmount: BigDecimal = _  // _ means default initializer
}
