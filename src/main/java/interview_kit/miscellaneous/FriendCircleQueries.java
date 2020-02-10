
package interview_kit.miscellaneous;

import java.util.*;

class FriendCircleQueries {

	static int[] maxCircle(int[][] queries) {
		DisjointSet set = new DisjointSet();

		List<Integer> results = new LinkedList<>();
		for (int[] row : queries) {

			set.AddElement(row[0], row[1]);
			results.add(set.GetMaxUnion());

		}

		return results.stream().mapToInt(el -> el).toArray();
    	}

	


	public static void main(String[] args) {

		// int[][] input = 
		// {
		// 	{1000000000,23},
		// 	{11,3778},
		// 	{7,47},
		// 	{11,1000000000}
		// };
		int[][] input = 
		{
			{1,2},
			{3,4},
			{1,3},
			{5,7},
			{5,6},
			{7,4},
		};
		// int[][] input = 
		// {
		// 	{1,2},
		// 	{3,4},
		// 	{2,3}
		// };
		System.out.println(Arrays.toString(maxCircle(input)));
	}

	static class DisjointSet {
		int counter = 0;
		Map<Integer,Node> nodes = new HashMap<>();

		void AddElement(int first, int second) {

			System.out.println("first: " + first + " second: " + second);
			// both exists 
			if (nodes.containsKey(first) &&  nodes.containsKey(second)) {
				System.out.println("Both of them exists");
				int countForFirstKey = nodes.get(first).howManyElementsInGroup;
				int countForSecondKey = nodes.get(second).howManyElementsInGroup;

				System.out.println("countForFirstKey: "+ first + " in group: " + nodes.get(first).groupName + " count: " + countForFirstKey);
				System.out.println("countForSecondKey:" +second + " in group: " + nodes.get(second).groupName+ " count: " +countForSecondKey);

				int currentMax = countForFirstKey + countForSecondKey;
				System.out.println("new max: "+ currentMax);

				if (countForFirstKey > countForSecondKey) {
					changeAllElements(nodes.get(second), nodes.get(first), currentMax);

				} else {
					changeAllElements(nodes.get(first), nodes.get(second), currentMax);
				}


			} else if (nodes.containsKey(first)) {
				System.out.println("Only first: " + first + " adding second");
				Node existing = nodes.get(first);
				int localCounter =  existing.howManyElementsInGroup + 1;
				System.out.println("localCounter: " + localCounter);
				nodes.put(second, new Node(existing.groupName, localCounter));
				updateAllCountersInGroup(existing.groupName, localCounter); 

			} else if (nodes.containsKey(second)) {
				System.out.println("Only second: " + second + " adding first");
				Node existing = nodes.get(second);
				int localCounter =  existing.howManyElementsInGroup + 1;
				System.out.println("localCounter: " + localCounter);
				nodes.put(first, new Node(existing.groupName, localCounter));
				updateAllCountersInGroup(existing.groupName, localCounter); 
			} else {
				System.out.println("None of them exist");
				nodes.put(first, new Node(counter, 2));
				nodes.put(second, new Node(counter, 2));
				counter++;

			}
			System.out.println("Current max: "+ GetMaxUnion());
			System.out.println("*******************************************");
		}

		private void changeAllElements(Node from , Node to2, int counter) {
			 nodes.entrySet()
				.stream()
				.filter(el -> {
					System.out.println("checking group name: " + el.getValue().groupName);
					return el.getValue().groupName == from.groupName;
				})
				.map(el -> {
					// TODO cos tu nie dziala
					System.out.println("Changin to new max: " + counter);
					el.getValue().groupName = to2.groupName;
					el.getValue().howManyElementsInGroup = counter;
					return el;
				}).forEach(el -> System.out.println(el.getValue().howManyElementsInGroup));

		}

		private void updateAllCountersInGroup(int groupName, int counter) {
			for(Map.Entry<Integer, Node> entry : nodes.entrySet()) {
				Integer key = entry.getKey();
				Node node = entry.getValue();

				if(node.groupName == groupName) {
					node.howManyElementsInGroup = counter;
				}
			}


			}
		}
		// private int howManyElementsForKey(Node node) {
		// 	int[] array = nodes.entrySet()
		// 		.stream()
		// 		.filter(el -> el.getValue().groupName == node.groupName)
		// 		.peek(el -> System.out.println("groupName: "+ el.groupName)) 
		// 		.mapToInt(el -> 1)
		// 		.toArray();
                //
		// 	return (int) array.length;
		// }


		int GetMaxUnion() {
			return nodes.entrySet()
					.stream()
					.map(el -> el.getValue().howManyElementsInGroup)
					.mapToInt(el -> el)
					.max()
					.orElse(0);
		}
	}

	static class Node {
		public int groupName;
		public int howManyElementsInGroup;

		public Node(int groupName, int howManyElementsInGroup) {
			this.groupName = groupName;
			this.howManyElementsInGroup = howManyElementsInGroup;
		}
	}
}
