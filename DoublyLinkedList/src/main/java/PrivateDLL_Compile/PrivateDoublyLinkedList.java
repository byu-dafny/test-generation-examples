// Class PrivateDoublyLinkedList
// Dafny class PrivateDoublyLinkedList compiled into Java
package PrivateDLL_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class PrivateDoublyLinkedList<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public PrivateDoublyLinkedList(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
    this.head = (PrivateNode<T>) null;
    this.tail = (PrivateNode<T>) null;
  }
  public PrivateNode<T> head;
  public PrivateNode<T> tail;
  public void __ctor()
  {
    (this).head = (PrivateNode<T>) null;
    (this).tail = (PrivateNode<T>) null;
  }
  public boolean IsEmpty()
  {
    boolean b = false;
    if(true) {
      b = ((this.head) == (Object)  ((PrivateNode<T>) null)) && ((this.tail) == (Object)  ((PrivateNode<T>) null));
    }
    return b;
  }
  public void Remove(PrivateNode<T> x)
  {
    if (((x.L) == (Object)  ((PrivateNode<T>) null)) && ((x.R) == (Object)  ((PrivateNode<T>) null))) {
      (this).head = (PrivateNode<T>) null;
      (this).tail = (PrivateNode<T>) null;
    } else if ((x.L) == (Object)  ((PrivateNode<T>) null)) {
      PrivateNode<T> _obj0 = x.R;
      _obj0.L = (PrivateNode<T>) null;
      (this).head = x.R;
    } else if ((x.R) == (Object)  ((PrivateNode<T>) null)) {
      PrivateNode<T> _obj1 = x.L;
      _obj1.R = (PrivateNode<T>) null;
      (this).tail = x.L;
    } else {
      PrivateNode<T> _obj2 = x.R;
      _obj2.L = x.L;
      PrivateNode<T> _obj3 = x.L;
      _obj3.R = x.R;
    }
  }
  public T RemoveHead()
  {
    @SuppressWarnings({"unchecked", "deprecation"})
    T h = null;
    if(true) {
      h = this.head.payload;
      (this).Remove(this.head);
    }
    return h;
  }
  public T RemoveTail()
  {
    @SuppressWarnings({"unchecked", "deprecation"})
    T t = null;
    if(true) {
      t = this.tail.payload;
      (this).Remove(this.tail);
    }
    return t;
  }
  public void InsertHead(T v)
  {
    PrivateNode<T> _543_x;
    PrivateNode<T> _nw0 = new PrivateNode<T>(_td_T);
    _nw0.__ctor(v);
    _543_x = _nw0;
    if ((this.head) == (Object)  ((PrivateNode<T>) null)) {
      (this).head = _543_x;
      (this).tail = _543_x;
      (_543_x).L = (PrivateNode<T>) null;
      (_543_x).R = (PrivateNode<T>) null;
    } else {
      (_543_x).R = this.head;
      (_543_x).L = (PrivateNode<T>) null;
      PrivateNode<T> _obj4 = this.head;
      _obj4.L = _543_x;
      (this).head = _543_x;
    }
  }
  public void InsertTail(T v)
  {
    PrivateNode<T> _544_x;
    PrivateNode<T> _nw1 = new PrivateNode<T>(_td_T);
    _nw1.__ctor(v);
    _544_x = _nw1;
    if ((this.tail) == (Object)  ((PrivateNode<T>) null)) {
      (this).head = _544_x;
      (this).tail = _544_x;
      (_544_x).L = (PrivateNode<T>) null;
      (_544_x).R = (PrivateNode<T>) null;
    } else {
      (_544_x).L = this.tail;
      (_544_x).R = (PrivateNode<T>) null;
      PrivateNode<T> _obj5 = this.tail;
      _obj5.R = _544_x;
      (this).tail = _544_x;
    }
  }
  public T PeekHead()
  {
    @SuppressWarnings({"unchecked", "deprecation"})
    T v = null;
    if(true) {
      v = this.head.payload;
    }
    return v;
  }
  public T PeekTail()
  {
    @SuppressWarnings({"unchecked", "deprecation"})
    T v = null;
    if(true) {
      v = this.tail.payload;
    }
    return v;
  }
  public void Clear()
  {
    (this).head = (PrivateNode<T>) null;
    (this).tail = (PrivateNode<T>) null;
  }
  public static <T> dafny.TypeDescriptor<PrivateDoublyLinkedList<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<PrivateDoublyLinkedList<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(PrivateDoublyLinkedList.class, () -> (PrivateDoublyLinkedList<T>) null);
  }
}
