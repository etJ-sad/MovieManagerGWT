package main;

import java.util.List;

public class Util {
  
  public static Integer overallRating(Integer ratingMovie, List<Integer> ratingPerformers) { 
    Integer maxRatingPerformer = 0; 
    if (ratingMovie == null || ratingPerformers == null) {
      return -1; 
    }
    if (ratingMovie < 0 || ratingMovie > 5) {
      return -1; 
    }
    int i;  
    for (i=0; i < ratingPerformers.size(); i++) {
      if (ratingPerformers.get(i) < 0 || ratingPerformers.get(i) > 5) {
        return -1; 
      }
      if (ratingPerformers.get(i) > maxRatingPerformer) {
        maxRatingPerformer = ratingPerformers.get(i);  
      }
    }
    if (i > ratingPerformers.size()) {
      return -2; 
    }
    return ratingMovie + maxRatingPerformer;
  }
}
