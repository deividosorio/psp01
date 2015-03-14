/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author deividosorio
 */
public class counterLOC {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private String[] fileList;
    ArrayList<counterLOCFile> filesLC = new ArrayList<counterLOCFile>();
    private String path = "";
    private int nFiles = 0;
    counterLOCFile cLOCf;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    public counterLOC(String path) {
        this.path = path;
        fileList = getFilesPath();

        for (int i = 0; i < this.nFiles; i++) {
            if (fileList[i].endsWith(".java")) {
                cLOCf = new counterLOCFile(this.path + fileList[i]);
                filesLC.add(cLOCf);
            }
        }
    }

    private String[] getFilesPath() {
        File dir = new File(this.path);
        fileList = dir.list();
        this.nFiles = fileList.length;
        return fileList;
    }

    public ArrayList<counterLOCFile> getFiles() {
        return this.filesLC;
    }

    public long getNumTotLOC() {
        long numTotLOC = 0;
        counterLOCFile counter;
        for (int i = 0; i < this.filesLC.size(); i++) {
            counter = filesLC.get(i);
            numTotLOC+= counter.getNumLOC();
        }
        return numTotLOC;
    }

    public long getNumTotMethods() {
        long numTotMethod = 0;
        counterLOCFile counter;
        for (int i = 0; i < this.filesLC.size(); i++) {
            counter = filesLC.get(i);
            numTotMethod+= counter.getNumMethods();
        }
        return numTotMethod;
    }
    
    public long getNumTotLEmpty() {
        long numTotLEmpty = 0;
        counterLOCFile counter;
        for (int i = 0; i < this.filesLC.size(); i++) {
            counter = filesLC.get(i);
            numTotLEmpty+= counter.getNumEmpty();
        }
        return numTotLEmpty;
    }

    public long getNumTotLComment() {
        long getNumTotLComment = 0;
        counterLOCFile counter;
        for (int i = 0; i < this.filesLC.size(); i++) {
            counter = filesLC.get(i);
            getNumTotLComment+= counter.getNumCommet();
        }
        return getNumTotLComment;
    }

    public long getNumTotFiles() {
        return this.nFiles;
    }
}
