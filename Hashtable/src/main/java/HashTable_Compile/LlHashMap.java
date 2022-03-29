// Class LlHashMap
// Dafny class LlHashMap compiled into Java
package Hashtable_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class LlHashMap {
  public LlHashMap() {
    this.buffer = new ListNode[0];
    this.size = java.math.BigInteger.ZERO;
  }
  public ListNode[] buffer;
  public java.math.BigInteger size;
  public void __ctor(java.math.BigInteger nrBuckets)
  {
    ListNode[] _nw2 = (ListNode[]) ListNode._typeDescriptor().newArray(dafny.Helpers.toIntChecked((nrBuckets), "Java arrays may be no larger than the maximum 32-bit signed int"));
    java.util.function.Function<java.math.BigInteger, ListNode> _arrayinit0 = ((java.util.function.Function<java.math.BigInteger, ListNode>)(_60___v0) -> {
      return (ListNode) null;
    });
    for (java.math.BigInteger _arrayinit_00 = java.math.BigInteger.ZERO; _arrayinit_00.compareTo(java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength(_nw2))) < 0; _arrayinit_00 = _arrayinit_00.add(java.math.BigInteger.ONE)) {
      _nw2[dafny.Helpers.toInt(_arrayinit_00)] = _arrayinit0.apply(_arrayinit_00);
    }
    (this).buffer = _nw2;
    (this).size = java.math.BigInteger.ZERO;
  }
  public void put(java.math.BigInteger key, java.math.BigInteger value)
  {
    java.math.BigInteger _61_index = java.math.BigInteger.ZERO;
    java.math.BigInteger _out1 = java.math.BigInteger.ZERO;
    _out1 = (this).hashOf(key);
    _61_index = _out1;
    if (((this.buffer)[(dafny.Helpers.toInt((_61_index)))]) == (Object)  ((ListNode) null)) {
      ListNode[] _arr0 = this.buffer;
      ListNode _nw3 = new ListNode();
      _nw3.__ctor(key, value);
      _arr0[dafny.Helpers.toInt(((_61_index)).intValue())] = _nw3;
      (this).size = (this.size).add((java.math.BigInteger.ONE));
    } else {
      ListNode _62_el;
      ListNode _out2;
      _out2 = ((this.buffer)[(dafny.Helpers.toInt((_61_index)))]).insert(key, value);
      _62_el = _out2;
      if ((_62_el) != (Object)  ((ListNode) null)) {
        (this).size = (this.size).add((java.math.BigInteger.ONE));
      }
    }
  }
  public ListNode find(java.math.BigInteger key)
  {
    ListNode out = (ListNode) null;
    java.math.BigInteger _63_index = java.math.BigInteger.ZERO;
    java.math.BigInteger _out3 = java.math.BigInteger.ZERO;
    _out3 = (this).hashOf(key);
    _63_index = _out3;
    ListNode _64_el;
    _64_el = (this.buffer)[(dafny.Helpers.toInt((_63_index)))];
    if (((_64_el) == (Object)  ((ListNode) null)) || (java.util.Objects.equals(_64_el.entry.key, key))) {
      out = _64_el;
      return out;
    }
    while (((_64_el.next) != (Object)  ((ListNode) null)) && (!java.util.Objects.equals(_64_el.next.entry.key, key))) {
      _64_el = _64_el.next;
    }
    out = _64_el;
    return out;
  }
  public boolean contains(java.math.BigInteger key)
  {
    boolean out = false;
    if(true) {
      ListNode _65_node;
      ListNode _out4;
      _out4 = (this).find(key);
      _65_node = _out4;
      out = (_65_node) != (Object)  ((ListNode) null);
    }
    return out;
  }
  public Integer get(java.math.BigInteger key)
  {
    Integer out = (Integer) null;
    if(true) {
      ListNode _66_found;
      ListNode _out5;
      _out5 = (this).find(key);
      _66_found = _out5;
      if ((_66_found) == (Object)  ((ListNode) null)) {
        out = (Integer) null;
        return out;
      } else {
        Integer _nw4 = new Integer();
        _nw4.__ctor(_66_found.entry.value);
        out = _nw4;
        return out;
      }
    }
    return out;
  }
  public java.math.BigInteger abs__f(java.math.BigInteger key) {
    return dafny.DafnyEuclidean.EuclideanModulus(((((key).signum() != -1) ? (java.math.BigInteger.ONE) : (java.math.BigInteger.valueOf(-1L)))).multiply((key)), java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((this.buffer))));
  }
  public java.math.BigInteger Abs(java.math.BigInteger x)
  {
    java.math.BigInteger y = java.math.BigInteger.ZERO;
    if ((x).signum() == -1) {
      y = (java.math.BigInteger.ZERO).subtract((x));
      return y;
    }
    y = x;
    return y;
  }
  public java.math.BigInteger hashOf(java.math.BigInteger key)
  {
    java.math.BigInteger out = java.math.BigInteger.ZERO;
    if(true) {
      java.math.BigInteger _67_new__key = java.math.BigInteger.ZERO;
      java.math.BigInteger _out6 = java.math.BigInteger.ZERO;
      _out6 = (this).Abs(key);
      _67_new__key = _out6;
      out = dafny.DafnyEuclidean.EuclideanModulus(_67_new__key, java.math.BigInteger.valueOf(java.lang.reflect.Array.getLength((this.buffer))));
    }
    return out;
  }
  private static final dafny.TypeDescriptor<LlHashMap> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(LlHashMap.class, () -> (LlHashMap) null);
  public static dafny.TypeDescriptor<LlHashMap> _typeDescriptor() {
    return (dafny.TypeDescriptor<LlHashMap>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
