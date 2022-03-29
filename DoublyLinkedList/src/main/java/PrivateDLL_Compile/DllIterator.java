// Class DllIterator
// Dafny class DllIterator compiled into Java
package PrivateDLL_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class DllIterator<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public DllIterator(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
    this.ptr = (PrivateNode<T>) null;
    this.d = null;
  }
  public PrivateNode<T> ptr;
  public PrivateDoublyLinkedList<T> d;
  public void __ctor(PrivateDoublyLinkedList<T> d_k)
  {
    (this).d = d_k;
    (this).ptr = d_k.head;
  }
  public T GetVal()
  {
    @SuppressWarnings({"unchecked", "deprecation"})
    T v = null;
    v = this.ptr.payload;
    return v;
  }
  public boolean MoveNext()
  {
    boolean good = false;
    if(true) {
      (this).ptr = this.ptr.R;
      if ((this.ptr) != (Object)  ((PrivateNode<T>) null)) {
        good = true;
      } else {
        good = false;
      }
    }
    return good;
  }
  public <__T> void InsertBeforeIter(dafny.TypeDescriptor<__T> _td___T, PrivateDoublyLinkedList<__T> d, DllIterator<__T> iter, __T v)
  {
    if ((iter.ptr) == (Object)  (d.head)) {
      (d).InsertHead(v);
    } else {
      PrivateNode<__T> _545_x;
      PrivateNode<__T> _nw2 = new PrivateNode<__T>(_td___T);
      _nw2.__ctor(v);
      _545_x = _nw2;
      (_545_x).L = iter.ptr.L;
      (_545_x).R = iter.ptr;
      PrivateNode<__T> _obj6 = iter.ptr.L;
      _obj6.R = _545_x;
      PrivateNode<__T> _obj7 = iter.ptr;
      _obj7.L = _545_x;
    }
  }
  public <__T> boolean RemoveIter(dafny.TypeDescriptor<__T> _td___T, PrivateDoublyLinkedList<__T> d, DllIterator<__T> iter)
  {
    boolean good = false;
    if(true) {
      good = (iter.ptr.R) != (Object)  ((PrivateNode<__T>) null);
      PrivateNode<__T> _546_tmp;
      _546_tmp = iter.ptr.R;
      (d).Remove(iter.ptr);
      if (good) {
        (iter).ptr = _546_tmp;
      }
    }
    return good;
  }
  public static <T> dafny.TypeDescriptor<DllIterator<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<DllIterator<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(DllIterator.class, () -> (DllIterator<T>) null);
  }
}
