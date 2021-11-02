// Class ClearanceLevel_TopSecret
// Dafny class ClearanceLevel_TopSecret compiled into Java
package Tokeneer_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class ClearanceLevel_TopSecret extends ClearanceLevel {
  public ClearanceLevel_TopSecret () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ClearanceLevel_TopSecret o = (ClearanceLevel_TopSecret)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 2;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Tokeneer_Compile.ClearanceLevel.TopSecret");
    return s.toString();
  }
}
