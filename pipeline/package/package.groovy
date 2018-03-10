def pack( String targetEnv ){
	node(){
   		echo "This is package.groovy"
		checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/bobclarke/hw.git']]])
    }
}
return this;
