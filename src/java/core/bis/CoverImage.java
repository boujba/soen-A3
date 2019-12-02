package core.bis;

import java.io.InputStream;
import java.sql.Blob;
import java.util.Base64;


public class CoverImage {
    
    private String mimeType;
    private Blob image;
    private InputStream imageData;
    byte[] imageByes;
    
    public CoverImage() {

    }
    
    public CoverImage(String mimeType, Blob image) {
        this.mimeType = mimeType;
        this.image = image;
    }
    
    public CoverImage(String mimeType, InputStream imageData) {
        this.mimeType = mimeType;
        this.imageData = imageData;
    }

    public CoverImage(String mimetype, byte[] image) {
        this.mimeType = mimeType;
        this.imageByes = image;
    }
    
    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mime) {
        this.mimeType = mime;
    }
    
    public Blob getImage() {
        return image;
    }

    public void setImage(Blob img) {
        this.image = img;
    }
    
    public InputStream getImageData() {
        return imageData;
    }

    public void setImageData(InputStream imgdata) {
        this.imageData = imgdata;
    }
    
    public String getBase64Image() {
        String base64Image = Base64.getEncoder().encodeToString(imageByes);
        return base64Image;
    }
    

    @Override
    public String toString() {
        return "CoverImage{" + "mimeType=" + mimeType + '}';
    }
    
    
}