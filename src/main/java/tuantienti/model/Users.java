package tuantienti.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @NotEmpty
    @Size(min = 7, max = 30)
    private String acc;
    @NotEmpty
    @Size(min = 7, max = 30)
    private String pass;

    public Users(@NotEmpty @Size(min = 7, max = 30) String name, @NotEmpty @Size(min = 7, max = 30) String acc, @NotEmpty @Size(min = 7, max = 30) String pass) {
        this.name = name;
        this.acc = acc;
        this.pass = pass;
    }

    public Users() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAcc() {
        return acc;
    }

    public String getPass() {
        return pass;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
