// Class DynamicArrayUtils
// Dafny class DynamicArrayUtils compiled into Java
package Utils_Compile;

import NativeTypes_Compile.*;
import DynamicArray_Compile.*;
import dafny.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class DynamicArrayUtils {
  public DynamicArrayUtils() {
  }
  private static final dafny.TypeDescriptor<DynamicArrayUtils> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(DynamicArrayUtils.class, () -> (DynamicArrayUtils) null);
  public static dafny.TypeDescriptor<DynamicArrayUtils> _typeDescriptor() {
    return (dafny.TypeDescriptor<DynamicArrayUtils>) (dafny.TypeDescriptor<?>) _TYPE;
  }

  public static <T> DynamicArray_Compile.Vector<T> fresh__DynamicArray(dafny.TypeDescriptor<T> _td_T, T t)
  {
    DynamicArray_Compile.Vector<T> vector = null;
    DynamicArray_Compile.Vector<T> _nw1 = new DynamicArray_Compile.Vector<T>(_td_T);
    _nw1.__ctor(t);
    vector = _nw1;
    return vector;
  }
}
