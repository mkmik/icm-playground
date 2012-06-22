package eu.dnetlib.playground;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.sarasvati.Arc;
import com.googlecode.sarasvati.Engine;
import com.googlecode.sarasvati.NodeToken;

import eu.dnetlib.workflow.AbstractJobNode;

public class PlaygroundStepJob extends AbstractJobNode {

	private static final Log log = LogFactory.getLog(PlaygroundStepJob.class);

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

	private String flavour;
	private int duration;

	@Override
	public void execute(final Engine engine, final NodeToken token) {
		log.info("Executing node");

		token.getEnv().setAttribute("somePrecomputedParameter", "somePrecomputedValue");

		class Tick implements Runnable {
			private int left;

			Tick(int left) {
				this.left = left;
			}

			@Override
			public void run() {
				log.info("Timer fired");
				if (left > 0) {
					executor.schedule(new Tick(left - 1), 1, TimeUnit.SECONDS);
				} else {
					token.getEnv().setAttribute("someParameter", "someComputedValue");
					engine.complete(token, Arc.DEFAULT_ARC);
				}
			}
		}
		;

		new Tick(duration + 1).run();
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
