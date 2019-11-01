package algorithms

import spock.lang.Specification

class Java1DArrayTest extends Specification {

    def "Should pass following case scenarios"() {
        expect:
        result == Java1DArray.canWin(leap, inputArr as int[])
        where:
        leap || inputArr           || result
        3    || [0, 0, 0, 0, 0]    || true
        5    || [0, 0, 0, 1, 1, 1] || true
        3    || [0, 0, 1, 1, 1, 0] || false
        1    || [0, 1, 0]          || false
        2    || [0, 1, 0, 1, 0, 1] || true
        2    || [1, 0, 0, 1, 0, 1] || true
        4    || [0, 1, 1, 0, 0, 1, 1, 0, 1] || true
    }
}
