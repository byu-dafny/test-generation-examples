include "FindAndReplace.dfy"
include "Utils.dfy"

module FindAndReplaceTests {

    import opened FindAndReplace
    import opened Utils

    class FindAndReplaceTests {

        method {:test "JUnit5"} test_findAndReplace_should_replaceWordInMiddleOfStr()
        {
            var str := "tis";
            var toFind := "is";
            var toReplace := "was";

            var witnessValue := "ah";

            assert witnessValue != toFind;
            JUnit5.assertNotEquals(witnessValue, toFind);

            var result := findAndReplace(str, toFind, toReplace);

            var oracleValue := "twas";

            assert result == oracleValue;
            JUnit5.assertEquals(result, oracleValue);
        }
    }
}






























    // method findAndReplace_should_replaceWordInMiddleOfStr()
    // {
    //     var str := "i is";
    //     var toFind := "is";
    //     var toReplace := "was";

    //     assert !(|str| == 0 || |str| < |toFind|);
    //     assert str[..|toFind|] == "i ";
    //     assert str[..|toFind|] != toFind;
    //     assert str[0..1] == "i";

    //     var str_it2 := str[1..];
        
    //     assert  !(|str_it2| == 0 || |str_it2| < |toFind|);
    //     assert str_it2[..|toFind|] == " i";
    //     assert str_it2[..|toFind|] != toFind;
    //     assert str_it2[0..1] == " ";

    //     var str_it3 := str_it2[1..];

    //     assert !(|str_it3| == 0 || |str_it3| < |toFind|);
    //     assert (str_it3[..|toFind|] == toFind);

    //     var str_it4 := str_it3[|toFind|..];

    //     assert str_it4 == "";



    //     var result := findAndReplace(str, toFind, toReplace);
    //     assert result == "i was";
    //     //assert verify(result, str, toFind, toReplace);

    //     // assert verify("a", "a", "b", "d");
    //     // assert verify("it was time", "it is time", "is", "was");
    //     //assert verify("itistime", "it is time", " ", "");

    //     // var c := " x";
    //     // assert c[..1] == " ";

    //     // var newstr := " y";
    //     // var str := " x";
    //     // var toFind := "x";
    //     // assert str[..1] == " ";
    //     // var toReplace := "y";



    //     // assert verify(newstr, str, toFind, toReplace);















        //     var str := "ahell";
        // var newstr := "agood";
        // var toFind := "hell";
        // var toReplace := "good";

        // assert !(|str| == 0 || |newstr| == 0 || |str| < |toFind| || |newstr| < |toReplace|);
        // assert str[..|toFind|] == "ahel";
        // assert !(str[..|toFind|] == toFind);

        // assert verify(newstr, str, toFind, toReplace);