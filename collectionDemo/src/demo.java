import java.util.*;

public class demo {
    public static void main(String[] args) {

        Map<String,Integer>studend =new HashMap<>();
        studend.put("Ravi",35);
        studend.put("Supriya",28);
        studend.put("Aniket",33);
        studend.put("Vaibhav",36);

        for(String key:studend.keySet()){
            System.out.println(key+":"+studend.get(key));

        }
        //System.out.println(studend.get("Ravi"));
        //System.out.println(studend);
//
//        Set<Integer> list=new TreeSet<Integer>();
//
//        list.add(12);
//        list.add(24);
//        list.add(45);
//        list.add(56);
//        list.add(24);
//
//        Iterator iterator= list.iterator();
//
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//        //System.out.println(list.get(3));
////        for (int a:list){
////            System.out.println(a);
////        }
////        System.out.println(list);
    }
}

