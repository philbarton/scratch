package bigdecimal

import org.scalatest.{BeforeAndAfter, FunSuite}
import java.math.MathContext.DECIMAL32
import ClientInvoiceCalculator._

class ClientInvoiceCalculatorTest extends FunSuite with BeforeAndAfter {
  var ci: ClientInvoice = _

  before {
    ci = new ClientInvoice(
      vatAmount = BigDecimal("20", DECIMAL32),
      invoiceRate = BigDecimal("2.2", DECIMAL32),
      vatOutStandingAmount = BigDecimal("200", DECIMAL32),
      exchangeRate = BigDecimal("1.6666", DECIMAL32)
    )
  }

  test("CalculateClientInvoiceAllocationErdAmount") {
    calculateClientInvoiceAllocationErdAmount( ci)
    assert(ci.erdAmount === BigDecimal("2.909571"))
  }

  test("CalculateClientInvoiceAllocationErdAmount VAT same") {
    ci.vatAmount = BigDecimal("200", DECIMAL32)
    calculateClientInvoiceAllocationErdAmount( ci)
    assert(ci.erdAmount === BigDecimal("29.09571"))
  }

  test("CalculateClientInvoiceAllocationErdAmount VAT larger") {
    ci.vatAmount = BigDecimal("2000", DECIMAL32)
    calculateClientInvoiceAllocationErdAmount(ci)
    assert(ci.erdAmount === BigDecimal("0"))
  }
}
