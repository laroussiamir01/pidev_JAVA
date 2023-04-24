/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
/**
 *
 * @author Asus store
 */
public class Reclamation {
      private int id;
     private String message;
     private int user_id;
     
     
   
     
     
     public Reclamation(){}
     public Reclamation(int id,String message){
         this.id=id;
         this.message=message;
     }
     public Reclamation(int id,String message, int user){
         this.id=id;
         this.message=message;
         this.user_id=user;
     }
     
     public Reclamation(String message, int user){
         this.message=message;
         this.user_id=user;
     }
      public Reclamation(String message){
         this.message=message;
     }
  /*    public Reclamation(int id,String message,int user_id){
          this.id=id;
         this.message=message;
         this.user=user_id;
     }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUser() {
        return user_id;
    }

    public void setUser(int user) {
        this.user_id = user;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", message=" + message + ", user=" + user_id + '}';
    }

  

   
     
    
}
