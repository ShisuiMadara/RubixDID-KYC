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

import io.ipfs.multihash.Multihash;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;
import static com.rubix.DIDCreation.DIDcreate.*;



public class App 
{
    public static void main( String[] args )
    {
        Path p = Paths.get("/home/shisuimadara/rubixProject/rubixProject/icon.png");
        byte[] cont = null;
        try {
            cont = Files.readAllBytes(p);
        } catch (final IOException e) {
        }
        MultipartFile m = new MockMultipartFile("icon.png", "icon.png", "image/png", cont);
        System.out.println( "Hello World!" );
        IPFS ipfs = new IPFS("localhost", 5001);
        JSONObject j;
        //Multipart mu = new Multipart();
        try
        {
        j = createDID("Hello World Sex!",m.getInputStream());
        }
        catch (IOException ex)
        {
            throw new RuntimeException("ERROR IN MULTIPART FILE ", ex);
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException("ERROR IN INTERRUPTTED ", e);
        }
        // try {
        //     NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File("/home/gjeanmart/Documents/hello.txt"));
        //     MerkleNode response = ipfs.add(file).get(0);
        //     System.out.println("Hash (base 58): " + response.hash.toBase58());
        //   } catch (IOException ex) {
        //     throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        //   }

        
          
          System.out.println(j);
          try {
            String hash = "QmTGMLPgJan2Mhq1QJy6iS8WQcAR9Rxb3Pcdyob9LVgmtS"; // Hash of a file
            Multihash multihash = Multihash.fromBase58(hash);
            byte[] content = ipfs.cat(multihash);
            System.out.println("Content of " + hash + ": " + new String(content));
          } catch (IOException ex) {
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
          }
        
        
    }
}
