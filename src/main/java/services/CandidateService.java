package services;

import com.thetransactioncompany.cors.CORSFilter;
import entity.Candidate;
import provider.CandidateProvider;
import model.Message;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("Votacion")
public class CandidateService extends CORSFilter {

    @GET
    @Path("Candidatos")
    @Produces("application/json")
    public Response getCandidates() {
        try {
            CandidateProvider provider = new CandidateProvider();
            ArrayList<Candidate> candidates = provider.getCandidates();
            return Response.status(200).header("Access-Control-Allow-Origin","*").entity(candidates).build();
        } catch (SQLException ex) {
            Message m = new Message("SQL Exception", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        } catch (ClassNotFoundException ex) {
            Message m = new Message("Class not found Except", ex.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin","*").entity(m).build();
        }

    }
    @PUT
    @Path("Actualizar")
    @Produces("application/json")
    public Response updateVotes(Candidate candidate){
        CandidateProvider provider = new CandidateProvider();
        try {
            provider.updateTotalVotes(candidate);

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