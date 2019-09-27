from collections import Counter 

def hackerrankInString(s):
    freq_of_s = Counter(s) 
    freq_of_hack = Counter("hackerrank")
    is_in = all(item in freq_of_hack.items() for item in freq_of_s.items())
# https://stackoverflow.com/questions/9323749/python-check-if-one-dictionary-is-a-subset-of-another-larger-dictionary
    if is_in:
        print("YES")
    else:
        print("NO")

# hackerrankInString("hhaacckkekraraannk")
hackerrankInString("hereiamstackerrank")
