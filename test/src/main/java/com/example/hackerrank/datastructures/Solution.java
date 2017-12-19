package com.example.hackerrank.datastructures;

import java.util.Arrays;
import java.util.List;

public class Solution {
       
       static class Point {
              int x;
              int y;
              
              public Point(int x, int y) {
                     super();
                     this.x = x;
                     this.y = y;
              }
              public int getX() {
                     return x;
              }
              public int getY() {
                     return y;
              }
              @Override
              public int hashCode() {
                     final int prime = 31;
                     int result = 1;
                     result = prime * result + x;
                     result = prime * result + y;
                     return result;
              }
              @Override
              public boolean equals(Object obj) {
                     if (this == obj)
                           return true;
                     if (obj == null)
                           return false;
                     if (getClass() != obj.getClass())
                           return false;
                     Point other = (Point) obj;
                     if (x != other.x)
                           return false;
                     if (y != other.y)
                           return false;
                     return true;
              }
              @Override
              public String toString() {
                     return "Point [x=" + x + ", y=" + y + "]";
              }
              
              
              
       }

       public static void main(String[] args) {
              
              List<Point> points = Arrays.asList(new Point(9,9), new Point(3,5), new Point(6,6), new Point(2,8), new Point(2,2), new Point(1,3));
              
              int count = 0;
              int index =0;
              for (Point point : points) {
                     for (Point point1 : points.subList(index++, points.size())) {
                           if(point1.equals(point)){
                                  continue;
                           }
                           if(Math.abs(point1.getX() - point.getX()) == Math.abs(point1.getY() - point.getY())){
                                  System.out.println(point1 + "  " + point);
                                  ++ count;
                           }
                     }
                     
              }
              
              System.out.println(count); 
       }

}
