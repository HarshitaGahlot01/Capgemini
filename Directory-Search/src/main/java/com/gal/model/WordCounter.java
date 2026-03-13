package com.gal.model;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WordCounter {

    @Autowired
    private FileListProvider fileListProvider;

    public Map<String, Integer> countSystemWord() {

        Map<String, Integer> result = new HashMap<>();

        List<File> files = fileListProvider.getJavaFiles();

        for (File f : files) {

            int count = 0;

            try (Scanner sc = new Scanner(f)) {

                while (sc.hasNext()) {

                    String word = sc.next();

                    if (word.contains("System")) {
                        count++;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            result.put(f.getName(), count);
        }

        return result;
    }
}
