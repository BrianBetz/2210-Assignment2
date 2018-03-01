import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 2015-01-26
 *
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }

   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @param <T> is type variable T.
    */
    
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
   
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      Iterator<T> itr = coll.iterator();
      T min = itr.next();
      
      for (T value : coll) {
         if (comp.compare(value, min) < 0) {
            min = value;
         }
      }
      
      return min;
   }

   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @param <T> is type variable T.
    */
    
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
   
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      Iterator<T> itr = coll.iterator();
      T max = itr.next();
      
      for (T value : coll) {
         if (comp.compare(value, max) > 0) {
            max = value;
         }
      }
      
      return max;
   }

   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @param <T> is type variable T.
    */
    
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
   
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      int c = 1;
      ArrayList<T> alist = new ArrayList<T>();
      
      for (T val : coll) {
         alist.add(val);
      }
      
      T kmin = alist.get(0);
      
      java.util.Collections.sort(alist, comp);
      for (int i = 0; i < alist.size() - 1; i++) {
         if (alist.get(i) != alist.get(i + 1)) {
            c++;
         }
         
         if (c == k) {
            kmin = alist.get(i + 1); 
         }
      }
      
      if (k == 1) {
         kmin = alist.get(0);
      }
      
      if (k < 1 || k > coll.size() || k > c) {
         throw new NoSuchElementException();
      }
   
      return kmin;
   }

   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @param <T> is type variable T.
    */
    
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
   
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      int c = 1;
      ArrayList<T> alist = new ArrayList<T>();
      
      for (T val : coll) {
         alist.add(val);
      }
      
      T kmax = alist.get(0);
      
      java.util.Collections.sort(alist, comp);
      
      for (int i = alist.size() - 1; i > 0; i--) {
         if (alist.get(i) != alist.get(i - 1)) {
            c++;
         }
         
         if (c == k) {
            kmax = alist.get(i - 1); 
         }
      }
      
      if (k == 1) {
         kmax = alist.get(alist.size() - 1);
      }
      
      if (k < 1 || k > coll.size() || k > c) {
         throw new NoSuchElementException();
      }
   
      return kmax;
   }

   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @param <T> is type variable T.
    */
    
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
                                         
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
   
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      Iterator<T> itr = coll.iterator();
      ArrayList<T> alist = new ArrayList<T>();  
      for (T val : coll) {
         if (comp.compare(val, low) >= 0 && comp.compare(val, high) <= 0) {
            alist.add(val);
         }
      }
      
      if (alist.size() == 0) {
         throw new NoSuchElementException();
      }
      
      return alist;
   }

   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @param <T> is type variable T.
    */
    
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      T max = max(coll, comp);
      if (comp.compare(key, max) > 0) {
         throw new NoSuchElementException();
      }
      for (T value : coll) {
         if (comp.compare(value, key) >= 0 && comp.compare(value, max) <= 0) {
            max = value;
         }
      }
      
      return max;
   }

   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @param <T> is type variable T.
    */
    
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      }
      
      if (coll.size() == 0) {
         throw new NoSuchElementException();
      }
      
      T min = min(coll, comp);
      if (comp.compare(key, min) < 0) {
         throw new NoSuchElementException();
      }
      for (T value : coll) {
         if (comp.compare(value, key) <= 0 && comp.compare(value, min) >= 0) {
            min = value;
         }
      }
      
      return min;
   }

}
