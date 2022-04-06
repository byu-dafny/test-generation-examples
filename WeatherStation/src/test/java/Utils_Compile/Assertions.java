// Class Assertions
// Dafny class Assertions compiled into Java
package Utils_Compile;

import Extern_Compile.*;

@SuppressWarnings({"unchecked", "deprecation"})
public class Assertions<T> {
  private dafny.TypeDescriptor<T> _td_T;
  public Assertions(dafny.TypeDescriptor<T> _td_T) {
    this._td_T = _td_T;
  }
  public static <T> dafny.TypeDescriptor<Assertions<T>> _typeDescriptor(dafny.TypeDescriptor<T> _td_T) {
    return (dafny.TypeDescriptor<Assertions<T>>) (dafny.TypeDescriptor<?>) dafny.TypeDescriptor.referenceWithInitializer(Assertions.class, () -> (Assertions<T>) null);
  }
}
