package DTO;

import java.sql.Date;

public class chitiethoadonDTO {
    private String mave, makht, makh, makm, mahd;
    private double giave;

    public chitiethoadonDTO() {
        // Constructor
    }
    public chitiethoadonDTO(String mave, String makht, String makh,String makm , double giave, String mahd) {
        this.mahd = mahd;
        this.mave = mave;
        this.makh = makh;
        this.makht = makht;
        this.makm = makm;
        
        this.giave = giave;
    }
    // Getter and setter methods for each attribute
    public String getMave() {
        return mave;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMakht() {
        return makht;
    }

    public void setMakht(String makht) {
        this.makht = makht;
    }
    
    
    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }
    
    
    public double getGiave() {
        return giave;
    }

    public void setGiave(double giave) {
        this.giave = giave;
    }
    
    public String getMakm() {
        return makm;
    }

    public void setMakm(String makm) {
        this.makm = makm;
    }
    
    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }
    // Define getter and setter methods for other attributes similarly
}
