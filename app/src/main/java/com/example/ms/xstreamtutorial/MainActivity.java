package com.example.ms.xstreamtutorial;

import android.provider.DocumentsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thoughtworks.xstream.XStream;

import android.content.Context;
import android.telephony.TelephonyManager;

import java.io.File;
import java.io.FileOutputStream;

import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new StundenplanParser().execute("");


    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        System.out.println("\ngetFilesDir():\n" + getApplicationContext().getFilesDir());
//
//        System.out.println("\nFile Directory.... ");
//        String [] files = this.getFilesDir().list();
//        for (int i = 0; i < files.length; i++)
//            System.out.println("\nFile: " + files[i]);
//
//        // File[] files2delete = this.getFilesDir().listFiles();
//        // for (int i = 0; i < files2delete.length; i++)
//        //     files2delete[i].delete();
//
//        PersonList pl1 = new PersonList(exampleXML);
//        PersonList pl2 = new PersonList(10);
//
//        Person[] result = pl1.searchPerson("Schaub");
//        for (int i = 0; i < result.length; i++)
//            System.out.println("\nPL1 (Schaub): " + result[i].getFirstname() + ", " + result[i].getLastname() + ", " + result[i].getEmail() + ", " + result[i].getPhone());
//
//        result = pl2.searchPerson("Dow_2");
//        for (int i = 0; i < result.length; i++)
//            System.out.println("\nPL2 (Dow2)  : " + result[i].getFirstname() + ", " + result[i].getLastname() + ", " + result[i].getEmail() + ", " + result[i].getPhone());
//
//        FileOutputStream outputStream;
//        try {
//            outputStream = this.openFileOutput("PersonList1", Context.MODE_PRIVATE);
//            outputStream.write(pl1.toXML().getBytes("UTF-8"));
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            outputStream = this.openFileOutput("PersonList2", Context.MODE_PRIVATE);
//            outputStream.write(pl2.toXML().getBytes("UTF-8"));
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        /*
//        try {
//            FileInputStream in = openFileInput("person");
//            InputStreamReader inputStream = new InputStreamReader(in);
//            BufferedReader bufferedReader = new BufferedReader(inputStream);
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            System.out.println("\nZurück Aus dem File:\n" + sb.toString());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//*/
//    }


    String exampleXML =
            "<Person-array>\n" +
                    "  <Person>\n" +
                    "    <firstname>Markus</firstname>\n" +
                    "    <lastname>Schaub</lastname>\n" +
                    "    <email>mschaub@s-c.biz</email>\n" +
                    "    <phone>+41 76 572 5240</phone>\n" +
                    "  </Person>\n" +
                    "  <Person>\n" +
                    "    <firstname>Jacqueline</firstname>\n" +
                    "    <lastname>Blank</lastname>\n" +
                    "    <email>jablank@gmx.ch</email>\n" +
                    "  </Person>\n" +
                    "  <Person>\n" +
                    "    <firstname>Noah</firstname>\n" +
                    "    <lastname>Schaub</lastname>\n" +
                    "    <phone>+41 76 510 2008</phone>\n" +
                    "  </Person>\n" +
                    "</Person-array>\n";
}
