package com.gal.model;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileListProvider {

    @Autowired
    private DirectoryPath dirpath;

    public List<File> getJavaFiles() {

        List<File> files = new ArrayList<>();
        search(new File(dirpath.getDir()), files);

        return files;
    }

    private void search(File dir, List<File> files) {

        File[] list = dir.listFiles();

        if (list != null) {
            for (File f : list) {

                if (f.isDirectory()) {
                    search(f, files);
                }

                else if (f.getName().endsWith(".java")) {
                    files.add(f);
                }
            }
        }
    }
}