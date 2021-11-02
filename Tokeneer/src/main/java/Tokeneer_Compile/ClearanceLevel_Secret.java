// Class ClearanceLevel_Secret
// Dafny class ClearanceLevel_Secret compiled into Java
package Tokeneer_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class ClearanceLevel_Secret extends ClearanceLevel {
  public ClearanceLevel_Secret () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ClearanceLevel_Secret o = (ClearanceLevel_Secret)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 1;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Tokeneer_Compile.ClearanceLevel.Secret");
    return s.toString();
  }
}
