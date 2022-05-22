package provider;

import db.DbConn;
import entity.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidateProvider {

    public ArrayList<Candidate> getCandidates()throws SQLException, ClassNotFoundException {

        DbConn conn = new DbConn();

        ArrayList<Candidate> candidates = new ArrayList<>();


        ResultSet results =  conn.getData("SELECT * FROM candidatesA00369206");

        while(results.next()){

            int id = results.getInt("id");

            String president = results.getString("presidentName");

            String formula = results.getString("formulaName");


            String presidentImage = results.getString("presidentPhoto");

            String formulaImage = results.getString("formulaPhoto");

            String groupImage = results.getString("partyPhoto");

            int totalVotes = results.getInt("totalVotes");


            Candidate candidate = new Candidate(id,presidentName,formulaName,presidentTittle,formulaTittle,presidentPhoto,formulaPhoto,partyPhoto,totalVotes);
            candidates.add(candidate);
        }

        System.out.println(candidates.size());
        conn.close();
        return candidates;

    }

    public void updateTotalVotes(int id) throws SQLException, ClassNotFoundException {

        System.out.println(id);

        DbConn conn = new DbConn();


        String sql = "SELECT * FROM parcial2A00369267 WHERE id = $ID";
        sql = sql.replace("$ID", ""+id);

        System.out.println(sql);

        Candidate candidate = new Candidate();
        candidate.setId(id);
        ResultSet results =  conn.getData(sql);
        while(results.next()){


            int totalVotes = results.getInt("totalVotes");

            candidate.setTotalVotes(totalVotes);

            //products.add(product);
        }

        System.out.println("Tiene id:" + candidate.getId() +" y votos totales:" + candidate.getTotalVotes());

        sql="UPDATE parcial2A00369267 SET totalVotes = $TOTAL WHERE id = $ID";
        sql= sql.replace("$ID",  ""+id);
        sql = sql.replace("$TOTAL",    Integer.toString(candidate.getTotalVotes()+1));
        System.out.println(sql);

        conn.runQuery(sql);
        conn.close();



    }




}