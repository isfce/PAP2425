def calculDecision(note : float)->str:
    ''' calcule la décision sur base de la note
        note sera un nombre entier ou float
    '''
    assert 0<=note<=100 , "La note doit être entre 0 et 100"
    if note<30:
        res = "Refus"
    elif note<50:
        res = "Ajourné"
    else:
        res= "Réussite"
    return res

if __name__ == "__main__":
    #Input
    n = float(input("Entrez une note: "))
    #Traitement
    r = calculDecision(n)
    #Output
    print(f"La note de {n} donne une décision de {r}")
