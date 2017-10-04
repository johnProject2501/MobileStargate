package john2501.projetperso.model.beans;

import java.io.Serializable;

/**
 * Created by john2501 on 30/08/2017.
 */

public class Episode implements Serializable {

    private Integer id;
    private Integer idOfSaison;
    private String titre;
    private String resumerCourt;
    private String resumerLong;
    private String photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdOfSaison() {
        return idOfSaison;
    }

    public void setIdOfSaison(Integer idOfSaison) {
        this.idOfSaison = idOfSaison;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResumerCourt() {
        return resumerCourt;
    }

    public void setResumerCourt(String resumerCourt) {
        this.resumerCourt = resumerCourt;
    }

    public String getResumerLong() {
        return resumerLong;
    }

    public void setResumerLong(String resumerLong) {
        this.resumerLong = resumerLong;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
