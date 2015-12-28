package Chapter8

class SavingsAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  private val interest = 1.0
  private val commissionValue = 1.0

  private var monthlyOperations = 0

  private def applyCommission() = balance -= commissionValue

  def earnMonthlyInterest() = {
    balance += (balance / 100) * interest
    monthlyOperations = 0
  }

  override def deposit(amount: Double) = {
    if (monthlyOperations >= 3) {
      applyCommission()
    }
    monthlyOperations += 1

    super.deposit(amount)
  }

  override def withdraw(amount: Double) = {
    if (monthlyOperations >= 3) {
      applyCommission()
    }
    monthlyOperations += 1

    super.withdraw(amount)
  }
}
