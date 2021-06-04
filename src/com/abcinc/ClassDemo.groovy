package com.abcinc;

class ClassDemo implements Serializable {
  private script

  ClassDemo(Script script) {
    this.script = script
  }

  public stage_checkout() {
    script.node() {
    script.stage('Checkout') {
      script.git ''
      script.echo 'Checkout done'
    }
  }

  // public stage_package() {
  //   script.stage('Package') {
  //     script.stage_package()
  //   }
  // }

  // public stage_clean() {
  //   script.stage('Clean') {
  //     script.stage_clean()
  //   }
  // }

  // public stage_sit() {
  //   script.stage('SIT') {
  //     script.stage_sit()
  //   }
  // }

  // public stage_archive_reports() {
  //   script.stage('Archive Reports') {
  //     script.stage_archive_reports()
  //   }
  // }

  // public stage_uat(job) {
  //   script.stage('UAT') {
  //     script.stage_uat()
  //   }
  // }
}