import sys

user = sys.argv[1]
fichier = open("user.txt", "w")
fichier.write(user)
fichier.close()