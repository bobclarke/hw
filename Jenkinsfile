#!/bin/groovy

node(){
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
}

// This line pulls in the var and src dirs 
// These contain invoke.groovy and Handlers.groovy
@Library('plib')
import com.stack1.testlib.* // import Handlers.groovy class

// points to package.groovy
def packager = "pipeline/package/package.groovy"

// instantiate a new Handlers object
Handlers handlers = new Handlers( packager )

// Check if a SCM payload exists
print ">>> Checking for SCM payload: ${env.payload}"

// call invoke.groovy (this lives in out plib library under the vars dir
invoke( handlers )
