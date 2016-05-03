package com.scala.test

import org.junit.Test
import scala.util.Random
import scala.collection.mutable.ArrayBuffer
import org.junit.Assert

class Practice01 {
  
  def signum(num : Int){
    if(num > 0) println(1)
    else if(num < 0) println(-1)
    else println(0)
  }
  
  /*
   * 编写一段代码，将a设置为一个n个随机整数的数组，要求随机数介于0和n之间。
   */
  def makeArr(n : Int) : Array[Int] = {
    val a = new Array[Int](n)
    val rand = new Random()
    for(i <- a) yield rand.nextInt(n)
  }
  
  /*
   * 编写一个循环，将整数数组中相邻的元素置换。
   */
  def revert(arr : Array[Int]) = {
    for(i <- 0 until (arr.length - 1, 2)){
      val t = arr(i)
      arr(i) = arr(i + 1)
      arr(i + 1) = t
    }
  }
  
  /*
   * 重复前一个练习，不过这次生成一个新的值交换过的数组。用for/yield。
   */
  def revertYield(arr : Array[Int]) = {
    for(i <- 0 until arr.length) yield {
      if(i < (arr.length - 1) && i % 2 == 0){
        val t = arr(i)
        arr(i) = arr(i + 1)
        arr(i + 1) = t
      }
      arr(i)
    }
  }
  
  /*
   * 给定一个整数数组，产出一个新的数组，包含元数组中的所有正值，以原有顺序排列，之后的元素是所有零或负值，以原有顺序排列。
   */
  def sigNumArr(arr : Array[Int]) = {
    val buf = new ArrayBuffer[Int]()
    buf ++= (for(i <- arr if i > 0) yield i)
    buf ++= (for(i <- arr if i == 0) yield i)
    buf ++= (for(i <- arr if i < 0) yield i)
    
    buf.toArray
  }
  
  @Test def distinctArray(){
    val a = ArrayBuffer(-1,-1,2,-3,-4,5)
    val c = ArrayBuffer[Int]()
    c ++= a.distinct
    c.foreach (println)
  }
}

object Practice01{
  def main(args: Array[String]): Unit = {
    val sign = new Practice01
    sign.signum(0)
    
    val array = sign.makeArr(9)
    for(i <- 0 until array.length){
      print(array(i) + ",")
    }
println("****************************")

    val a = Array(1,2,3,4,5,6)
    sign.revert(a)
    a.foreach(println)
println("****************************")

    val b = Array(9,8,7,6,5,4,3)
    val c = sign.revertYield(b)
    c.foreach(println)
println("****************************")

    val d = Array(1,-2,3,-4,5,-6)
    val e = sign.sigNumArr(d)
    e.foreach (println)
  }
  
  
}
