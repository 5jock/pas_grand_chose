import sys


def renvoi_user(a):
    with open(a+'\\repertoire_sauv\\user.txt') as fichier:
        ligne = fichier.readline()
    return ligne


sys.argv[2] = renvoi_user(sys.argv[1])
print(sys.argv[2])