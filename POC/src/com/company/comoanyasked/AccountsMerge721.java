package com.company.comoanyasked;

import java.util.*;

public class AccountsMerge721 {

    public static void main(String[] args) {
        AccountsMerge721 accountsMerge721 = new AccountsMerge721();

        List<List<String>> imput = new ArrayList<>();
        imput.add(Arrays.asList("John","johnsmith@mail.com","john_newyork@mail.com"));
        imput.add(Arrays.asList("John","johnsmith@mail.com","john00@mail.com"));
        imput.add(Arrays.asList("Mary","mary@mail.com"));
        imput.add(Arrays.asList("John","johnnybravo@mail.com"));
        accountsMerge721.accountsMerge(imput);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        DisjointSet ds = new DisjointSet();
        Map<String , Integer> map = new HashMap<>();

        for(List<String> list: accounts) {

            String parent = list.get(0);
            Node n= null;
            if(map.get(parent) == null) {
                n = ds.makeSet(parent+"#0");
                map.put(parent, 0);
            }else{
                boolean common = false;
                for(int i=1;i< list.size();i++)  {
                    if(ds.isNodeExists(list.get(i))) {
                        n = ds.getParent(list.get(i));
                        common = true;
                        break;
                    }
                }
                if(!common){
                    map.put(parent, map.get(parent)+1);
                    n = ds.makeSet(parent+"#"+map.get(parent));
                }

            }

            for(int i=1;i< list.size();i++) {
                Node child = ds.makeSet(list.get(i));
                ds.connect(child, n);
            }
        }

        List<List<String>> result = new ArrayList<>();

        for(String s: map.keySet()) {
            for(int i=0;i<=map.get(s);i++) {
                List<String> t = new ArrayList();
                t.add(s);
                Set<String> temp = ds.getChildren(s+"#"+i);
                t.addAll(temp);
                result.add(t);
            }
        }

        return result;
    }

    class DisjointSet{
        Map<String,Node> map = new HashMap();
        Map<String, Set<String>> childrens = new HashMap();

        Node makeSet(String str) {
            if(map.get(str) != null) return map.get(str);
            Node n = new Node();
            n.id =str;
            n.parent = n;
            map.put(str, n);
            return n;
        }

        void connect(Node child, Node parent) {
            child.parent = parent;
            Set<String> temp = childrens.get(parent.id);
            if(temp == null) {
                temp = new HashSet<>();
            }
            temp.add(child.id);
            childrens.put(parent.id, temp);
        }

        Set<String> getChildren(String str){
            return childrens.get(str);
        }

        Node getParent(String str) {
            Node n = map.get(str);
            if( n == null){
                return null;
            }else{
                return getParent(n);
            }
        }

        Node getParent(Node n) {
            if(n.parent == n){
                return n;
            }else{
                return getParent(n.parent);
            }
        }

        boolean isNodeExists(String str) {
            return map.get(str) != null;
        }

    }

    class Node {
        String id;
        Node parent;
    }
}
