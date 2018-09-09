package com.pw.dw.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.pw.dw.generator.ModelGenerator;
import com.pw.dw.model.Person;

import java.util.ArrayList;
import java.util.List;


@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
public class PersonsResource {

    private ModelGenerator<Person> personGenerator = new ModelGenerator<Person>(Person.class);


    @GET
    @Timed
    @Path("/persons/{id}")
    public List<Person> getPerson(@PathParam("id") final int count) {
        final List<Person> persons = new ArrayList<Person>(count);
        for (int i =0; i< count; i++){
            persons.add(personGenerator.generate());
        }

        return persons;
    }     
}