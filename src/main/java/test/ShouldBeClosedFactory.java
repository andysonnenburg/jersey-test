package test;

import org.glassfish.hk2.api.Factory;
import org.glassfish.jersey.process.internal.RequestScoped;

public class ShouldBeClosedFactory implements Factory<ShouldBeClosed> {
	@Override
	@RequestScoped
	public ShouldBeClosed provide() {
		return new ShouldBeClosed() {
			@Override
			public void execute() {
				System.out.println("executed");
			}
			@Override
			public void close() {
				System.out.println("closed");
			}
		};
	}
	@Override
	public void dispose(ShouldBeClosed shouldBeClosed) {
		shouldBeClosed.close();
	}
}
