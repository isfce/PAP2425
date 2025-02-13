
def rechercheMin(m):
    mini = m[0][0]
    for v in m:
        for elem in v:
            mini = min(mini,elem)
    return mini

def existeInMat(m,valeur):
    trouve = False
    i = 0
    while not trouve and i < len(m):
        j = 0
        while not trouve and j< len(m[i]):
            trouve =  m[i][j] == valeur
            j = j + 1
        i = i + 1
    return trouve

def estSymetrique(m):
    " m est une matrice n*n"
    sym = True
    i = 1
    while sym and i<len(m):
        j = 0
        while sym and j <i:
            sym = m[i][j] == m[j][i]
            j++
        i++
    return sym 
        
if __name__ == "__main__":
    m1 = [[1,2,7],[6,4,-5]]
    print(existeInMat(m1,4))
    print(existeInMat(m1,40))
    print(f'min de m1: {rechercheMin(m1)}')