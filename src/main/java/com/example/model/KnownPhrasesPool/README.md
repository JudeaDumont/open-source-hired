It is recommended you set your own keyphrase pool using something like this:

        String result = PostToKeyPoolConfigurationEndPoint.postToKeyPoolConfigurationEndPoint(
                readResourceAsString("testdata/V2TechMatcher/AffirmBase/Affirm1LinePool1LineJD1LineResumeTest1/p.json")
        );

Add keywords via category files or json files.

Json files are pulled in automatically

as long as they are in
C:\dev\repos\mine\open-source-hired\src\main\java\com\example\model\keywordchecker\V2\KeyPool\Pool\json-pool

and code based files need to be included via loadKeyPhraseCode()

