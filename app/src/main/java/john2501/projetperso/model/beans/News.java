package john2501.projetperso.model.beans;

import java.io.Serializable;

/**
 * Created by john2501 on 30/08/2017.
 */

public class News implements Serializable {

    private Integer id;
    private String File;
    private String titre;
    private String Text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFile() {
        return File;
    }

    public void setFile(String file) {
        this.File = file;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }
}
