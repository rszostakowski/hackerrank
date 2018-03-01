package hackerrank.algorithms.javaLanguage.dataStructures;

import java.util.Comparator;

public class JavaComparator implements Comparator<JavaComparator.Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o2.score - o1.score == 0)
            return o1.name.compareTo(o2.name);
        else
            return o2.score - o1.score;
    }

    class Player{
        String name;
        int score;

        Player(String name, int score){
            this.name = name;
            this.score = score;
        }
    }
}

