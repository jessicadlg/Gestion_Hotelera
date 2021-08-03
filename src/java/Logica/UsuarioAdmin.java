
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class UsuarioAdmin implements Serializable {
    @Id
    int id_usuario;
    @Basic
    String user;
    String password;

    public UsuarioAdmin() {
    }

    public UsuarioAdmin(int id_usuario, String user, String password) {
        this.id_usuario = id_usuario;
        this.user = user;
        this.password = password;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
