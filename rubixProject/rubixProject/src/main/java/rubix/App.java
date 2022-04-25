package rubix;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.rubix.DIDCreation.DIDcreate;
import io.ipfs.api.Multipart;
import io.ipfs.api.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;
import org.json.*;
import javax.json.JsonObject;
import javax.management.RuntimeErrorException;
import java.util.HashMap;
import io.ipfs.multihash.Multihash;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;
import static com.rubix.DIDCreation.DIDcreate.*;



public class App 
{
    public static void main( String[] args )
    {
      Scanner sc= new Scanner(System.in);
      String path = sc.nextLine();

        Path p = Paths.get(path);
        byte[] cont = null;
        try {
            cont = Files.readAllBytes(p);
        } catch (final IOException e) {
        }
        HashMap<String, Integer> map = new HashMap<>();
        MultipartFile m = new MockMultipartFile("icon.png", "icon.png", "image/png", cont);
        JSONObject j;       
       

        String choice ;
        choice = sc.nextLine();
        
        System.out.println(choice);
        String UserInput = sc.nextLine();
        if(choice.equals("1"))
        {
          
          try
          {
          j = createDID(UserInput,m.getInputStream());
          }
          catch (IOException ex)
          {
              throw new RuntimeException("ERROR IN MULTIPART FILE ", ex);
          }
          catch (InterruptedException e)
          {
              throw new RuntimeException("ERROR IN INTERRUPTTED ", e);
          }
          String HashedValue = j.getString("DID");
        
          System.out.println(HashedValue);
          map.put(HashedValue, 1);
        }
        else
        {
          String DID = sc.nextLine();
          
          if(map.containsKey(UserInput))
          {
            System.out.println("SUCCESS");
          }
          else
          {
            System.out.println("FAILURE");
          }
        }
        
    }
}
