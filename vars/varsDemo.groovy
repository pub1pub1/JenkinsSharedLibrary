package com.abcinc;

def checkout() {
   node {
		stage('Checkout') {
      echo 'checkout'
    }
	}
}

def mvn_package() {
	node {
		stage('Package') {
      echo 'package'
    }
	}
}

def mvn_clean() {
	node {
		stage('Clean') {
      echo 'clean'
    }
	}
}

def mvn_sit() {
	node {
		stage('SIT') {
      echo 'SIT'
    }
	}
}

def archive_reports() {
	node {
		stage('Archive Reports') {
      echo 'archive reports'
    }
	}
}

def user_acceptance(job) {
	node {
		stage('UAT') {
		
		def response= input message: 'Is this build good to go?',
		 parameters: [choice(choices: 'Yes\nNo', 
		 description: '', name: 'Pass')]

		if(response=="Yes") {
		  stage('Deploy') {
        echo 'Deployed!'
		 }	
		}	
   }
	}
}