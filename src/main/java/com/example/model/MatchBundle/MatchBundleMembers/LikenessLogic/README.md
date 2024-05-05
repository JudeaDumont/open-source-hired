DirectlyAlikePhrasesLogic Chains together conditional 
logic for match, miss, or superfluous

this makes more sense than say, abstracting all three methods into MatchInformation
and making MatchInformation an abstract class
that needs those three methods implemented. 

that would be unnecessary.

this is also alot more convenient for making new matching logics, 

all you have to do is copy all the files in the top level directory "LikenessLogic"

Into a new directory "someothertypeoflogic"

and redefine the matching logic and conditions therein, then, make another MatchInformation
Container in the matchBundles members to house those statistics.
