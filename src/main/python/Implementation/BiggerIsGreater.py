def  some_letter_bigger(letter, word):
    print("letter: {}, word: {}".format(letter, word))
    for other_letter in word: 
        if other_letter > letter:
            return True
    return False

def swap_bigger_letter(letter, word, initial_word):
    seq = [ord(i) for i in list(word) if ord(i) > ord(letter)]
    minimum = min(seq)
    print("changing: {} to: {}".format(letter, chr(minimum)))
#TODO change the last occurence of the letter 
    return swap(initial_word, initial_word.index(letter), initial_word.index(chr(minimum)))

def some_letter_smaller(letter, word):
    print("letter: {}, word: {}".format(letter, word))
    for other_letter in word: 
        if other_letter < letter:
            return True
    return False
#
def swap_smaller_letter(letter, word, initial_word):
    seq = [ord(i) for i in list(word) if ord(i) < ord(letter)]
    minimum = min(seq)
    print("changing: {} to: {}".format(letter, chr(minimum)))
    return swap(initial_word, initial_word.index(letter), initial_word.index(chr(minimum)))

def biggerIsGreater(w):
    print(w)
    original_word = w
    n = len(w) 
    idx = 1

    for i in range(1,n):
        if some_letter_bigger(w[n-i-1], w[n-i:]):
            w = swap_bigger_letter(w[n-i-1], w[n-i:], original_word)
            idx = n-i
            break

    if original_word != w:
        after_first_change = w
        print("After first chang {}".format(after_first_change))

        for i in range(idx,n):
            if some_letter_smaller(w[i], w[i:]):
                w = swap_smaller_letter(w[i], w[i:], after_first_change)
                break
    else:
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
# print(biggerIsGreater("dkhc"))
# print(biggerIsGreater("dcba"))
# print(biggerIsGreater("bcdb"))
# print(biggerIsGreater("abdc"))
# print(biggerIsGreater("kdhc"))
# print(biggerIsGreater("dcba"))
print(biggerIsGreater("fedcbabcd"))
# assert(biggerIsGreater("dkhc")=="hcdk")
# word = "dkhc"
# for i in list(word):
#     print(ord(i))

# print(ord('b') - ord('a'))
