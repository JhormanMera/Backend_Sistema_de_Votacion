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
            String president = results.getString("president");
            String formula = results.getString("formula");
            String presidentImage = results.getString("presidentImage");
            String formulaImage = results.getString("formulaImage");
            String groupImage = results.getString("groupImage");
            int votes = results.getInt("votes");
            Candidate candidate = new Candidate(id,president,formula,presidentImage,formulaImage,groupImage,votes);
            candidates.add(candidate);
        }
        System.out.println(candidates.size());
        conn.close();
        return candidates;
    }
    public void updateTotalVotes(int id) throws SQLException, ClassNotFoundException {
        System.out.println(id);
        DbConn conn = new DbConn();

        String sql = "SELECT * FROM candidatesA00369206 WHERE id = $ID";
        sql = sql.replace("$ID", ""+id);
        System.out.println(sql);
        ResultSet results =  conn.getData(sql);

        sql="UPDATE candidatesA00369206 SET votes = $TOTAL WHERE id = $ID";
        sql= sql.replace("$ID",  ""+id);
        sql = sql.replace("$TOTAL",Integer.toString(results.getInt("totalVotes")+1));
        System.out.println(sql);
        conn.runQuery(sql);
        conn.close();
    }
}