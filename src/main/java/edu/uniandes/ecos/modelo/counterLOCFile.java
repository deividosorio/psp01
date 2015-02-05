/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author deividosorio
 */
public class counterLOCFile {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private int nloc = 0;
    private int nlempty = 0;
    private int nlcomment = 0;
    private int nmethod = 0;
    private String nameFile = "";
    private String nameMethod = "";

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    public counterLOCFile(String nameFile) {
        this.nameFile = nameFile;

        String line = "";

        try {
            FileReader fr = new FileReader(this.nameFile);
            BufferedReader bf = new BufferedReader(fr);

            while ((line = bf.readLine()) != null) {
                if (line.length() == 0) {
                    this.nlempty++;
                } else if (line.startsWith("//") || line.startsWith("*")
                        || line.startsWith("/*") || line.startsWith("*/")) {
                    this.nlcomment++;
                } else if (line.startsWith("Private") || line.startsWith("Public")
                        || line.startsWith("Protected")) {
                    this.nmethod++;
                    this.nameMethod = line;
                } else {
                    this.nloc++;
                }
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public String getNameMethod() {
        return this.nameMethod;
    }

    public int getNumLOC() {
        return this.nloc;
    }

    public int getNumEmpty() {
        return this.nlempty;
    }

    public int getNumCommet() {
        return this.nlcomment;
    }

    public String getNameFile() {
        return this.nameFile;
    }

}
