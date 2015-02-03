/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo;

import java.io.File;
import java.io.IOException;
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
    private counterLOCFile[] filesLC;
    private String path = "";
    private long nFiles = 0;
    counterLOCFile cLOCf;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    public counterLOC(String path) {
        this.path = path;
        fileList = getFilesPath();

        for (int i = 0; i < fileList.length; i++) {
            cLOCf = new counterLOCFile(fileList[i]);
            filesLC[i] = cLOCf;
        }
    }

    private String[] getFilesPath() {
        File dir = new File(this.path);
        String[] files = dir.list();
        this.nFiles = dir.length();
        return files;
    }
    
    public counterLOCFile[] getFiles(){
        return this.filesLC;
    }
    
    public long getNumTotLOC(){
        long numTotLOC = 0;
        for (int i = 0; i < this.filesLC.length; i++){
            numTotLOC++;
        }
        return numTotLOC;
    }
    
    public long getNumTotLEmpty(){
        long numTotLEmpty = 0;
        for (int i = 0; i < this.filesLC.length; i++){
            numTotLEmpty++;
        }
        return numTotLEmpty;
    }

    public long getNumTotLComment(){
        long getNumTotLComment = 0;
        for (int i = 0; i < this.filesLC.length; i++){
            getNumTotLComment++;
        }
        return getNumTotLComment;
    }
    
    public long getNumTotFiles(){
        return this.nFiles;
    }
}
