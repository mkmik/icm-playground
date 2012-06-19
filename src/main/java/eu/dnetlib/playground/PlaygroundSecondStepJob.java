package eu.dnetlib.playground;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.sarasvati.Arc;
import com.googlecode.sarasvati.Engine;
import com.googlecode.sarasvati.NodeToken;

import eu.dnetlib.workflow.AbstractJobNode;

public class PlaygroundSecondStepJob extends AbstractJobNode {
	private static final Log log = LogFactory.getLog(PlaygroundStepJob.class);

	@Override
	public void execute(final Engine engine, final NodeToken token) {
		log.info(String.format("Second step running in thread %s", Thread.currentThread()));
		
		engine.complete(token, Arc.DEFAULT_ARC);
	}
}
