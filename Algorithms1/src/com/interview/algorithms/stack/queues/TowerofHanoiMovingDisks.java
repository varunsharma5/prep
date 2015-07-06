package com.interview.algorithms.stack.queues;

import com.example.datastructures.Stack;

/*
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different
 sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending
 order of size from top to bottom (e.g., each disk sits on top of an even larger one). You
 have the following constraints:	
 (A) Only one disk can be moved at a time.
 (B) A disk is slid off the top of one rod onto the next rod.
 (C) A disk can only be placed on top of a larger disk.
 Write a program to move the disks from the first rod to the last using Stacks.
 */
public class TowerofHanoiMovingDisks {

	public static void main(String[] args) {
		int n = 5;
		Tower[] towers = new Tower[n];
		for (int i = 0; i < 3; i++)
			towers[i] = new Tower(i);

		for (int i = n - 1; i >= 0; i--)
			towers[0].add(i);

		towers[0].moveDisks(n, towers[2], towers[1]);
	}
	

}

/**
 * We need to move N disks from Rod 1 to Rod 3, but let’s start from the
 * beginning. Moving the top disk is easy - we just move it to Disk 3.
 * 
 *  Can we move the top two disks? Yes: 
 * 1. Move Disk 1 from Rod 1 to Rod 2
 * 2. Move Disk 2 from Rod 1 to Rod 3 
 * 3. Move Disk 1 from Rod 2 to Rod 3 
 * 
 * Can we move the top three disks?
 *  1. We know we can move the top two disks around from one Rod to
 * another (as shown earlier), so let’s assume we have moved Disk 1 and 2 to Rod2. 
 * 
 * 2. Move Disk 3 to Rod 3 3. Again we know we can move the top two disks
 * around, so let’s move them from Rod 2 to Rod 
 * 
 * 3. This approach leads to a natural recursive algorithm:
 * 
 * @author ajitkoti
 *
 */
class Tower {
	private Stack<Integer> disks;
	private int index;

	public Tower(int i) {
		disks = new Stack<Integer>(10);
		index = i;
	}

	public int index() {
		return index;
	}

	public void add(int d) {
		if (!disks.isEmpty() && disks.peek() <= d) {
			System.out.println("Error placing disk " + d);
		} else {
			disks.push(d);

		}

	}

	public void moveTopTo(Tower t) {
		int top = disks.pop();
		t.add(top);
		System.out.println("Move disk " + top + " from " + index() + " to " + t.index());
	}

	public void print() {
		System.out.println("Contents of Tower " + index());
		for (int i = disks.size() - 1; i >= 0; i--) {
			disks.display();
		}

	}

	public void moveDisks(int n, Tower destination, Tower buffer) {
		if (n > 0) {
			moveDisks(n - 1, buffer, destination);
			moveTopTo(destination);
			buffer.moveDisks(n - 1, destination, this);
		}

	}

}
