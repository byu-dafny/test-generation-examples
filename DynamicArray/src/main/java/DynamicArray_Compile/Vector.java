// Class Vector
// Dafny class Vector compiled into Java
package DynamicArray_Compile;

import NativeTypes_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Vector<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public Vector(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
    this.buffer = (Object) _td_T.newArray(0);
    this.current__capacity = 0;
    this.current__size = 0;
  }
  public java.lang.Object buffer;
  public int current__capacity;
  public int current__size;
  public int get__size()
  {
    int x = 0;
    x = this.current__size;
    return x;
  }
  public T at__index(int index)
  {
    @SuppressWarnings({"unchecked", "deprecation"})
    T x = null;
    x = _td_T.getArrayElement((this.buffer), (index));
    return x;
  }
  public void extend__buffer(T value)
  {
    if (Integer.compareUnsigned(this.current__capacity, Integer.divideUnsigned(NativeTypes_Compile.__default.UINT32__MAX(), 2)) >= 0) {
      Extern.fatal(dafny.DafnySequence.asString("at max capacity"));
      return;
    }
    java.lang.Object _154_old__buffer;
    _154_old__buffer = this.buffer;
    int _155_old__size;
    _155_old__size = this.current__capacity;
    (this).current__capacity = (int)  ((_155_old__size) * (2));
    java.lang.Object _out0;
    _out0 = Extern.<T>newArrayFill(_td_T, this.current__capacity, value);
    (this).buffer = _out0;
    int _156_i;
    _156_i = 0;
    goto_0: {
      while (Integer.compareUnsigned(_156_i, _155_old__size) < 0) {
        java.lang.Object _arr0 = this.buffer;
        _td_T.setArrayElement(_arr0, (_156_i),_td_T.getArrayElement((_154_old__buffer), (_156_i)));
        if ((_156_i) == ((int)  ((_155_old__size) - (1)))) {
          break goto_0;
        }
        _156_i = (int)  ((_156_i) + (1));
      }
    }
  }
  public void push__back(T value)
  {
    if (((int)  ((this.current__size) + (1))) == (this.current__capacity)) {
      (this).extend__buffer(value);
    }
    java.lang.Object _arr1 = this.buffer;
    int _index0 = this.current__size;
    _td_T.setArrayElement(_arr1, _index0,value);
    (this).current__size = (int)  ((this.current__size) + (1));
  }
  public void clear()
  {
    (this).current__size = 0;
  }
  public void __ctor(T default__val)
  {
    (this).current__size = 0;
    (this).current__capacity = Vector.<T>DEFAULT__SIZE(_td_T);
    java.lang.Object _out1;
    _out1 = Extern.<T>newArrayFill(_td_T, Vector.<T>DEFAULT__SIZE(_td_T), default__val);
    (this).buffer = _out1;
  }
  public static <T> int DEFAULT__SIZE(dafny.TypeDescriptor<T> _td_T) {
    return 16;
  }
  public static <T> dafny.TypeDescriptor<Vector<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<Vector<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(Vector.class, () -> (Vector<T>) null);
  }
}
