/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;
import javafx.scene.control.DatePicker;

/**
 *
 * @author sarah
 */
public class Materiel {
    
     private int id;
        private  String libelle;
        private String type;
        private int prix;
        private int fournisseur_id;

    public Materiel() {
    }

        
    public Materiel(int id, String libelle, String type, int prix) {
        this.id = id;
        this.libelle = libelle;
        this.type = type;
        this.prix = prix;
    }

    public Materiel(String libelle, String type, int prix) {
        this.libelle = libelle;
        this.type = type;
        this.prix = prix;
    }

    public Materiel(String libelle, String type) {
        this.libelle = libelle;
        this.type = type;
      
    }

    public Materiel(int id, String libelle, String type,int prix, int fournisseur_id) {
        this.id = id;
        this.libelle = libelle;
        this.type = type;
        
        this.prix = prix;
        this.fournisseur_id = fournisseur_id;
    }

    public Materiel(String libelle, String type, int prix, int fournisseur_id) {
        this.libelle = libelle;
        this.type = type;
        this.prix = prix;
        this.fournisseur_id = fournisseur_id;
    }
    

    public Materiel(String text, String text0, String text1, float parseFloat, String lien, int parseInt, java.util.Date date, java.util.Date from, java.util.Date from0, String enabled, int uid, int category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Materiel(String text, String text0, String text1, float parseFloat, String lien, int parseInt, java.util.Date date, java.util.Date from, java.util.Date from0, String enabled, int uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Materiel(String text, String text0, String text1, String lien, int parseInt, java.util.Date date, java.util.Date from, java.util.Date from0, String enabled, int uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Materiel(String text, String text0, String lien, int parseInt, java.util.Date date, java.util.Date from, java.util.Date from0, String enabled, int uid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Materiel(int id, String libelle, String type) {
        this.id = id;
        this.libelle = libelle;
        this.type = type;
        
    }

    public Materiel(int id, String text, String text0, String lien, int parseInt, java.util.Date date, java.util.Date from, java.util.Date from0, String enabled, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Materiel(int aInt, String string, String string0, Date date, Date date0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Materiel(String text, String text0, String lien, int parseInt, java.util.Date date, java.util.Date from, java.util.Date from0, String enabled, int uid, int category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Evenement{" + "id=" + id + ", libelle=" + libelle + ", type=" + type +  ", prix=" + prix + ", fournisseur_id=" + fournisseur_id + '}';
    }

   

    public void setDate_debut(DatePicker dpEventAddDateDeb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getFournisseur_id() {
        return fournisseur_id;
    }

    public void setFournisseur_id(int fournisseur_id) {
        this.fournisseur_id = fournisseur_id;
    }
    
        
    
}
