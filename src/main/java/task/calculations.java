package task;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("calc")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class calculations {
	
	@PersistenceContext
    private EntityManager em;
	
	@Path("PostCalc")
	@POST
	public result calc(operations op) {
		result r = new result();
		if(op.getOp().equalsIgnoreCase("+"))
		{
			r.setResult(op.getNumber1() + op.getNumber2());
			em.persist(op);
			return r;
		}
		else if(op.getOp().equalsIgnoreCase("-"))
		{
			r.setResult(op.getNumber1() - op.getNumber2());
			em.persist(op);
			return r;
		}
		else if(op.getOp().equalsIgnoreCase("*"))
		{
			r.setResult(op.getNumber1() * op.getNumber2());
			em.persist(op);
			return r;
		}
		else if(op.getOp().equalsIgnoreCase("/"))
		{
			r.setResult(op.getNumber1() / op.getNumber2());
			em.persist(op);
			return r;
		}
		em.persist(op);
		return r;
	}
	@Path("GetCalc")
	@GET
	public List<operations> getAllPersons() {
		TypedQuery<operations> query = em.createQuery("SELECT op FROM operations op", operations.class);
		List<operations> op = query.getResultList();

		return op;
	}

}
