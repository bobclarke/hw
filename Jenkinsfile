#!/bin/groovy

node(){
	def payload

	checkout([
		$class: 'GitSCM', 
		branches: [[name: '*/master']], 
		doGenerateSubmoduleConfigurations: false, 
		extensions: [], 
		submoduleCfg: [], 
		userRemoteConfigs: [[
			credentialsId: '', 
			url: 'https://github.com/bobclarke/hw.git'
		]]
	])

	// Check if a SCM payload exists
	print ">>> Checking for SCM payload: ${env.payload}"
	if( env.payload == null ){
		println "No SCM payload detected. Assuming this is a test run and using default parameters"
	} else {
		this.payload = env.payload
	}
}

// This line pulls in the var and src dirs 
// These contain invoke.groovy and Handlers.groovy
@Library('plib')
import com.stack1.testlib.* // import Handlers.groovy class

// points to package.groovy
def packager = "pipeline/package/package.groovy"

// instantiate a new Handlers object
Handlers handlers = new Handlers( packager )


// call invoke.groovy (this lives in out plib library under the vars dir
invoke( handlers )
