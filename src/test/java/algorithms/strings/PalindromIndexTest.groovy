package algorithms.strings

import spock.lang.Specification

class PalindromIndexTest extends Specification {

    def "Should pass following case scenarios"() {
        expect:
        result == PalindromeIndex.palindromeIndex(word)
        where:
        result  || word
        3       || "aaab"
        0       || "baa"
        -1      || "aaa"

    }
}
