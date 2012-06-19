package eu.dnetlib.playground;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.googlecode.sarasvati.Engine;
import com.googlecode.sarasvati.NodeToken;

import eu.dnetlib.workflow.AbstractJobNode;

public class PlaygroundStepJob extends AbstractJobNode {

	private static final Log log = LogFactory.getLog(PlaygroundStepJob.class);
	
	@Override
	public void execute(Engine engine, NodeToken token) {
		log.info("Executing node");
	}

}
