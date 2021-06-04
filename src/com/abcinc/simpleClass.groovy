package com.abcinc

import java.text.SimpleDateFormat

class simpleClass {
 public int square(int a) {
  return a * a; 
 }

 public def sayHello(def name) {
  return "Hi, ${name}";
 }

 public def getDateTime() {
  def date = new Date()
  def sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
  return sdf.format(date);
 }
}