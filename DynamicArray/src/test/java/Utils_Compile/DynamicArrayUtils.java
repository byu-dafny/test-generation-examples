// Class DynamicArrayUtils
// Dafny class DynamicArrayUtils compiled into Java
package Utils_Compile;

import NativeTypes_Compile.*;
import Extern_Compile.*;
import DynamicArray_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamicArrayUtils<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public DynamicArrayUtils(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
  }
  public static <T> DynamicArray_Compile.Vector<T> fresh__DynamicArray(dafny.TypeDescriptor<T> _td_T, T t)
  {
    DynamicArray_Compile.Vector<T> vector = null;
    DynamicArray_Compile.Vector<T> _nw1 = new DynamicArray_Compile.Vector<T>(_td_T);
    _nw1.__ctor(t);
    vector = _nw1;
    return vector;
  }
  public static <T> dafny.TypeDescriptor<DynamicArrayUtils<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<DynamicArrayUtils<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(DynamicArrayUtils.class, () -> (DynamicArrayUtils<T>) null);
  }
}
