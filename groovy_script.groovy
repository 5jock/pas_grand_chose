node {
    //    stage('Récupérer repo Github') {
    //    // Get some code from a GitHub repository
    //    git 'https://github.com/5jock/pas_grand_chose.git'
    //}
    
    wrap([$class: 'BuildUser']) {
        user = env.BUILD_USER_ID
    }
    
    echo "$user"
    chemin = "${env.WORKSPACE}"
    echo "$chemin"
    returnedValue = "nanana"
    echo "$returnedValue"
    
    stage('Lancer le script Python') {
        run = bat(
            returnStdout: true,
            script: 'D:\\Users\\benoit.audinet\\Documents\\Projets\\Python\\Apprentissage\\pas_grand_chose\\SaveUser.py '+"${user}"
        )
    }
    
    stage('Lancer le script .bat') {
        bat "D:/Users/benoit.audinet/Documents/Projets/Python/Apprentissage/pas_grand_chose/batch_script.bat ${chemin}"
    }
    
    stage('Afficher dans la console') {
        run = bat(
            script: "D:/Users/benoit.audinet/Documents/Projets/Python/Apprentissage/pas_grand_chose/ReadFile.py ${chemin} ${returnedValue}",
            returnStdout: true
        )
        echo "$run"
    }
}
