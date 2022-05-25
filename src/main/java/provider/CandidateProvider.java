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
        conn.close();
        return candidates;
    }
    public void updateTotalVotes(Candidate candidate) throws SQLException, ClassNotFoundException {
        DbConn conn = new DbConn();

        String sql = "SELECT * FROM candidatesA00369206 WHERE id = $ID";
        sql = sql.replace("$ID",Integer.toString(candidate.getId()));
        ResultSet results =  conn.getData(sql);
        Candidate can = new Candidate();
        while(results.next()){
            can.setVotes(results.getInt("votes"));
        }
        sql="UPDATE candidatesA00369206 SET votes = $TOTAL WHERE id = $ID";
        sql= sql.replace("$ID",Integer.toString(candidate.getId()));
        sql = sql.replace("$TOTAL",Integer.toString(can.getVotes()+1));
        conn.runQuery(sql);
        conn.close();
    }
}