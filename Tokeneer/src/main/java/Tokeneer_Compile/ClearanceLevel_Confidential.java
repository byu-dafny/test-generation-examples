// Class ClearanceLevel_Confidential
// Dafny class ClearanceLevel_Confidential compiled into Java
package Tokeneer_Compile;


@SuppressWarnings({"unchecked", "deprecation"})
public class ClearanceLevel_Confidential extends ClearanceLevel {
  public ClearanceLevel_Confidential () {
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null) return false;
    if (getClass() != other.getClass()) return false;
    ClearanceLevel_Confidential o = (ClearanceLevel_Confidential)other;
    return true;
  }
  @Override
  public int hashCode() {
    long hash = 5381;
    hash = ((hash << 5) + hash) + 0;
    return (int)hash;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Tokeneer_Compile.ClearanceLevel.Confidential");
    return s.toString();
  }
}
