package com.interview.algorithms.trie;

import java.util.HashMap;

import com.example.datastructures.Trie;
import com.example.datastructures.node.TrieNode;

/**
 * Given a dictionary of words and an input string, find the longest prefix of the string which is also a word in dictionary.

Examples:

Let the dictionary contains the following words:
{are, area, base, cat, cater, children, basement}

Below are some input/output examples:
--------------------------------------
Input String            Output
--------------------------------------
caterer                 cater
basemexy                base
child                   < Empty >
 * http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/
 * @author ajitkoti
 *
 */
public class LongestPrefixMatching {

	
	// The main method that finds out the longest string 'input'
    public String getMatchingPrefix(String input, TrieNode root)  {
        String result = ""; // Initialize resultant string
        int length = input.length();  // Find length of the input string       
           
        // Initialize reference to traverse through Trie
        TrieNode crawl = root;   
          
        // Iterate through all characters of input string 'str' and traverse 
        // down the Trie
        int level, prevMatch = 0; 
        for( level = 0 ; level < length; level++ )
        {    
            // Find current character of str
            char ch = input.charAt(level);    
              
            // HashMap of current Trie node to traverse down
            HashMap<Character,TrieNode> child = crawl.getChildren();                        
             
            // See if there is a Trie edge for the current character
            if( child.containsKey(ch) )
            {
               result += ch;          //Update result
               crawl = child.get(ch); //Update crawl to move down in Trie
                 
               // If this is end of a word, then update prevMatch
               if( crawl.isEnd() ) 
                    prevMatch = level + 1;
            }            
            else  break;
        }
          
        // If the last processed character did not match end of a word, 
        // return the previously matching prefix
        if( !crawl.isEnd() )
                return result.substring(0, prevMatch);        
         
        else return result;
    }

}
