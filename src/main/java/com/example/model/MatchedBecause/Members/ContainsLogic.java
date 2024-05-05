package com.example.model.MatchedBecause.Members;

public class ContainsLogic extends AddLogic {
    protected ContainsLogic() {
    }

    public boolean Contains(String j, String r) {
        return ht.containsKey(j + " --- " + r);
    }
}
