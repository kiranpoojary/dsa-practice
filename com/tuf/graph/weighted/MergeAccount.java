package com.tuf.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeAccount {

    public static ArrayList<ArrayList<String>> mergAccounts(ArrayList<ArrayList<String>> accountInfo) {
        int n = accountInfo.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String, Integer> emailNodeMapper = new HashMap<>();
        for (int i = 0; i < accountInfo.size(); i++) {
            for (int j = 1; j < accountInfo.get(i).size(); j++) {
                if (emailNodeMapper.containsKey(accountInfo.get(i).get(j))) {
                    ds.unionByRank(i, emailNodeMapper.get(accountInfo.get(i).get(j)));
                } else {
                    emailNodeMapper.put(accountInfo.get(i).get(j), i);
                }
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++)
            mergedMail[i] = new ArrayList<String>();
        for (Map.Entry<String, Integer> it : emailNodeMapper.entrySet()) {
            String mail = it.getKey();
            int node = ds.findUPar(it.getValue());
            mergedMail[node].add(mail);
        }

        ArrayList<ArrayList<String>> mergedAccountInfo = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0)
                continue;
            Collections.sort(mergedMail[i]);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(accountInfo.get(i).get(0));
            for (String it : mergedMail[i]) {
                temp.add(it);
            }
            mergedAccountInfo.add(temp);
        }
        return mergedAccountInfo;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        accounts.add(new ArrayList<>(Arrays.asList("john", "j1@gmail.com", "j2@gmail.com", "j3@gmail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("john", "j4@gmail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("raj", "r1@gmail.com", "r2@gmail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("john", "j1@gmail.com", "j5@gmail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("raj", "r2@gmail.com", "r3@gmail.com")));
        accounts.add(new ArrayList<>(Arrays.asList("mery", "m1@gmail.com")));
        System.out.println("Merged Accounts   :" + MergeAccount.mergAccounts(accounts));
    }
}
