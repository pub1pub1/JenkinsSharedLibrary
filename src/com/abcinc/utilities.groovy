package com.abcinc;

class utilities implements Serializable {
 def checkout() {
   //stage 'Checkout'
   //git url: 'C:\\Software\\repos\\SimpleGreeting.git'
 }
 
 def mvn() {
    node {
		bat 'mvn install'
	}
	//steps "${steps.tool 'Maven'}mvn install"
 }
}