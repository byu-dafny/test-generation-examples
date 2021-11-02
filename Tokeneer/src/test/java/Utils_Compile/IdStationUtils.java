// Class IdStationUtils
// Dafny class IdStationUtils compiled into Java
package Utils_Compile;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import Tokeneer_Compile.IdStation;
import Tokeneer_Compile.Token;
import Tokeneer_Compile.ClearanceLevel_TopSecret;

public class IdStationUtils {
  public static IdStation fresh__IdStation() {
    return new IdStation();
  }

  public static Token mock__Token__OpenVersion0__NotIsValid() {
    Token token = mock(Token.class);
    when(token.isValid(any())).thenReturn(true);
    when(token.isMatch(any())).thenReturn(true);

    ClearanceLevel_TopSecret topSecret = new ClearanceLevel_TopSecret();
    when(token.getClearanceLevel()).thenReturn(topSecret);
    return token;
  }
}
