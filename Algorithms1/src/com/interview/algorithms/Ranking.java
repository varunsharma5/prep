package com.interview.algorithms;

/**
 * You are given the data for the tennis players - the number of games played,
 * wins/losses, years played, etc. Design an algorithm to rank the players. This
 * is an open ended question.
 * 
 * @author ajitkoti
 * 
 */
public class Ranking {
	
	public static int calculateRank(int wins, int loses, int totalYears ){
		int noOfGamesPlayed = wins+loses;
		int rank = (wins)/((noOfGamesPlayed) * totalYears);
		return rank;
	}

}
