package com.scala.test04

import scala.collection.mutable.ArrayBuffer


abstract class Item {
  def price() : Double
  
  def description() : String
  
  override def toString() : String = {
    "description:" + description() + " price:" + price() 
  }
}

class SimpleItem(val price: Double, val description : String) extends Item {
}

class Bundle extends Item{
  val items = new ArrayBuffer[Item]()
  
  def addItem(item : Item){
    items += item
  }
  
  def price() : Double ={
    var total = 0d
    items.foreach(total += _.price())
    total
  }
  
  def description() : String = {
    items.mkString(" ")
  }
}