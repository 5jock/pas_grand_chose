//un autre pipeline doit lancer celui que tu as fait à plusieurs reprise 
pipeline {
    agent any
    stages {
//        node {
        stage ('Lancement multiple'){
            steps {
                script {
                    //- le nombre d'itération doit être demandé à l'utilisateur avant le lancement du pipeline
                    //script {
                    //    env.NB_ITERATION = input message: 'Veillez saisir le nombre de fois que devra être lancé le pipeline enfant : ',
                    //                      parameters: [string(defaultValue: '1',
                    //                                   description: '',
                    //                                   name: "Nombre d'itération")]
                    NB_ITERATION = NB_ITERATION.toInteger()
                    //}
                    
                    //- à chaque itération X, le script pause et demande le nom du fichier Y dans le lequel on doit copié le nom de l'utilisateur (ça demande une modif de ton script actuel)
                    //messagevalidation = input message: "Voici le nombre d'itération(s) pris en compte : "+"$NB_ITERATION_2",
                    //                    ok: 'Valider ?'
                                        
                    for (int i = 0; i < NB_ITERATION; i++) {
                        stage('Lancer '+ (i+1) +' fois le pipeline') {
                            //compteur = input message: 'Valeur de i : '+"$i",
                            //            ok: 'Continuer ?'
                            env.NOM_FICHIER = input message: 'Veillez saisir un nom de fichier : ',
                                         parameters: [string(defaultValue: '',
                                                      description: '',
                                                      name: 'Nom du fichier')]
                            lancementPipeline = build job: "test_pipeline",
                                                parameters: [string(name: 'NOM_FICHIER',
                                                             value: "$env.NOM_FICHIER")
                                                ]
                        }
                    }
                }
            }
        }
//        }
    }
}
//- à la fin, je doit obtenir X fichier user_Y.txt dans lequel est écrit le nom de l'utilisateur