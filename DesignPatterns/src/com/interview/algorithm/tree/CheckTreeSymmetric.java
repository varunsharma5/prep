package com.interview.algorithm.tree;

/**
 * 	boolean mirrorEquals(BTree left, BTree right) {
  		if (left == null || right == null) 
  			return left == null && right == null;
  		return left.value == right.value && mirrorEquals(left.left, right.right) && mirrorEquals(left.right, right.left);
	}

 * @author Varun
 *
 */

public class CheckTreeSymmetric {

}
