import sys


def renvoi_user(a, b):
    with open(a+'\\repertoire_sauv\\user_'+b+'.txt') as fichier:
        ligne = fichier.readline()
    return ligne


sys.argv[2] = renvoi_user(sys.argv[1], sys.argv[3])
print(sys.argv[2])