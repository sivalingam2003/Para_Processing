import java.util.*;
class Para {
    private static List<String> splitBy(String s,String by){
        String[] str= s.split(by);
        List<String> lowerCase = new ArrayList<>();
        for(String each:str){
            lowerCase.add(each.toLowerCase());
        }
        return lowerCase;
    }
    private static Set<String> toUniqueWords(List<String> splitted){
        Set<String> uniqueWords=new HashSet<>();
        for(String a:splitted)
            uniqueWords.add(a);
        return uniqueWords;
    } 
    private static Map<String,Map<String,Integer>> wordOccurAndLength(List<String> splitted){
        Map<String,Map<String,Integer>> word = new LinkedHashMap<>();
        for(int i=0;i<splitted.size();i++){
            Map<String,Integer> occurAndLength=new LinkedHashMap<>();
            String current=splitted.get(i);
            if(word.containsKey(current)){
                occurAndLength=occurence(word.get(current),current);RRR
                word.put(current,occurAndLength);
            }
            else{
                occurAndLength.put("Occur",1);
                occurAndLength.put("length",current.length());
                word.put(current,occurAndLength);
            }
        }
        return word;
    }
    private static Map<String,Integer> occurence(Map<String,Integer> sample,String current){
        Map<String,Integer> occurAndLength= new LinkedHashMap<>();
        int occur=sample.get("Occur");
        occurAndLength.put("Occur",occur+1);
        occurAndLength.put("length",current.length());
        return occurAndLength;
    }
    private static String findBiggestWord(Set<String> uniqueWords){
        String max=" ";
        for(String c:uniqueWords){
            if(c.length()>max.length())
                max=c;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input = sc.nextLine();
        Map<String,Object> processString=new LinkedHashMap<>();
        processString.put("String",input);
        List<String> splitted=new ArrayList<>();
        splitted=splitBy(input," ");
        processString.put("Splitted",splitted);
        Set<String> uniqueWords=new HashSet<>();
        uniqueWords=toUniqueWords(splitted);
        processString.put("UniqueWords",uniqueWords);
        Map<String,Map<String,Integer>> wordOccurAndLength =new LinkedHashMap<>();
        wordOccurAndLength=wordOccurAndLength(splitted);
        processString.put("wordOccurAndLength",wordOccurAndLength);
        String biggestWord = findBiggestWord(uniqueWords);
        processString.put("BiggestWord",biggestWord);
        processString.put("BiggestWordLength",biggestWord.length());
        processString.put("NoOfSplittedWords",splitted.size());
        processString.put("NoOfUniquedWords",uniqueWords.size());
	for(String key: processString.keySet()){
            System.out.println(key+" = "+processString.get(key));
        }
        sc.close();
    }
}