def caesarCipher(s, k):
    ciphered = ""
    for i in s:
        if i.isalpha():
            ciphered_char = cipher_char(i.lower(), k)
            if i.isupper():
                ciphered += ciphered_char.upper()
            else:
                ciphered += ciphered_char     
        else:
            ciphered += i

    return ciphered

def cipher_char(i, k):
    diff = ord('z') -  ord('a')+1
    modulo = (ord(i) + int(k) % diff)
    print("i {}, ord(i): {}, modulo {}".format(i, ord(i), modulo))
    if modulo > ord('z'):
        return chr(modulo - diff)
    return chr(modulo)

diff = ord('z') -  ord('a')
print("ord('a') {} ord('z') {} diff {}".format(ord('a'), ord('z'), diff))

print(caesarCipher("middle-Outz", 2))
# caesarCipher("www.abc.xy", 2)
# print(caesarCipher("Ciphering.", 26))
