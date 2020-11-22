public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *  If the denominator is negative, negate both numerator and denominator
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored!
    if (deno==0){
      numerator = 0;
      denominator = 1;
    }
    else if(deno<0){
      numerator = -(nume);
      denominator = -(deno);
    }
    else{
      numerator = nume;
      denominator = deno;
    }
    reduce();
  }

  public double getValue(){
    return 0.0;
  }

  /**
  *@return the numerator
  */
  public int getNumerator(){
    return numerator;
  }
  /**
  *@return the denominator
  */
  public int getDenominator(){
    return denominator;
  }
  /**
  *@return a new RationalNumber that has the same numerator
  *and denominator as this RationalNumber but reversed.
  */
  public RationalNumber reciprocal(){
    RationalNumber a = new RationalNumber(getDenominator(),getNumerator());
    return a;
  }
  /**
  *@return true when the RationalNumbers have the same numerators and denominators, false otherwise.
  */
  public boolean equals(RationalNumber other){
    if (this.getNumerator() == other.getNumerator() && this.getDenominator() == other.getDenominator()){
      return true;
    }
    return false;
  }


  /**
  *@return the value expressed as "3/4" or "8/3"
  */
  public String toString(){
    return getNumerator()+"/"+getDenominator();
  }

  /**Calculate the GCD of two integers.
  *@param a the first integers
  *@param b the second integer
  *@return the value of the GCD
  */
  private static int gcd(int a, int b){
    if (a==0 || b==0){
      return 0;
    }
    if (a<b){
      int c = a;
      a = b;
      b = c;
    }
    int r = 1;
    while (r != 0){
      r = a%b;
      if (r == 0){
        break;
      }
      a = b;
      b = r;
    }
    if (b<0){
      b = -b;
    }
    return b;
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    int a = gcd(getNumerator(),getDenominator());
    if (a!=0){
      numerator = numerator/a;
      denominator = denominator/a;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    RationalNumber a = new RationalNumber(getNumerator()*other.getNumerator(),getDenominator()*other.getDenominator());
    return a;
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    RationalNumber a = new RationalNumber(getNumerator()*other.getDenominator(),getDenominator()*other.getNumerator());
    return a;
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    RationalNumber a = new RationalNumber(getNumerator()*other.getDenominator()+other.getNumerator()*getDenominator(),getDenominator()*other.getDenominator());
    return a;
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    RationalNumber a = new RationalNumber(getNumerator()*other.getDenominator()-other.getNumerator()*getDenominator(),getDenominator()*other.getDenominator());
    return a;
  }
}
