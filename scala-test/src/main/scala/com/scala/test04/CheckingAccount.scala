package com.scala.test04

class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
  override def deposit(amount: Double): Double = super.deposit(amount - 1)

  override def withdraw(amount: Double): Double = super.withdraw(amount - 1)
}

object CheckingAccount {
  def main(args: Array[String]): Unit = {
    val account = new CheckingAccount(49.2)
    val d = account.deposit(0.2)
    val w = account.withdraw(0.2)
    print("d :"  + " === w " + w)
  }

}