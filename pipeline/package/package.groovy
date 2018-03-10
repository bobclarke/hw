
def pack( String targetEnv ){

  //def applicationServerEnv = context.config.application.SERVER_ENV ?: 'production'

  node(){

    def versionNumber = env.BUILD_NUMBER
    //def packageDir = context.config.package.directory

    try {
      withEnv([
	"environment=${targetEnv}",
      ]) {
        echo "This is package.groovy"
      }
    } catch (error) {
      echo "FAILURE: Application Build failed"
      throw error
    } finally{
      step([
        //$class: 'WsCleanup', 
        //notFailBuild: true
      ])
    }
  }
}
return this;
