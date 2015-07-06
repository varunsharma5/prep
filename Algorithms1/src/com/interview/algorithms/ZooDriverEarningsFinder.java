package com.interview.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * There is a zoo and there are several groups(number of groups:K) of people for
 * tour. Each group is having different size (g1,g2,g3…gK). There is one bus
 * with capacity C. Journey starts from a point and bus will come back to the
 * same point. A group can only be included in the bus if all the members of the
 * groups can be accumulated in bus. After coming back from the tour, each group
 * in the bus will again wait in the queue at the bus-stand. Bus-driver earns a
 * rupee for each person travelled. You have to find the earning of the bus
 * driver after R rounds. Example Number of groups G = 4 Group size for each
 * group : 2 4 3 5 Bus capacity : 7 Number of rounds R : 4 queue : (from front
 * side) 2 4 3 5 First round : 2 4 (we can’t take 3rd group as 3 members can’t
 * be accumulated after 2 and 4.) queue : 3 5 2 4 (1st and 2nd group are
 * enqueued. i.e. 2 and 4)
 * 
 * Second round : 3 queue : 5 2 4 3 Third Round : 5 2 queue : 4 3 5 2 Fourth
 * Round : 4 3 After 4 rounds, total earning is 6+3+7+7 = 23.
 * 
 * @author ajitkoti
 *
 */

public class ZooDriverEarningsFinder {

	int numberOfGroups;
	int[] groupSizes;
	int busCapacity;
	int noOfRounds;

	public ZooDriverEarningsFinder(int numberOfGroups, int[] groupSizes,
			int busCapacity, int noOfRounds) {
		this.numberOfGroups = numberOfGroups;
		this.groupSizes = groupSizes;
		this.busCapacity = busCapacity;
		this.noOfRounds = noOfRounds;
	}

	public int calculateEarnings() {

		Queue<Integer> groupsQueue = new LinkedList<Integer>();
		for (int grpSize : groupSizes) {
			groupsQueue.offer(grpSize);
		}

		int roundsCount = 0;
		int earnings = 0;

		while (roundsCount < noOfRounds) {

			int currentCapacity = 0;

			while (currentCapacity <= busCapacity) {
				int nextGrpSize = groupsQueue.peek();
				if ((currentCapacity + nextGrpSize) <= busCapacity) {
					currentCapacity = currentCapacity + nextGrpSize;
					groupsQueue.offer(groupsQueue.poll());
				} else {
					// bus is full. Commence journey
					break;
				}
			}
			// capacity is full. Add earning.
			earnings = earnings + currentCapacity;
			// increment rounds
			roundsCount++;
		}
		return earnings;
	}

	public static void main(String args[]) {

		Scanner scanner = new Scanner(System.in);

		// get number of groups
		int numberOfGroups = scanner.nextInt();

		int[] groupSizes = new int[numberOfGroups];

		// get group sizes
		for (int i = 0; i < numberOfGroups; i++) {
			groupSizes[i] = scanner.nextInt();
		}

		int busCapacity = scanner.nextInt();

		int noOfRounds = scanner.nextInt();

		ZooDriverEarningsFinder earningsFinder = new ZooDriverEarningsFinder(
				numberOfGroups, groupSizes, busCapacity, noOfRounds);
		System.out.println("Total Earnings : "
				+ earningsFinder.calculateEarnings());
	}
}
