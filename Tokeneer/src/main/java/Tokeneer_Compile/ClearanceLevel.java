// Class ClearanceLevel
// Dafny class ClearanceLevel compiled into Java
package Tokeneer_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public abstract class ClearanceLevel {
  public ClearanceLevel() { }

  private static final ClearanceLevel theDefault = Tokeneer_Compile.ClearanceLevel.create_Confidential();
  public static ClearanceLevel Default() {
    return theDefault;
  }
  private static final dafny.TypeDescriptor<ClearanceLevel> _TYPE = dafny.TypeDescriptor.referenceWithInitializer(ClearanceLevel.class, () -> Default());
  public static dafny.TypeDescriptor<ClearanceLevel> _typeDescriptor() {
    return (dafny.TypeDescriptor<ClearanceLevel>) (dafny.TypeDescriptor<?>) _TYPE;
  }
  public static ClearanceLevel create_Confidential() {
    return new ClearanceLevel_Confidential();
  }
  public static ClearanceLevel create_Secret() {
    return new ClearanceLevel_Secret();
  }
  public static ClearanceLevel create_TopSecret() {
    return new ClearanceLevel_TopSecret();
  }
  public boolean is_Confidential() { return this instanceof ClearanceLevel_Confidential; }
  public boolean is_Secret() { return this instanceof ClearanceLevel_Secret; }
  public boolean is_TopSecret() { return this instanceof ClearanceLevel_TopSecret; }
  public static java.util.ArrayList<ClearanceLevel> AllSingletonConstructors() {
    java.util.ArrayList<ClearanceLevel> singleton_iterator = new java.util.ArrayList<>();
    singleton_iterator.add(new ClearanceLevel_Confidential());
    singleton_iterator.add(new ClearanceLevel_Secret());
    singleton_iterator.add(new ClearanceLevel_TopSecret());
    return singleton_iterator;
  }
}
