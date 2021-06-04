package com.abcinc;

mvnHome = null

def configTools() {
  mvnHome = tool 'maven_default'
  return mvnHome  
}

def checkout() {
   node {
		stage('Checkout') {
      git url: 'https://github.com/pub1pub1/SimpleGreetingMaven.git'
    }
	}
}

def mvn_install() {
	node {
		stage('Install') {
      if(isUnix()) {
        sh '"$mvnHome/bin/mvn" install'
      } else {
        bat '"$mvnHome/bin/mvn" install'
      }
    }
	}
}

def mvn_clean() {
	node {
		stage('Clean') {
      if(isUnix()) {
        sh '"$mvnHome/bin/mvn" clean'
      } else {
        bat '"$mvnHome/bin/mvn" clean'
      }
    }
	}
}

def mvn_verify() {
	node {
		stage('Verify') {
      if(isUnix()) {
        sh '"$mvnHome/bin/mvn" verify'
      } else {
        bat '"$mvnHome/bin/mvn" verify'
      }
    }
	}
}

def archive_reports() {
	node {
		stage('Archive Reports') {
      step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
    }
	}
}

def user_acceptance(job) {
	node {
		stage('User Acceptance Test') {
		
		def response= input message: 'Is this build good to go?',
		 parameters: [choice(choices: 'Yes\nNo', 
		 description: '', name: 'Pass')]

		if(response=="Yes") {
		  stage('Deploy') {
        // bat "xcopy \"C:\\Program Files (x86)\\Jenkins\\workspace\\$job\\target\\SimpleGreeting*.jar\" C:\\workspace\\dev\\ /y"
        echo 'Deployed!'
		 }	
		}	
   }
	}
}