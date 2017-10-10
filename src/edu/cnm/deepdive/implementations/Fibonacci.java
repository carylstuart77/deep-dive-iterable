/**
 * Using enhanced for with iterable
 */
package edu.cnm.deepdive.implementations;

import java.math.BigInteger;
import java.util.Iterator;

/**
 * @author caryl
 *
 */
public class Fibonacci implements Iterable<BigInteger> {
  //no upper limit; Chaining Constructors
  private static final int DEFAULT_UPPER = -1;
  private final int upper; 
  public Fibonacci() {
    this(DEFAULT_UPPER);
    
  }
  
  public Fibonacci(int upper) {
    this.upper = upper;
  }
  //doing with an inner class
  @Override
  public Iterator<BigInteger> iterator() {
    // TODO Auto-generated method stub
    //return new FibIterator();

    // Anonumous class implementing the Iterator <BigInteger> interface.
    return new Iterator<BigInteger> () {
      //start with -1
      private BigInteger previous = BigInteger.valueOf(-1);
      //current value
      private BigInteger current = BigInteger.ONE;
      //current index
      private int index = 0;
      
      @Override
      public boolean hasNext() {
        //true or False   OR index less than upper
        return upper < 0 || index < upper;
      }

      @Override
      public BigInteger next() {
        // will not change current
        BigInteger next = previous.add(current);
        previous = current;
        current = next;
        index++;
        return current;
          
      }
  }
}
}

      
//inner class(no static)-can access non-static fields in class
//  private class FibIterator implements Iterator<BigInteger>{
//    //start with -1
//    private BigInteger previous = BigInteger.valueOf(-1);
//    //current value
//    private BigInteger current = BigInteger.ONE;
//    //current index
//    private int index = 0;
//    
//
//    @Override
//    public boolean hasNext() {
//      //true or False   OR index less than upper
//      return upper < 0 || index < upper;
//    }
//
//    @Override
//    public BigInteger next() {
//      // will not change current
//      BigInteger next = previous.add(current);
//      previous = current;
//      current = next;
//      index++;
//      return current;
//        
//    }
//    
//  }

