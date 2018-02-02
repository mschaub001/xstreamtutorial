package com.example.ms.xstreamtutorial;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class StundenplanParser extends AsyncTask<String, Void, String> {

    private Exception exception;

    protected String doInBackground(String... urls) {
        try {
            String URL = "http://www.stundenplan.alte-kanti-aarau.ch/Stundenplan_Files/Abteilungen_I3A.htm";
            System.out.println("URL = " + URL);
            Document document = document = Jsoup.connect(URL).get(); //get the HTML page
            System.out.println("got Document");
            Elements rows = document.select("table[border=\"3\"] > tbody > tr:has(td)"); //select all rows
            System.out.println("Got Rows: " + rows.size());
//            rows = rows.select("tr"); //select all rows
//            System.out.println("Got elements: " + rows.size());
            int[] offsets = new int[rows.size()];

            String stundenplan[][] = new String[13][6];
            for (int i = 0; i < 13; i++) {
                for (int j = 0; j < 6; j++) {
                    stundenplan[i][j] = "";
                }
            }

            for (int i = 0; i < rows.get(0).children().size(); i++) //unless colspans are used, this should return the number of columns
            {
                System.out.println("Assuming Number of Cols: " + rows.get(0).children().size());
                for (int j = 0; j < 13 /*rows.size() */; j++)  // loops through the rows of each column
                {
                    if (rows.get(j).children().size() > 0) {
                        Element cell = rows.get(j).child(i + offsets[j]); //get an individual cell
//                      Element cell = rows.get(j).child(i); //get an individual cell
                        System.out.printf("Cell (%d/%d) : %s %n", i, j, cell.text());
                        stundenplan[j][i] = cell.text();
                        if (cell.hasAttr("rowspan")) //if that cell has a rowspan
                        {
                            int rowspan = Integer.parseInt(cell.attr("rowspan")) / 2;
                            if (rowspan > 1) {
                                System.out.printf("Rowspan %d found at (%d/%d)%n", rowspan, i, j);
                            }

                            for (int k = 1; k < rowspan; k++) {
                                offsets[j + k]--; //add offsets to rows that now have a cell "missing"
                                stundenplan[j + k][i] = cell.text();
                            }
                            j += rowspan - 1; //add rowspan to index, to skip the "missing" cells
                        }
                    }
                }
            }
            System.out.println("DONE");

            for (int i = 0; i < 12; i++) {
                System.out.printf("%-15s %-35s %-35s %-35s %-35s %-35s %n", stundenplan[i][0], stundenplan[i][1], stundenplan[i][2], stundenplan[i][3], stundenplan[i][4], stundenplan[i][5]);

            }

            return "done";
        } catch (Exception e) {
            this.exception = e;
            e.printStackTrace();
            return null;
        } finally {
        }
    }

    protected void onPostExecute(String feed) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}