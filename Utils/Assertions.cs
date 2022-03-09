namespace Utils_Compile { // change as needed

  public partial class Assertions {
    public Assertions() {
    }

    public static void assertEquals<T>(T a, T b) {
      Xunit.Assert.Equal(a, b);
    }

    public static void expectEquals<T>(T a, T b) {
      Xunit.Assert.Equal(a, b);
    }

    public static void assertNotEquals<T>(T a, T b) {
      Xunit.Assert.NotEqual(a, b);
    }

    public static void expectNotEquals<T>(T a, T b) {
      Xunit.Assert.NotEqual(a, b);
    }

    public static void assertTrue(bool condition) {
      Xunit.Assert.True(condition);
    }

    public static void expectTrue(bool condition) {
      Xunit.Assert.True(condition);
    }

    public static void assertFalse(bool condition) {
      Xunit.Assert.False(condition);
    }

    public static void expectFalse(bool condition) {
      Xunit.Assert.False(condition);
    }
  }
}