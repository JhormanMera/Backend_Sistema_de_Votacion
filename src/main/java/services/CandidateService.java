package services;

import entity.Candidate;
import provider.CandidateProvider;
import model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("candidate")
public class CandidateService {

    @GET
    @Path("Candidatos")
    @Produces("application/json")
    public Response getCandidates() {
        try {
            CandidateProvider provider = new CandidateProvider();
            ArrayList<Candidate> candidates = null;
            candidates = provider.getCandidates();
            return Response.status(200).header("Access-Control-Allow-Origin","*").entity(candidates).build();
        } catch (SQLException ex) {
            //ex.printStackTrace();
            Message m = new Message("SQL Exception", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        } catch (ClassNotFoundException ex) {

            Message m = new Message("Class not found Except", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        }

    }

    @PUT
    @Path("ActualizarVotos")
    @Produces("application/json")
    public Response updateVotes(int id){
        CandidateProvider provider = new CandidateProvider();
        try {
            provider.updateTotalVotes(id);
            Message m2 = new Message("SQL Sucess","Sucess");
            return Response.status(200).header("Access-Control-Allow-Origin","*").entity(m2).build();
        } catch (SQLException e) {

            Message m = new Message("SQL Exception", e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        } catch (ClassNotFoundException ex) {
            Message m = new Message("Class not found Except", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        }

    }
}