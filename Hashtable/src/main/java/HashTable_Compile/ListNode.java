// Class ListNode
// Dafny class ListNode compiled into Java
package Hashtable_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class ListNode {
  public ListNode() {
    this.next = (ListNode) null;
    this.entry = null;
    this.size = java.math.BigInteger.ZERO;
  }
  public ListNode next;
  public HashEntry entry;
  public java.math.BigInteger size;
  public void __ctor(java.math.BigInteger key, java.math.BigInteger val)
  {
    (this).next = (ListNode) null;
    HashEntry _nw0 = new HashEntry();
    _nw0.__ctor(key, val);
    (this).entry = _nw0;
    (this).size = java.math.BigInteger.ONE;
  }
  public ListNode insert(java.math.BigInteger key, java.math.BigInteger value)
  {
    ListNode node = null;
    if(true) {
      ListNode _nw1 = new ListNode();
      _nw1.__ctor(key, value);
      node = _nw1;
      (node).next = this;
      (node).size = (this.size).add((java.math.BigInteger.ONE));
    }
    return node;
  }
  public java.math.BigInteger listSize()
  {
    java.math.BigInteger size = java.math.BigInteger.ZERO;
    if(true) {
      size = this.size;
    }
    return size;
  }
  public boolean contains(java.math.BigInteger key)
  {
    ListNode _this = this;
    TAIL_CALL_START: while (true) {
      boolean out = false;
      if(true) {
        if (java.util.Objects.equals(_this.entry.key, key)) {
          out = true;
          return out;
        }
        if ((_this.next) == (Object)  ((ListNode) null)) {
          out = false;
          return out;
        }
        ListNode _in0 = _this.next;
        java.math.BigInteger _in1 = key;
        _this = _in0;
        key = _in1;
        continue TAIL_CALL_START;
      }
      return out;
    }
  }
  public boolean containedBy(ListNode other)
  {
    ListNode _this = this;
    TAIL_CALL_START: while (true) {
      boolean out = false;
      if(true) {
        if ((other) == (Object)  ((ListNode) null)) {
          out = false;
          return out;
        }
        boolean _59_other__contains;
        boolean _out0;
        _out0 = (other).contains(_this.entry.key);
        _59_other__contains = _out0;
        if (!(_59_other__contains)) {
          out = false;
          return out;
        }
        if ((_this.next) == (Object)  ((ListNode) null)) {
          out = true;
          return out;
        }
        ListNode _in2 = _this.next;
        ListNode _in3 = other;
        _this = _in2;
        other = _in3;
        continue TAIL_CALL_START;
      }
      return out;
    }
  }
  private static final dafny.TypeDescriptor<ListNode> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ListNode.class, () -> (ListNode) null);
  public static dafny.TypeDescriptor<ListNode> _typeDescriptor() {
    return (dafny.TypeDescriptor<ListNode>) (dafny.TypeDescriptor<?>) _TYPE;
  }
}
