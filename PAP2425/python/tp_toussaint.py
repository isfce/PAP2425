def nbChiffres(n:int)->int:
    '''
    Retourne le nombre de chiffres du nombre
    '''
    assert n >= 0 ; "N doit être >=0"
    cpt = 1
    while n >= 10:
        n = n //10
        cpt = cpt + 1
    return cpt

def inverseNbr(n:int)->int:
    "Inverse les chiffres du nombre"
    assert n >= 0 ; "N doit être >=0"
    inv = 0
    while n > 0:
        inv = inv * 10 + n % 10
        n = n //10
    return inv

def convertTemp(t:float, unitI:str, unitD:str)->float:
    ''' Convertir une température de Celsius<->Fahrenheit<->Kelvin'''
    assert (unitD == 'C' or unitD == 'F' or unitD == 'K') and ((unitI == 'K' and t >= 0) or (unitI == 'C' or unitI == 'F'));"t doit être positif pour UnitI=K sinon unit doit être C F ou K"
    if unitI == unitD:
        return t
    cf = lambda x: (x * 18) / 10 + 32.0
    fc = lambda x: (x - 32.0) * 10 / 18.0
    ck = lambda x: (x * 100 + 27315) / 100.0
    kc = lambda x: (x * 100 - 27315) / 100.0
    #Convertir en Celcius
    if unitI == 'K':
        dc = kc(t)
    elif unitI == 'F':
        dc = fc(t)
    else:
        dc = t
    #UnitD
    if unitD == 'K':
        res = ck(dc)
    elif unitD == 'F':
        res = cf(dc)
    else :
        res = dc
    return res
    