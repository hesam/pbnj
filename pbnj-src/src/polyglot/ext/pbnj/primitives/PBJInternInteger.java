package polyglot.ext.pbnj.primitives;

import polyglot.ext.pbnj.tologic.*;

import kodkod.ast.Formula;
import kodkod.ast.Expression;
import kodkod.ast.Variable;
import kodkod.ast.Decls;
import kodkod.ast.IntExpression;
import kodkod.ast.IntConstant;
import kodkod.ast.Relation;
import kodkod.instance.TupleSet;
import kodkod.instance.TupleFactory;
import kodkod.instance.Bounds;

import java.util.HashMap;

import java.io.CharArrayWriter;

public final class PBJInternInteger extends Number implements Comparable<PBJInternInteger>, PBJInternObject
{
  /**
   * Compatible with JDK 1.0.2+.
   */
  private static final long serialVersionUID = 1360826667806852920L;

  /**
   * The minimum value an <code>int</code> can represent is -2147483648 (or
   * -2<sup>31</sup>).
   */
  public static int MIN_VALUE = 0x80000000;

  /**
   * The maximum value an <code>int</code> can represent is 2147483647 (or
   * 2<sup>31</sup> - 1).
   */
  public static int MAX_VALUE = 0x7fffffff;

  /**
   * All possible chars for representing a number as a String
   */
  final static char[] digits = {
      '0' , '1' , '2' , '3' , '4' , '5' ,
      '6' , '7' , '8' , '9' , 'a' , 'b' ,
      'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
      'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
      'o' , 'p' , 'q' , 'r' , 's' , 't' ,
              'u' , 'v' , 'w' , 'x' , 'y' , 'z'
  };
  /**
   * The primitive type <code>int</code> is represented by this
   * <code>Class</code> object.
   * @since 1.1
   */

  /**
   * The number of bits needed to represent an <code>int</code>.
   * @since 1.5
   */
  public static final int SIZE = 32;

  // This caches some PBJInternInteger values, and is used by boxing
  // conversions via valueOf().  We must cache at least -128..127;
  // these constants control how much we actually cache.
  private static final int MIN_CACHE = -128;
  private static final int MAX_CACHE = 127;
  private static PBJInternInteger[] intCache = new PBJInternInteger[MAX_CACHE - MIN_CACHE + 1];

  /**
   * The immutable value of this PBJInternInteger.
   *
   * @serial the wrapped int
   */
  private final int value;

  /**
   * Create an <code>PBJInternInteger</code> object representing the value of the
   * <code>int</code> argument.
   *
   * @param value the value to use
   */
  public PBJInternInteger(int value)
  {
    this.value = value;
  }

  /**
   * Create an <code>PBJInternInteger</code> object representing the value of the
   * argument after conversion to an <code>int</code>.
   *
   * @param s the string to convert
   * @throws NumberFormatException if the String does not contain an int
   * @see #valueOf(String)
   */
  public PBJInternInteger(String s)
  {
    value = parseInt(s, 10, false);
  }

  /**
   * Converts the <code>int</code> to a <code>String</code> using
   * the specified radix (base). If the radix exceeds
   * <code>Character.MIN_RADIX</code> or <code>Character.MAX_RADIX</code>, 10
   * is used instead. If the result is negative, the leading character is
   * '-' ('\\u002D'). The remaining characters come from
   * <code>Character.forDigit(digit, radix)</code> ('0'-'9','a'-'z').
   *
   * @param num the <code>int</code> to convert to <code>String</code>
   * @param radix the radix (base) to use in the conversion
   * @return the <code>String</code> representation of the argument
   */
  public static String toString(int num, int radix)
  {
    if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX)
      radix = 10;

    // For negative numbers, print out the absolute value w/ a leading '-'.
    // Use an array large enough for a binary number.
    char[] buffer = new char[33];
    int i = 33;
    boolean isNeg = false;
    if (num < 0)
      {
        isNeg = true;
        num = -num;

        // When the value is MIN_VALUE, it overflows when made positive
        if (num < 0)
	  {
	    buffer[--i] = digits[(int) (-(num + radix) % radix)];
	    num = -(num / radix);
	  }
      }

    do
      {
        buffer[--i] = digits[num % radix];
        num /= radix;
      }
    while (num > 0);

    if (isNeg)
      buffer[--i] = '-';

    // Package constructor avoids an array copy.
    return new String(buffer, i, 33 - i); //, true);
  }

  /**
   * Converts the <code>int</code> to a <code>String</code> assuming it is
   * unsigned in base 16.
   *
   * @param i the <code>int</code> to convert to <code>String</code>
   * @return the <code>String</code> representation of the argument
   */
  public static String toHexString(int i)
  {
    return toUnsignedString(i, 4);
  }

  /**
   * Converts the <code>int</code> to a <code>String</code> assuming it is
   * unsigned in base 8.
   *
   * @param i the <code>int</code> to convert to <code>String</code>
   * @return the <code>String</code> representation of the argument
   */
  public static String toOctalString(int i)
  {
    return toUnsignedString(i, 3);
  }

  /**
   * Converts the <code>int</code> to a <code>String</code> assuming it is
   * unsigned in base 2.
   *
   * @param i the <code>int</code> to convert to <code>String</code>
   * @return the <code>String</code> representation of the argument
   */
  public static String toBinaryString(int i)
  {
    return toUnsignedString(i, 1);
  }

  /**
   * Converts the <code>int</code> to a <code>String</code> and assumes
   * a radix of 10.
   *
   * @param i the <code>int</code> to convert to <code>String</code>
   * @return the <code>String</code> representation of the argument
   * @see #toString(int, int)
   */
  public static String toString(int i)
  {
    // This is tricky: in libgcj, String.valueOf(int) is a fast native
    // implementation.  In Classpath it just calls back to
    // PBJInternInteger.toString(int, int).
    return String.valueOf(i);
  }

  /**
   * Converts the specified <code>String</code> into an <code>int</code>
   * using the specified radix (base). The string must not be <code>null</code>
   * or empty. It may begin with an optional '-', which will negate the answer,
   * provided that there are also valid digits. Each digit is parsed as if by
   * <code>Character.digit(d, radix)</code>, and must be in the range
   * <code>0</code> to <code>radix - 1</code>. Finally, the result must be
   * within <code>MIN_VALUE</code> to <code>MAX_VALUE</code>, inclusive.
   * Unlike Double.parseDouble, you may not have a leading '+'.
   *
   * @param str the <code>String</code> to convert
   * @param radix the radix (base) to use in the conversion
   * @return the <code>String</code> argument converted to <code>int</code>
   * @throws NumberFormatException if <code>s</code> cannot be parsed as an
   *         <code>int</code>
   */
  public static int parseInt(String str, int radix)
  {
    return parseInt(str, radix, false);
  }

  /**
   * Converts the specified <code>String</code> into an <code>int</code>.
   * This function assumes a radix of 10.
   *
   * @param s the <code>String</code> to convert
   * @return the <code>int</code> value of <code>s</code>
   * @throws NumberFormatException if <code>s</code> cannot be parsed as an
   *         <code>int</code>
   * @see #parseInt(String, int)
   */
  public static int parseInt(String s)
  {
    return parseInt(s, 10, false);
  }

  /**
   * Creates a new <code>PBJInternInteger</code> object using the <code>String</code>
   * and specified radix (base).
   *
   * @param s the <code>String</code> to convert
   * @param radix the radix (base) to convert with
   * @return the new <code>PBJInternInteger</code>
   * @throws NumberFormatException if <code>s</code> cannot be parsed as an
   *         <code>int</code>
   * @see #parseInt(String, int)
   */
  public static PBJInternInteger valueOf(String s, int radix)
  {
    return new PBJInternInteger(parseInt(s, radix, false));
  }

  /**
   * Creates a new <code>PBJInternInteger</code> object using the <code>String</code>,
   * assuming a radix of 10.
   *
   * @param s the <code>String</code> to convert
   * @return the new <code>PBJInternInteger</code>
   * @throws NumberFormatException if <code>s</code> cannot be parsed as an
   *         <code>int</code>
   * @see #PBJInternInteger(String)
   * @see #parseInt(String)
   */
  public static PBJInternInteger valueOf(String s)
  {
    return new PBJInternInteger(parseInt(s, 10, false));
  }

  /**
   * Returns an <code>PBJInternInteger</code> object wrapping the value.
   * In contrast to the <code>PBJInternInteger</code> constructor, this method
   * will cache some values.  It is used by boxing conversion.
   *
   * @param val the value to wrap
   * @return the <code>PBJInternInteger</code>
   */
  public static PBJInternInteger valueOf(int val)
  {
    if (val < MIN_CACHE || val > MAX_CACHE)
      return new PBJInternInteger(val);
    synchronized (intCache)
      {
	if (intCache[val - MIN_CACHE] == null)
	  intCache[val - MIN_CACHE] = new PBJInternInteger(val);
	return intCache[val - MIN_CACHE];
      }
  }

  /**
   * Return the value of this <code>PBJInternInteger</code> as a <code>byte</code>.
   *
   * @return the byte value
   */
  public byte byteValue()
  {
    return (byte) value;
  }

  /**
   * Return the value of this <code>PBJInternInteger</code> as a <code>short</code>.
   *
   * @return the short value
   */
  public short shortValue()
  {
    return (short) value;
  }

  /**
   * Return the value of this <code>PBJInternInteger</code>.
   * @return the int value
   */
  public int intValue()
  {
    return value;
  }

  /**
   * Return the value of this <code>PBJInternInteger</code> as a <code>long</code>.
   *
   * @return the long value
   */
  public long longValue()
  {
    return value;
  }

  /**
   * Return the value of this <code>PBJInternInteger</code> as a <code>float</code>.
   *
   * @return the float value
   */
  public float floatValue()
  {
    return value;
  }

  /**
   * Return the value of this <code>PBJInternInteger</code> as a <code>double</code>.
   *
   * @return the double value
   */
  public double doubleValue()
  {
    return value;
  }

  /**
   * Converts the <code>PBJInternInteger</code> value to a <code>String</code> and
   * assumes a radix of 10.
   *
   * @return the <code>String</code> representation
   */
  public String toString()
  {
    return String.valueOf(value);
  }

  /**
   * Return a hashcode representing this Object. <code>PBJInternInteger</code>'s hash
   * code is simply its value.
   *
   * @return this Object's hash code
   */
  public int hashCode()
  {
    return value;
  }

  /**
   * Returns <code>true</code> if <code>obj</code> is an instance of
   * <code>PBJInternInteger</code> and represents the same int value.
   *
   * @param obj the object to compare
   * @return whether these Objects are semantically equal
   */
  public boolean equals(Object obj)
  {
    return obj instanceof PBJInternInteger && value == ((PBJInternInteger) obj).value;
  }

  /**
   * Get the specified system property as an <code>PBJInternInteger</code>. The
   * <code>decode()</code> method will be used to interpret the value of
   * the property.
   *
   * @param nm the name of the system property
   * @return the system property as an <code>PBJInternInteger</code>, or null if the
   *         property is not found or cannot be decoded
   * @throws SecurityException if accessing the system property is forbidden
   * @see System#getProperty(String)
   * @see #decode(String)
   */
  public static PBJInternInteger getPBJInternInteger(String nm)
  {
    return getPBJInternInteger(nm, null);
  }

  /**
   * Get the specified system property as an <code>PBJInternInteger</code>, or use a
   * default <code>int</code> value if the property is not found or is not
   * decodable. The <code>decode()</code> method will be used to interpret
   * the value of the property.
   *
   * @param nm the name of the system property
   * @param val the default value
   * @return the value of the system property, or the default
   * @throws SecurityException if accessing the system property is forbidden
   * @see System#getProperty(String)
   * @see #decode(String)
   */
  public static PBJInternInteger getPBJInternInteger(String nm, int val)
  {
    PBJInternInteger result = getPBJInternInteger(nm, null);
    return result == null ? new PBJInternInteger(val) : result;
  }

  /**
   * Get the specified system property as an <code>PBJInternInteger</code>, or use a
   * default <code>PBJInternInteger</code> value if the property is not found or is
   * not decodable. The <code>decode()</code> method will be used to
   * interpret the value of the property.
   *
   * @param nm the name of the system property
   * @param def the default value
   * @return the value of the system property, or the default
   * @throws SecurityException if accessing the system property is forbidden
   * @see System#getProperty(String)
   * @see #decode(String)
   */
  public static PBJInternInteger getPBJInternInteger(String nm, PBJInternInteger def)
  {
    if (nm == null || "".equals(nm))
      return def;
    nm = System.getProperty(nm);
    if (nm == null)
      return def;
    try
      {
        return decode(nm);
      }
    catch (NumberFormatException e)
      {
        return def;
      }
  }

  /**
   * Convert the specified <code>String</code> into an <code>PBJInternInteger</code>.
   * The <code>String</code> may represent decimal, hexadecimal, or
   * octal numbers.
   *
   * <p>The extended BNF grammar is as follows:<br>
   * <pre>
   * <em>DecodableString</em>:
   *      ( [ <code>-</code> ] <em>DecimalNumber</em> )
   *    | ( [ <code>-</code> ] ( <code>0x</code> | <code>0X</code>
   *              | <code>#</code> ) <em>HexDigit</em> { <em>HexDigit</em> } )
   *    | ( [ <code>-</code> ] <code>0</code> { <em>OctalDigit</em> } )
   * <em>DecimalNumber</em>:
   *        <em>DecimalDigit except '0'</em> { <em>DecimalDigit</em> }
   * <em>DecimalDigit</em>:
   *        <em>Character.digit(d, 10) has value 0 to 9</em>
   * <em>OctalDigit</em>:
   *        <em>Character.digit(d, 8) has value 0 to 7</em>
   * <em>DecimalDigit</em>:
   *        <em>Character.digit(d, 16) has value 0 to 15</em>
   * </pre>
   * Finally, the value must be in the range <code>MIN_VALUE</code> to
   * <code>MAX_VALUE</code>, or an exception is thrown.
   *
   * @param str the <code>String</code> to interpret
   * @return the value of the String as an <code>PBJInternInteger</code>
   * @throws NumberFormatException if <code>s</code> cannot be parsed as a
   *         <code>int</code>
   * @throws NullPointerException if <code>s</code> is null
   * @since 1.2
   */
  public static PBJInternInteger decode(String str)
  {
    return new PBJInternInteger(parseInt(str, 10, true));
  }

  /**
   * Compare two PBJInternIntegers numerically by comparing their <code>int</code>
   * values. The result is positive if the first is greater, negative if the
   * second is greater, and 0 if the two are equal.
   *
   * @param i the PBJInternInteger to compare
   * @return the comparison
   * @since 1.2
   */
  public int compareTo(PBJInternInteger i)
  {
    if (value == i.value)
      return 0;
    // Returns just -1 or 1 on inequality; doing math might overflow.
    return value > i.value ? 1 : -1;
  }

  /**
   * Return the number of bits set in x.
   * @param x value to examine
   * @since 1.5
   */
  public static int bitCount(int x)
  {
    // Successively collapse alternating bit groups into a sum.
    x = ((x >> 1) & 0x55555555) + (x & 0x55555555);
    x = ((x >> 2) & 0x33333333) + (x & 0x33333333);
    x = ((x >> 4) & 0x0f0f0f0f) + (x & 0x0f0f0f0f);
    x = ((x >> 8) & 0x00ff00ff) + (x & 0x00ff00ff);
    return ((x >> 16) & 0x0000ffff) + (x & 0x0000ffff);
  }

  /**
   * Rotate x to the left by distance bits.
   * @param x the value to rotate
   * @param distance the number of bits by which to rotate
   * @since 1.5
   */
  public static int rotateLeft(int x, int distance)
  {
    // This trick works because the shift operators implicitly mask
    // the shift count.
    return (x << distance) | (x >>> - distance);
  }

  /**
   * Rotate x to the right by distance bits.
   * @param x the value to rotate
   * @param distance the number of bits by which to rotate
   * @since 1.5
   */
  public static int rotateRight(int x, int distance)
  {
    // This trick works because the shift operators implicitly mask
    // the shift count.
    return (x << - distance) | (x >>> distance);
  }

  /**
   * Find the highest set bit in value, and return a new value
   * with only that bit set.
   * @param value the value to examine
   * @since 1.5
   */
  public static int highestOneBit(int value)
  {
    value |= value >>> 1;
    value |= value >>> 2;
    value |= value >>> 4;
    value |= value >>> 8;
    value |= value >>> 16;
    return value ^ (value >>> 1);
  }

  /**
   * Return the number of leading zeros in value.
   * @param value the value to examine
   * @since 1.5
   */
  public static int numberOfLeadingZeros(int value)
  {
    value |= value >>> 1;
    value |= value >>> 2;
    value |= value >>> 4;
    value |= value >>> 8;
    value |= value >>> 16;
    return bitCount(~value);
  }

  /**
   * Find the lowest set bit in value, and return a new value
   * with only that bit set.
   * @param value the value to examine
   * @since 1.5
   */
  public static int lowestOneBit(int value)
  {
    // Classic assembly trick.
    return value & - value;
  }

  /**
   * Find the number of trailing zeros in value.
   * @param value the value to examine
   * @since 1.5
   */
  public static int numberOfTrailingZeros(int value)
  {
    return bitCount((value & -value) - 1);
  }

  /**
   * Return 1 if x is positive, -1 if it is negative, and 0 if it is
   * zero.
   * @param x the value to examine
   * @since 1.5
   */
  public static int signum(int x)
  {
    return x < 0 ? -1 : (x > 0 ? 1 : 0);
  }

  /**
   * Reverse the bytes in val.
   * @since 1.5
   */
  public static int reverseBytes(int val)
  {
    return (  ((val >> 24) & 0xff)
	    | ((val >> 8) & 0xff00)
	    | ((val << 8) & 0xff0000)
	    | ((val << 24) & 0xff000000));
  }

  /**
   * Reverse the bits in val.
   * @since 1.5
   */
  public static int reverse(int val)
  {
    // Successively swap alternating bit groups.
    val = ((val >> 1) & 0x55555555) + ((val << 1) & ~0x55555555);
    val = ((val >> 2) & 0x33333333) + ((val << 2) & ~0x33333333);
    val = ((val >> 4) & 0x0f0f0f0f) + ((val << 4) & ~0x0f0f0f0f);
    val = ((val >> 8) & 0x00ff00ff) + ((val << 8) & ~0x00ff00ff);
    return ((val >> 16) & 0x0000ffff) + ((val << 16) & ~0x0000ffff);
  }

  /**
   * Helper for converting unsigned numbers to String.
   *
   * @param num the number
   * @param exp log2(digit) (ie. 1, 3, or 4 for binary, oct, hex)
   */
  // Package visible for use by Long.
  static String toUnsignedString(int num, int exp)
  {
    // Use an array large enough for a binary number.
    int mask = (1 << exp) - 1;
    char[] buffer = new char[32];
    int i = 32;
    do
      {
        buffer[--i] = digits[num & mask];
        num >>>= exp;
      }
    while (num != 0);

    // Package constructor avoids an array copy.
    return new String(buffer, i, 32 - i); //, true);
  }

  /**
   * Helper for parsing ints, used by PBJInternInteger, Short, and Byte.
   *
   * @param str the string to parse
   * @param radix the radix to use, must be 10 if decode is true
   * @param decode if called from decode
   * @return the parsed int value
   * @throws NumberFormatException if there is an error
   * @throws NullPointerException if decode is true and str if null
   * @see #parseInt(String, int)
   * @see #decode(String)
   * @see Byte#parseByte(String, int)
   * @see Short#parseShort(String, int)
   */
  static int parseInt(String str, int radix, boolean decode)
  {
    if (! decode && str == null)
      throw new NumberFormatException();
    int index = 0;
    int len = str.length();
    boolean isNeg = false;
    if (len == 0)
      throw new NumberFormatException("string length is null");
    int ch = str.charAt(index);
    if (ch == '-')
      {
        if (len == 1)
          throw new NumberFormatException("pure '-'");
        isNeg = true;
        ch = str.charAt(++index);
      }
    if (decode)
      {
        if (ch == '0')
          {
            if (++index == len)
              return 0;
            if ((str.charAt(index) & ~('x' ^ 'X')) == 'X')
              {
                radix = 16;
                index++;
              }
            else
              radix = 8;
          }
        else if (ch == '#')
          {
            radix = 16;
            index++;
          }
      }
    if (index == len)
      throw new NumberFormatException("non terminated number: " + str);

    int max = MAX_VALUE / radix;
    // We can't directly write `max = (MAX_VALUE + 1) / radix'.
    // So instead we fake it.
    if (isNeg && MAX_VALUE % radix == radix - 1)
      ++max;

    int val = 0;
    while (index < len)
      {
	if (val < 0 || val > max)
	  throw new NumberFormatException("number overflow (pos=" + index + ") : " + str);

        ch = Character.digit(str.charAt(index++), radix);
        val = val * radix + ch;
        if (ch < 0 || (val < 0 && (! isNeg || val != MIN_VALUE)))
          throw new NumberFormatException("invalid character at position " + index + " in " + str);
      }
    return isNeg ? -val : val;
  }

  private static void setBounds(LogProblem problem, int min, int max) {
      if (LogMap.SolverOpt_debug2)
	  System.out.println("setting Ints.MIN_VALUE= " + min + " Ints.MAX_VALUE=" + max);
      MIN_VALUE = min;
      MAX_VALUE = max;
      if (problem != null) {
	  int i;
	  for(i=min;i<=max;i++) {
	      int i_log = log(i);
	      problem.put1p(i,i_log);
	      problem.put2(i_log,i);
	  }
      }
  }

  public static void setBitWidth(LogProblem problem, int bw) {
      if (bw >= 8 || (LogMap.SolverOpt_NaturalIntsOnly && bw >= 7) || (!LogMap.SolverOpt_IncludeCharType && bw > 2)) {
	  int b = 2 << (bw-2);
	  if (LogMap.SolverOpt_NaturalIntsOnly)	      
	      setBounds(problem, 0, 2 * b - 1);
	  else
	      setBounds(problem, -1 * b, b - 1);
      } else {
	  System.out.println("bit width < 8 not allowed due to the inclusion of char type!");
	  System.exit(-1);
      }
	  
  }

  // PBJInternInteger class init

  public PBJInternInteger old;
  public Object fallback_field_result;
  public Object[] fallback_field_resultArray;
  public void fallback_updateField(java.lang.reflect.Method m, Object[] args) { }
  public Object fallback_newInstance(java.lang.reflect.Constructor cons, Object[] args, String[] typeParamNames) { return null; }
  public Object fallback_setTypeArgs(String[] typeParamNames) { return this; }
  public void fallback_field_result(Object r) { this.fallback_field_result = r; }
  public void fallback_field_resultArray(Object[] r) { this.fallback_field_resultArray = r; }

  public PBJInternInteger old() { 
      return old; 
  }

  public boolean isOld() { 
      return old == null;
  }

  public void fallback_atomize(LogProblem p, //String type, 
			       String typeArgsStr, String[] typeArgs) { }
  public void fallback_relationizeOld(LogProblem p, //String type, 
				      String typeArgsStr, String[] typeArgs) { }
  public boolean verifyInvariants() { return true; }
  public PBJInternInteger fallback_clone() { return this; }


  public static int BoundsSize() {
      return  MAX_VALUE - MIN_VALUE + 1;
  }
  
  public static PBJInternList<Integer> range(int l, int u) {
      PBJInternList<Integer> res = new PBJInternList<Integer>();
      for(int i=l;i<=u;i++) {
	  res.add(new Integer(i));
      }
      return res;
  }

  public static int bitWidth() {
      return LogMap.SolverOpt_IntBitWidth;

  }

  public static int log(int num) {
      return num;
  }
  
  public static LogExpr zeroTo_log(LogProblem problem, int n) {

      Bounds bounds = problem.problemBounds();
      TupleFactory factory = problem.problemFactory();

      Relation Idxs = Relation.unary("Idxs");
      TupleSet Idxs_upper = factory.noneOf(1);

      for(int i=0;i<n;i++) {
	  Object ti = log(i);
	  Idxs_upper.add(factory.tuple(ti));
      }
      bounds.boundExactly(Idxs, Idxs_upper);

      return new LogExpr(problem, Idxs);
  }

  public static LogExpr allInstances_log(LogProblem problem) {
      return problem.ints_log();
  }

  //FIXME
  public static LogExpr range_log(LogProblem problem,  LogExpr fallback_target,
				  String fallback_targetTypeArgsStr,
				  String[] fallback_targetTypeArgs,
				  boolean fallback_target_isOld,
				  LogExpr l, boolean b1, LogExpr u, boolean b2) {
      Variable v1 = Variable.unary("p");      
      Decls d1 = v1.oneOf(problem.ints_log().expr());
      Expression e = v1.sum().gte(l.intExpr()).and(v1.sum().lte(u.intExpr())).comprehension(d1);
      return new LogExpr(problem, e);
  }

  public static PBJInternList<Integer> allInstances() {
      return range(MIN_VALUE,MAX_VALUE);
  }


  public static PBJInternList<Integer> allInstances(int l, int u) {
      return range(l,u);
  }
  
}
