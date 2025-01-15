class Stack:
    def __init__(self,initTaille:int):
        self.__sommet = 0
        self.__v= initTaille *[None]
        #print(f'Taille de v: {len(self.__v)}')
    
    def push(self,elem):
        if self.__sommet == len(self.__v):
            self.__v.append(elem)
        else:
            self.__v[self.__sommet]=elem
        self.__sommet = self.__sommet + 1
     
    def pop(self):
        assert not self.empty(),'Le stack est vide!!!'
        self.__sommet = self.__sommet - 1
        elem = self.__v[self.__sommet]
        self.__v[self.__sommet] = None
        return elem
    
    def top(self):
        assert not self.empty(),'Le stack est vide!!!'
        return self.__v[self.__sommet-1]
    
    def empty(self):
        return self.__sommet == 0
    
if __name__ == '__main__':
    s1 = Stack(3)
    s1.push(5)
    s1.push(7)
    s1.push(8)
    s1.push(9)
    print("FIN PUSH")
    while not s1.empty():
        print(f'elem: {s1.pop()}')
    