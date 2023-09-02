package leetcode.problems.heap;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        List<String> characters = Arrays.asList("A", "A", "A", "B", "B", "B", "C", "C", "C");

        // Count the frequency of each character
        Map<String, Integer> charFrequency = new HashMap<>();
        for (String c : characters) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Create a custom comparator based on character frequency
        Comparator<String> customComparator = (c1, c2) -> {
            int freq1 = charFrequency.get(c1);
            int freq2 = charFrequency.get(c2);

            // Compare by frequency in descending order
            if (freq1 != freq2) {
                return Integer.compare(freq2, freq1);
            }

            return 0; // Equal frequencies, no change in order
        };

        // Create a PriorityQueue using the custom comparator
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(characters.size(), customComparator);

        // Add characters to the PriorityQueue
        priorityQueue.addAll(characters);

        // Create the result list with the desired order
        List<String> result = new ArrayList<>();

        // Create a queue to store characters temporarily
        Queue<String> tempQueue = new LinkedList<>();

        while (!priorityQueue.isEmpty() || !tempQueue.isEmpty()) {
            if (!priorityQueue.isEmpty()) {
                String character = priorityQueue.poll();
                if (!result.isEmpty() && character.equals(result.get(result.size() - 1))) {
                    tempQueue.offer(character); // Place the character in the temporary queue
                } else {
                    result.add(character);
                }
            } else {
                result.add(""); // Placeholder for empty slots
            }

            if (tempQueue.size() >= charFrequency.get(result.get(result.size() - 1))) {
                priorityQueue.addAll(tempQueue); // Return characters from the temporary queue
                tempQueue.clear();
            }
        }

        // Remove any empty placeholders from the result
        result.removeIf(s -> s.equals(""));

        // Convert the result to an array or another desired data structure
        String[] resultArray = result.toArray(new String[0]);

        // Print the result
        System.out.println(Arrays.toString(resultArray));
    }
}
