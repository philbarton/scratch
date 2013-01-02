package bigdecimal

import org.scalatest.{BeforeAndAfter, FunSuite}
import java.math.MathContext.DECIMAL32
import bigdecimal.ClientInvoiceAllocationCalculator._

class ClientInvoiceAllocationCalculatorTest extends FunSuite with BeforeAndAfter {
  var cia: ClientInvoiceAllocation = _

  before {
    cia = new ClientInvoiceAllocation()
    cia.setVatAmount(new java.math.BigDecimal("20", DECIMAL32))
    cia.setInvoiceRate(new java.math.BigDecimal("2.2", DECIMAL32))
    cia.setVatOutStandingAmount(new java.math.BigDecimal("200", DECIMAL32))
    cia.setExchangeRate(new java.math.BigDecimal("1.6666", DECIMAL32))
  }

  test("java CalculateClientInvoiceAllocationErdAmount") {
    calculateClientInvoiceAllocationErdAmount(cia)
    assert(cia.getErdAmount === new java.math.BigDecimal("2.909571"))
  }

  test("java CalculateClientInvoiceAllocationErdAmount VAT same") {
    cia.setVatAmount(new java.math.BigDecimal("200", DECIMAL32))
    calculateClientInvoiceAllocationErdAmount(cia)
    assert(cia.getErdAmount === new java.math.BigDecimal("29.09571"))
  }

  test("java CalculateClientInvoiceAllocationErdAmount VAT larger") {
    cia.setVatAmount(new java.math.BigDecimal("2000", DECIMAL32))
    calculateClientInvoiceAllocationErdAmount(cia)
    assert(cia.getErdAmount === java.math.BigDecimal.ZERO)
  }
}
