import sys

with open(sys.argv[2]+'\\repertoire_sauv\\user.txt') as fichier:
    ligne = fichier.readline()
sys.argv[1] = ligne
