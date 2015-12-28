package Chapter08

class BankAccount(initialBalance: Double) {
  protected var balance = initialBalance

  def currentBalance = balance

  def deposit(amount: Double) = {
    balance += amount
    balance
  }

  def withdraw(amount: Double) = {
    balance -= amount
    balance
  }
}

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {

  private val commissionValue = 1.0

  private def applyCommission() = balance -= commissionValue

  override def deposit(amount: Double) = {
    applyCommission()
    super.deposit(amount)
  }

  override def withdraw(amount: Double) = {
    applyCommission()
    super.withdraw(amount)
  }
}