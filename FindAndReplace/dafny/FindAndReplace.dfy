module FindAndReplace {

    export  
        reveals verify
        provides findAndReplace, findAndReplace2

    function verify(str:string, toFind:string, toReplace:string) : string 
    requires |toFind| > 0
    decreases str
    {
        if |str| < |toFind| 
        then
            str 
        else 
            if str[..|toFind|] == toFind 
            then
                toReplace + verify(str[|toFind|..], toFind, toReplace)
            else
                str[..1] + verify(str[1..], toFind, toReplace)
    }

    method findAndReplace(str : string, toFind : string, toReplace : string) returns (newString : string)
    requires |toFind| > 0
    ensures newString == verify(str, toFind, toReplace)
    decreases str
    {
        if (|str| < |toFind|)
        {
            return str;
        }

        if (toFind <= str)
        {
            var result := findAndReplace(str[|toFind|..], toFind, toReplace);
            return toReplace + result;
        }
        else
        {
            var result := findAndReplace(str[1..], toFind, toReplace);
            return str[..1] + result;
        }
        
    }

    method findAndReplace2(str:string, toFind:string, toReplace:string) returns (newString:string)
    requires |toFind| > 0
    ensures newString == verify(str, toFind, toReplace)
    {
        newString := "";
        var i := 0;
        while (i < |str|) 
        invariant i <= |str|
        invariant newString == verify(str[..i], toFind, toReplace) //TODO: fix invariant violation
        decreases |str| - i
        {
            if( toFind <= str[i..]) {
                newString := newString + toReplace;
                i := i + |toFind|;
            }
            else {
                var next := str[i..i+1];
                newString := newString + next;
                i := i + 1;
            }
        }
        return newString;
    }
}























    //     // change to function
    // predicate verify(newstr : string, str : string, toFind : string, toReplace : string)
    // requires |toFind| > 0
    // decreases newstr, str
    // {
    //     if (|newstr| == 0 || |str| < |toFind| || |newstr| < |toReplace|)
    //     then newstr == str
    //     else    if (str[..|toFind|] == toFind)
    //             then 
    //                 newstr[..|toReplace|] == toReplace && 
    //                 verify(newstr[|toReplace|..], str[|toFind|..], toFind, toReplace)
    //             else 
    //                 newstr[0] == str[0] && 
    //                 verify(newstr[1..], str[1..], toFind, toReplace)
    // }












    // predicate verify(newstr : string, str : string, toFind : string, toReplace : string)
    // requires |toFind| > 0
    // decreases newstr, str
    // {
    //     if (|str| == 0  || |newstr| == 0)
    //     then true
    //     else    if (|str| < |toFind| || |newstr| < |toReplace|)
    //             then newstr == str
    //             else    if (str[..|toFind|] == toFind)
    //                     then newstr[..|toReplace|] == toReplace && verify(newstr[|toReplace|..], str[|toFind|..], toFind, toReplace)
    //                     else newstr[0] == str[0] && verify(newstr[1..], str[1..], toFind, toReplace)
    // }
