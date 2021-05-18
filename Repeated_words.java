package com.repeated_words;


import java.io.*;
import java.util.*;


public class Repeated_words {


    public static void main(String[] args) throws Exception {
        HashMap<String,Integer> wordCount= new HashMap<String,Integer>();
        String eachWord = "";
        int count = 0, maxCount = 0;
        ArrayList<String> words = new ArrayList<String>();
        Properties prop=new Properties();
        prop.load(new FileInputStream("/Users/santhosh/Desktop/config.properties"));
        System.out.println(prop.getProperty("input_file"));
        FileInputStream fis=new FileInputStream(prop.getProperty("input_file"));
        Scanner sc=new Scanner(fis);

        while(sc.hasNextLine())
        {
            String line = sc.nextLine();                   // reading from the file and stored in list
            words.addAll(Arrays.asList(line.split(" ")));
        }

        System.out.println(words);

                                                            //Determine the most repeated word in a  hash map
        for(int i = 0; i < words.size(); i++){

            eachWord = words.get(i);
          
            if(!wordCount.containsKey(eachWord)){
                wordCount.put(eachWord,0);
            }

            wordCount.put(eachWord,wordCount.get(eachWord)+1);
        }
        System.out.println(wordCount);
        sc.close();
        File file = new File(prop.getProperty("output_file"));      //storing the output in another file

        BufferedWriter bf = null;

        try {


            bf = new BufferedWriter(new FileWriter(file));


            for (Map.Entry<String, Integer> entry :
                    wordCount.entrySet()) {


                bf.write(entry.getKey() + ":"
                        + entry.getValue());

                bf.newLine();
            }

            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
