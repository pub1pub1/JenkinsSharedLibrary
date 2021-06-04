package com.abcinc;

class ClassDemo implements Serializable {
  private script

  ClassDemo(Script script) {
    this.script = script
  }

  public checkout() {
    script.node() {
    script.stage('Checkout') {
      script.git 'https://github.com/pub1pub1/SimpleGreetingMaven.git'
      script.echo 'Checkout done'
    }
  }
  }

  public stage_package() {
    script.stage('Package') {
      script.echo 'Package'
    }
  }

  public stage_clean() {
    script.stage('Clean') {
      script.echo 'clean'
    }
  }

  public stage_sit() {
    script.stage('SIT') {
      script.echo 'SIT'
    }
  }

  public stage_archive_reports() {
    script.stage('Archive Reports') {
      script.echo 'Archive Reports'
    }
  }

  public stage_uat(job) {
    script.stage('UAT') {
    
    def response= script.input message: 'Is this build good to go?',
         parameters: [choice(choices: 'Yes\nNo', 
         description: '', name: 'Pass')]

    if(response=="Yes") {
        script.stage('Deploy') {
        // bat "xcopy \"C:\\Program Files (x86)\\Jenkins\\workspace\\$job\\target\\SimpleGreeting*.jar\" C:\\workspace\\dev\\ /y"
          script.echo 'Deployed!'
         }    
    }
  }
}
}