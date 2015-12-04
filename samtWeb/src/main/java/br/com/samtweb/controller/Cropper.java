
package br.com.samtweb.controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageOutputStream;
import javax.servlet.ServletContext;
import org.primefaces.component.imagecropper.ImageCropper;
import org.primefaces.component.imagecropper.ImageCropperRenderer;
import org.primefaces.model.CroppedImage;


/**
 * @autor: Adalberto Kamida
 * @dt. inclusao: 24/11/2015
 */

@ManagedBean(name="cropper")
@RequestScoped
public class Cropper {

    private CroppedImage croppedImage;
    private String imagemVeiculo;
    private String newImageName;
    
    
    public Cropper(){
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        setImagemVeiculo("/temp/1_0.jpg");
//        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Imagem: " + this.imagemVeiculo, ""));


    }
    
    public String crop() throws IOException{
        if(croppedImage == null)
        return null;
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

//        String NewFileName = servletContext.getRealPath("") + File.separator + "imagens" + File.separator + croppedImage.getOriginalFilename() + "cropped.jpg";
//        String NewFileName = servletContext.getRealPath("") + File.separator + "imagens" + File.separator + "teste.jpg";
        String NewFileName = "c:/temp_pessoal/teste.jpg";

        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(NewFileName));
            imageOutput.write(croppedImage.getBytes(),0, croppedImage.getBytes().length);
            imageOutput.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        
       BufferedImage image = ImageIO.read(new File("C:/desenvjava/trunk/projetos/samtWeb/samtWeb/src/main/webapp/temp/1_0.jpg"));   
       BufferedImage image2 = ImageIO.read(new File("C:/java/teste.jpg"));   
      
       int w = image2.getWidth();   
       int h = image2.getHeight();   
      
       Graphics2D graphics = image.createGraphics();  
//       graphics.drawImage(image2, 0, 0, w, h, null);  
//       graphics.drawImage(image2, croppedImage.getTop(), croppedImage.getLeft(), croppedImage.getWidth(), croppedImage.getHeight(), null);  
       graphics.setColor(Color.BLACK);
       graphics.fillRect(croppedImage.getLeft(), croppedImage.getTop(), croppedImage.getWidth(), croppedImage.getHeight());
       graphics.dispose(); 
       File ImagemDestino = new File("C:/TEMP_PESSOAL/image_obliterada.jpg");
       ImageIO.write(image, "jpg", ImagemDestino);
       ImagemDestino = new File(servletContext.getRealPath("") + File.separator + "temp" + File.separator + "1_0.jpg");         
       ImageIO.write(image, "jpg", ImagemDestino);
       newImageName = servletContext.getRealPath("") + File.separator + "temp" + File.separator + "1_0.jpg";
       return null;
    }

    public CroppedImage getCroppedImage() {
        return croppedImage;
    }

    public void setCroppedImage(CroppedImage croppedImage) {
        this.croppedImage = croppedImage;
    }

    public String getImagemVeiculo() {
        return imagemVeiculo;
    }

    public void setImagemVeiculo(String imagemVeiculo) {
        this.imagemVeiculo = imagemVeiculo;
    }

    public String getNewImageName() {
        return newImageName;
    }

    public void setNewImageName(String newImageName) {
        this.newImageName = newImageName;
    }

    
    
    public static void copyFile(File source, File destination) throws IOException{  
      
    if (destination.exists())     
        destination.delete();     
  
    FileChannel sourceChannel = null;     
    FileChannel destinationChannel = null;     
  
    try {     
          
        sourceChannel = new FileInputStream(source).getChannel();     
        destinationChannel = new FileOutputStream(destination).getChannel();     
        sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);   
          
    } finally {     
          
        if (sourceChannel != null && sourceChannel.isOpen())     
            sourceChannel.close();     
        if (destinationChannel != null && destinationChannel.isOpen())     
            destinationChannel.close();     
    }     
  
    }  
    
}
