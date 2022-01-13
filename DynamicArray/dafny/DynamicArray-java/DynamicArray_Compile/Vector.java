// Class Vector
// Dafny class Vector compiled into Java
package DynamicArray_Compile;

import NativeTypes_Compile.*;
import Extern_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Vector<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public Vector(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
    this.buffer = (Object) _td_T.newArray(0);
    this.current__capacity = (short) 0;
    this.current__size = (short) 0;
  }
  public java.lang.Object buffer;
  public short current__capacity;
  public short current__size;
  public short get__size()
  {
    DafnyProfiling.CodeCoverage.Record(13);
    short x = (short) 0;
    x = this.current__size;
    return x;
  }
  public T at__index(short index)
  {
    DafnyProfiling.CodeCoverage.Record(14);
    @SuppressWarnings({"unchecked", "deprecation"})
    T x = null;
    x = _td_T.getArrayElement((this.buffer), (dafny.Helpers.unsignedToInt(index)));
    return x;
  }
  public void extend__buffer(T value)
  {
    DafnyProfiling.CodeCoverage.Record(15);
    if (Integer.compareUnsigned(this.current__capacity, dafny.Helpers.divideUnsignedShort(NativeTypes_Compile.__default.UINT16__MAX__JAVA(), (short) 2)) >= 0) {
      DafnyProfiling.CodeCoverage.Record(16);
      Extern.fatal(dafny.DafnySequence.asString("at max capacity"));
    } else {
      DafnyProfiling.CodeCoverage.Record(17);
    }
    java.lang.Object _102_old__buffer;
    _102_old__buffer = this.buffer;
    short _103_old__size;
    _103_old__size = this.current__capacity;
    (this).current__capacity = (short)((short) (short)  ((_103_old__size) * ((short) 2)));
    java.lang.Object _out0;
    _out0 = Extern_Compile.__default.<T>newArrayFill(_td_T, this.current__capacity, value);
    (this).buffer = _out0;
    short _104_i;
    _104_i = (short) 0;
    while (Integer.compareUnsigned(_104_i, _103_old__size) < 0) {
      DafnyProfiling.CodeCoverage.Record(18);
      java.lang.Object _arr0 = this.buffer;
      _td_T.setArrayElement(_arr0, dafny.Helpers.unsignedToInt((_104_i)),_td_T.getArrayElement((_102_old__buffer), (dafny.Helpers.unsignedToInt(_104_i))));
      _104_i = (short)((short) (short)  ((_104_i) + ((short) 1)));
    }
  }
  public void push__back(T value)
  {
    DafnyProfiling.CodeCoverage.Record(19);
    if (((short)((short) (short)  ((this.current__size) + ((short) 1)))) == (this.current__capacity)) {
      DafnyProfiling.CodeCoverage.Record(20);
      (this).extend__buffer(value);
    } else {
      DafnyProfiling.CodeCoverage.Record(21);
    }
    java.lang.Object _arr1 = this.buffer;
    short _index0 = this.current__size;
    _td_T.setArrayElement(_arr1, dafny.Helpers.unsignedToInt(_index0),value);
    (this).current__size = (short)((short) (short)  ((this.current__size) + ((short) 1)));
  }
  public void clear()
  {
    DafnyProfiling.CodeCoverage.Record(22);
    (this).current__size = (short) 0;
  }
  public void __ctor(T default__val)
  {
    DafnyProfiling.CodeCoverage.Record(23);
    (this).current__size = (short) 0;
    (this).current__capacity = Vector.<T>DEFAULT__SIZE(_td_T);
    java.lang.Object _out1;
    _out1 = Extern_Compile.__default.<T>newArrayFill(_td_T, Vector.<T>DEFAULT__SIZE(_td_T), default__val);
    (this).buffer = _out1;
  }
  public static <T> short DEFAULT__SIZE(dafny.TypeDescriptor<T> _td_T) {
    return (short) 16;
  }
  public static <T> dafny.TypeDescriptor<Vector<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<Vector<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(Vector.class, () -> (Vector<T>) null);
  }
}
