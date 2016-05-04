package com.scala.test04

class BankAccount(initialBalance: Double) {
  private var balance = initialBalance

  def deposit(amount: Double) = { balance += amount; balance }

  def withdraw(amount: Double) = { balance -= amount; balance }
}

object BankAccount {
  def main(args: Array[String]): Unit = {
    val account = new BankAccount(0.9)
//    println(account.deposit(9))
    println(account.withdraw(9))
  }
}