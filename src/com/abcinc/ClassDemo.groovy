package com.abcinc;

class ClassDemo {

public checkout() {
   node {
		stage('Checkout') {
      echo 'checkout'
    }
	}
}

public mvn_package() {
	node {
		stage('Package') {
      echo 'package'
    }
	}
}

public mvn_clean() {
	node {
		stage('Clean') {
      echo 'clean'
    }
	}
}

public mvn_sit() {
	node {
		stage('SIT') {
      echo 'SIT'
    }
	}
}

public archive_reports() {
	node {
		stage('Archive Reports') {
      echo 'archive reports'
    }
	}
}

public user_acceptance(job) {
	node {
		stage('UAT') {
		
		public response= input message: 'Is this build good to go?',
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
}