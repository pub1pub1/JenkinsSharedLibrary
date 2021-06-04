package com.abcinc;

def checkout() {
   node {
		stage('Checkout') {
      git url: 'https://github.com/pub1pub1/SimpleGreetingMaven.git'
    }
	}
}

def mvn_install() {
	node {
		stage('Package') {
      mvnHome = tool 'maven_default'
      echo $mvnHome
      echo mvnHome
      withEnv(["MVN_HOME=$mvnHome"]) {
        echo $MVN_HOME
          sh '"$mvnHome/bin/mvn" package'
      }
    }
	}
}

def mvn_clean() {
	node {
		stage('Clean') {
      mvnHome = tool 'maven_default'
      withEnv(["MVN_HOME=$mvnHome"]) {
          sh '"$mvnHome/bin/mvn" clean'
      }
    }
	}
}

def mvn_verify() {
	node {
		stage('Verify') {
      mvnHome = tool 'maven_default'
      withEnv(["MVN_HOME=$mvnHome"]) {
          sh '"$mvnHome/bin/mvn" verify'
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