package br.com.samtweb.conversores;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterSHA1")
public class ConverterSHA1 implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return cipher(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }

    public static String cipher(String value) {
        String algorithm = "SHA1";
        byte[] buffer = value.getBytes();
        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
            md.update(buffer);
            byte[] digest = md.digest();
            String hexValue = "";
            for (int i = 0; i < digest.length; i++) {
                int b = digest[i] & 0xff;
                if (Integer.toHexString(b).length() == 1) {
                    hexValue = hexValue + "0";
                }
                hexValue = hexValue + Integer.toHexString(b);
            }
            return hexValue;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ConverterSHA1.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static String criptografa(String PLC_texto_origem)
    {
        String VLC_retorno = ""; 
        String VLC_letra = "";
        int VLN_codigo_asc = 0;
        int VLN_i = 0; 
        
        if (PLC_texto_origem.equals(""))
        {
            return VLC_retorno;
        }
        for (VLN_i = 0; VLN_i < PLC_texto_origem.length() ; VLN_i ++ )
        {
            VLN_codigo_asc = (int)PLC_texto_origem.charAt(VLN_i) + 30 ;     
            if (VLN_codigo_asc > 255)
            {
                VLN_codigo_asc = VLN_codigo_asc - 255; 
            }
            VLC_retorno += (char)VLN_codigo_asc;     
        }
        
        return VLC_retorno;
    }
    
    public static String descriptografa(String PLC_texto_origem)
    {
        String VLC_retorno = ""; 
        int VLN_i = 0; 
        int VLN_codigo_asc = 0; 
        
        if (PLC_texto_origem.equals(""))
        {
            return VLC_retorno;
        }
        
        for (VLN_i = 0; VLN_i < PLC_texto_origem.length(); VLN_i ++)
        {
            VLN_codigo_asc = (int)PLC_texto_origem.charAt(VLN_i);
            if (VLN_codigo_asc < 30)
                {
                   VLN_codigo_asc = VLN_codigo_asc+255-30;
                }
            else
                {
                   VLN_codigo_asc = VLN_codigo_asc-30;
                }
            VLC_retorno += (char)VLN_codigo_asc; 
        }
        return VLC_retorno;
    }

}
