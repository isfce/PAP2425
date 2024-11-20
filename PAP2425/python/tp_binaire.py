def nbBytesUtf8(c:str)->int:
    '''Indique le nombre de bytes nécessaires
        pour coder le caractère unicode en utf8'''
    n = ord(c)
    if n<128: return 1
    if n<2048: return 2
    return 3


def estMajuscule(c:str)->bool:
    "indique si une lettre est une majuscule "
    assert c.isalpha(); "il faut une lettre"
    return (ord(c) & 32)==0

if __name__=="__main__":
    print('B est une majuscule: ',estMajuscule('B'))
    print('t est une majuscule: ',estMajuscule('t'))
    