import sys

with open('repertoire_sauv\user.txt') as fichier:
    ligne = fichier.readline()
sys.argv[1] = ligne
