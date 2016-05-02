package com.scala.test01

import scala.collection.mutable.ArrayBuffer

object TrimNegativeNum {
  def trimNegative(a : ArrayBuffer[Int]) : ArrayBuffer[Int] = {
    var first = true
    val indexes = for (i <- 0 until a.length if first || a(i) >= 0) yield {
      if (a(i) < 0) first = false; i
    }
    
    for(j <- 0 until indexes.length) a(j) = a(indexes(j))
    a.trimEnd(a.length - indexes.length)
    a    
  }
  
  def main(args: Array[String]): Unit = {
    val b = ArrayBuffer[Int]()
    b += (1,4,-2,-5,4,-6)
    println(TrimNegativeNum.trimNegative(b))
  }
}