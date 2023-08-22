package leetcode.problems.top_interview_150.graph_bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        String startDiff = "";
        String endDiff = "";
        int n = startGene.length();

        char[] startCh = startGene.toCharArray();
        char[] endCh = endGene.toCharArray();

        for (int i = 0; i < n; i++) {
            if(startCh[i] != endCh[i]) {
                startDiff += startCh[i];
                endDiff += endCh[i];
            }
        }
        System.out.println("startDiff: "+ startDiff + " endDiff: "+ endDiff);
        String[] bankDiffs = calcBankDiffs(bank, startGene);
        System.out.println(Arrays.toString(bankDiffs));


        return perfomBFS(startDiff, endDiff, new HashSet<>(Arrays.stream(bankDiffs).collect(Collectors.toList())), 0);
    }

    private int perfomBFS(String startDiff, String endDiff, Set<String> bankDiffs, int counter) {
        //startDiff: CT endDiff: AA
       //         [A, CA, AA]
        if (startDiff.equals(endDiff)) {
            return counter;
        }

        if (bankDiffs.contains(endDiff)) {

        }

        char[] startDiffCh = startDiff.toCharArray();

        for (int i = 0; i < startDiffCh.length; i++) {

        }

        return 0;
    }

    private String[] calcBankDiffs(String[] bank, String startGene) {
        int n = startGene.length();
        char[] endCh = startGene.toCharArray();
        String[] diffs = new String[bank.length];
        int idx =0;
        for (String bankGene : bank) {
            String diff = "";
            char[] bankCh = bankGene.toCharArray();
            for (int i = 0; i < n; i++) {
                if(bankCh[i] != endCh[i]) {
                    diff += bankCh[i];
                }
            }
            diffs[idx++] = diff;
        }

        return diffs;
    }
}
