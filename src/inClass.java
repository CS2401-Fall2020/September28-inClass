
public class inClass {

  public static void main(String[] args) {
    char[] test1 = {'c','f','q','a','g','f','b'};
    char[] test1correct = {'a','b','c','f','f','g','q'};
    myQuickSort(test1, 0, test1.length-1);
    for(int i=0; i<test1.length; i++) {
      System.out.println("Index " + i + " should be " + test1correct[i] + " and its " + test1[i] );
      assert(test1correct[i] == test1[i] );
    }

  }
  
  public static void myQuickSort(char[] charArray, int start, int end) {
    // base case
    
    if(start >= end) {
      return;
    }
    
    
    // recursive case
    
    //finds pivot
    int pivot_index = start + (end-start)/2;
    char pivot = charArray[pivot_index];
    
    //shuffle around pivot
    int l = start;
    int h = end;
    boolean done = false;
    
    /*
     * 
     *  ---------------------
     *  |   |   | p |   |   |
     *  ---------------------
     *    l               h 
     * 
     */
    while(!done) {
      while(charArray[l] < pivot)
        l++;
      
      while(charArray[h] > pivot)
        h--;
      
      if(l >= h)
        done = true;
      else {
        char temp = charArray[l];
        charArray[l] = charArray[h];
        charArray[h] = temp;
        l++;
        h--;
      }
    }
    
    
    // everything to the left of (including) h is smaller (or equal) than the pivot
    myQuickSort(charArray, start, h);
    // everything to the right (not including) h is larger (or equal) than the pivot
    myQuickSort(charArray, h+1, end);
  }

}
