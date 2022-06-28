node {
    wrap([$class: 'BuildUser']) {
        def user = env.BUILD_USER_ID
    }
}
node {
    def mvnHome
    stage('Récupérer repo Github') {
        // Get some code from a GitHub repository
        git 'https://github.com/5jock/pas_grand_chose.git'
    }
    stage('Lancer le script Python') {
        run = bat(
            returnStdout: true,
            script: 'python D:\\Users\\benoit.audinet\\Documents\\Projets\\Python\\Apprentissage\\pas_grand_chose\\SaveUser.py user'
        )
    }
    stage('Lancer le script .bat') {
        
    }
    stage('Afficher dans la console') {
        
    }
}
