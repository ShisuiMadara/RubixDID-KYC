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
import io.ipfs.multihash.Multihash;
import org.springframework.web.multipart.MultipartFile;


public class App 
{
    public static void main( String[] args )
    {
        //createDID("hello World!", );
        System.out.println( "Hello World!" );
        IPFS ipfs = new IPFS("localhost", 5001);
        
        //Multipart mu = new Multipart();
        // try {
        //     NamedStreamable.FileWrapper file = new NamedStreamable.FileWrapper(new File("/home/gjeanmart/Documents/hello.txt"));
        //     MerkleNode response = ipfs.add(file).get(0);
        //     System.out.println("Hash (base 58): " + response.hash.toBase58());
        //   } catch (IOException ex) {
        //     throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
        //   }

        
          try {
            String hash = "QmT78zSuBmuS4z925WZfrqQ1qHaJ56DQaTfyMUF7F8ff5o"; // Hash of a file
            Multihash multihash = Multihash.fromBase58(hash);
            byte[] content = ipfs.cat(multihash);
            System.out.println("Content of " + hash + ": " + new String(content));
          } catch (IOException ex) {
            throw new RuntimeException("Error whilst communicating with the IPFS node", ex);
          }
          
          
        
    }
}
