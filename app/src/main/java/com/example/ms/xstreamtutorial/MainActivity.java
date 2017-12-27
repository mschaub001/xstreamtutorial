package com.example.ms.xstreamtutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thoughtworks.xstream.XStream;

import android.content.Context;
import android.telephony.TelephonyManager;

import java.io.FileOutputStream;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("\ngetFilesDir():\n" + getApplicationContext().getFilesDir());

        System.out.println("\nFile Directory.... ");
        String [] files = this.getFilesDir().list();
        for (int i = 0; i < files.length; i++)
            System.out.println("\nFile: " + files[i]);

        PersonList pl1 = new PersonList(exampleXML);
        PersonList pl2 = new PersonList(10);

        FileOutputStream outputStream;
        try {
            outputStream = this.openFileOutput("PersonList1", Context.MODE_PRIVATE);
            outputStream.write(pl1.toXML().getBytes("UTF-8"));
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            outputStream = this.openFileOutput("PersonList2", Context.MODE_PRIVATE);
            outputStream.write(pl2.toXML().getBytes("UTF-8"));
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        /*
        try {
            FileInputStream in = openFileInput("person");
            InputStreamReader inputStream = new InputStreamReader(in);
            BufferedReader bufferedReader = new BufferedReader(inputStream);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println("\nZurück Aus dem File:\n" + sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
*/
    }






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
            "    <phone>+41 76 572 5240</phone>\n" +
            "  </Person>\n" +
            "</Person-array>\n";
}
