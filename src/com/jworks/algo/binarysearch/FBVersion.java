package com.jworks.algo.binarysearch;

public class FBVersion{
   
// -- DO NOT CHANGE THIS SECTION -----------------
   public static boolean isBadVersion(int v){ // isBadVersion() is the API function that returns true or false depending upon whether the provided version ID is bad or not
      return FBVersion.isBad(v);
   }

   private static boolean isBad(int v) {
      //supposed to call an API to determine if it's true /false
      return true;
   }
//-------------------------------------------------

   public static int[] firstBadVersion(int n) {

      int first = 1;
      // Assigning last pointer with n that is the number of versions
      int last = n;
      int calls = 0;
      int[] result = new int[2];

      while (first <= last){

         int middle = first + (last - first) / 2;

         boolean isBadVersion = isBadVersion(middle);

         calls +=1;

         if(isBadVersion){
            last = middle - 1;
         }else{
            first = middle + 1;
         }
      }

      result [0] = first;
      result[1]= calls;

      

      // Replace this placeholder return statement with your code
      return result;
   }
}