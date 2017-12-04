import java.util.*;
import java.io.*;
import java.text.*;

public class BigSorting{
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    String[] unsorted = new String[N];
    for(int i=0; i<N; ++i){
      st = new StringTokenizer(br.readLine());
      unsorted[i] = st.nextToken();
    }
    mergeSort(unsorted, 0, unsorted.length - 1);
    for(int i=0; i<N; ++i){
      System.out.println(unsorted[i]);
    }
  }

  public static void mergeSort(String[] arr, int lower, int upper){
    if(lower < upper){
      int mid = lower+(upper-lower)/2;
      mergeSort(arr, lower, mid);
      mergeSort(arr, mid+1, upper);

      merge(arr, lower, mid, upper);
    }
  }

  public static void merge(String[] arr, int lower, int mid, int upper){
    int n1 = mid - lower + 1;
    int n2 = upper - mid;

    String[] first = new String[n1];
    String[] second = new String[n2];

    for(int i=0; i<n1; ++i){
      first[i] = arr[lower + i];
    }
    for(int i=0; i<n2; ++i){
      second[i] = arr[mid + i + 1];
    }

    int i=0;
    int j=0;
    int k=lower;
    while(i < n1 && j < n2){
      if(compareIsBiggerStringInteger(second[j], first[i])){
        arr[k] = first[i];
        ++i;
      }else{
        arr[k] = second[j];
        ++j;
      }
      ++k;
    }

    while(i < n1){
      arr[k] = first[i];
      ++i;
      ++k;
    }
    while(j < n2){
      arr[k] = second[j];
      ++j;
      ++k;
    }
  }

  public static boolean compareIsBiggerStringInteger(String one, String two){
    if(one.length() > two.length()) return true;
    if(two.length() > one.length()) return false;

    StringBuffer first = new StringBuffer(one);
    StringBuffer second = new StringBuffer(two);
    int N = first.length();
    for(int i=0; i<N; ++i){
      if((int) first.charAt(i) > (int) second.charAt(i)) return true;
      if((int) first.charAt(i) < (int) second.charAt(i)) return false;
    }
    return true; //no swap
  }
}
