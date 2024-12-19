def estPalindrome(v:list | str)->bool:
    "vérifie si un string est un palindrome"
    pal=True
    i=0
    j=len(v)-1
    while pal and i<j:
        pal = v[i]==v[j]
        i = i + 1
        j = j - 1
    return pal

def copieInverse(v:list)->list:
    "Crée une copie de v avec les éléments inversés"
    clone = v[:]
    j = len(v)-1
    for elem in v:
        clone[j] = elem
        j=j-1
    return clone    

def rechercheBin(v:list,elem:int)->bool:
    ''' recherche binaire d'un élément
       !!! la liste doit être trié par ordre croissant'''
    d = 0
    f = len(v)-1
    trouve = False
    while not trouve and d<=f:
        m = (d + f)//2
        trouve = v[m] == elem
        if (elem < v[m]):
            f = m -1
        else:
            d = m + 1
    return trouve

def sansDoublon(v:list)->bool:
    "Indique si le vecteur possède des doublons"
    i = 0
    sd = True
    limite = len(v)-1
    while sd and i< limite:
        j = i+1
        while sd and j<len(v):
            sd = v[i] != v[j]
            j = j + 1
        i = i + 1
    return sd

def sansDoublonV2(v:list)->bool:
    if  len(v)<2 : return True
    v2 = v[:]
    v2[0] = v[0]
    n = 1
    sd = True
    i = 1
    while (sd and i < len(v)):
        elem = v[i]
        pos = rechercheBin2(v2, n, elem)
        sd = (pos == n) or (v2[pos] != elem)
        if sd:
            n = insertToPos(v2, n, pos, elem)
            i = i + 1
    return sd;

def rechercheBin2(v: list, n:int, elem:int)->int:
    d = 0
    f = n -1
    trouve = False
    m = 0
    while not trouve and d <= f:
        m = (d + f) // 2
        trouve = v[m] == elem
        if v[m] > elem:
            f = m - 1
        else:
            d = m + 1;
    return m if trouve else d

def insertToPos(v:list,n:int,pos:int,elem:int)->int:
    for i in range(n,pos,-1):
        v[i] = v[i-1]
    v[pos]=elem
    return n+1


if __name__ == "__main__":
    print(estPalindrome(['R','A','D','A','R']))
    print(estPalindrome('RADAR'))
    print(copieInverse([1,2,3]))
    l=[1,3,6,8]
    print(rechercheBin(l,8))
    print(rechercheBin(l,0))
    print(sansDoublonV2([1,2,3,4,5]))
    print(sansDoublonV2([1,5,3,4,5]))
          
          
    
    
    