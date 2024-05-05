package com.example.model.MatchedBecause.Members;

public class AddLogic extends Json {
    protected AddLogic() {
    }

    public void Add(String cluster, String jd, String r) {
        //-> turns into -\u003e after being marshalled into json.
        ht.put(jd + " --- " + r,
                cluster
        );
    }
}
