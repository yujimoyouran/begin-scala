package com.scala.test01

import scala.io.Source

object ReadFile {
  
  def widthOfLength(s: String) = s.length.toString.length
  
  def readFileByLine(args: Array[String]) : Unit = {
    if(args.length > 0) {
      val lines = Source.fromFile(args(0)).getLines().toList
      
      val longestLine = lines.reduceLeft(
        (a, b) => if (a.length > b.length) a else b    
      )

      val maxWidth = widthOfLength(longestLine)
      
      for(line <- lines){
        val numSpace = maxWidth - widthOfLength(line)
        val padding = ' ' * numSpace
        println(padding + line.length + " | " + line)
      }
    }
  }
  
  def main(args: Array[String]): Unit = {
    val array = Array("D:\\work\\scalaspace\\scala-test\\src\\main\\scala\\com\\scala\\test01\\ReadFile.scala")
    readFileByLine(array);
  }
}