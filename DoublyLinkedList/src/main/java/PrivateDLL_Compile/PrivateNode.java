// Class PrivateNode
// Dafny class PrivateNode compiled into Java
package PrivateDLL_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class PrivateNode<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public PrivateNode(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
    this.L = (PrivateNode<T>) null;
    this.R = (PrivateNode<T>) null;
    this.payload = null;
  }
  public PrivateNode<T> L;
  public PrivateNode<T> R;
  public T payload;
  public void __ctor(T p)
  {
    (this).payload = p;
  }
  public static <T> dafny.TypeDescriptor<PrivateNode<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<PrivateNode<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(PrivateNode.class, () -> (PrivateNode<T>) null);
  }
}
