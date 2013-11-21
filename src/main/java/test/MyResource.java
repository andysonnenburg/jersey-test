package test;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

@Path("myresource")
public class MyResource {
	private final ShouldBeClosed shouldBeClosed;

	@Inject
	public MyResource(ShouldBeClosed shouldBeClosed) {
		this.shouldBeClosed = shouldBeClosed;
	}

	@GET
	@Produces(TEXT_PLAIN)
	public String getIt() {
		shouldBeClosed.execute();
		return "Got it!";
	}
}
