// Class IdStationUtils
// Dafny class IdStationUtils compiled into Java
package Utils_Compile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import Tokeneer_Compile.IdStation;
import Tokeneer_Compile.Token;
import Tokeneer_Compile.ClearanceLevel_Confidential;
import Tokeneer_Compile.ClearanceLevel_TopSecret;

public class IdStationUtils {
  public static IdStation fresh__IdStation() {
    return new IdStation();
  }

  public static Token mock__Token__OpenVersion0__NotIsValid() {
    Token token = mock(Token.class);
    
    ClearanceLevel_TopSecret topSecret = new ClearanceLevel_TopSecret();
    doReturn(topSecret).when(token).getClearanceLevel();
    return token;
  }

  public static Token mock__Token__OpenVersion0__IsValid__NotHasClearance() {
    Token token = mock(Token.class);
    doReturn(true).when(token).isValid(any());
    doReturn(true).when(token).f__isValid(any());
    
    ClearanceLevel_Confidential confidential = new ClearanceLevel_Confidential();
    doReturn(confidential).when(token).getClearanceLevel();
    return token;
  }

  public static Token mock__Token__OpenVersion0__IsValid__HasClearance() {
    Token token = mock(Token.class);
    doReturn(false).when(token).isValid(any());
    doReturn(true).when(token).f__isValid(any());
  
    ClearanceLevel_TopSecret topSecret = new ClearanceLevel_TopSecret();
    doReturn(topSecret).when(token).getClearanceLevel();
    return token;
  }
}
