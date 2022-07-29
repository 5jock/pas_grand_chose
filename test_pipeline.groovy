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
    echo "$NOM_FICHIER"
    
    stage('Lancer le script Python') {
        run = bat(
            returnStdout: true,
            script: 'D:\\Users\\benoit.audinet\\Documents\\Projets\\Python\\Apprentissage\\pas_grand_chose\\SaveUser.py '+"${user}"
        )
    }
    
    stage('Lancer le script .bat') {
        //script {
        //  nomFichier = input message: 'Veillez saisir un nom de fichier : ',
        //                     parameters: [string(defaultValue: '',
        //                                  description: '',
        //                                  name: 'Nom du fichier')]
        //}
        bat "D:/Users/benoit.audinet/Documents/Projets/Python/Apprentissage/pas_grand_chose/batch_script.bat ${chemin} ${NOM_FICHIER}"
    }
    
    stage('Afficher dans la console') {
        run = bat(
            script: "D:/Users/benoit.audinet/Documents/Projets/Python/Apprentissage/pas_grand_chose/ReadFile.py ${chemin} ${returnedValue} ${NOM_FICHIER}",
            returnStdout: true
        )
        echo "$run"
    }
}
