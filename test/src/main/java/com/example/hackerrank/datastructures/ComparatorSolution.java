package com.example.hackerrank.datastructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ComparatorSolution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }

	}

}

class Checker implements Comparator<Player> { 
    
    /*public int compare(Player a, Player b) {
        int i = b.score - a.score;
        
        if (i != 0) return i;
        else i = a.name.compareTo(b.name);
        
        return i;
    }*/
    
    public int compare(Player a, Player b) {
    	Integer s1 = new Integer(a.score);
    	Integer s2 = new Integer(b.score);
        int i = s2.compareTo(s1);
        
        if (i != 0) return i;
        else i = a.name.compareTo(b.name);
        
        return i;
    }
}

class Player{
    String name;
    int score;
    
    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}
