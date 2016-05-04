package com.scala.test04

class SavingsAccount(initialBalance : Double) extends BankAccount(initialBalance){
  private var num : Int = _
  
  def earnMonthlyInterest() = {
    println(num)
    num = 3
    super.deposit(1)
  }
  
  override def deposit(amount : Double) : Double ={
    num -= 1
    if(num < 0) super.deposit(amount - 1) else super.deposit(amount)
  }
  
  override def withdraw(amount : Double) : Double ={
    num -= 1
    if(num > 0) super.withdraw(amount + 1) else super.withdraw(amount)
  }
}

object SavingsAccount{
  def main(args: Array[String]): Unit = {
    val account = new SavingsAccount(49.2)
    
    account.earnMonthlyInterest();
    
    println(account.deposit(0.8))
    println(account.withdraw(0.8))
  }
}