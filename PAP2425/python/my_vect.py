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



if __name__ == "__main__":
    print(estPalindrome(['R','A','D','A','R']))
    print(estPalindrome('RADAR'))
    