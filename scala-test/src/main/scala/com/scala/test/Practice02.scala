package com.scala.test

import scala.io.Source
import scala.collection.mutable.HashMap
import org.junit.Test

class Practice02 {
  /**
   * 读取文件并且统计单词个数
   */
  @Test def wordCount() = {
    val source = Source.fromFile("D:\\myfile.txt").mkString
    
    val tokens = source.split("\\s+")
    
    val map = new HashMap[String, Int]
    
    for(key <- tokens){
      map(key) = map.getOrElse(key, 0) + 1
    }
    
    println(map.mkString(","))
  }
}