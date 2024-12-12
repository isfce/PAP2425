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

if __name__ == "__main__":
    print(estPalindrome(['R','A','D','A','R']))
    print(estPalindrome('RADAR'))
    print(copieInverse([1,2,3]))
    l=[1,3,6,8]
    print(rechercheBin(l,8))
    print(rechercheBin(l,0))
    
    
    