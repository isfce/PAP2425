def triBulle(v:list):
    'Tri à bulles classique'
    d = len(v)-1
    while d > 0:
        fin = d
        d = 0
        for i in range(fin):
            if v[i] > v[i+1]:
                v[i],v[i+1] = v[i+1], v[i]
                d = i
            
if __name__ == "__main__":
    l1 = [6,2,9,1]
    triBulle(l1)
    print(l1)