package com.abcinc;

def stage_checkout() {
   node {
        stage('Checkout') {
      echo 'checkout'
    }
    }
}

def stage_package() {
    node {
        stage('Package') {
      echo 'package'
    }
    }
}

def stage_clean() {
    node {
        stage('Clean') {
      echo 'clean'
    }
    }
}

def stage_sit() {
    node {
        stage('SIT') {
      echo 'SIT'
    }
    }
}

def stage_archive_reports() {
    node {
        stage('Archive Reports') {
      echo 'archive reports'
    }
    }
}

def stage_uat(job) {
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