package com.company.secondchapter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by zzy on 18-9-20.
 */
public class Airbnb {


    static List<String> evaluateActions(List<String> actions) {

        if(actions==null||actions.size()==0) return null;

        String support="Support";
        String hold="Hold";
        String move="Move";
        Map<String,List<String>> locationArmyMap=new HashMap<>();
        Map<String,String> armyLocationMap=new HashMap<>();
        Map<String,Integer> armyLife=new HashMap<>();

        List<String> armys=new ArrayList<>();

        List<String> moveActions=new ArrayList();
        List<String> supportActions=new ArrayList();
        List<String> holdActions=new ArrayList();
        int len=actions.size();
       for(String action: actions){
           if(action.contains(move)){
               moveActions.add(action);
           }else if(action.contains(hold)){
               holdActions.add(action);
           }else if(action.contains(support)){
               supportActions.add(action);
           }
       }

       // handle move
        for(String action: moveActions){
           String [] strs=action.split(" ");
           //name is index 0, move dest is
            if(!armys.contains(strs[0])){

                armys.add(strs[0]);
                armyLife.put(strs[0],1);
            }

            //location-->army  dst add army
            List<String> haveArmys=locationArmyMap.getOrDefault(strs[strs.length-1],new ArrayList<>());
            haveArmys.add(strs[0]);
            locationArmyMap.put(strs[strs.length-1],haveArmys);

            // src remove army
            /*   先不要这段代码
            List<String> removeArmys=locationArmyMap.get(strs[1]);
            if(removeArmys!=null&&removeArmys.contains(strs[0])){
                removeArmys.remove(strs[0]);
            }
*/
            //army--location
            armyLocationMap.put(strs[0],strs[strs.length-1]);
        }
        // handle hold
        for(String action: holdActions){
            String[] strs=action.split(" ");
            if(!armys.contains(strs[0])){

                armys.add(strs[0]);
                armyLife.put(strs[0],1);
            }
            List<String> haveArmys=locationArmyMap.getOrDefault(strs[1],new ArrayList<>());
            haveArmys.add(strs[0]);
            locationArmyMap.put(strs[1],haveArmys);
            armyLocationMap.put(strs[0],strs[1]);
        }
        //handle support

        for(String action:supportActions){
            String[] strs=action.split(" ");
            if(!armys.contains(strs[0])){

                armys.add(strs[0]);
                armyLife.put(strs[0],1);
            }
            String destArmy=strs[strs.length-1];
            String armyLocation=strs[1];


            List<String> haveArmys=locationArmyMap.getOrDefault(strs[1],new ArrayList<>());
            haveArmys.add(strs[0]);
            locationArmyMap.put(strs[1],haveArmys);
            //can  support
            if(haveArmys.size()==1){
                int life=armyLife.getOrDefault(destArmy,0);
                armyLife.put(destArmy,life+1);
            }


           //calc live

            for(String key: locationArmyMap.keySet()){
                List<String> values=locationArmyMap.get(key);

                //
                if(values.size()==1){
                    armyLocationMap.put(values.get(0),key);
                }else{
                   // charge life, find the largest ,otherwise,all dead

                    int max=armyLife.get(values.get(0));
                    int liveIndex=-1;
                   for(int i=1;i<values.size();i++){
                       if(armyLife.get(values.get(i))>max){
                           liveIndex=i;
                       }
                   }

                   if(liveIndex==-1){
                       for(String army: values){
                           armyLocationMap.put(army,"[dead]");
                       }
                   }else{
                       for(int i=0;i<values.size();i++){
                           if(liveIndex==i){

                               armyLocationMap.put(values.get(i),key);
                           }
                           else{
                               armyLocationMap.put(values.get(i),"[dead]");
                           }
                       }
                   }
                }
            }
            //

            Collections.sort(armys);
            return armys.stream().map(army->armyLocationMap.get(army)).collect(Collectors.toList());
        }


        return null;
    }

    public static void main(String[] args){

    }
}
