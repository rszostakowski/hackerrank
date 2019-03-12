def  some_letter_bigger(letter, word):
    print("letter: {}, word: {}".format(letter, word))
    for other_letter in word: 
        if other_letter > letter:
            return True
    return False

def swap_bigger_letter(letter, word, initial_word):
    seq = [ord(i) for i in list(word) if ord(i) > ord(letter)]
    minimum = min(seq)
    return swap(initial_word, initial_word.index(letter), initial_word.index(chr(minimum)))

def biggerIsGreater(w):
    print(w)
    original_word = w
    n = len(w) 

    for i in range(1,n):
        if some_letter_bigger(w[n-i-1], w[n-i:]):
            return swap_bigger_letter(w[n-i-1], w[n-i:], original_word)

    if original_word == w:
        return "no answer"
    return w


def swap(word, idx_1, idx_2):
    word = list(word)
    first = word[idx_1]
    second = word[idx_2]
    word[idx_1] = second
    word[idx_2] = first
    return ''.join(word )


# print(biggerIsGreater("ab"))
# biggerIsGreater("bb")
# print(biggerIsGreater("hefg"))
# biggerIsGreater("dhck")
print(biggerIsGreater("dkhc"))
# print(biggerIsGreater("dcba"))
# print(biggerIsGreater("bcdb"))
# print(biggerIsGreater("abdc"))
# print(biggerIsGreater("kdhc"))
# assert(biggerIsGreater("dkhc")=="hcdk"))
# word = "dkhc"
# for i in list(word):
#     print(ord(i))

# print(ord('b') - ord('a'))
